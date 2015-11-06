package my.transcription;

import java.sql.*;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Erica
 */
public class PassiveBE {
    
    private Connection conn;
    private Statement stmt;
    private Random rand;
    
    /**
     * Creates the passive backend.
     */
    public PassiveBE(){
        setupDB();
        rand = new Random();
    }
    /**
     * Sets up the database for use by the backend.
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
    
    private void closeDB(){
        try{
            conn.close();
            stmt.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //Randomly select file from list of them in DB
    //Parse through document paths until random one reached
    //Create parser to go through file
    //Randomly select a line from that file
    //Return that line
}
