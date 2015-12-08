package my.transcription;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import javax.sound.sampled.*;
import javax.swing.JFrame;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Erica
 */
public class PassiveBE {

    private Statement stmt;
    private ResultSet rs;
    private Random rand;
    private JFrame parentFrame;
    private static ArrayList<File> clips;
    private String regex;
    
    private int lesson;
    private String sublesson;
    
    Clip[] currentClips = new Clip[5];

    private Clip clip1;
    private Clip clip2;
    private Clip clip3;
    private Clip clip4;
    private Clip clip5;

    /**
     * Creates the passive backend.
     * @param pFrame    parent JFrame of backend.
     */
    public PassiveBE(JFrame pFrame) {
        parentFrame = pFrame;
        stmt = User.setupDB(parentFrame,getClass().getResource("TAA.db").toString());
        rand = new Random();
        clips = new ArrayList<File>();
    }

    /**
     *
     * @param lesson
     * @param sublesson
     * @return
     */
    public String findFile(int l, String s) {
        try {
            lesson = l;
            sublesson = s;
            //pulling .txt file that contains lesson matches
            String query = "SELECT(FileList) FROM LESSONS WHERE Lesson = " + lesson
                    + " AND Sublesson = '" + sublesson + "';";
            rs = stmt.executeQuery(query);
            String path = rs.getString("FileList");

            //pulling filename from lesson match string
            String[] filePaths = path.split("; ");

            //get random filename from the list
            int random = rand.nextInt(filePaths.length - 1);
            path = filePaths[random];

            //create sound file name from transcription path name
            String soundName = path.replace(".trs", ".wav");
            soundName = soundName.replace("Transcripciones", "Sonidos");
            if (soundName.contains("_ed")) {
                soundName = soundName.split("_ed")[0];
                soundName = soundName + ".wav";

            }
            //add the appropriate file to the clip array
            clips.add(new File(soundName));
            return path;
        } catch (Exception e) {
            User.errorMessage(parentFrame, e.getMessage(), "Error");
            parentFrame.dispose();
        }
        return null;
    }

    /**
     * Get the list of sound clip file names
     * @return  The list of sound clip file names
     */
    public ArrayList<File> getClips() {
        return clips;
    }

