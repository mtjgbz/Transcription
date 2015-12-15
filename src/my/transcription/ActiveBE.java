/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author mike
 */
public class ActiveBE {

    private Statement stmt;
    private ResultSet rs;
    private Random rand;
    private static ArrayList<File> clips;
    private static ArrayList<String> phrases;
    private static ArrayList<String> correctAnswers;
    private static ArrayList<String> userAnswers;
    private ArrayList<Integer> attempts;

    private JFrame parentFrame;

    private Clip clip;
    private boolean isTest;

    int wordCount = 0;

    public ActiveBE(boolean isTest) {
        this.isTest = isTest;
        stmt = User.setupDB(parentFrame, getClass().getResource("TAA.db").toString());
        rand = new Random();
        clips = new ArrayList<>();
        attempts = new ArrayList<Integer>();
        correctAnswers = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            attempts.add(1);
        }
    }

    public Clip makeClip(int pageNum) {

        AudioInputStream audioIn;
        try {
                audioIn = AudioSystem.getAudioInputStream(clips.get(pageNum-1));
                DataLine.Info info = new DataLine.Info(Clip.class, audioIn.getFormat());
                clip = (Clip) AudioSystem.getLine(info);
                clip.open(audioIn);
                audioIn.close();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(ActiveBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ActiveBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(ActiveBE.class.getName()).log(Level.SEVERE, null, ex);
        }

        return clip;
    }

    public void closeAudio() {
        clip.close();
    }

    public void submit(ArrayList<String> answerList, ArrayList<String> attemptList) {
        if (isTest) {

        } else {

        }
    }

    public int newPractice(String username, int lesson, String sublesson) {
        try {
            String query = "INSERT INTO PRACTICE(Username, DateTaken, Lesson, Sublesson, DateTaken)"
                    + " VALUES('" + username + "', " + lesson + ", '" + sublesson + "', "
                    + "NOW());";
            stmt.execute(query);
            query = "SELECT(PracticeID) FROM PRACTICE WHERE PracticeID = LAST_INSERT_ROWID();";
            ResultSet rs = stmt.executeQuery(query);
            int id = rs.getInt("PracticeID");
            rs.close();
            return id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void newAttempt(int questionNum, int practiceID) {
        try {
            int attempt = attempts.get(questionNum - 1);
            String response = userAnswers.get(questionNum - 1);
            String answer = userAnswers.get(questionNum - 1);

            //get the practice id from the db
            stmt = User.setupDB(parentFrame, getClass().getResource("TAA.db").toString());

            //get the word from that practice from the db or just the array
            //get the questionID from that word
            String corrAnswer = correctAnswers.get(questionNum - 1);

            String query = "SELECT QuestionID FROM PRACTICE_ANSWER WHERE"
                    + " PracticeID = " + practiceID + " AND ANSWER LIKE "
                    + corrAnswer + "; ";
            ResultSet rs = stmt.executeQuery(query);
            int questionID = rs.getInt("QuestionID");

            //if it matches the answer in the array put it in as the correct score
            float score;
            float weightedScore;
            if (response.equals(answer)) {
                score = 100;
                weightedScore = 1 / attempt;
            } else {
                score = 0;
                weightedScore = 0 / attempt;
            }

            query = "INSERT INTO PRACTICE_ATTEMPT(PracticeID, Attempt, "
                    + "QuestionID, Response, Score, WeightedScore) VALUES("
                    + attempt + ", " + questionID + ", " + response + ", " + score
                    + ", " + weightedScore + "; ";
            stmt.executeQuery(query);

            attempts.set(questionNum - 1, attempt + 1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String findFile(int lesson, String sublesson) {
        try {
            //pulling .txt file that contains lesson matches
            String query = "SELECT(FileList) FROM LESSONS WHERE Lesson = " + lesson
                    + " AND Sublesson = '" + sublesson + "';";
            rs = stmt.executeQuery(query);
            String path = rs.getString("FileList");

            //pulling filename from lesson match string
            String[] filePaths = path.split("; ");

            //get a random file name from the list
            int random = rand.nextInt(filePaths.length - 1);
            path = filePaths[random];

            //System.out.println(path);
            String soundName = path.replace(".trs", ".wav");
            soundName = soundName.replace("Transcripciones", "Sonidos");
            if (soundName.contains("_ed")) {
                soundName = soundName.split("_ed")[0];
                soundName = soundName + ".wav";

            }
            clips.add(new File(soundName));

            return path;

        } catch (Exception e) {
            e.printStackTrace();
        }
        User.closeDB(stmt, rs);

        return null;
    }

    /**
     * Finds the phrase and time around the phrase containing the words for the
     * lesson.
     *
     * @param document Path name for the transcription file containing the
     * phrase.
     * @return The start time, phrase, and end time as given in the document
     */
    public ArrayList<String> findPhrase(String document) {
        try {
            ArrayList<String> phrase = new ArrayList<String>();

            File file = new File(document);
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            if (document.contains(".txt")) {
                return null;
            }
            Document doc = dBuilder.parse(file);
            NodeList nList = doc.getElementsByTagName("Sync");

            Pattern regexp = Pattern.compile("\\s([b-df-hj-np-tv-zñ]+[aeiou]([134])[b-df-hj-np-tv-zñ][aeiou]\\2)\\s");       //example exp - change later
            Matcher matcher = regexp.matcher(file.getName());

            int count = rand.nextInt(nList.getLength());
            //System.out.println(count + " out of " + nList.getLength());

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                NamedNodeMap attributes = nNode.getAttributes();
                String value = nNode.getNextSibling().getNodeValue();
                matcher.reset(value);
                if (matcher.find()) {
                    //phrases.add(value);
                    if (i >= count) {
                        String time = attributes.getNamedItem("time").toString();
                        time = time.replace("time=", "");
                        time = time.replace("\"", "");
                        phrase.add(time);
                        if (value != null) {
                            phrase.add(value);
                            //System.out.println(value);
                        } else {
                            return null;
                        }
                        if (nList.item(i + 1) != null) {
                            NamedNodeMap nextAttributes = nList.item(i + 1).getAttributes();
                            time = nextAttributes.getNamedItem("time").toString();
                            time = time.replace("time=", "");
                            time = time.replace("\"", "");
                            phrase.add(time);
                            return phrase;
                        } else {
                            phrase.add("0");
                            return phrase;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        for(String p : phrases) {
//            System.out.println("Phrase: " + p);
//        }
//        System.out.println("Size: " + phrases.size());
        return null;
    }

    public ArrayList<File> getClips() {
        return clips;
    }

    /**
     * Finds the words that fit the lesson in the phrase selected.
     *
     * @param phrases Phrases given to Passive that contains applicable words
     * @param words Words within the phrases that match the regular expression.
     */
    public void findWords(String input, ArrayList<String> words) {
        wordCount = 0;
        Pattern regexp = Pattern.compile("\\s([b-df-hj-np-tv-zñ]+[aeiou]([134])[b-df-hj-np-tv-zñ][aeiou]\\2)\\s");       //example exp - change later
        Matcher matcher;
        String[] phrase = input.split(" ");
        matcher = regexp.matcher(input);
        while (matcher.find()) {
            System.out.println("found word");
            String word = matcher.group(1);
            word = word.replaceAll(" ", "");
            if (!(words.contains(word))) {
                words.add(word);
                correctAnswers.add(word);
                wordCount++;
            }
        }
    }

    String setBlanks(String input, ArrayList<String> words) {
        //words.add("yo4o4");
        //words.add("tan42");
        boolean used1 = false;
        boolean used2 = false;
        boolean used3 = false;
        boolean used4 = false;

        String label = "";

        String word1 = "";
        String word2 = "";
        String word3 = "";
        String word4 = "";

        int count = 0;
        //String word2 = words.get(1);
        String output = "";
        char[] statement = input.toCharArray();
        char c;

        for (int i = 0; i < statement.length; i++) {
            c = statement[i];
            label = label + c;
            if (wordCount == 1) {
                word1 = words.get(0);

                if (label.contains(word1) && used1 == false) {
                    count++;
                    label = label.replace(word1, "[     ] ");
                    //blanks.add("[     ] ");
                    output += label;
                    label = "";
                    used1 = true;
                }
            } else if (wordCount == 2) {
                word1 = words.get(0);
                word2 = words.get(1);

                if (label.contains(word1) && used1 == false) {
                    count++;
                    label = label.replace(word1, "[     ] ");
                    //blanks.add("[     ] ");
                    output += label;
                    label = "";
                    used1 = true;
                }
                if (label.contains(word2) && used2 == false) {
                    count++;
                    label = label.replace(word2, "[     ] ");
                    //blanks.add("[     ] ");
                    output += label;
                    label = "";
                    used2 = true;
                }
            } else if (wordCount == 3) {
                word1 = words.get(0);
                word2 = words.get(1);
                word3 = words.get(2);

                if (label.contains(word1) && used1 == false) {
                    count++;
                    label = label.replace(word1, "[     ] ");
                    //blanks.add("[     ] ");
                    output += label;
                    label = "";
                    used1 = true;
                }
                if (label.contains(word2) && used2 == false) {
                    count++;
                    label = label.replace(word2, "[     ] ");
                    //blanks.add("[     ] ");
                    output += label;
                    label = "";
                    used2 = true;
                }
                if (label.contains(word3) && used3 == false) {
                    count++;
                    label = label.replace(word3, "[     ] ");
                    //blanks.add("[     ] ");
                    output += label;
                    label = "";
                    used3 = true;
                }
            } else if (wordCount >= 4) {
                word1 = words.get(0);
                word2 = words.get(1);
                word3 = words.get(2);
                word4 = words.get(3);

                if (label.contains(word1) && used1 == false) {
                    count++;
                    label = label.replace(word1, "[     ] ");
                    //blanks.add("[     ] ");
                    output += label;
                    label = "";
                    used1 = true;
                }
                if (label.contains(word2) && used2 == false) {
                    count++;
                    label = label.replace(word2, "[     ] ");
                    //blanks.add("[     ] ");
                    output += label;
                    label = "";
                    used2 = true;
                }
                if (label.contains(word3) && used3 == false) {
                    count++;
                    label = label.replace(word3, "[     ] ");
                    //blanks.add("[     ] ");
                    output += label;
                    label = "";
                    used3 = true;
                }
                if (label.contains(word4) && used4 == false) {
                    count++;
                    label = label.replace(word4, "[     ] ");
                    //blanks.add("[     ] ");
                    output += label;
                    label = "";
                    used4 = true;
                }
            }
        }
        output += label;
//       for(String s : blanks) {
//           System.out.println(s);
//       }
        //System.out.println(blanks.size());
        System.out.println(output);
        return output;
    }
}
