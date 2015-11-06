package my.transcription;

import java.io.*;
import java.sql.*;
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
            
            String line = reader.readLine();
            while (line != null){
                line = reader.readLine();
            }
                      
            
            int num = Integer.parseInt(line);
            int random = rand.nextInt() % num;
            
            reader.setLineNumber(random);
            path = reader.readLine();
            return path;
            
        }catch(Exception e){
            e.printStackTrace();
        }
        closeDB();
        return null;
    }
    
    public String findPhrase(String document){
        try{
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
                        return value;
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
