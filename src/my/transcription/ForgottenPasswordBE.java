
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;
import java.sql.*;
import java.util.Scanner;
/**
 *
 * @author Casey
 */
public class ForgottenPasswordBE {
// TODO: pull security question from DB and populate jTextField4 with it
// TODO: pull inputted username and security question answer and check agianst DB entries.
//       if match pull password from DB and populate jTextField3 with it
    
    private String fname;
    private String lname;
    private String username;
    private String password;
    private int questionID;
    private String questionAnswer;
    
    private Connection conn;
    Statement stmt;
    //private ResultSet rs;
    
    /**
     * Constructor to set up database.
     */
    public ForgottenPasswordBE(){
        setupDB();
    }
    
    /**
     * Sets up the database to connect from. 
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
    
    /**
     * Closes the database connection and all similar statements and results.
     */
    public void closeDB(){
        try{
            //rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