    /**
     * Finds the phrase and time around the phrase containing the words for the
     * lesson.
     * @param document  Path name for the transcription file containing the phrase.
     * @return          The start time, phrase, and end time as given in the document
     */
    public ArrayList<String> findPhrase(String document) {
        try {
            //ArrayList for start time, phrase, and end time
            ArrayList<String> phrase = new ArrayList<String>();

            //Setting up the document reader to parse
            File file = new File(document);
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            
            if (!document.contains(".trs")) {
                //if the document is not a .trs file
                return null;
            }
            
            //Parse the file and get all of the phrases
            Document doc = dBuilder.parse(file);
            NodeList nList = doc.getElementsByTagName("Sync");
            
            //Get the applicable regular expression from the database
            String query = "SELECT RegularExpression FROM LESSON_PLAN WHERE "
                    + "Lesson = " + lesson + " AND Sublesson LIKE '" + sublesson + "';";
            rs = stmt.executeQuery(query);
            regex = rs.getString("RegularExpression");

            //Setting up the regular expression searcher
            Pattern regexp = Pattern.compile(regex);
            Matcher matcher = regexp.matcher(file.getName());

            //random number within the number of rows there are
            int count = rand.nextInt(nList.getLength());

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                NamedNodeMap attributes = nNode.getAttributes();
                String value = nNode.getNextSibling().getNodeValue();
                matcher.reset(value);
                if (matcher.find()) {
                    if (i >= count) {
                        String time = attributes.getNamedItem("time").toString();
                        time = time.replace("time=", "");
                        time = time.replace("\"", "");
                        phrase.add(time);
                        if (value != null) {
                            phrase.add(value);
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
            parentFrame.dispose();            
            User.closeDB(stmt, rs);
            User.errorMessage(parentFrame, e.getMessage(), "Error");
        }
        return null;
    }

    /**
     * Finds the words that fit the lesson in the phrase selected.
     * @param phrases   Phrases given to Passive that contains applicable words
     * @param words     Words within the phrases that match the regular expression.
     */
    public void findWords(ArrayList<String> phrases, ArrayList<String> words) {
        Pattern regexp = Pattern.compile(regex);
        Matcher matcher;
        for (String phrase : phrases) {
            matcher = regexp.matcher(phrase);
            //System.out.println(phrase);
            while (matcher.find()) {
                String word = matcher.group(1);
                //System.out.println("Phrase: " + phrase + " Word: " + word);
                if (!words.contains(word)) {
                    words.add(word);
                }
            }
        }
//        for(String w : words) {
//            System.out.println("Word in Words: " + w);
//        }

    }

    /**
     * 
     * @param pageNum
     * @return 
     */
    public ArrayList<Clip> makeClips(int pageNum) {
        ArrayList<Clip> clips1 = new ArrayList<>();

        try {

            if (pageNum == 1) {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(clips.get(0));
                clip1 = AudioSystem.getClip();
                clip1.open(audioIn);
                //clips1.setMicrosecondPosition(timesList.get(0).get(0));
                audioIn.close();

                audioIn = AudioSystem.getAudioInputStream(clips.get(1));
                clip2 = AudioSystem.getClip();
                clip2.open(audioIn);
                //clips2.setMicrosecondPosition(timesList.get(0).get(1));
                audioIn.close();

                audioIn = AudioSystem.getAudioInputStream(clips.get(2));
                clip3 = AudioSystem.getClip();
                clip3.open(audioIn);
                //clips3.setMicrosecondPosition(timesList.get(0).get(2));
                audioIn.close();

                audioIn = AudioSystem.getAudioInputStream(clips.get(3));
                clip4 = AudioSystem.getClip();
                clip4.open(audioIn);
                //clips4.setMicrosecondPosition(timesList.get(0).get(3));
                audioIn.close();

                audioIn = AudioSystem.getAudioInputStream(clips.get(4));
                clip5 = AudioSystem.getClip();
                clip5.open(audioIn);
                //clips5.setMicrosecondPosition(timesList.get(0).get(4));
                audioIn.close();
            } else if (pageNum == 2) {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(clips.get(5));
                clip1 = AudioSystem.getClip();
                clip1.open(audioIn);
                //clips1.setMicrosecondPosition(timesList.get(0).get(0));
                audioIn.close();

                audioIn = AudioSystem.getAudioInputStream(clips.get(6));
                clip2 = AudioSystem.getClip();
                clip2.open(audioIn);
                //clips2.setMicrosecondPosition(timesList.get(0).get(1));
                audioIn.close();

                audioIn = AudioSystem.getAudioInputStream(clips.get(7));
                clip3 = AudioSystem.getClip();
                clip3.open(audioIn);
                //clips3.setMicrosecondPosition(timesList.get(0).get(2));
                audioIn.close();

                audioIn = AudioSystem.getAudioInputStream(clips.get(8));
                clip4 = AudioSystem.getClip();
                clip4.open(audioIn);
                //clips4.setMicrosecondPosition(timesList.get(0).get(3));
                audioIn.close();

                audioIn = AudioSystem.getAudioInputStream(clips.get(9));
                clip5 = AudioSystem.getClip();
                clip5.open(audioIn);
                //clips5.setMicrosecondPosition(timesList.get(0).get(4));
                audioIn.close();
            } else if (pageNum == 3) {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(clips.get(10));
                clip1 = AudioSystem.getClip();
                clip1.open(audioIn);
                //clips1.setMicrosecondPosition(timesList.get(0).get(0));
                audioIn.close();

                audioIn = AudioSystem.getAudioInputStream(clips.get(11));
                clip2 = AudioSystem.getClip();
                clip2.open(audioIn);
                //clips2.setMicrosecondPosition(timesList.get(0).get(1));
                audioIn.close();

                audioIn = AudioSystem.getAudioInputStream(clips.get(12));
                clip3 = AudioSystem.getClip();
                clip3.open(audioIn);
                //clips3.setMicrosecondPosition(timesList.get(0).get(2));
                audioIn.close();

                audioIn = AudioSystem.getAudioInputStream(clips.get(13));
                clip4 = AudioSystem.getClip();
                clip4.open(audioIn);
                //clips4.setMicrosecondPosition(timesList.get(0).get(3));
                audioIn.close();

                audioIn = AudioSystem.getAudioInputStream(clips.get(14));
                clip5 = AudioSystem.getClip();
                clip5.open(audioIn);
                //clips5.setMicrosecondPosition(timesList.get(0).get(4));
                audioIn.close();
            } else {
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(clips.get(15));
                clip1 = AudioSystem.getClip();
                clip1.open(audioIn);
                //clips1.setMicrosecondPosition(timesList.get(0).get(0));
                audioIn.close();

                audioIn = AudioSystem.getAudioInputStream(clips.get(16));
                clip2 = AudioSystem.getClip();
                clip2.open(audioIn);
                //clips2.setMicrosecondPosition(timesList.get(0).get(1));
                audioIn.close();

                audioIn = AudioSystem.getAudioInputStream(clips.get(17));
                clip3 = AudioSystem.getClip();
                clip3.open(audioIn);
                //clips3.setMicrosecondPosition(timesList.get(0).get(2));
                audioIn.close();

                audioIn = AudioSystem.getAudioInputStream(clips.get(18));
                clip4 = AudioSystem.getClip();
                clip4.open(audioIn);
                //clips4.setMicrosecondPosition(timesList.get(0).get(3));
                audioIn.close();

                audioIn = AudioSystem.getAudioInputStream(clips.get(19));
                clip5 = AudioSystem.getClip();
                clip5.open(audioIn);
                //clips5.setMicrosecondPosition(timesList.get(0).get(4));
                audioIn.close();
            }

            clips1.add(clip1);
            clips1.add(clip2);
            clips1.add(clip3);
            clips1.add(clip4);
            clips1.add(clip5);

            return clips1;

        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clips1;
    }

    public void closeAudio() {
        clip1.close();
        clip2.close();
        clip3.close();
        clip4.close();
        clip5.close();
    }

    //Parse through document paths until random one reached
    //Create parser to go through file
    //Randomly select a line from that file
    //Return that line
}
