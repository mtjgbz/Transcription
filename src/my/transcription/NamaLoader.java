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
import javax.sound.sampled.LineEvent;
import static javax.sound.sampled.LineEvent.Type.STOP;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author mike
 */
public class NamaLoader {
    
    String path = "/home/mike/Transcription Data/Nama/";
    public ArrayList<Clip> load(){
        ArrayList<Clip> clips = new ArrayList<>();
        AudioInputStream audioIn;
        try {          
            audioIn = AudioSystem.getAudioInputStream(new File(path+"01-01-na3ma3_edited.wav"));
            Clip clip1 = AudioSystem.getClip();
            clip1.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"02-12-na4ma4_edited.wav"));
            Clip clip2 = AudioSystem.getClip();
            clip2.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"03-21-na4ma4_edited.wav"));
            Clip clip3 = AudioSystem.getClip();
            clip3.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"04-20-na4ma2_edited.wav"));
            Clip clip4 = AudioSystem.getClip();
            clip4.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"05-11-na4ma3_edited.wav"));
            Clip clip5 = AudioSystem.getClip();
            clip5.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"06-10-na3ma2_edited.wav"));
            Clip clip6 = AudioSystem.getClip();
            clip6.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"07-13-na3ma2_edited.wav"));
            Clip clip7 = AudioSystem.getClip();
            clip7.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"08-14-na1ma3_edited.wav"));
            Clip clip8 = AudioSystem.getClip();
            clip8.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"09-17-na1ma4_edited.wav"));
            Clip clip9 = AudioSystem.getClip();
            clip9.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"10-06-na3ma4_edited.wav"));
            Clip clip10 = AudioSystem.getClip();
            clip10.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"11-16-na3ma4_edited.wav"));
            Clip clip11 = AudioSystem.getClip();
            clip11.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"12-15-na14ma2_edited.wav"));
            Clip clip12 = AudioSystem.getClip();
            clip12.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"13-19-na14ma3_edited.wav"));
            Clip clip13 = AudioSystem.getClip();
            clip13.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"14-05-na14ma4_edited.wav"));
            Clip clip14 = AudioSystem.getClip();
            clip14.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"15-24-na14ma13_edited.wav"));
            Clip clip15 = AudioSystem.getClip();
            clip15.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"16-18-na14ma132_edited.wav"));
            Clip clip16 = AudioSystem.getClip();
            clip16.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"17-22-na14ma42_edited.wav"));
            Clip clip17 = AudioSystem.getClip();
            clip17.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"18-09-na1ma32_edited.wav"));
            Clip clip18 = AudioSystem.getClip();
            clip18.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"19-03-na1ma42_edited.wav"));
            Clip clip19 = AudioSystem.getClip();
            clip19.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"20-08-na3ma42_edited.wav"));
            Clip clip20 = AudioSystem.getClip();
            clip20.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"21-02-na4ma13_edited.wav"));
            Clip clip21 = AudioSystem.getClip();
            clip21.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"22-07-na4ma132_edited.wav"));
            Clip clip22 = AudioSystem.getClip();
            clip22.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"23-04-na4ma42_edited.wav"));
            Clip clip23 = AudioSystem.getClip();
            clip23.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"24-23-na4ma42_edited.wav"));
            Clip clip24 = AudioSystem.getClip();
            clip24.open(audioIn);
            audioIn.close();
            
            clips.add(clip1);
            clips.add(clip2);
            clips.add(clip3);
            clips.add(clip4);
            clips.add(clip5);
            clips.add(clip6);
            clips.add(clip7);
            clips.add(clip8);
            clips.add(clip9);
            clips.add(clip10);
            clips.add(clip11);
            clips.add(clip12);
            clips.add(clip13);
            clips.add(clip14);
            clips.add(clip15);
            clips.add(clip16);
            clips.add(clip17);
            clips.add(clip18);
            clips.add(clip18);
            clips.add(clip20);
            clips.add(clip21);
            clips.add(clip22);
            clips.add(clip23);
            clips.add(clip24);
            
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(NamaLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(NamaLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(NamaLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clips;
    }
}
