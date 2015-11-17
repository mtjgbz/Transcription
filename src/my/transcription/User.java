/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

/**
 *
 * @author Erica
 */
public class User {
    
    private static Connection conn;
    
    /**
     * Creates the window for the file browser and sets it visible.
     */
    public static void updateLessonFile(){
        UpdateLessonFile frame = new UpdateLessonFile();
        frame.setVisible(true);
    }
    
    /**
     * Creates the text file with the list of applicable transcriptions for 
     * each lesson. Updates the database with the resulting text file.
     * @param transcriptions    Path where all the transcription files are located
     * @param path              Path for the text file to be stored in
     */
    public static void createTextFile(String transcriptions, String path){
        try{
            Statement stmt = setupDB();
            Statement stmt2 = setupDB();
            String query = "SELECT Lesson, Sublesson FROM LESSON_PLAN";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<String> filePaths = new ArrayList<String>();
            ArrayList<Integer> lessons = new ArrayList<Integer>();
            ArrayList<String> sublessons = new ArrayList<String>();
            while(rs.next()){
                int lesson = rs.getInt("Lesson");
                String sublesson = rs.getString("Sublesson");
                query = "SELECT RegularExpression FROM LESSON_PLAN WHERE "
                        + "Lesson = " + lesson + " AND "
                        + "Sublesson LIKE '" + sublesson + "';";
                ResultSet rsExp = stmt2.executeQuery(query);
                
                lessons.add(lesson);
                sublessons.add(sublesson);
                
                String regex = rsExp.getString("RegularExpression");
                String filePath = path + "lesson" + lesson + "-" + sublesson + ".txt";
                BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
                
                searchFile(regex, transcriptions, out);
                
                filePaths.add(filePath);
                out.close();
            }
            stmt2.close();
            closeDB(stmt, rs);
            
            stmt = setupDB();
            for(int i = 0; i < filePaths.size(); i++){
                String newQuery = "UPDATE LESSONS SET FileList = '" + filePaths.get(i) + "' "
                        + "WHERE Lesson = " + lessons.get(i) + " AND "
                        + "Sublesson LIKE '" + sublessons.get(i) + "';";
                System.out.println(newQuery);
                stmt.execute(newQuery);
            }
            closeDB(stmt);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    /**
     * Searches the directory given and uses the given writer to write the path 
     * to the text file if it matches requirements.
     * @param regex     Regular expression to search the transcription files
     * @param path      Directory or file to search for transcription files
     * @param out       Writer for the final text file
     */
    private static void searchFile(String regex, String path, BufferedWriter out){
        try{
            //Search through all the files
            File home = new File(path);
            File[] fileList = home.listFiles();
            if(fileList == null){
                return;
            }
            //System.out.println(path);
            for(File f : fileList){
            //If it's null, return so
            //If it's a folder, search through that as well
                if (f.isDirectory()){
                    searchFile(regex, f.getPath(), out);
                }
            //If it's .trs, search it using printName
                else if(f.getName().contains(".trs")){
                    if(setupFile(f.getPath(), regex)){
                        try{
                            out.write(f.getPath());
                            out.newLine();
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }
            //If it comes up "positive" add it to a .txt file
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * Searches the given file to see if there is any phrase matching the regular
     * expression given.
     * @param filename  File to search with regular expression
     * @param regex     Regular expression to search with
     * @return          True if the file contains a word matching the regular expression
     */
    private static boolean setupFile(String filename, String regex){
        try{
            File inputFile = new File(filename);
            DocumentBuilderFactory dbFactory
                    = DocumentBuilderFactory.newInstance();
            dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Sync");
            Pattern regexp = Pattern.compile(regex);
            Matcher matcher = regexp.matcher(inputFile.getName());
            
            //System.out.println(inputFile.getName());
            
            for (int i = 0; i < nList.getLength(); i++){
                Node nNode = nList.item(i);
                String value = nNode.getNextSibling().getNodeValue();
                matcher.reset(value);

                if(matcher.find()){
                    //System.out.println(value);
                    return true;
                }
            }
            return false;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
    
    /**
     * Sets up the database.
     * @return Statement that is a part of the database
     */
    public static Statement setupDB(){
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:TAA.db");
            System.out.println("Database opened successfully.");
            Statement stmt = conn.createStatement();
            return stmt;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Closes the connection to the database
     * @param stmt Statement to be closed with the database
     */
    public static void closeDB(Statement stmt){
        try{
            stmt.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * Closes the connection to the database.
     * @param stmt  Statement to be closed with the database
     * @param rs    ResultSet to be closed with the database
     */
    public static void closeDB(Statement stmt, ResultSet rs){
        try{
            stmt.close();
            rs.close();
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
