package my.transcription;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.*;
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
    
    /**
     * Creates the passive backend.
     */
    public PassiveBE(){
        setupDB();
        rand = new Random();
        clips = new ArrayList<File>();
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
            
            System.out.println(path);
            String soundName = path.replace(".trs", ".wav");
            soundName = soundName.replace("Transcripciones", "Sonido");
            if(soundName.contains("_ed")){
                soundName = soundName.split("_ed")[0];
                soundName = soundName + ".wav";
                
            }
            clips.add(new File(soundName));
            
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
    //Parse through document paths until random one reached
    //Create parser to go through file
    //Randomly select a line from that file
    //Return that line
}
