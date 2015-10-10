/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;
import java.sql.*;
import java.util.Scanner;
//TODO: set up to simultaneously create new information in LESSONTRACK
//TODO: set up query to get question id numbers

/**
 *
 * @author Erica
 */
public class RegisterBE {
    private String fname;
    private String lname;
    private String username;
    private String password;
    private int questionID;
    private String questionAnswer;
    
    private Connection conn;
    private Statement stmt;
    //private ResultSet rs;
    
    /**
     * Constructor to set up database.
     */
    public RegisterBE(){
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
        }catch(Exception e){
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
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    /**
     * Checks the password against its entered match.
     * @param pw    password to be matched against the original.
     * @return      True if the match enters the initial password.
     */
    public boolean passwordMatch(String pw){
        if (pw.equals(password)){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Inserts the user into the database.
     */
    private void insertUser(){
        String query = "INSERT INTO USERS" 
                + "(Fname, Lname, Username, Password, "
                + "QuestionID, QuestionAnswer) VALUES('"
                + fname + "', '"
                + lname + "', '"
                + username + "', '"
                + password + "', "
                + questionID + ", '"
                + questionAnswer + "');";
        try{
            int changed = stmt.executeUpdate(query);
            if(changed < 1){
                System.out.println("Insert failed.");
            }else{
                closeDB();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
                
    }
    
    /**
     * Sets the information given by the user.
     * @param f     First name as entered.
     * @param l     Last name as entered.
     * @param u     Username as entered.
     * @param p     Initial password as entered.
     * @param p2    Password match as entered.
     * @param id    Number of the security question selected.
     * @param a     Answer of the security question selected.
     */
    public boolean setInfo(String f, String l, String u, String p, String p2, int id, String a){
        password = p;
        if (!passwordMatch(p2)){ //ECL: If the two passwords given don't match.
            password = null;
            System.out.println("Passwords do not match.");
            return false;
        }
        
        fname = f;
        lname = l;
        username = u;
        questionID = id;
        questionAnswer = a;
        
        insertUser();
        
        return true;
    }
}
