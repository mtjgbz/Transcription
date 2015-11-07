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
          
    int page = 1;
    String user;
    int t = 0;
    
    boolean running1 = false;
    boolean running2 = false;
    boolean running3 = false;
    boolean running4 = false;
    boolean running5 = false;
    
    ArrayList<String> textData = new ArrayList<>();
    ArrayList<File> soundArr = new ArrayList<>();
    ArrayList<File> files = new ArrayList<>();
    ArrayList<Clip> clips = new ArrayList<>();
    ArrayList<Integer> times = new ArrayList<>();
    ArrayList<Timer> timers = new ArrayList<>();
    
   
    ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            clips.get(0).stop();
            clips.get(0).setMicrosecondPosition(times.get(0));
            clips.get(1).stop();
            clips.get(1).setMicrosecondPosition(times.get(1));
            clips.get(2).stop();
            clips.get(2).setMicrosecondPosition(times.get(2));
            clips.get(3).stop();
            clips.get(3).setMicrosecondPosition(times.get(3));
            clips.get(4).stop();
            clips.get(4).setMicrosecondPosition(times.get(4));
            playButton1.setText("Play");
            playButton2.setText("Play");
            playButton3.setText("Play");
            playButton4.setText("Play");
            playButton5.setText("Play");
        }
    };

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
        
        for(int i = 0; i < 20; i++) {
            timers.add(new Timer(4428, listener));
            times.add(9029000);
        }
        
        textData.add("nda4a2 chi3ñu3 ba42 nu14u3 nu14u3 i4xa3=na2 tan3 sa1a3 nda4-ya'1a3=na2 kwa'1an1=na1 tan42 i3in3 tan42 i3in3 chi3ñu3 kan4 tan3");
        textData.add("text2");
        textData.add("text3");
        textData.add("text4");
        textData.add("text5");
        
        textData.add("text6");
        textData.add("text7");
        textData.add("text8");
        textData.add("text9");
        textData.add("text10");
        
        textData.add("text11");
        textData.add("text12");
        textData.add("text13");
        textData.add("text14");
        textData.add("text15");
        
        textData.add("text16");
        textData.add("text17");
        textData.add("text18");
        textData.add("text19");
        textData.add("text20");
        
        soundArr.add(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
        soundArr.add(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
        soundArr.add(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
        soundArr.add(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
        soundArr.add(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
        
        soundArr.add(new File("oGolden.wav"));
        soundArr.add(new File("oGolden.wav"));
        soundArr.add(new File("oGolden.wav"));
        soundArr.add(new File("oGolden.wav"));
        soundArr.add(new File("oGolden.wav"));
        
        soundArr.add(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
        soundArr.add(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
        soundArr.add(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
        soundArr.add(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
        soundArr.add(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
        
        soundArr.add(new File("oGolden.wav"));
        soundArr.add(new File("oGolden.wav"));
        soundArr.add(new File("oGolden.wav"));
        soundArr.add(new File("oGolden.wav"));
        soundArr.add(new File("oGolden.wav"));
        
        initComponents();
        jMenu5.setText(user);
        this.setTitle("Mixtec Transcription: Passive Training");
        
        jTextPane1.setText(textData.get(0));
        jTextPane2.setText(textData.get(1));
        jTextPane3.setText(textData.get(2));
        jTextPane4.setText(textData.get(3));
        jTextPane5.setText(textData.get(4));

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
            audioIn = AudioSystem.getAudioInputStream(soundArr.get(0));
            clips.add(AudioSystem.getClip());
            clips.get(0).open(audioIn);
            clips.get(0).setMicrosecondPosition(times.get(0));  
            audioIn = AudioSystem.getAudioInputStream(soundArr.get(1));
            clips.add(AudioSystem.getClip());
            clips.get(1).open(audioIn);
            clips.get(1).setMicrosecondPosition(times.get(1));
            audioIn = AudioSystem.getAudioInputStream(soundArr.get(2));
            clips.add(AudioSystem.getClip());
            clips.get(2).open(audioIn);
            clips.get(2).setMicrosecondPosition(times.get(2));
            audioIn = AudioSystem.getAudioInputStream(soundArr.get(3));
            clips.add(AudioSystem.getClip());
            clips.get(3).open(audioIn);
            clips.get(3).setMicrosecondPosition(times.get(3));
            audioIn = AudioSystem.getAudioInputStream(soundArr.get(4));
            clips.add(AudioSystem.getClip());
            clips.get(4).open(audioIn);
            clips.get(4).setMicrosecondPosition(times.get(4));
            audioIn = AudioSystem.getAudioInputStream(soundArr.get(5));
            clips.add(AudioSystem.getClip());
            clips.get(5).open(audioIn);
            clips.get(5).setMicrosecondPosition(times.get(5));
            audioIn = AudioSystem.getAudioInputStream(soundArr.get(6));
            clips.add(AudioSystem.getClip());
            clips.get(6).open(audioIn);
            clips.get(6).setMicrosecondPosition(times.get(6));
            audioIn = AudioSystem.getAudioInputStream(soundArr.get(7));
            clips.add(AudioSystem.getClip());
            clips.get(7).open(audioIn);
            clips.get(7).setMicrosecondPosition(times.get(7));
            audioIn = AudioSystem.getAudioInputStream(soundArr.get(8));
            clips.add(AudioSystem.getClip());
            clips.get(8).open(audioIn);
            clips.get(8).setMicrosecondPosition(times.get(8));
            audioIn = AudioSystem.getAudioInputStream(soundArr.get(9));
            clips.add(AudioSystem.getClip());
            clips.get(9).open(audioIn);
            clips.get(9).setMicrosecondPosition(times.get(9));
            audioIn = AudioSystem.getAudioInputStream(soundArr.get(10));
            clips.add(AudioSystem.getClip());
            clips.get(10).open(audioIn);
            clips.get(10).setMicrosecondPosition(times.get(10));
            audioIn = AudioSystem.getAudioInputStream(soundArr.get(11));
            clips.add(AudioSystem.getClip());
            clips.get(11).open(audioIn);
            clips.get(11).setMicrosecondPosition(times.get(11));
            audioIn = AudioSystem.getAudioInputStream(soundArr.get(12));
            clips.add(AudioSystem.getClip());
            clips.get(12).open(audioIn);
            clips.get(12).setMicrosecondPosition(times.get(12));
            audioIn = AudioSystem.getAudioInputStream(soundArr.get(13));
            clips.add(AudioSystem.getClip());
            clips.get(13).open(audioIn);
            clips.get(13).setMicrosecondPosition(times.get(13));
            audioIn = AudioSystem.getAudioInputStream(soundArr.get(14));
            clips.add(AudioSystem.getClip());
            clips.get(14).open(audioIn);
            clips.get(14).setMicrosecondPosition(times.get(14));
            audioIn = AudioSystem.getAudioInputStream(soundArr.get(15));
            clips.add(AudioSystem.getClip());
            clips.get(15).open(audioIn);
            clips.get(15).setMicrosecondPosition(times.get(15));
            audioIn = AudioSystem.getAudioInputStream(soundArr.get(16));
            clips.add(AudioSystem.getClip());
            clips.get(16).open(audioIn);
            clips.get(16).setMicrosecondPosition(times.get(16));
            audioIn = AudioSystem.getAudioInputStream(soundArr.get(17));
            clips.add(AudioSystem.getClip());
            clips.get(17).open(audioIn);
            clips.get(17).setMicrosecondPosition(times.get(17));
            audioIn = AudioSystem.getAudioInputStream(soundArr.get(18));
            clips.add(AudioSystem.getClip());
            clips.get(18).open(audioIn);
            clips.get(18).setMicrosecondPosition(times.get(18));
            audioIn = AudioSystem.getAudioInputStream(soundArr.get(19));
            clips.add(AudioSystem.getClip());
            clips.get(19).open(audioIn);
            clips.get(19).setMicrosecondPosition(times.get(19));
        
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
        String file = backend.findFile(1, 'a');
        System.out.println("Phrase found: " + backend.findPhrase(file)); //ECL: Adjusted this to test the findPhrase
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
        for(int i = 0; i < clips.size(); i++) {
            if(i != 0 || i != 5 || i != 10 || i != 15) {
               clips.get(i).stop();
               timers.get(i).stop();
            }
            clips.get(i).setMicrosecondPosition(times.get(i));
        }
        playButton2.setText("Play");
        playButton3.setText("Play");
        playButton4.setText("Play");
        playButton5.setText("Play");
        
        if(page == 1) {
            t = 0;
        }
        else if(page == 2) {
            t = 5;
        }
        else if(page == 3) {
            t = 10;
        }
        else {
            t = 15;
        }
        
        if (!running1) {
            clips.get(t).start();
            timers.get(t).start();
            playButton1.setText("Pause");
            running1 = true;
        }
        else {
            clips.get(t).stop();
            timers.get(t).stop();
            playButton1.setText("Play");
            running1 = false;
        }
    }//GEN-LAST:event_playButton1MouseReleased

    private void playButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playButton2MouseReleased
        for(int i = 0; i < clips.size(); i++) {
            if(i != 1 || i != 6 || i != 11 || i != 16) {
               clips.get(i).stop();
               timers.get(i).stop();
               clips.get(i).setMicrosecondPosition(times.get(i));
            }
        }
        playButton1.setText("Play");
        playButton3.setText("Play");
        playButton4.setText("Play");
        playButton5.setText("Play");

        if(page == 1) {
            t = 1;
        }
        else if(page == 2) {
            t = 6;
        }
        else if(page == 3) {
            t = 11;
        }
        else {
            t = 16;
        }
        
        if (!running2) {
            clips.get(t).start();
            timers.get(t).start();
            playButton2.setText("Pause");
            running2 = true;
        }
        else {
            clips.get(t).stop();
            timers.get(t).stop();
            playButton2.setText("Play");
            running2 = false;
        }
    }//GEN-LAST:event_playButton2MouseReleased

    private void playButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playButton3MouseReleased
        for(int i = 0; i < clips.size(); i++) {
            if(i != 2 || i != 7 || i != 12 || i != 17) {
               clips.get(i).stop();
               timers.get(i).stop();
               clips.get(i).setMicrosecondPosition(times.get(i));
            }
        }
        playButton2.setText("Play");
        playButton1.setText("Play");
        playButton4.setText("Play");
        playButton5.setText("Play");

        if(page == 1) {
            t = 2;
        }
        else if(page == 2) {
            t = 7;
        }
        else if(page == 3) {
            t = 12;
        }
        else {
            t = 17;
        }
        
        if (!running3) {
            clips.get(t).start();
            timers.get(t).start();
            playButton3.setText("Pause");
            running3 = true;
        }
        else {
            clips.get(t).stop();
            timers.get(t).stop();
            playButton3.setText("Play");
            running3 = false;
        }
    }//GEN-LAST:event_playButton3MouseReleased

    private void playButton4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playButton4MouseReleased
        for(int i = 0; i < clips.size(); i++) {
            if(i != 3 || i != 8 || i != 13 || i != 18) {
               clips.get(i).stop();
               timers.get(i).stop();
               clips.get(i).setMicrosecondPosition(times.get(i));
            }
        }
        playButton2.setText("Play");
        playButton3.setText("Play");
        playButton1.setText("Play");
        playButton5.setText("Play");

        if(page == 1) {
            t = 3;
        }
        else if(page == 2) {
            t = 8;
        }
        else if(page == 3) {
            t = 13;
        }
        else {
            t = 18;
        }
        
        if (!running4) {
            clips.get(t).start();
            timers.get(t).start();
            playButton4.setText("Pause");
            running4 = true;
        }
        else {
            clips.get(t).stop();
            timers.get(t).stop();
            playButton4.setText("Play");
            running4 = false;
        }
    }//GEN-LAST:event_playButton4MouseReleased

    private void playButton5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playButton5MouseReleased
        for(int i = 0; i < clips.size(); i++) {
            if(i != 4 || i != 9 || i != 14 || i != 19) {
               clips.get(i).stop();
               timers.get(i).stop();
               clips.get(i).setMicrosecondPosition(times.get(i));
            }
        }
        playButton2.setText("Play");
        playButton3.setText("Play");
        playButton4.setText("Play");
        playButton1.setText("Play");
      
        if(page == 1) {
            t = 4;
        }
        else if(page == 2) {
            t = 9;
        }
        else if(page == 3) {
            t = 14;
        }
        else {
            t = 19;
        }
        
        if (!running5) {
            clips.get(t).start();
            timers.get(t).start();
            playButton5.setText("Pause");
            running5 = true;
        }
        else {
            clips.get(t).stop();
            timers.get(t).stop();
            playButton5.setText("Play");
            running5 = false;
        }
    }//GEN-LAST:event_playButton5MouseReleased

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(page >= 1 && page < 4) {
            page ++;
        }
        if(page == 2) {
            jButton7.setText("Page 3 >>");
            jButton8.setText("<< Page 1");
            jTextPane1.setText(textData.get(5));
            jTextPane2.setText(textData.get(6));
            jTextPane3.setText(textData.get(7));
            jTextPane4.setText(textData.get(8));
            jTextPane5.setText(textData.get(9));
        }
        else if (page == 3) {
            jButton7.setText("Page 4 >>");
            jButton8.setText("<< Page 2");
            jTextPane1.setText(textData.get(10));
            jTextPane2.setText(textData.get(11));
            jTextPane3.setText(textData.get(12));
            jTextPane4.setText(textData.get(13));
            jTextPane5.setText(textData.get(14));
        }
        else if (page == 4) {
            jButton8.setText("<< Page 3");
            jButton7.setText("Current");
            jTextPane1.setText(textData.get(15)); 
            jTextPane2.setText(textData.get(16));
            jTextPane3.setText(textData.get(17));
            jTextPane4.setText(textData.get(18));
            jTextPane5.setText(textData.get(19));
        }
        for(int i = 0; i < 19; i++){
            clips.get(i).stop();
            timers.get(i).stop();
        }
     
        playButton1.setText("Play");
        playButton2.setText("Play");
        playButton3.setText("Play");
        playButton4.setText("Play");
        playButton5.setText("Play");
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(page <= 4 && page > 1) {
            page --;
        }
        if (page == 1) {
            jButton7.setText("Page 2 >>");
            jButton8.setText("Current");
            jTextPane1.setText(textData.get(0));
            jTextPane2.setText(textData.get(1));
            jTextPane3.setText(textData.get(2));
            jTextPane4.setText(textData.get(3));
            jTextPane5.setText(textData.get(4));  
        }
        else if(page == 2) {
            jButton7.setText("Page 3 >>");
            jButton8.setText("<< Page 1");
            jTextPane1.setText(textData.get(5));
            jTextPane2.setText(textData.get(6));
            jTextPane3.setText(textData.get(7));
            jTextPane4.setText(textData.get(8));
            jTextPane5.setText(textData.get(9)); 
        }
        else if (page == 3) {
            jButton7.setText("Page 4 >>");
            jButton8.setText("<< Page 2");
            jTextPane1.setText(textData.get(10)); 
            jTextPane2.setText(textData.get(11));
            jTextPane3.setText(textData.get(12));
            jTextPane4.setText(textData.get(13));
            jTextPane5.setText(textData.get(14));    
        }
        for(int i = 0; i < 19; i++){
            clips.get(i).stop();
            timers.get(i).stop();
        }
     
        playButton1.setText("Play");
        playButton2.setText("Play");
        playButton3.setText("Play");
        playButton4.setText("Play");
        playButton5.setText("Play");
        
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
