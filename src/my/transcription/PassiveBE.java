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
    
    private Clip clip1;
    private Clip clip2;
    private Clip clip3;
    private Clip clip4;
    private Clip clip5;
    private Clip clip6;
    private Clip clip7;
    private Clip clip8;
    private Clip clip9;
    private Clip clip10;
    private Clip clip11;
    private Clip clip12;
    private Clip clip13;
    private Clip clip14;
    private Clip clip15;
    private Clip clip16;
    private Clip clip17;
    private Clip clip18;
    private Clip clip19;
    private Clip clip20;
    
    
    /**
     * Creates the passive backend.
     */
    public PassiveBE(){
        setupDB();
        rand = new Random();
    }
    /**
     * Sets up the database for use by the backend.
     */
    private void setupDB(){
        try{
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:TAA.db");
            System.out.println("Database opened successfully.");
            stmt = conn.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    private void closeDB(){
        try{
            conn.close();
            stmt.close();
            rs.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Randomly select file from list of them in DB
    public String findFile(int lesson, char sublesson){
        try{
            //pulling .txt file that contains lesson matches
            String query = "SELECT(FileList) FROM LESSONS WHERE Lesson = " + lesson + 
                    " AND Sublesson = '" + sublesson + "';";
            rs = stmt.executeQuery(query);
            String path = rs.getString("FileList");
            
            //pulling filename from lesson match .txt file
            File file = new File(path);
            LineNumberReader reader = new LineNumberReader(new FileReader(file));
            int lineCount = 0;
            
            //reading lines int the file
            String line = reader.readLine();
            //mark the first line so can reset when go to pull random line later
            reader.mark((int)file.length());
            //go through lines and count them to get the total number
            while (line != null){
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
            for(int i = 0; i < random-1; i++) {
                path = reader.readLine();
            }
            
            //close the lineReader and return the line (path for findPhrase)
            reader.close();
            return path;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        closeDB();
        
        return null;
    }
    
    public ArrayList<File> getClips(){
        return clips;
    }
    
    public ArrayList<String> findPhrase(String document){
        try{
            ArrayList<String> phrase = new ArrayList<String>();
            
            String soundName = document.replace(".trs", ".wav");
            soundName = soundName.replace("Transcripciones", "Sonido");
            if(soundName.contains("_ed")){
                document = soundName.split("_ed")[0];
                soundName = soundName + ".wav";
                
            }
            clips.add(new File(soundName));
            
            File file = new File(document);
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            if(document.contains("list.txt")){
                return null;
            }
            Document doc = dBuilder.parse(file);
            NodeList nList = doc.getElementsByTagName("Sync");
            
            Pattern regexp = Pattern.compile("[a-zñ][aeiou]([134])[a-zñ][aeiou]\\1");       //example exp - change later
            Matcher matcher = regexp.matcher(file.getName());
            
            int count = rand.nextInt(nList.getLength());
            //System.out.println(count + " out of " + nList.getLength());
            
            for(int i = 0; i < nList.getLength(); i++){
                Node nNode = nList.item(i);
                NamedNodeMap attributes = nNode.getAttributes();
                String value = nNode.getNextSibling().getNodeValue();
                matcher.reset(value);
                if(matcher.find()){
                    if(i >= count){
                        String time = attributes.getNamedItem("time").toString();
                        time = time.replace("time=", "");
                        time = time.replace("\"", "");
                        phrase.add(time);
                        if(value != null){
                            phrase.add(value);
                            //System.out.println(value);
                        }else{
                            return null;
                        }
                        if(nList.item(i + 1) != null){
                            NamedNodeMap nextAttributes = nList.item(i + 1).getAttributes();
                            time = nextAttributes.getNamedItem("time").toString();
                            time = time.replace("time=", "");
                            time = time.replace("\"", "");
                            phrase.add(time);
                            return phrase;
                        }else{
                            phrase.add("0");
                            return phrase;
                        }
                    }
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<ArrayList<Clip>> makeClips(){
        ArrayList<ArrayList<Clip>>  clipsList = new ArrayList<>();
        ArrayList<Clip> clips1 = new ArrayList<>();
        ArrayList<Clip> clips2 = new ArrayList<>();
        ArrayList<Clip> clips3 = new ArrayList<>();
        ArrayList<Clip> clips4 = new ArrayList<>();
         try {
            
            
            
            
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
            clip1 = AudioSystem.getClip();
            clip1.open(audioIn);
            //clips1.setMicrosecondPosition(timesList.get(0).get(0));
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
            clip2 = AudioSystem.getClip();
            clip2.open(audioIn);
            //clips2.setMicrosecondPosition(timesList.get(0).get(1));
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
            clip3 = AudioSystem.getClip();
            clip3.open(audioIn);
            //clips3.setMicrosecondPosition(timesList.get(0).get(2));
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
            clip4 = AudioSystem.getClip();
            clip4.open(audioIn);
            //clips4.setMicrosecondPosition(timesList.get(0).get(3));
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
            clip5 = AudioSystem.getClip();
            clip5.open(audioIn);
            //clips5.setMicrosecondPosition(timesList.get(0).get(4));
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File("oGolden.wav"));
            clip6 = AudioSystem.getClip();
            clip6.open(audioIn);
            //clips6.setMicrosecondPosition(timesList.get(1).get(0));
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File("oGolden.wav"));
            clip7 = AudioSystem.getClip();
            clip7.open(audioIn);
            //clips7.setMicrosecondPosition(timesList.get(1).get(1));
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File("oGolden.wav"));
            clip8 = AudioSystem.getClip();
            clip8.open(audioIn);
            //clips8.setMicrosecondPosition(timesList.get(1).get(2));
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File("oGolden.wav"));
            clip9 = AudioSystem.getClip();
            clip9.open(audioIn);
            //clips9.setMicrosecondPosition(timesList.get(1).get(3));
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File("oGolden.wav"));
            clip10 = AudioSystem.getClip();
            clip10.open(audioIn);
            //clips10.setMicrosecondPosition(timesList.get(1).get(4));
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
            clip11 = AudioSystem.getClip();
            clip11.open(audioIn);
            //clips11.setMicrosecondPosition(timesList.get(2).get(0));
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
            clip12 = AudioSystem.getClip();
            clip12.open(audioIn);
            //clips12.setMicrosecondPosition(timesList.get(2).get(1));
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
            clip13 = AudioSystem.getClip();
            clip13.open(audioIn);
            //clips13.setMicrosecondPosition(timesList.get(2).get(2));
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
            clip14 = AudioSystem.getClip();
            clip14.open(audioIn);
            //clips14.setMicrosecondPosition(timesList.get(2).get(3));
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
            clip15 = AudioSystem.getClip();
            clip15.open(audioIn);
            //clips15.setMicrosecondPosition(timesList.get(2).get(4));
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File("oGolden.wav"));
            clip16 = AudioSystem.getClip();
            clip16.open(audioIn);
            //clips16.setMicrosecondPosition(timesList.get(3).get(0));
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File("oGolden.wav"));
            clip17 = AudioSystem.getClip();
            clip17.open(audioIn);
            //clips17.setMicrosecondPosition(timesList.get(3).get(1));
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File("oGolden.wav"));
            clip18 = AudioSystem.getClip();
            clip18.open(audioIn);
            //clips18.setMicrosecondPosition(timesList.get(3).get(2));
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File("oGolden.wav"));
            clip19 = AudioSystem.getClip();
            clip19.open(audioIn);
            //clips19.setMicrosecondPosition(timesList.get(3).get(3));
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File("oGolden.wav"));
            clip20 = AudioSystem.getClip();
            clip20.open(audioIn);
            //clips20.setMicrosecondPosition(timesList.get(3).get(4));
            audioIn.close();
            
            clips1.add(clip1);
            clips1.add(clip2);
            clips1.add(clip3);
            clips1.add(clip4);
            clips1.add(clip5);
            
            clips2.add(clip6);
            clips2.add(clip7);
            clips2.add(clip8);
            clips2.add(clip9);
            clips2.add(clip10);
            
            
            clips3.add(clip11);
            clips3.add(clip12);
            clips3.add(clip13);
            clips3.add(clip14);
            clips3.add(clip15);
            
            clips4.add(clip16);
            clips4.add(clip17);
            clips4.add(clip18);
            clips4.add(clip19);
            clips4.add(clip20);
            
            
            
            clipsList.add(clips1);
            clipsList.add(clips2);
            clipsList.add(clips3);
            clipsList.add(clips4);
            
            
            
            return clipsList;
           
            
                
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return clipsList;
    }
    
    public void closeAudio(){
        clip1.close();
        clip2.close();
        clip3.close();
        clip4.close();
        clip5.close();
        clip6.close();
        clip7.close();
        clip8.close();
        clip9.close();
        clip10.close();
        clip11.close();
        clip12.close();
        clip13.close();
        clip14.close();
        clip15.close();
        clip16.close();
        clip17.close();
        clip18.close();
        clip19.close();
        clip20.close();
    }
    
    //Parse through document paths until random one reached
    //Create parser to go through file
    //Randomly select a line from that file
    //Return that line
}
