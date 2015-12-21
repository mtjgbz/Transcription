/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
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
    private static HashMap<Integer, ArrayList<String>> userAnswers;
    private static ArrayList<Integer> idList;
    private ArrayList<Integer> attempts;
    private static int sessionID;

    private JFrame parentFrame;

    private Clip clip;
    private boolean isTest;

    int wordCount = 0;
    
    private static final String TEST_TABLE = "TESTS";
    private static final String TEST_ATTEMPT = "TEST_ATTEMPT";
    private static final String TEST_ANSWER = "TEST_ANSWER";
    private static final String TEST_ID = "TestID";
    
    private static final String PRACTICE_TABLE = "PRACTICE";
    private static final String PRACTICE_ATTEMPT = "PRACTICE_ATTEMPT";
    private static final String PRACTICE_ANSWER = "PRACTICE_ANSWER";
    private static final String PRACTICE_ID = "PracticeID";

    /**
     * Creates the Test or Passive backend, based on boolean input
     * @param isTest    Whether the active class is practice or a test.
     */
    public ActiveBE(boolean isTest) {
        this.isTest = isTest;
        stmt = User.setupDB(parentFrame, getClass().getResource("TAA.db").toString());
        rand = new Random();
        clips = new ArrayList<>();
        attempts = new ArrayList<Integer>();
        correctAnswers = new ArrayList<String>();
        userAnswers = new HashMap<>();
        idList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            attempts.add(1);
        }
    }
    
    /**
     * Adds the selected correct answer to the database
     * @param answer        Gold standard word to be added to the database.
     * @param questionNum   Question number that the answer applies to
     */
    public void addCorrectAnswer(String answer, int questionNum){
        String table;
        String column;
        if(isTest){
            table = TEST_ANSWER;
            column = TEST_ID;
        }else{
            table = PRACTICE_ANSWER;
            column = PRACTICE_ID;
        }
        
        try{
            questionNum++;
            String query = "INSERT INTO " + table + "(" + column + ", Answer, "
                    + "QuestionNum) VALUES(" + sessionID + ", '" + answer + "', "
                    + questionNum + ");";
            stmt.execute(query);
            
            String query1 = "SELECT QuestionID FROM " + table + " WHERE "
                    + "QuestionID = LAST_INSERT_ROWID();";
            rs = stmt.executeQuery(query1);
            int questionID = rs.getInt("QuestionID");
            rs.close();
            idList.add(questionID);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * Adds the answer given by a user into the database
     * @param answer        User response to the blank
     * @param questionID    QuestionID to be added with the user response
     * @param attempt       Attempt number of the response
     * @param correct       Boolean for if the answer is correct
     */
    public void addUserAnswer(String answer, int questionID, int attempt, boolean correct){
        userAnswers.get(questionID).add(answer);
        attempt = Math.abs(attempt - 3);
        int score;
        if(correct){ 
            score = 1; 
        }else{ 
            score = 0; 
        }
        
        String table;
        String column;
        if(isTest){
            table = TEST_ATTEMPT;
            column = TEST_ID;
        }else{
            table = PRACTICE_ATTEMPT;
            column = PRACTICE_ID;
        }
        
        try{
            String query = "INSERT INTO " + table + "(" + column + ", Attempt, QuestionID, "
                    + "Response, Score) VALUES(" + sessionID + ", " + attempt + ", "
                    + questionID + ", '" + answer + "', " + score + ");";
            stmt.execute(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * Updates the database on the current score of the active session.
     */
    public void calculateScore(){
        String table;
        String table2;
        String column;
        
        if(isTest){
            table = TEST_ATTEMPT;
            table2 = TEST_TABLE;
            column = TEST_ID;
        }else{
            table = PRACTICE_ATTEMPT;
            table2 = PRACTICE_TABLE;
            column = PRACTICE_ID;
        }
        
        try{
            String query = "SELECT * FROM " + table + " WHERE " + column + " = "
                    + sessionID + ";";
            rs = stmt.executeQuery(query);
            float weightedScore = 0;
            int attemptNum = 0;
            while(rs.next()){
                int num = rs.getInt("Score");
                attemptNum++;
                weightedScore += num;
            }
            weightedScore /= attemptNum;
            System.out.println("Weighted: " + weightedScore);
            weightedScore *= 100;
            rs.close();
            
            query = "UPDATE " + table2 + " SET Score = " + weightedScore + " WHERE " + column + " = "
                    + sessionID + ";";
            stmt.execute(query);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Sets up the clips for the given page.
     * @param pageNum   page number for which the audio clip will be played on
     * @return          the clip opened for the page.
     */
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

    /**
     * Closes the open clip.
     */
    public void closeAudio() {
        clip.close();
    }
    
    /**
     * Creates a new log entry when an active session is started.
     * @param username      User opening the session.
     * @param lesson        Lesson of the session.
     * @param sublesson     Sublesson of the session.
     * @return              ID of the session that has been entered into the DB.
     */
    public int newPractice(String username, int lesson, String sublesson) {
        String table;
        String column;
        if(isTest){
            table = TEST_TABLE;
            column = TEST_ID;
        }else{
            table = PRACTICE_TABLE;
            column = PRACTICE_ID;
        }
        
        try {
            String query = "INSERT INTO " + table + "(Username, Lesson, Sublesson, DateTaken)"
                    + " VALUES('" + username + "', " + lesson + ", '" + sublesson + "', "
                    + "datetime('now', 'localtime'));";
            stmt.execute(query);
            query = "SELECT(" + column + ") FROM " + table + " WHERE " + column + " = LAST_INSERT_ROWID();";
            ResultSet rs = stmt.executeQuery(query);
            sessionID = rs.getInt(column);
            rs.close();
            return sessionID;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Adds a new entry into the database for new new active attempt.
     * @param a         attempt number given from the session.
     * @param word      user's answer for the blank
     * @param correct   if the user's answer is correct or incorrect.
     */
    public void newAttempt(int a, String word, boolean correct) {
        try {
            int attempt = Math.abs(a - 3);
            int questionID = idList.get(0);
            ArrayList<String> currList = userAnswers.get(getQuestionID(word));
            String userAnswer = currList.get(currList.size() - 1);
            int score;
            if(correct){
                score = 1;
            }else{
                score = 0;
            }
            
            String table;
            String column;
            if(isTest){
                table = TEST_ATTEMPT;
                column = TEST_ID;
            }else{
                table = PRACTICE_ATTEMPT;
                column = PRACTICE_ID;
            }
            
            String query = "INSERT INTO " + table + "(" + column + ", Attempt, QuestionID, "
                    + "Response, Score) VALUES(" + sessionID + ", " + attempt + ", "
                    + questionID + ", '" + userAnswer + "', " + score + ");";
            stmt.execute(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * pulls a random transcription file for the lesson from the database.
     * @param lesson        Lesson for the file.
     * @param sublesson     Sublesson for the file.
     * @return              Path of the file randomly chosen.
     */
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

    /**
     * Returns the list of clips open for the session.
     * @return  List of clips open for the session.
     */
    public ArrayList<File> getClips() {
        return clips;
    }
    
    /**
     * Returns the ID in the database of a given word within the practice ID.
     * @param answer    Gold standard answer to find in the database.
     * @return          QuestionID of answer from database.
     */
    public int getQuestionID(String answer){
        String table;
        String column; 
        
        if(isTest){
            table = TEST_ANSWER;
            column = TEST_ID;
        }else{
            table = PRACTICE_ANSWER;
            column = PRACTICE_ID;
        }
        
        try{
            String query = "SELECT * FROM " + table + " WHERE " + column + " = " + sessionID
                    + " AND Answer LIKE '" + answer + "';";
            rs = stmt.executeQuery(query);
            int id = rs.getInt("QuestionID");
            System.out.println(answer + ": " + id);
            return id;
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
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
            String word = matcher.group(1);
            word = word.replaceAll(" ", "");
            if (!(words.contains(word))) {
                words.add(word);
                correctAnswers.add(word);
                addCorrectAnswer(word, correctAnswers.indexOf(word));
                userAnswers.put(getQuestionID(word), new ArrayList<String>());
                wordCount++;
            }
        }
    }

    /**
     * Sets the blanks within the phrase selected from the database.
     * @param input     phrase selected for use in Active
     * @param words     words found from the phrase that will be blanked out.
     * @return          phrase with blanks.
     */
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
        return output;
    }
}
