/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.sql.*;
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
}
