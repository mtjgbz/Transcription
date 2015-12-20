/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
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
import javax.swing.JOptionPane;
import static my.transcription.Nasalizations.errorMsg;

/**
 *
 * @author Noah
 */
public class Nasalizations extends javax.swing.JFrame {
    
    Clip clip;
    int buttonNum = 0;
    int numOfButtons = 18;
    ArrayList<ArrayList<String>> stringNames = new ArrayList<>();
    ArrayList<Integer> count = new ArrayList<>();
    private static String path;
    
    /**
     * Creates new form Nasalizations
     */
    public Nasalizations(String path) {
        initComponents();
        this.setTitle("Transcripción Mixteca: Mesa de Nasalización");
        this.setLocation(x, y);
        this.path = path;
        for (int i = 0; i < numOfButtons; i++) {
            count.add(0);
        }
        
        /**
         * creates the ArrayLists for the ArrayList stringNames and adds them
         */
        ArrayList<String> i0 = new ArrayList<>();//1.1b
        i0.add("b_1-1_ku71u1-ku71un1_edited.wav");
        i0.add("b_1-1_ku71u1-ku71un1_edited.wav");
        stringNames.add(i0);
        ArrayList<String> i1 = new ArrayList<>();//1.1e
        i1.add("e_1-1_bi1xi1-bi1xin1_edited.wav");
        i1.add("e_1-1_nda1ka1-nda1kan1_edited.wav");
        stringNames.add(i1);
        ArrayList<String> i2 = new ArrayList<>();//3.3a
        i2.add("a_3-3_ku3u3-ku3un3_edited.wav");
        i2.add("a_3-3_kwi3i3-kwi3in3_edited.wav");
        i2.add("a_3-3_tu3u3-tu3un3_edited.wav");
        stringNames.add(i2);
        ArrayList<String> i3 = new ArrayList<>();//3.3b
        i3.add("b_3-3_ka73a3-ka73an3_edited.wav");
        stringNames.add(i3);
        ArrayList<String> i4 = new ArrayList<>();//4.4a
        i4.add("a_4-4_i4i4-i4in4_edited.wav");
        stringNames.add(i4);
        ArrayList<String> i5 = new ArrayList<>();//4.4b
        i5.add("b_4-4_xi74i4-xi74in4_edited.wav");
        stringNames.add(i5);
        ArrayList<String> i6 = new ArrayList<>();//4.2b
        i6.add("b_4-2_xa74a2-xa74an2_edited.wav");
        stringNames.add(i6);
        ArrayList<String> i7 = new ArrayList<>();//4.3b
        i7.add("b_4-3_i74i3-i74in3_edited.wav");
        stringNames.add(i7);
        ArrayList<String> i8 = new ArrayList<>();//4.3e
        i8.add("e_4-3_ka4xi3-ka4xin3_edited.wav");
        i8.add("e_4-3_xu4xa3-xu4xan3_edited.wav");
        stringNames.add(i8);
        ArrayList<String> i9 = new ArrayList<>();//3.2e
        i9.add("e_3-2_i3tu2-i3tun2_edited.wav");
        stringNames.add(i9);
        ArrayList<String> i10 = new ArrayList<>();//1.3a
        i10.add("a_1-3_ka1a3-ka1an3_edited.wav");
        i10.add("a_1-3_ta1a3-ta1an3_edited.wav");
        stringNames.add(i10);
        ArrayList<String> i11 = new ArrayList<>();//1.4a
        i11.add("a_1-4_xi1i4-xi1in4_edited.wav");
        stringNames.add(i11);
        ArrayList<String> i12 = new ArrayList<>();//1.4b
        i12.add("b_1-4_tiu71u4-tiu71un4_edited.wav");
        stringNames.add(i12);
        ArrayList<String> i13 = new ArrayList<>();//1.4e
        i13.add("e_1-4_is1ta4-is1tan4_edited.wav");
        i13.add("e_1-4_ka1tu4-ka1tun4_edited.wav");
        i13.add("e_1-4_tiu1ku4-tiu1kun4_edited.wav");
        stringNames.add(i13);
        ArrayList<String> i14 = new ArrayList<>();//3.4a
        i14.add("e_3-4_i3ki4-i3kin4_edited.wav");//need
        i14.add("e_3-4_i3ki4-i3kin4_edited.wav");//need
        i14.add("e_3-4_i3ki4-i3kin4_edited.wav");//need
        stringNames.add(i14);
        ArrayList<String> i15 = new ArrayList<>();//3.4b
        i15.add("b_3-4_ka73a4-ka73an4_edited.wav");
        stringNames.add(i15);
        ArrayList<String> i16 = new ArrayList<>();//3.4e
        i16.add("e_3-4_i3ki4-i3kin4_edited.wav");
        i16.add("e_3-4_ndi3ki4-ndi3kin4_edited.wav");
        i16.add("e_3-4_sa3ka4-sa3kan4_edited.wav");
        i16.add("e_3-4_tu3tu4-tu3tun4_edited.wav");
        stringNames.add(i16);
        ArrayList<String> i17 = new ArrayList<>();//4.24a
        i17.add("a_4-24_kwa4a24-kwa4an4_edited.wav");
        stringNames.add(i17);
    }
    
