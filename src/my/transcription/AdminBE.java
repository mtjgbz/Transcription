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
}
