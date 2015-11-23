/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.io.File;
import java.io.IOException;
import java.sql.*;
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
    private Random rand;
    private Statement stmt;
    private static ArrayList<File> clips;
    private static ArrayList<String> phrases;
    private static ArrayList<String> words;
    
    private Clip clip;
    private boolean isTest;
    
    public ActiveBE(boolean isTest) {
        this.isTest=isTest;
        stmt = User.setupDB();
        rand = new Random();
        clips = new ArrayList<>();
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
    
    public void submit(ArrayList<String> answerList, ArrayList<String> attemptList){
        if(isTest){
            
        }else{
            
        }
    }
    
    public int newPractice(String username, int lesson, char sublesson){
        try{
        String query = "INSERT INTO PRACTICE(Username, DateTaken, Lesson, Sublesson, DateTaken)"
                + " VALUES('" + username + "', " + lesson + ", '" + sublesson + "', "
                + "NOW());";
        stmt.execute(query);
        query = "SELECT(PracticeID) FROM PRACTICE WHERE PracticeID = LAST_INSERT_ROWID();";
        ResultSet rs = stmt.executeQuery(query);
        int id = rs.getInt("PracticeID");
        rs.close();
        return id;
        }catch(Exception e){
            e.printStackTrace();
        }
        return 0;
    }
    
    public void newAttempt(){
        
    }
}