    /**
     * Error Message Pop-Up
     * @param infoMessage
     * @param titleBar
     */
    public static void errorMsg(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "Error: " + titleBar, JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * method that creates the audio clip every time the button is clicked to
     * avoid heap space errors
     */
    public void buttonAction() {
        AudioInputStream audioIn = null;
        try {
            if (clip == null || !clip.isOpen()) {
                audioIn = AudioSystem.getAudioInputStream(new File(path + stringNames.get(buttonNum).get(count.get(buttonNum))));
                clip = AudioSystem.getClip();
                clip.open(audioIn);
                audioIn.close();
                clip.addLineListener(listener);
                clip.start();
            } else {
                clip.stop();
                
                audioIn = AudioSystem.getAudioInputStream(new File(path + stringNames.get(buttonNum).get(count.get(buttonNum))));
                clip = AudioSystem.getClip();
                clip.open(audioIn);
                audioIn.close();
                clip.addLineListener(listener);
                clip.start();
            }
            
        } catch (FileNotFoundException ex) {
            errorMsg("Nasalization Audio no Encontrado, Por favor tenga carga de Ddministración de archivos de Audio.", "Nasalización");
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Nasalizations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Nasalizations.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Nasalizations.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (count.get(buttonNum).equals(stringNames.get(buttonNum).size() - 1)) {
            count.set(buttonNum, 0);
        } else {
            int value = count.get(buttonNum);
            value = value + 1;
            count.set(buttonNum, value);
        }
    }
    
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
    Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();
    
    int x = (int) rect.getMaxX();
    int y = 0;
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        
        jScrollPane2 = new javax.swing.JScrollPane();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        
        jScrollPane2.setHorizontalScrollBar(null);
        
        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton1.setText("<html><center>ka'<sup>1</sup>a<sup>1</sup>/ka'<sup>1</sup>an<sup>1</sup><br>ku'<sup>1</sup>u<sup>1</sup>/ku'<sup>1</sup>un<sup>1</sup></center></html>\\n");
        jButton1.setMaximumSize(new java.awt.Dimension(160, 60));
        jButton1.setMinimumSize(new java.awt.Dimension(160, 60));
        jButton1.setPreferredSize(new java.awt.Dimension(160, 60));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        
        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton2.setText("<html><center>bi<sup>1</sup>xi<sup>1</sup>/bi<sup>1</sup>xin<sup>1</sup><br>nda<sup>1</sup>ka<sup>1</sup>/nda<sup>1</sup>kan<sup>1</sup></center></html>\\n");
        jButton2.setMaximumSize(new java.awt.Dimension(160, 60));
        jButton2.setMinimumSize(new java.awt.Dimension(160, 60));
        jButton2.setPreferredSize(new java.awt.Dimension(160, 60));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        
        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton3.setText("<html><center>ku<sup>3</sup>u<sup>3</sup>/ku<sup>3</sup>un<sup>3</sup><br>kwi<sup>3</sup>i<sup>3</sup>/kwi<sup>3</sup>in<sup>3</sup><br>tu<sup>3</sup>u<sup>3</sup>/tu<sup>3</sup>un<sup>3</sup></center></html>\\n");
        jButton3.setMaximumSize(new java.awt.Dimension(160, 60));
        jButton3.setMinimumSize(new java.awt.Dimension(160, 60));
        jButton3.setPreferredSize(new java.awt.Dimension(160, 60));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        
        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton4.setText("<html><center>ka'<sup>3</sup>a<sup>3</sup>/ka'<sup>3</sup>an<sup>3</sup></center></html>\\n");
        jButton4.setMaximumSize(new java.awt.Dimension(160, 60));
        jButton4.setMinimumSize(new java.awt.Dimension(160, 60));
        jButton4.setPreferredSize(new java.awt.Dimension(160, 60));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        
        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton5.setText("<html><center>i<sup>4</sup>i<sup>4</sup>/i<sup>4</sup>in<sup>4</sup></center></html>\\n");
        jButton5.setMaximumSize(new java.awt.Dimension(160, 60));
        jButton5.setMinimumSize(new java.awt.Dimension(160, 60));
        jButton5.setPreferredSize(new java.awt.Dimension(160, 60));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        
        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton6.setText("<html><center>xi'<sup>4</sup>i<sup>4</sup>/xi'<sup>4</sup>in<sup>4</sup></center></html>\\n");
        jButton6.setMaximumSize(new java.awt.Dimension(160, 60));
        jButton6.setMinimumSize(new java.awt.Dimension(160, 60));
        jButton6.setPreferredSize(new java.awt.Dimension(160, 60));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        
        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton7.setText("<html><center>xa'<sup>4</sup>a<sup>2</sup>/xa'<sup>4</sup>an<sup>2</sup></center></html>\\n");
        jButton7.setMaximumSize(new java.awt.Dimension(160, 60));
        jButton7.setMinimumSize(new java.awt.Dimension(160, 60));
        jButton7.setPreferredSize(new java.awt.Dimension(160, 60));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        
        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton8.setText("<html><center>i'<sup>4</sup>i<sup>3</sup>/i'<sup>4</sup>in<sup>3</sup></center></html>\\n");
        jButton8.setMaximumSize(new java.awt.Dimension(160, 60));
        jButton8.setMinimumSize(new java.awt.Dimension(160, 60));
        jButton8.setPreferredSize(new java.awt.Dimension(160, 60));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        
        jButton9.setBackground(new java.awt.Color(255, 255, 255));
        jButton9.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton9.setText("<html><center>ka<sup>4</sup>ki<sup>3</sup>/ka<sup>4</sup>xin<sup>3</sup><br>xu<sup>4</sup>xa<sup>3</sup>/xu<sup>4</sup>xan<sup>3</sup></center></html>\\n");
        jButton9.setMaximumSize(new java.awt.Dimension(160, 60));
        jButton9.setMinimumSize(new java.awt.Dimension(160, 60));
        jButton9.setPreferredSize(new java.awt.Dimension(160, 60));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        
        jButton10.setBackground(new java.awt.Color(255, 255, 255));
        jButton10.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton10.setText("<html><center>i<sup>3</sup>tu<sup>2</sup>/i<sup>3</sup>tun<sup>2</sup></center></html>\\n");
        jButton10.setMaximumSize(new java.awt.Dimension(160, 60));
        jButton10.setMinimumSize(new java.awt.Dimension(160, 60));
        jButton10.setPreferredSize(new java.awt.Dimension(160, 60));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        
        jButton11.setBackground(new java.awt.Color(255, 255, 255));
        jButton11.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton11.setText("<html><center>ka<sup>1</sup>a<sup>3</sup>/ka<sup>1</sup>an<sup>3</sup><br>ta<sup>1</sup>a<sup>3</sup>/ta<sup>1</sup>an<sup>3</sup></center></html>\\n");
        jButton11.setMaximumSize(new java.awt.Dimension(160, 60));
        jButton11.setMinimumSize(new java.awt.Dimension(160, 60));
        jButton11.setPreferredSize(new java.awt.Dimension(160, 60));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        
        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton12.setText("<html><center>xi<sup>1</sup>i<sup>4</sup>/xi<sup>1</sup>in<sup>4</sup></center></html>\\n");
        jButton12.setMaximumSize(new java.awt.Dimension(160, 60));
        jButton12.setMinimumSize(new java.awt.Dimension(160, 60));
        jButton12.setPreferredSize(new java.awt.Dimension(160, 60));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        
        jButton13.setBackground(new java.awt.Color(255, 255, 255));
        jButton13.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton13.setText("<html><center>tiu'<sup>1</sup>u<sup>4</sup>/tiu'<sup>1</sup>un<sup>4</sup></center></html>\\n");
        jButton13.setMaximumSize(new java.awt.Dimension(160, 60));
        jButton13.setMinimumSize(new java.awt.Dimension(160, 60));
        jButton13.setPreferredSize(new java.awt.Dimension(160, 60));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });
        
