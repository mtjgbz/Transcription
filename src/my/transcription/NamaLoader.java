/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author mike
 */
public class NamaLoader {

    private static String path;
    private ArrayList<File> fileList;

    /**
     * Creates the necessary files for nama table to work
     * @param path Path as a Sting to the files associated with the nama table 
     */
    public void makeFiles(String path) {
        this.path = path;
        fileList.add(new File(path + "01-01-na3ma3_edited.wav"));
        fileList.add(new File(path + "02-12-na4ma4_edited.wav"));
        fileList.add(new File(path + "03-21-na4ma4_edited.wav"));
        fileList.add(new File(path + "04-20-na4ma2_edited.wav"));
        fileList.add(new File(path + "05-11-na4ma3_edited.wav"));
        fileList.add(new File(path + "06-10-na3ma2_edited.wav"));
        fileList.add(new File(path + "07-13-na3ma2_edited.wav"));
        fileList.add(new File(path + "08-14-na1ma3_edited.wav"));
        fileList.add(new File(path + "09-17-na1ma4_edited.wav"));
        fileList.add(new File(path + "10-06-na3ma4_edited.wav"));
        fileList.add(new File(path + "11-16-na3ma4_edited.wav"));
        fileList.add(new File(path + "12-15-na14ma2_edited.wav"));
        fileList.add(new File(path + "13-19-na14ma3_edited.wav"));
        fileList.add(new File(path + "14-05-na14ma4_edited.wav"));
        fileList.add(new File(path + "15-24-na14ma13_edited.wav"));
        fileList.add(new File(path + "16-18-na14ma132_edited.wav"));
        fileList.add(new File(path + "18-09-na1ma32_edited.wav"));
        fileList.add(new File(path + "19-03-na1ma42_edited.wav"));
        fileList.add(new File(path + "20-08-na3ma42_edited.wav"));
        fileList.add(new File(path + "21-02-na4ma13_edited.wav"));
        fileList.add(new File(path + "22-07-na4ma132_edited.wav"));
        fileList.add(new File(path + "23-04-na4ma42_edited.wav"));
        fileList.add(new File(path + "24-23-na4ma42_edited.wav"));

    }

    /**
     * Creates clips from each file
     * 
     * @return Returns an ArrayList of the clips created
     */
    public ArrayList<Clip> load() {
        ArrayList<Clip> clips = new ArrayList<>();
        AudioInputStream audioIn;
        try {
            for (File file : fileList) {
                audioIn = AudioSystem.getAudioInputStream(file);
                DataLine.Info info = new DataLine.Info(Clip.class, audioIn.getFormat());
                Clip clip = (Clip) AudioSystem.getLine(info);
                clip.open(audioIn);
                audioIn.close();

                clips.add(clip);
            }

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(NamaLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clips;
    }
}
