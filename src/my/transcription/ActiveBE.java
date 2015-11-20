/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;



/**
 *
 * @author mike
 */
public class ActiveBE {
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private Random rand;
    private static ArrayList<File> clips;
    private static ArrayList<String> phrases;
    private static ArrayList<String> words;
    
    private Clip clip;
    private boolean isTest;
    
    public ActiveBE(boolean isTest) {
        this.isTest=isTest;
        setupDB();
        rand = new Random();
        clips = new ArrayList<>();
    }
     
     /**
     * Sets up the database for use by the backend.
     */
    private void setupDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:TAA.db");
            System.out.println("Database opened successfully.");
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Break down the database after use.
     */
    private void closeDB() {
        try {
            conn.close();
            stmt.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Clip makeClip(int pageNum){
        
        AudioInputStream audioIn;
        try {
            //audioIn = AudioSystem.getAudioInputStream(clips.get(pageNum-1));
            audioIn = AudioSystem.getAudioInputStream(new File("oGolden.wav"));
            clip = AudioSystem.getClip();
            clip.open(audioIn);
        //clips1.setMicrosecondPosition(timesList.get(0).get(0));
            audioIn.close();
            return clip;
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(ActiveBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ActiveBE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(ActiveBE.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return clip;
    }
    
    public void closeAudio(){
        clip.close();
    }
    
    public void submit(ArrayList<String> answerList){
        if(isTest){
            
        }else{
            
        }
    }
}