        jButton14.setBackground(new java.awt.Color(255, 255, 255));
        jButton14.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton14.setText("<html><center>is<sup>1</sup>ta<sup>4</sup>/is<sup>1</sup>tan<sup>4</sup><br>ka<sup>1</sup>tu<sup>4</sup>/ka<sup>1</sup>tun<sup>4</sup><br>tiu<sup>1</sup>ku<sup>4</sup>/tiu<sup>1</sup>kun<sup>4</sup></center></html>\\n");
        jButton14.setMaximumSize(new java.awt.Dimension(160, 60));
        jButton14.setMinimumSize(new java.awt.Dimension(160, 60));
        jButton14.setPreferredSize(new java.awt.Dimension(160, 60));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        
        jButton15.setBackground(new java.awt.Color(255, 255, 255));
        jButton15.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton15.setText("<html><center>i<sup>3</sup>i<sup>4</sup>/i<sup>3</sup>in<sup>4</sup><br>kwi<sup>3</sup>i<sup>4</sup>/kwi<sup>3</sup>in<sup>4</sup><br>tu<sup>3</sup>u<sup>4</sup>/tu<sup>3</sup>un<sup>4</sup></center></html>\\n");
        jButton15.setMaximumSize(new java.awt.Dimension(160, 75));
        jButton15.setMinimumSize(new java.awt.Dimension(160, 75));
        jButton15.setPreferredSize(new java.awt.Dimension(160, 75));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        
        jButton16.setBackground(new java.awt.Color(255, 255, 255));
        jButton16.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton16.setText("<html><center>i'<sup>4</sup>i<sup>3</sup>/i'<sup>4</sup>in<sup>3</sup></center></html>\\n");
        jButton16.setMaximumSize(new java.awt.Dimension(160, 75));
        jButton16.setMinimumSize(new java.awt.Dimension(160, 75));
        jButton16.setPreferredSize(new java.awt.Dimension(160, 75));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        
        jButton17.setBackground(new java.awt.Color(255, 255, 255));
        jButton17.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton17.setText("<html><center>ku<sup>3</sup>u<sup>3</sup>/ku<sup>3</sup>un<sup>3</sup><br>kwi<sup>3</sup>i<sup>3</sup>/kwi<sup>3</sup>in<sup>3</sup><br>tu<sup>3</sup>u<sup>3</sup>/tu<sup>3</sup>un<sup>3</sup></center></html>\\n");
        jButton17.setMaximumSize(new java.awt.Dimension(160, 75));
        jButton17.setMinimumSize(new java.awt.Dimension(160, 75));
        jButton17.setPreferredSize(new java.awt.Dimension(160, 75));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        
        jButton18.setBackground(new java.awt.Color(255, 255, 255));
        jButton18.setFont(new java.awt.Font("Lucida Grande", 0, 11)); // NOI18N
        jButton18.setText("<html><center>kwa<sup>4</sup>a<sup>24</sup>/kwa<sup>4</sup>a<sup>24</sup></center></html>\\n");
        jButton18.setMaximumSize(new java.awt.Dimension(160, 75));
        jButton18.setMinimumSize(new java.awt.Dimension(160, 75));
        jButton18.setPreferredSize(new java.awt.Dimension(160, 75));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/transcription/TTPictures/Nasalizations2.png"))); // NOI18N
        
