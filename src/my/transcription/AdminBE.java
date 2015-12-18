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
    
    public HashMap<ArrayList<String>, Integer> userPractice(String username){
        try{
            String query = "SELECT * FROM PRACTICE WHERE Username = '" + username + "';";
            rs = stmt.executeQuery(query);
            
            HashMap<ArrayList<String>, Integer> practiceMap = new HashMap<>();
            while(rs.next()){
                int practiceID = rs.getInt("PracticeID");
                String date = rs.getString("DateTaken");
                int lesson = rs.getInt("Lesson");
                String sublesson = rs.getString("Sublesson");
                float score = rs.getFloat("Score");
                
                ArrayList<String> practiceInfo = new ArrayList<>();
                practiceInfo.add(date);
                practiceInfo.add("" + lesson);
                practiceInfo.add(sublesson);
                practiceInfo.add("" + score);
                
                practiceMap.put(practiceInfo, practiceID);
            }
            return practiceMap;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;        
    }
    
    public int getPracticeID(String date){
        try{
            String query = "SELECT PracticeID FROM PRACTICE WHERE DATETAKEN = " + date;
            rs = stmt.executeQuery(query);
            int practiceID = rs.getInt("PracticeID");
            return practiceID;
        }catch(Exception e){
            e.printStackTrace();
        }
        return -1;
    }
    
    public ArrayList<ArrayList<String>> traineeLog(int practiceID){
        try{
            String query = "SELECT * FROM PRACTICE_ANSWER AS A JOIN PRACTICE_ATTEMPT AS T "
                    + "ON A.QuestionID = T.QuestionID WHERE A.PracticeID = "
                    + practiceID + ";";
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
        }catch(Exception e){
            
        }
            
        return null;
    }
}
