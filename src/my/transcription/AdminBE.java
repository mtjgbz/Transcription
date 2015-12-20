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
public class AdminBE {
    private Statement stmt;
    private ResultSet rs;
    
    private JFrame parentFrame;
    
    public AdminBE(JFrame pFrame){
        parentFrame = pFrame;
    }
    
    public HashMap<String, String> createLogs(){
        try{
            stmt = User.setupDB(parentFrame, getClass().getResource("TAA.db").toString());
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
    
    public HashMap<ArrayList<String>, Integer> pullResults(String username, boolean isTest){
        try{
            String table;
            String id;
            if(isTest){
                table = "TESTS";
                id = "TestID";
            }else{
                table = "PRACTICE";
                id = "PracticeID";
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
    
    public int getID(String date, boolean isTest){
        try{
            String name;
            String table;
            if(isTest){
                name = "TestID";
                table = "TESTS";
            }else{
                name = "PracticeID";
                table = "PRACTICE";
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
    
    public ArrayList<ArrayList<String>> traineeLog(int id, boolean isTest){
        try{
            String answerTable;
            String attemptTable;
            String columnName;
            if(isTest){
                answerTable = "TEST_ANSWER";
                attemptTable = "TEST_ATTEMPT";
                columnName = "TestID";
            }else{
                answerTable = "PRACTIC_ANSWER";
                attemptTable = "PRACTICE_ATTEMPT";
                columnName = "PracticeID";
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
