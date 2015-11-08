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
            
            System.out.println("Line num: " + lineCount);
            //get a random line number from the total number of lines
            int random = rand.nextInt(lineCount +1);
            System.out.println("Random: " + random);
            
            //reset lineReader to the beginnig of the file so can read up to the random line
            //and then return it
            reader.reset();
            System.out.println("Line before loop: " + reader.getLineNumber());
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
    
    public ArrayList<String> findPhrase(String document){
        try{
            ArrayList<String> phrase = new ArrayList<String>();
            File file = new File(document);
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            NodeList nList = doc.getElementsByTagName("Sync");
            
            Pattern regexp = Pattern.compile("[a-zñ][aeiou]([134])[a-zñ][aeiou]\\1");       //example exp - change later
            Matcher matcher = regexp.matcher(file.getName());
            
            int count = Math.abs(rand.nextInt() % nList.getLength());
            
            for(int i = 0; i < nList.getLength(); i++){
                Node nNode = nList.item(i);
                NamedNodeMap attributes = nNode.getAttributes();
                String value = nNode.getNextSibling().getNodeValue();
                matcher.reset(value);
                if(matcher.find()){
                    if(i >= count){
                        phrase.add(attributes.getNamedItem("time").toString());
                        phrase.add(value);
                        NamedNodeMap nextAttributes = nList.item(i + 1).getAttributes();
                        phrase.add(nextAttributes.getNamedItem("time").toString());
                        return phrase;
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