        jLabel2.setText("4.4");
        
        jLabel3.setText("3.3");
        
        jLabel4.setText("1.1");
        
        jLabel5.setText("4.2");
        
        jLabel6.setText("4.3");
        
        jLabel7.setText("3.2");
        
        jLabel8.setText("1.3");
        
        jLabel9.setText("1.4");
        
        jLabel10.setText("3.4");
        
        jLabel11.setText("4.24");
        
        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
                                               jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                               .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                               .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                                                         .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                   .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                             .addComponent(jLabel2)
                                                                             .addComponent(jLabel4)
                                                                             .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                                                   .addComponent(jLabel5)
                                                                   .addComponent(jLabel7)
                                                                   .addComponent(jLabel6)
                                                                   .addComponent(jLabel10)
                                                                   .addComponent(jLabel9)
                                                                   .addComponent(jLabel8)
                                                                   .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                                             .addContainerGap()
                                                                             .addComponent(jLabel11)))
                                                         .addGap(22, 22, 22)
                                                         .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                   .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                   .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                                             .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                             .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                             .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                   .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                                             .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                             .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                   .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                   .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                                             .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                             .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                       .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                       .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                                                                 .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                 .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                   .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                                             .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                             .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                       .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                       .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                       .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                                                                 .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                 .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                           .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                           .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                           .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                                               );
        jLayeredPane1Layout.setVerticalGroup(
                                             jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                             .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                       .addGap(0, 0, 0)
                                                       .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                 .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                 .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                 .addComponent(jLabel4))
                                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                       .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                 .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                                           .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                     .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                     .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                                 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                                                                           .addComponent(jLabel3)
                                                                           .addGap(31, 31, 31)))
                                                       .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                 .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                           .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                           .addComponent(jLabel2))
                                                                 .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                       .addGap(40, 40, 40)
                                                       .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                 .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                 .addComponent(jLabel5))
                                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                       .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                 .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                           .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                           .addComponent(jLabel6))
                                                                 .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                       .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                 .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                 .addComponent(jLabel7))
                                                       .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                 .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                                           .addGap(40, 40, 40)
                                                                           .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                                                 .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                                                                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                           .addComponent(jLabel8)
                                                                           .addGap(29, 29, 29)))
                                                       .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                 .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                                           .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                           .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                 .addGroup(jLayeredPane1Layout.createSequentialGroup()
                                                                           .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                     .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                     .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                     .addComponent(jLabel9))
                                                                           .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                           .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                     .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                               .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                               .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                                                                                               .addComponent(jLabel10)
                                                                                               .addGap(26, 26, 26)))))
                                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                       .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                 .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                 .addComponent(jLabel11))
                                                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                       .addComponent(jLabel1)
                                                       .addContainerGap())
                                             );
        jLayeredPane1.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton12, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton13, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton14, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton15, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton16, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton17, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jButton18, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel9, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel10, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel11, javax.swing.JLayeredPane.DEFAULT_LAYER);
        
        jScrollPane2.setViewportView(jLayeredPane1);
        
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/transcription/TTPictures/Nasalizations1.png"))); // NOI18N
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                                  layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                  .addGroup(layout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                  .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel12)
                                            .addGap(23, 23, 23))
                                  );
        layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                          .addGap(0, 0, Short.MAX_VALUE)
                                          .addComponent(jLabel12)
                                          .addGap(0, 0, 0)
                                          .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                                );
        
        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Listener for the clip if it's closed.
     */
    LineListener listener = new LineListener() {
    @Override
    public void update(LineEvent event) {
    if (event.getType() == STOP) {
    clip.close();
}
}
};

