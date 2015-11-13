package my.transcription;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
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

    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private Random rand;
    private static ArrayList<File> clips;
    private static ArrayList<String> phrases;
    private static ArrayList<String> words;

    private Clip clip1;
    private Clip clip2;
    private Clip clip3;
    private Clip clip4;
    private Clip clip5;

    /**
     * Creates the passive backend.
     */
    public PassiveBE() {
        setupDB();
        rand = new Random();
        clips = new ArrayList<File>();
    }

    /**
     * Sets up the database for use by the backend.
     */
    private void setupDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:TAA.db");
            System.out.println("Database opened successfully.");
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void closeDB() {
        try {
            conn.close();
            stmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     *
     * @param lesson
     * @param sublesson
     * @return
     */
        public String findFile(int lesson, char sublesson) {
        try {
            //pulling .txt file that contains lesson matches
            String query = "SELECT(FileList) FROM LESSONS WHERE Lesson = " + lesson
                    + " AND Sublesson = '" + sublesson + "';";
            rs = stmt.executeQuery(query);
            String path = rs.getString("FileList");

            //pulling filename from lesson match .txt file
            File file = new File(path);
            LineNumberReader reader = new LineNumberReader(new FileReader(file));
            int lineCount = 0;

            //reading lines int the file
            String line = reader.readLine();
            //mark the first line so can reset when go to pull random line later
            reader.mark((int) file.length());
            //go through lines and count them to get the total number
            while (line != null) {
                line = reader.readLine();
                lineCount++;
            }

            //System.out.println("Line num: " + lineCount);
            //get a random line number from the total number of lines
            int random = rand.nextInt(lineCount);
            //System.out.println("Random: " + random);

            //reset lineReader to the beginnig of the file so can read up to the random line
            //and then return it
            reader.reset();
            //System.out.println("Line before loop: " + reader.getLineNumber());
            for (int i = 1; i < random - 1; i++) {
                path = reader.readLine();
            }

            //close the lineReader and return the line (path for findPhrase)
            reader.close();

            //System.out.println(path);
            String soundName = path.replace(".trs", ".wav");
            soundName = soundName.replace("Transcripciones", "Sonido");
            if (soundName.contains("_ed")) {
                soundName = soundName.split("_ed")[0];
                soundName = soundName + ".wav";

            }
            clips.add(new File(soundName));

            return path;

        } catch (Exception e) {
            e.printStackTrace();
        }
        closeDB();

        return null;
    }

    /**
     *
     * @return
     */
    public ArrayList<File> getClips() {
        return clips;
    }

    /**
     *
     * @param document
     * @return
     */
    public ArrayList<String> findPhrase(String document) {
        try {
            ArrayList<String> phrase = new ArrayList<String>();

            File file = new File(document);
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            if (document.contains("list.txt")) {
                return null;
            }
            Document doc = dBuilder.parse(file);
            NodeList nList = doc.getElementsByTagName("Sync");

            Pattern regexp = Pattern.compile("\\s([a-zñ]+[aeiou]([134])[a-zñ]?[aeiou]\\2)");       //example exp - change later
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
     *
     * @param phrases
     * @param words
     */
    public void findWords(ArrayList<String> phrases, ArrayList<String> words) {
        Pattern regexp = Pattern.compile("\\s([a-zñ]+[aeiou]([134])[a-zñ]?[aeiou]\\2)");       //example exp - change later
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

    /**
     *
     */
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
