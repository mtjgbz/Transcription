
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
// TODO: pull inputted username and sec ques ans and check agianst DB entries.
//       if match pull password from DB and populate jTextField3 with it
// TODO: ResultSet closed error
    
    private String fname;
    private String lname;
    private String username;
    private String password;
    private int questionID;
    private String questionAnswer;
    
    private Connection conn;
    Statement stmt;
    private ResultSet rs;
    
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
            rs.close();
            stmt.close();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    /**
     * @author Casey
     * @param un the username that the method will pull the security question from
     * @return the security question matching the username given if the username is correct,
     * or an empty string if it isn't.
     */
    public String retrieveSecurityQuestion(String un) {
        username = un;
        String question = null;
        try {
            // 1st Query to pull QuestionID from USERS
            String query1 = "SELECT QuestionID FROM USERS WHERE Username='" + username + "';";
        
            // Execute first query and store in questionID
            rs = stmt.executeQuery(query1);
            if(rs.next()) {
                questionID = rs.getInt("QuestionID");
                // 2nd Query to pull question from SECURITY_QUESTIONS using QuestionID
                String query2 = "SELECT Question FROM SECURITY_QUESTIONS WHERE QuestionID ='" + questionID + "';";
                // Execute second query and store result as a string
                rs = stmt.executeQuery(query2);
                question = rs.getString("Question");
            }
            else {
                question = "";
            }
       
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        // return the security question
        return question;
    }
    
    /**
     * @author Casey
     * @param un username pulled from the trainees input
     * @param qAnswer security question answer that was pulled from the Trainee's input
     * @return either an empty string if the security answer was incorrect, 
     * or the trainee's password if it was correct
     */
    public String validatePassword(String un, String qAnswer) {
        username = un; 
        questionAnswer = qAnswer;
        try {
            String query = "SELECT Password FROM USERS "
                + "WHERE QuestionID ='" + questionID + "' "
                + "AND Username='" + username + "' "
                + "AND QuestionAnswer='" + questionAnswer + "';";
        
            rs = stmt.executeQuery(query);
            if(rs.next()) {
                password = rs.getString("Password");
            }
            else {
                password = "";
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
        return password;
    }
    
}
