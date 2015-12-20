package my.transcription;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mike
 */
public class AudioClip {
    File file;
    long startPos;
    long stopPos;
    
    public AudioClip(){
       this.file = new File("/home/mike/Transcription Data/Tones/01-01-na3ma3_edited.wav");
       stopPos = 0;
    }
    
    public AudioClip(File file){
       this.file = file;
       stopPos = 0;
       
    }
    public AudioClip(File file, long startPos, long stopPos){
        this.file=file;
        this.startPos=startPos;
        this.stopPos = stopPos;
    }
    
    public void start(){
        AudioInputStream audioIn;
        try {
                        System.out.print("playback dones");

            audioIn = AudioSystem.getAudioInputStream(file);
            AudioFormat format = audioIn.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class,format);
            SourceDataLine dataLine  = (SourceDataLine) AudioSystem.getLine(info);
            dataLine.open(format);
            dataLine.start();
            float byteRate = format.getFrameSize()*format.getFrameRate();
            byte[] bytesBuffer;
            if(stopPos==0){
                bytesBuffer = new byte[dataLine.getBufferSize()];
            }else{
                long difference = stopPos-startPos;
                
                float length = (float) (difference/1e6);
                
                int bytes = (int) (length*byteRate);
                
                bytesBuffer = new byte[bytes];
            }  
            int off = (int) (byteRate*startPos/1e6);
            
            
            int bytesRead = audioIn.read(bytesBuffer);
            dataLine.write(bytesBuffer,off,bytesRead);
            dataLine.drain();
            dataLine.close();
            
            audioIn.close();
            
            
            
            
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
            Logger.getLogger(AudioClip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
