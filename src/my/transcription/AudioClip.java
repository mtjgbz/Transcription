package my.transcription;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineListener;
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

    private File file;
    private long startPos;
    private long stopPos;
    private boolean stopped = true;
    private int totalToRead;
    private int offset;
    


    /**
     * Creates a new AudioClip from the given file
     * @param file Audio file from which the clip will play
     */
    public AudioClip(File file) {
        this.file = file;
        stopPos = 0;
        

    }
    
    /**
     * Creates a new AudioClip from the given file starting at a certain
     * microsecond position, and ending at another
     * 
     * @param file Audio file from which the clip will play
     * @param startPos Microsecond position at which the clip will start
     * @param stopPos Microsecond position at which the clip will stop
     */
    public AudioClip(File file, long startPos, long stopPos) {
        this.file = file;
        this.startPos = startPos;
        this.stopPos = stopPos;
        offset = (int) (stopPos - startPos);
    }

    /**
     * Starts the clip playing
     */
    public void start() {
        AudioInputStream audioIn;
        try {

            audioIn = AudioSystem.getAudioInputStream(file);
            AudioFormat format = audioIn.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine dataLine = (SourceDataLine) AudioSystem.getLine(info);
            dataLine.open(format);
            dataLine.start();
            stopped = false;
            byte[] bytesBuffer = new byte[audioIn.available()];
            int bytesToRead = audioIn.available();
            int total = 0;
            int bytesRead;
            boolean first = true;
            if (stopPos == 0) {
                while (((bytesRead = audioIn.read(bytesBuffer, 0, bytesToRead)) != -1) && !stopped) {
                    bytesToRead = audioIn.available();
                    dataLine.write(bytesBuffer, 0, bytesRead);

                }
            } else {
                while (total < totalToRead && !stopped) {
                    bytesToRead = audioIn.available();
                    if (first) {
                        bytesRead = audioIn.read(bytesBuffer, offset, bytesToRead);
                    } else {
                        bytesRead = audioIn.read(bytesBuffer, 0, bytesToRead);
                    }
                    if (bytesRead == -1) {
                        break;
                    }
                    total += bytesRead;
                    dataLine.write(bytesBuffer, 0, bytesRead);

                }
            }
            dataLine.drain();
            dataLine.close();

            audioIn.close();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
            Logger.getLogger(AudioClip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Starts the clip playing with a given LineListener
     * 
     * @param listener Linelistener to be added to the clip
     */
    public void start(LineListener listener) {
        AudioInputStream audioIn;
        try {

            audioIn = AudioSystem.getAudioInputStream(file);
            AudioFormat format = audioIn.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine dataLine = (SourceDataLine) AudioSystem.getLine(info);
            dataLine.open(format);
            dataLine.addLineListener(listener);
            dataLine.start();
            stopped = false;
            byte[] bytesBuffer = new byte[audioIn.available()];
            int bytesToRead = audioIn.available();
            int total = 0;
            int bytesRead;
            boolean first = true;
            if (stopPos == 0) {
                while (((bytesRead = audioIn.read(bytesBuffer, 0, bytesToRead)) != -1) && !stopped) {
                    bytesToRead = audioIn.available();
                    dataLine.write(bytesBuffer, 0, bytesRead);

                }
            } else {
                while (total < totalToRead && !stopped) {
                    bytesToRead = audioIn.available();
                    if (first) {
                        bytesRead = audioIn.read(bytesBuffer, offset, bytesToRead);
                    } else {
                        bytesRead = audioIn.read(bytesBuffer, 0, bytesToRead);
                    }
                    if (bytesRead == -1) {
                        break;
                    }
                    total += bytesRead;
                    dataLine.write(bytesBuffer, 0, bytesRead);

                }
            }
            dataLine.drain();
            dataLine.close();

            audioIn.close();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
            Logger.getLogger(AudioClip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    /**
     * Starts the clip playing with multiple LineListeners
     * 
     * @param listeners ArrayList of LineListeners to be added to the clip
     */
    public void start(ArrayList<LineListener> listeners) {
        AudioInputStream audioIn;
        try {

            audioIn = AudioSystem.getAudioInputStream(file);
            AudioFormat format = audioIn.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine dataLine = (SourceDataLine) AudioSystem.getLine(info);
            dataLine.open(format);
            for(LineListener listen:listeners){
                dataLine.addLineListener(listen);
            }
            dataLine.start();
            stopped = false;
            byte[] bytesBuffer = new byte[audioIn.available()];
            int bytesToRead = audioIn.available();
            int total = 0;
            int bytesRead;
            boolean first = true;
            if (stopPos == 0) {
                while (((bytesRead = audioIn.read(bytesBuffer, 0, bytesToRead)) != -1) && !stopped) {
                    bytesToRead = audioIn.available();
                    dataLine.write(bytesBuffer, 0, bytesRead);

                }
            } else {
                while (total < totalToRead && !stopped) {
                    bytesToRead = audioIn.available();
                    if (first) {
                        bytesRead = audioIn.read(bytesBuffer, offset, bytesToRead);
                    } else {
                        bytesRead = audioIn.read(bytesBuffer, 0, bytesToRead);
                    }
                    if (bytesRead == -1) {
                        break;
                    }
                    total += bytesRead;
                    dataLine.write(bytesBuffer, 0, bytesRead);

                }
            }
            dataLine.drain();
            dataLine.close();

            audioIn.close();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
            Logger.getLogger(AudioClip.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Stops the clip 
     */
    public void stop() {
        stopped = true;
    }
}
