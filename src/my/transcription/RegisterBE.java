/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;
import java.sql.*;
import java.util.Scanner;
//TODO: (CAU) set up to simultaneously create new information in LESSON_TRACK upon registering 
//TODO: (CAU) set up query to get security question id numbers for registration/forgotton password
//TODO: (CAU) check if user already exists
//TODO: (ECL) check for empty text fields in registration 
//TODO: (ECL) catching errors from SQL

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
     * Checks the password against its entered match. Also checks if either field is blank.
     * @param pw    password to be matched against the original.
     * @return      True if the match enters the initial password.
     */
    public boolean passwordMatch(String pw){
        if (pw.equals(password)) {
            return true;
        }
        //ECL: Checking if password fields are blank.
        else if (password == "" || pw == ""){
            return false;
        }
        
        else {
            return false;
        }
    }
    
    /**
     * Inserts the user into the database.
     * @return      error message if there is one.
     */
    private String insertUser(){
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
            }
            else{
                closeDB();
            }
        }
        catch(Exception e){
            if(e.getMessage().contains("UNIQUE")){
                return "Username already exists. Please try again.";
            }
            return e.getMessage();
        }
        
        return null;
    }
    
    /**
     * Checks if there are any empty fields submitted.
     * @param fname     First name field
     * @param lname     Last name field
     * @param username  Username field
     * @param answer    Security question answer field
     * @return          True if fields are empty.
     */
    private boolean emptyFields(String fname, String lname, String username, String answer){
        if(fname.equals("")){
            return true;
        }else if (lname.equals("")){
            return true;
        }else if (username.equals("")){
            return true;
        }else if (answer.equals("")){
            return true;
        }else{        
            System.out.println("All fields have values.");
            return false;
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
     * @return      Null if there are no errors throughout the process.
     */
    public String setInfo(String f, String l, String u, String p, String p2, int id, String a){
        password = p;
        if (!passwordMatch(p2)){ //ECL: If the two passwords given don't match or are blank
            password = null;
            System.out.println("Passwords do not match.");
            return "Passwords do not match.";
        }
        
        //ECL: Check if any of the fields are empty - if they are, produce error
        if (emptyFields(f, l, u, a)){
            password = null;
            return "Not all fields were filled.";
        }
        fname = f;
        lname = l;
        username = u;
        questionID = id;
        questionAnswer = a;
        
        //ECL: Catch any error messages that might exist and use for popup.
        String success = insertUser();
        if(success != null){
            return success;
        }
        
        return null;
    }
}
