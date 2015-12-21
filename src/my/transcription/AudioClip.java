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

    private File file;
    private long startPos;
    private long stopPos;
    private boolean stopped = true;
    private int totalToRead;
    private int offset;

    public AudioClip() {
        this.file = new File("/home/mike/Transcription Data/Tones/01-01-na3ma3_edited.wav");
        stopPos = 0;
    }

    public AudioClip(File file) {
        this.file = file;
        stopPos = 0;
        

    }

    public AudioClip(File file, long startPos, long stopPos) {
        this.file = file;
        this.startPos = startPos;
        this.stopPos = stopPos;
        offset = (int) (stopPos - startPos);
    }

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

    public void stop() {
        stopped = true;
    }
}