/**
 * All of the Buttons Action Performed
 * @param evt 
 */
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
buttonNum = 0;
buttonAction();
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
buttonNum = 1;
buttonAction();
}//GEN-LAST:event_jButton2ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
buttonNum = 2;
buttonAction();
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
buttonNum = 3;
buttonAction();
}//GEN-LAST:event_jButton4ActionPerformed

private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
buttonNum = 4;
buttonAction();
}//GEN-LAST:event_jButton5ActionPerformed

private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
buttonNum = 5;
buttonAction();
}//GEN-LAST:event_jButton6ActionPerformed

private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
buttonNum = 6;
buttonAction();
}//GEN-LAST:event_jButton7ActionPerformed

private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
buttonNum = 7;
buttonAction();
}//GEN-LAST:event_jButton8ActionPerformed

private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
buttonNum = 8;
buttonAction();
}//GEN-LAST:event_jButton9ActionPerformed

private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
buttonNum = 9;
buttonAction();
}//GEN-LAST:event_jButton10ActionPerformed

private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
buttonNum = 10;
buttonAction();
}//GEN-LAST:event_jButton11ActionPerformed

private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
buttonNum = 11;
buttonAction();
}//GEN-LAST:event_jButton12ActionPerformed

private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
buttonNum = 12;
buttonAction();
}//GEN-LAST:event_jButton13ActionPerformed

