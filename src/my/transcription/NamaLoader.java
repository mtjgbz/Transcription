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
    //String path = "/Users/Noah/Documents/YOLOX MIXTEC/Table Sound Files/NamaTable/";
    String path = "/home/mike/Transcription Data/Nama/";
    public ArrayList<Clip> load(){
        ArrayList<Clip> clips = new ArrayList<>();
        AudioInputStream audioIn;
        try {          
            audioIn = AudioSystem.getAudioInputStream(new File(path+"01-01-na3ma3_edited.wav"));
            DataLine.Info info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip1 = (Clip)AudioSystem.getLine(info);
            clip1.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"02-12-na4ma4_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip2 = (Clip)AudioSystem.getLine(info);
            clip2.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"03-21-na4ma4_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip3 = (Clip)AudioSystem.getLine(info);
            clip3.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"04-20-na4ma2_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip4 = (Clip)AudioSystem.getLine(info);
            clip4.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"05-11-na4ma3_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip5 = (Clip)AudioSystem.getLine(info);
            clip5.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"06-10-na3ma2_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip6 = (Clip)AudioSystem.getLine(info);
            clip6.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"07-13-na3ma2_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip7 = (Clip)AudioSystem.getLine(info);
            clip7.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"08-14-na1ma3_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip8 = (Clip)AudioSystem.getLine(info);
            clip8.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"09-17-na1ma4_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip9 = (Clip)AudioSystem.getLine(info);
            clip9.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"10-06-na3ma4_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip10 = (Clip)AudioSystem.getLine(info);
            clip10.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"11-16-na3ma4_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip11 = (Clip)AudioSystem.getLine(info);
            clip11.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"12-15-na14ma2_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip12 = (Clip)AudioSystem.getLine(info);
            clip12.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"13-19-na14ma3_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip13 = (Clip)AudioSystem.getLine(info);
            clip13.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"14-05-na14ma4_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip14 = (Clip)AudioSystem.getLine(info);
            clip14.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"15-24-na14ma13_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip15 = (Clip)AudioSystem.getLine(info);
            clip15.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"16-18-na14ma132_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip16 = (Clip)AudioSystem.getLine(info);
            clip16.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"17-22-na14ma42_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip17 = (Clip)AudioSystem.getLine(info);
            clip17.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"18-09-na1ma32_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip18 = (Clip)AudioSystem.getLine(info);
            clip18.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"19-03-na1ma42_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip19 = (Clip)AudioSystem.getLine(info);
            clip19.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"20-08-na3ma42_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip20 = (Clip)AudioSystem.getLine(info);
            clip20.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"21-02-na4ma13_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip21 = (Clip)AudioSystem.getLine(info);
            clip21.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"22-07-na4ma132_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip22 = (Clip)AudioSystem.getLine(info);
            clip22.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"23-04-na4ma42_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip23 = (Clip)AudioSystem.getLine(info);
            clip23.open(audioIn);
            audioIn.close();
            
            audioIn = AudioSystem.getAudioInputStream(new File(path+"24-23-na4ma42_edited.wav"));
            info = new DataLine.Info(Clip.class, audioIn.getFormat());
            Clip clip24 = (Clip)AudioSystem.getLine(info);
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
            clips.add(clip19);
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
