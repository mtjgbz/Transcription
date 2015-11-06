/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

//import javafx.scene.media.Media;
/**
 *
 * @author Michael
 */
public class Passive extends javax.swing.JFrame {

    private String lesson;
    AudioInputStream audioIn;
    Clip clip1;
    Clip clip2;
    Clip clip3;
    Clip clip4;
    Clip clip5;
    
    File file1;
    File file2;
    File file3;
    File file4;
    File file5;
    
    int strCount = 1;
          
    int page = 1;
    String user;
    
    long init1 = 9029000;
    long init2 = 9029000;
    long init3 = 9029000;
    long init4 = 9029000;
    long init5 = 9029000;
    
    long time1 = init1;
    long time2 = init2;
    long time3 = init3;
    long time4 = init4;
    long time5 = init5;
    
    ArrayList<String> textGroup1 = new ArrayList<>();
    ArrayList<String> textGroup2 = new ArrayList<>();
    ArrayList<String> textGroup3 = new ArrayList<>();
    ArrayList<String> textGroup4 = new ArrayList<>();
    
    ArrayList<File> soundArr1 = new ArrayList<>();
    ArrayList<File> soundArr2 = new ArrayList<>();
    ArrayList<File> soundArr3 = new ArrayList<>();
    ArrayList<File> soundArr4 = new ArrayList<>();
   
    ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            clip1.stop();
            clip1.setMicrosecondPosition(time1);
            clip2.stop();
            clip2.setMicrosecondPosition(time2);
            clip3.stop();
            clip3.setMicrosecondPosition(time3);
            clip4.stop();
            clip4.setMicrosecondPosition(time4);
            clip5.stop();
            clip5.setMicrosecondPosition(time5);
            playButton1.setText("Play");
            playButton2.setText("Play");
            playButton3.setText("Play");
            playButton4.setText("Play");
            playButton5.setText("Play");
        }
    };
    
    //Timer timer = new Timer(4428, listener);
    Timer timer1 = new Timer(4428, listener);
    Timer timer2 = new Timer(4428, listener);
    Timer timer3 = new Timer(4428, listener);
    Timer timer4 = new Timer(4428, listener);
    Timer timer5 = new Timer(4428, listener);

    Enclitics enc = new Enclitics();
    Nasalizations nas = new Nasalizations();
    ToneTable tone = new ToneTable();
    
    private PassiveBE backend;

    /**
     * Creates new form Passive
     *
     * @param user
     */
    public Passive(String user) {
        this.user = user;
        
        textGroup1.add("nda4a2 chi3ñu3 ba42 nu14u3 nu14u3 i4xa3=na2 tan3 sa1a3 nda4-ya'1a3=na2 kwa'1an1=na1 tan42 i3in3 tan42 i3in3 chi3ñu3 kan4 tan3");
        textGroup1.add("text2");
        textGroup1.add("text3");
        textGroup1.add("text4");
        textGroup1.add("text5");
        
        textGroup2.add("text6");
        textGroup2.add("text7");
        textGroup2.add("text8");
        textGroup2.add("text9");
        textGroup2.add("text10");
        
        textGroup3.add("text11");
        textGroup3.add("text12");
        textGroup3.add("text13");
        textGroup3.add("text14");
        textGroup3.add("text15");
        
        textGroup4.add("text16");
        textGroup4.add("text17");
        textGroup4.add("text18");
        textGroup4.add("text19");
        textGroup4.add("text20");
        
        soundArr1.add(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
        soundArr1.add(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
        soundArr1.add(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
        soundArr1.add(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
        soundArr1.add(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
        
        soundArr2.add(new File("oGolden.wav"));
        soundArr2.add(new File("oGolden.wav"));
        soundArr2.add(new File("oGolden.wav"));
        soundArr2.add(new File("oGolden.wav"));
        soundArr2.add(new File("oGolden.wav"));
        
        file1 = soundArr1.get(0);
        file2 = soundArr1.get(1);
        file3 = soundArr1.get(2);
        file4 = soundArr1.get(3);
        file5 = soundArr1.get(4);
        
        initComponents();
        
        jMenu5.setText(user);
        this.setTitle("Mixtec Transcription: Passive Training");
        jTextPane1.setText(textGroup1.get(0));
        jTextPane2.setText(textGroup1.get(1));
        jTextPane3.setText(textGroup1.get(2));
        jTextPane4.setText(textGroup1.get(3));
        jTextPane5.setText(textGroup1.get(4));

       initAudio();
       initTextFields();
    }

    /**
     *
     * @param string
     */
    public void setLesson(String string) {
        this.lesson = string;
    }

    /**
     *
     * @return
     */
    public String getLesson() {
        return this.lesson;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane5 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        playButton1 = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        playButton2 = new javax.swing.JButton();
        playButton3 = new javax.swing.JButton();
        playButton4 = new javax.swing.JButton();
        playButton5 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(970, 600));
        setMinimumSize(new java.awt.Dimension(970, 600));
        setResizable(false);

        jTextPane5.setEditable(false);
        jTextPane5.setFocusable(false);
        jTextPane5.setMaximumSize(new java.awt.Dimension(550, 70));
        jTextPane5.setMinimumSize(new java.awt.Dimension(550, 70));
        jTextPane5.setPreferredSize(new java.awt.Dimension(550, 70));
        jTextPane5.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(jTextPane5);

        jTextPane3.setEditable(false);
        jTextPane3.setFocusable(false);
        jTextPane3.setMaximumSize(new java.awt.Dimension(550, 70));
        jTextPane3.setMinimumSize(new java.awt.Dimension(550, 70));
        jTextPane3.setPreferredSize(new java.awt.Dimension(550, 70));
        jTextPane3.setRequestFocusEnabled(false);
        jScrollPane3.setViewportView(jTextPane3);

        jTextPane2.setEditable(false);
        jTextPane2.setFocusable(false);
        jTextPane2.setMaximumSize(new java.awt.Dimension(550, 70));
        jTextPane2.setMinimumSize(new java.awt.Dimension(550, 70));
        jTextPane2.setPreferredSize(new java.awt.Dimension(550, 70));
        jTextPane2.setRequestFocusEnabled(false);
        jScrollPane4.setViewportView(jTextPane2);

        jTextPane1.setEditable(false);
        jTextPane1.setFocusable(false);
        jTextPane1.setMaximumSize(new java.awt.Dimension(550, 70));
        jTextPane1.setMinimumSize(new java.awt.Dimension(550, 70));
        jTextPane1.setPreferredSize(new java.awt.Dimension(550, 70));
        jTextPane1.setRequestFocusEnabled(false);
        jScrollPane5.setViewportView(jTextPane1);

        jTextPane4.setEditable(false);
        jTextPane4.setFocusable(false);
        jTextPane4.setMaximumSize(new java.awt.Dimension(550, 70));
        jTextPane4.setMinimumSize(new java.awt.Dimension(550, 70));
        jTextPane4.setPreferredSize(new java.awt.Dimension(550, 70));
        jTextPane4.setRequestFocusEnabled(false);
        jScrollPane6.setViewportView(jTextPane4);

        playButton1.setText("Play");
        playButton1.setMaximumSize(new java.awt.Dimension(97, 29));
        playButton1.setMinimumSize(new java.awt.Dimension(97, 29));
        playButton1.setPreferredSize(new java.awt.Dimension(97, 29));
        playButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playButton1MouseReleased(evt);
            }
        });

        playButton2.setText("Play");
        playButton2.setMaximumSize(new java.awt.Dimension(97, 29));
        playButton2.setMinimumSize(new java.awt.Dimension(97, 29));
        playButton2.setPreferredSize(new java.awt.Dimension(97, 29));
        playButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playButton2MouseReleased(evt);
            }
        });

        playButton3.setText("Play");
        playButton3.setMaximumSize(new java.awt.Dimension(97, 29));
        playButton3.setMinimumSize(new java.awt.Dimension(97, 29));
        playButton3.setPreferredSize(new java.awt.Dimension(97, 29));
        playButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playButton3MouseReleased(evt);
            }
        });

        playButton4.setText("Play");
        playButton4.setMaximumSize(new java.awt.Dimension(97, 29));
        playButton4.setMinimumSize(new java.awt.Dimension(97, 29));
        playButton4.setPreferredSize(new java.awt.Dimension(97, 29));
        playButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playButton4MouseReleased(evt);
            }
        });

        playButton5.setText("Play");
        playButton5.setMaximumSize(new java.awt.Dimension(97, 29));
        playButton5.setMinimumSize(new java.awt.Dimension(97, 29));
        playButton5.setPreferredSize(new java.awt.Dimension(97, 29));
        playButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playButton5MouseReleased(evt);
            }
        });

        jButton7.setText("Page 2 >>");
        jButton7.setMaximumSize(new java.awt.Dimension(97, 30));
        jButton7.setMinimumSize(new java.awt.Dimension(97, 30));
        jButton7.setPreferredSize(new java.awt.Dimension(97, 30));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Current");
        jButton8.setMaximumSize(new java.awt.Dimension(97, 30));
        jButton8.setMinimumSize(new java.awt.Dimension(97, 30));
        jButton8.setPreferredSize(new java.awt.Dimension(97, 30));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jMenu1.setText("Home");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setActionCommand("Enclitics");
        jMenu2.setLabel("Enclitics");
        jMenu2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu2MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Nasalization");
        jMenu3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu3MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Tone Table");
        jMenu4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu4MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu4);

        jMenu5.setText("User");

        jMenuItem1.setText("Log out");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseReleased(evt);
            }
        });
        jMenu5.add(jMenuItem1);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(playButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(playButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(playButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(playButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(filler1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(playButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 204, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(385, 385, 385))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(playButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(playButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(playButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(playButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(playButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void initAudio() {
          try {
            audioIn = AudioSystem.getAudioInputStream(file1);
            clip1 = AudioSystem.getClip();
            clip1.open(audioIn);
            clip1.setMicrosecondPosition(time1);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        }
          try {
            audioIn = AudioSystem.getAudioInputStream(file2);
            clip2 = AudioSystem.getClip();
            clip2.open(audioIn);
            clip2.setMicrosecondPosition(time2);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        }
          try {
            audioIn = AudioSystem.getAudioInputStream(file3);
            clip3 = AudioSystem.getClip();
            clip3.open(audioIn);
            clip3.setMicrosecondPosition(time3);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        }
          try {
            audioIn = AudioSystem.getAudioInputStream(file4);
            clip4 = AudioSystem.getClip();
            clip4.open(audioIn);
            clip4.setMicrosecondPosition(time4);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        }
          try {
            audioIn = AudioSystem.getAudioInputStream(file5);
             clip5 = AudioSystem.getClip();
            clip5.open(audioIn);
            clip5.setMicrosecondPosition(time5);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void initTextFields() {
        backend = new PassiveBE();
        System.out.println(backend.findPhrase("test.trs")); //ECL: Adjusted this to test the findPhrase
    }

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        enc.dispose();
        nas.dispose();
        tone.dispose();
        new Home(user).setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenu2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu2MouseClicked
        if (!enc.isShowing()) {
            enc.setVisible(true);
        } else {
            enc.toFront();
        }
    }//GEN-LAST:event_jMenu2MouseClicked

    private void jMenu3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu3MouseClicked
        if (!nas.isShowing()) {
            nas.setVisible(true);
        } else {
            nas.toFront();
        }
    }//GEN-LAST:event_jMenu3MouseClicked

    private void jMenu4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu4MouseClicked
        if (!tone.isShowing()) {
            tone.setVisible(true);
        } else {
            tone.toFront();
        }
    }//GEN-LAST:event_jMenu4MouseClicked

    private void jMenuItem1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseReleased
        new SignIn().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1MouseReleased

    private void playButton1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playButton1MouseReleased
        clip2.stop();
        timer2.stop();
        playButton2.setText("Play");
        clip3.stop();
        timer3.stop();
        playButton3.setText("Play");
        clip4.stop();
        timer4.stop();
        playButton4.setText("Play");
        clip5.stop();
        timer5.stop();
        playButton5.setText("Play");
        
        time2 = init2;
        time3 = init3;
        time4 = init4;
        time5 = init5;
        
        clip2.setMicrosecondPosition(time2);
        clip3.setMicrosecondPosition(time3);
        clip4.setMicrosecondPosition(time4);
        clip5.setMicrosecondPosition(time5);

        if (!clip1.isRunning()) {
            clip1.start();
            timer1.start();
            playButton1.setText("Pause");
        } else {
            clip1.stop();
            timer1.stop();
            playButton1.setText("Play");
        }
    }//GEN-LAST:event_playButton1MouseReleased

    private void playButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playButton2MouseReleased
        clip1.stop();
        timer1.stop();
        playButton1.setText("Play");
        clip3.stop();
        timer3.stop();
        playButton3.setText("Play");
        clip4.stop();
        timer4.stop();
        playButton4.setText("Play");
        clip5.stop();
        timer5.stop();
        playButton5.setText("Play");
        
        time1 = init1;
        time3 = init3;
        time4 = init4;
        time5 = init5;
        
        clip1.setMicrosecondPosition(time1);
        clip3.setMicrosecondPosition(time3);
        clip4.setMicrosecondPosition(time4);
        clip5.setMicrosecondPosition(time5);

        if (!clip2.isRunning()) {
            clip2.start();
            timer2.start();
            playButton2.setText("Pause");
        } else {
            clip2.stop();
            timer2.stop();
            playButton2.setText("Play");
        }
    }//GEN-LAST:event_playButton2MouseReleased

    private void playButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playButton3MouseReleased
        clip2.stop();
        timer2.stop();
        playButton2.setText("Play");
        clip1.stop();
        timer1.stop();
        playButton1.setText("Play");
        clip4.stop();
        timer4.stop();
        playButton4.setText("Play");
        clip5.stop();
        timer5.stop();
        playButton5.setText("Play");
        
        time1 = init1;
        time2 = init2;
        time4 = init4;
        time5 = init5;
        
        clip1.setMicrosecondPosition(time1);
        clip2.setMicrosecondPosition(time2);
        clip4.setMicrosecondPosition(time4);
        clip5.setMicrosecondPosition(time5);

        if (!clip3.isRunning()) {
            clip3.start();
            timer3.start();
            playButton3.setText("Pause");
        } else {
            clip3.stop();
            timer3.stop();
            playButton3.setText("Play");
        }
    }//GEN-LAST:event_playButton3MouseReleased

    private void playButton4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playButton4MouseReleased
        clip2.stop();
        timer2.stop();
        playButton2.setText("Play");
        clip3.stop();
        timer3.stop();
        playButton3.setText("Play");
        clip1.stop();
        timer1.stop();
        playButton1.setText("Play");
        clip5.stop();
        timer5.stop();
        playButton5.setText("Play");
        
        time1 = init1;
        time2 = init2;
        time3 = init3;
        time5 = init5;
        
        clip1.setMicrosecondPosition(time1);
        clip2.setMicrosecondPosition(time2);
        clip3.setMicrosecondPosition(time3);
        clip5.setMicrosecondPosition(time5);

        if (!clip4.isRunning()) {
            clip4.start();
            timer4.start();
            playButton4.setText("Pause");
        } else {
            clip4.stop();
            timer4.stop();
            playButton4.setText("Play");
        }
    }//GEN-LAST:event_playButton4MouseReleased

    private void playButton5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playButton5MouseReleased
        clip2.stop();
        timer2.stop();
        playButton2.setText("Play");
        clip3.stop();
        timer3.stop();
        playButton3.setText("Play");
        clip4.stop();
        timer4.stop();
        playButton4.setText("Play");
        clip1.stop();
        timer1.stop();
        playButton1.setText("Play");
        
        time1 = init1;
        time2 = init2;
        time3 = init3;
        time4 = init4;
        
        clip1.setMicrosecondPosition(time1);
        clip2.setMicrosecondPosition(time2);
        clip3.setMicrosecondPosition(time3);
        clip4.setMicrosecondPosition(time4);

        if (!clip5.isRunning()) {
            clip5.start();
            timer5.start();
            playButton5.setText("Pause");
        } else {
            clip5.stop();
            timer5.stop();
            playButton5.setText("Play");
        }
    }//GEN-LAST:event_playButton5MouseReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(page >= 1 && page < 4) {
            page ++;
        }
        if(page == 2) {
            jButton7.setText("Page 3 >>");
            jButton8.setText("<< Page 1");
            jTextPane1.setText(textGroup2.get(0));
            jTextPane2.setText(textGroup2.get(1));
            jTextPane3.setText(textGroup2.get(2));
            jTextPane4.setText(textGroup2.get(3));
            jTextPane5.setText(textGroup2.get(4));
            file1 = soundArr2.get(0);
            file2 = soundArr2.get(1);
            file3 = soundArr2.get(2);
            file4 = soundArr2.get(3);
            file5 = soundArr2.get(4);
        }
        else if (page == 3) {
            jButton7.setText("Page 4 >>");
            jButton8.setText("<< Page 2");
            jTextPane1.setText(textGroup3.get(0));
            jTextPane2.setText(textGroup3.get(1));
            jTextPane3.setText(textGroup3.get(2));
            jTextPane4.setText(textGroup3.get(3));
            jTextPane5.setText(textGroup3.get(4));
            
        }
        else if (page == 4) {
            jButton8.setText("<< Page 3");
            jButton7.setText("Current");
            jTextPane1.setText(textGroup4.get(0));
            jTextPane2.setText(textGroup4.get(1));
            jTextPane3.setText(textGroup4.get(2));
            jTextPane4.setText(textGroup4.get(3));
            jTextPane5.setText(textGroup4.get(4)); 
        }
        clip1.stop();
        timer1.stop();
        playButton1.setText("Play");
        clip2.stop();
        timer2.stop();
        playButton2.setText("Play");
        clip3.stop();
        timer3.stop();
        playButton3.setText("Play");
        clip4.stop();
        timer4.stop();
        playButton4.setText("Play");
        clip5.stop();
        timer5.stop();
        playButton5.setText("Play");
        initAudio();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(page <= 4 && page > 1) {
            page --;
        }
        if (page == 1) {
            jButton7.setText("Page 2 >>");
            jButton8.setText("Current");
            jTextPane1.setText(textGroup1.get(0));
            jTextPane2.setText(textGroup1.get(1));
            jTextPane3.setText(textGroup1.get(2));
            jTextPane4.setText(textGroup1.get(3));
            jTextPane5.setText(textGroup1.get(4));
            file1 = soundArr1.get(0);
            file2 = soundArr1.get(1);
            file3 = soundArr1.get(2);
            file4 = soundArr1.get(3);
            file5 = soundArr1.get(4);
           
        }
        else if(page == 2) {
            jButton7.setText("Page 3 >>");
            jButton8.setText("<< Page 1");
            jTextPane1.setText(textGroup2.get(0));
            jTextPane2.setText(textGroup2.get(1));
            jTextPane3.setText(textGroup2.get(2));
            jTextPane4.setText(textGroup2.get(3));
            jTextPane5.setText(textGroup2.get(4));
            file1 = soundArr2.get(0);
            file2 = soundArr2.get(1);
            file3 = soundArr2.get(2);
            file4 = soundArr2.get(3);
            file5 = soundArr2.get(4);
        }
        else if (page == 3) {
            jButton7.setText("Page 4 >>");
            jButton8.setText("<< Page 2");
            jTextPane1.setText(textGroup3.get(0));
            jTextPane2.setText(textGroup3.get(1));
            jTextPane3.setText(textGroup3.get(2));
            jTextPane4.setText(textGroup3.get(3));
            jTextPane5.setText(textGroup3.get(4)); 
        }
        clip1.stop();
        timer1.stop();
        playButton1.setText("Play");
        clip2.stop();
        timer2.stop();
        playButton2.setText("Play");
        clip3.stop();
        timer3.stop();
        playButton3.setText("Play");
        clip4.stop();
        timer4.stop();
        playButton4.setText("Play");
        clip5.stop();
        timer5.stop();
        playButton5.setText("Play");
        initAudio();
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Passive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Passive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Passive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Passive.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Passive().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JButton playButton1;
    private javax.swing.JButton playButton2;
    private javax.swing.JButton playButton3;
    private javax.swing.JButton playButton4;
    private javax.swing.JButton playButton5;
    // End of variables declaration//GEN-END:variables
}