private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
buttonNum = 13;
buttonAction();
}//GEN-LAST:event_jButton14ActionPerformed

private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
buttonNum = 14;
buttonAction();
}//GEN-LAST:event_jButton15ActionPerformed

private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
buttonNum = 15;
buttonAction();
}//GEN-LAST:event_jButton16ActionPerformed

private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
buttonNum = 16;
buttonAction();
}//GEN-LAST:event_jButton17ActionPerformed

private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
buttonNum = 17;
buttonAction();
}//GEN-LAST:event_jButton18ActionPerformed

private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
if(clip != null) {
clip.stop();
}
}//GEN-LAST:event_formWindowClosing

// Variables declaration - do not modify//GEN-BEGIN:variables
private javax.swing.JButton jButton1;
private javax.swing.JButton jButton10;
private javax.swing.JButton jButton11;
private javax.swing.JButton jButton12;
private javax.swing.JButton jButton13;
private javax.swing.JButton jButton14;
private javax.swing.JButton jButton15;
private javax.swing.JButton jButton16;
private javax.swing.JButton jButton17;
private javax.swing.JButton jButton18;
private javax.swing.JButton jButton2;
private javax.swing.JButton jButton3;
private javax.swing.JButton jButton4;
private javax.swing.JButton jButton5;
private javax.swing.JButton jButton6;
private javax.swing.JButton jButton7;
private javax.swing.JButton jButton8;
private javax.swing.JButton jButton9;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel10;
private javax.swing.JLabel jLabel11;
private javax.swing.JLabel jLabel12;
private javax.swing.JLabel jLabel2;
private javax.swing.JLabel jLabel3;
private javax.swing.JLabel jLabel4;
private javax.swing.JLabel jLabel5;
private javax.swing.JLabel jLabel6;
private javax.swing.JLabel jLabel7;
private javax.swing.JLabel jLabel8;
private javax.swing.JLabel jLabel9;
private javax.swing.JLayeredPane jLayeredPane1;
private javax.swing.JScrollPane jScrollPane2;
// End of variables declaration//GEN-END:variables
}