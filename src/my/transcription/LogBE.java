/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JFrame;

/**
 *
 * @author Erica
 */
public class LogBE {
    private Statement stmt;
    private ResultSet rs;
    
    private JFrame parentFrame;
    
    private static final String TEST_ATTEMPT = "TEST_ATTEMPT";
    private static final String TEST_ANSWER = "TEST_ANSWER";
    private static final String TEST_ID = "TestID";
    private static final String TEST_TABLE = "TESTS";
    
    private static final String PRACTICE_ATTEMPT = "PRACTICE_ATTEMPT";
    private static final String PRACTICE_ANSWER = "PRACTICE_ANSWER";
    private static final String PRACTICE_ID = "PracticeID";
    private static final String PRACTICE_TABLE = "PRACTICE";
    
    /**
     * Creates a backend for the given parent frame
     * @param pFrame    parent frame of the database
     */
    public LogBE(JFrame pFrame){
        parentFrame = pFrame;
        stmt = User.setupDB(parentFrame, getClass().getResource("TAA.db").toString());
    }
    
    /**
     * Creates the list of users to select logs from.
     * @return      Map of usernames mapped to student names.
     */
    public HashMap<String, String> createLogs(){
        try{
            String query = "SELECT * FROM USERS;";
            rs = stmt.executeQuery(query);
            
            HashMap<String, String> userMap = new HashMap<>();
            
            while(rs.next()){
                String fname = rs.getString("Fname");
                String lname = rs. getString("Lname");
                String username = rs.getString("Username");
                
                String name = lname + ", " + fname;
                userMap.put(name, username);
            }

            return userMap;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * Selects all logs from the database on active sessions.
     * @param username  username for the logs.
     * @param isTest    true if pulling from test information, false if pulling from practice
     * @return          ID of logs mapped to respective logs
     */
    public HashMap<ArrayList<String>, Integer> pullResults(String username, boolean isTest){
        try{
            String table;
            String id;
            if(isTest){
                table = TEST_TABLE;
                id = TEST_ID;
            }else{
                table = PRACTICE_TABLE;
                id = PRACTICE_ID;
            }
            String query = "SELECT * FROM " + table + " WHERE Username = '" + username + "';";
            rs = stmt.executeQuery(query);
            
            HashMap<ArrayList<String>, Integer> map = new HashMap<>();
            while(rs.next()){
                int practiceID = rs.getInt(id);
                String date = rs.getString("DateTaken");
                int lesson = rs.getInt("Lesson");
                String sublesson = rs.getString("Sublesson");
                float score = rs.getFloat("Score");
                
                ArrayList<String> info = new ArrayList<>();
                info.add(date);
                info.add("" + lesson);
                info.add(sublesson);
                info.add("" + score);
                
                map.put(info, practiceID);
            }
            rs.close();
            return map;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;        
    }
    
    /**
     * Gets the ID of a row in a log
     * @param date      Date of the log taken
     * @param isTest    True if used for a log for a test, false if for practice
     * @return          The ID if successful, -1 if unsuccessful.
     */
    public int getID(String date, boolean isTest){
        try{
            String name;
            String table;
            if(isTest){
                name = TEST_ID;
                table = TEST_TABLE;
            }else{
                name = PRACTICE_ID;
                table = PRACTICE_TABLE;
            }
            String query = "SELECT " + name + " FROM " + table + " WHERE DATETAKEN = '" 
                    + date + "';";
            rs = stmt.executeQuery(query);
            int practiceID = rs.getInt(name);
            rs.close();
            return practiceID;
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    
    /**
     * Pulls the answers from the database for logs of answers.
     * @param id        ID for the log selected.
     * @param isTest    True if log for a test, false if for practice
     * @return          ArrayList of log rows
     */
    public ArrayList<ArrayList<String>> traineeLog(int id, boolean isTest){
        try{
            String answerTable;
            String attemptTable;
            String columnName;
            if(isTest){
                answerTable = TEST_ANSWER;
                attemptTable = TEST_ATTEMPT;
                columnName = TEST_ID;
            }else{
                answerTable = PRACTICE_ANSWER;
                attemptTable = PRACTICE_ATTEMPT;
                columnName = PRACTICE_ID;
            }
            
            String query = "SELECT * FROM " + answerTable + " AS A JOIN "
                    + attemptTable + " AS T ON A.QuestionID = T.QuestionID WHERE"
                    + " A." + columnName + " = " + id + ";";
            rs = stmt.executeQuery(query);
            
            ArrayList<ArrayList<String>> results = new ArrayList<>();
            while(rs.next()){
                String questionNum = "" + rs.getInt("QuestionNum");
                String attempt = "" + rs.getInt("Attempt");
                String response = rs.getString("Response");
                String answer = rs.getString("Answer");
                
                ArrayList<String> row = new ArrayList<>();
                row.add(questionNum);
                row.add(attempt);
                row.add(response);
                row.add(answer);
                
                results.add(row);
            }            
            System.out.println(results);
            return results;
        }catch(Exception e){
            e.printStackTrace();
        }
            
        return null;
    }
}
