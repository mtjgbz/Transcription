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
    //private static ArrayList<String> words;
    private ArrayList<Integer> attempts;
    
    private JFrame parentFrame;
    
    private Clip clip;
    private boolean isTest;
    
    public ActiveBE(boolean isTest) {
        this.isTest=isTest;
       // stmt = User.setupDB(parentFrame);
        rand = new Random();
        clips = new ArrayList<>();
        attempts = new ArrayList<Integer>();
        for(int i = 0; i < 20; i++){
            attempts.add(1);
        }
    }
    
    public Clip makeClip(int pageNum){
        
        AudioInputStream audioIn;
        try {
            //audioIn = AudioSystem.getAudioInputStream(clips.get(pageNum-1));
            audioIn = AudioSystem.getAudioInputStream(new File("oGolden.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        //clips1.setMicrosecondPosition(timesList.get(0).get(0));
            audioIn.close();
            return clip;
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(ActiveBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ActiveBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(ActiveBE.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clip;
    }
    
    public void closeAudio(){
        clip.close();
    }
    
    public void submit(ArrayList<String> answerList, ArrayList<String> attemptList){
        if(isTest){
            
        }else{
            
        }
    }
    
    public int newPractice(String username, int lesson, String sublesson){
        try{
            String query = "INSERT INTO PRACTICE(Username, DateTaken, Lesson, Sublesson, DateTaken)"
                    + " VALUES('" + username + "', " + lesson + ", '" + sublesson + "', "
                    + "NOW());";
            stmt.execute(query);
            query = "SELECT(PracticeID) FROM PRACTICE WHERE PracticeID = LAST_INSERT_ROWID();";
            ResultSet rs = stmt.executeQuery(query);
            int id = rs.getInt("PracticeID");
            rs.close();
            return id;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public void newAttempt(int questionNum, int questionID, int practiceID){
        try{
            int attempt = attempts.get(questionNum - 1);
            
        }catch(Exception e){
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
        User.closeDB(stmt, rs);

        return null;
    }
    
    /**
     * Finds the phrase and time around the phrase containing the words for the
     * lesson.
     * @param document  Path name for the transcription file containing the phrase.
     * @return          The start time, phrase, and end time as given in the document
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
    
    public ArrayList<File> getClips() {
        return clips;
    }
    
    /**
     * Finds the words that fit the lesson in the phrase selected.
     * @param phrases   Phrases given to Passive that contains applicable words
     * @param words     Words within the phrases that match the regular expression.
     */
    public void findWords(String input, ArrayList<String> words) {
        Pattern regexp = Pattern.compile("\\s([a-zñ]+[aeiou]([134])[a-zñ]?[aeiou]\\2)");       //example exp - change later
        Matcher matcher;
        String[] phrase = input.split(" ");
        matcher = regexp.matcher(input);
        while (matcher.find()) {
            System.out.println("found word");
            String word = matcher.group(1);
            //System.out.println("Phrase: " + phrase + " Word: " + word);
            if (!words.contains(word)) {
                words.add(word);
            }
        }
        
//        for(String w : words) {
//            System.out.println("Word in Words: " + w);
//        }

    }
}
