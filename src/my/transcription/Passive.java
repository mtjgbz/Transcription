/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

//import javafx.scene.media.Media;
/**
 *
 * @author Michael
 */
public class Passive extends javax.swing.JFrame {

    private String lesson;
        
    int page = 1;
    String user;
    int t = 0;
    
    ArrayList<ArrayList<Clip>> clipsList = new ArrayList<>();
    ArrayList<ArrayList<Timer>> timersList = new ArrayList<>();
    ArrayList<ArrayList<String>> textList = new ArrayList<>();
    ArrayList<ArrayList<Integer>> timesList = new ArrayList<>();
    
    //Dummy array list
    ArrayList<File> clips = new ArrayList<>();
    
    Clip clip1;
    Clip clip2;
    Clip clip3;
    Clip clip4;
    Clip clip5;
    
    Timer timer1;
    Timer timer2;
    Timer timer3;
    Timer timer4;
    Timer timer5;
    
    private ArrayList<ArrayList<String>> phraseList;
    private ArrayList<String> wordsList = new ArrayList<String>();
    private int currPageIndex;
   
    ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            if(page == 1) {
                t = 0;
            }
            else if(page == 2) {
                t = 1;
            }
                else if(page == 3) {
                t = 2;
            }
            else {
                t = 3;
            }
            clip1.stop();
            clip1.setMicrosecondPosition(timesList.get(t).get(0));
            clip2.stop();
            clip2.setMicrosecondPosition(timesList.get(t).get(1));
            clip3.stop();
            clip3.setMicrosecondPosition(timesList.get(t).get(2));
            clip4.stop();
            clip4.setMicrosecondPosition(timesList.get(t).get(3));
            clip5.stop();
            clip5.setMicrosecondPosition(timesList.get(t).get(4));

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
        getContentPane().setBackground(new Color(148,189,203));
       
        initLists();
        
        backend = new PassiveBE();
        
        for(int i = 0; i < 5; i++) {
            timersList.get(0).add(new Timer(4428, listener));
            timersList.get(1).add(new Timer(4428, listener));
            timersList.get(2).add(new Timer(4428, listener));
            timersList.get(3).add(new Timer(4428, listener));
            timesList.get(0).add(9029000);
            timesList.get(1).add(9029000);
            timesList.get(2).add(9029000);
            timesList.get(3).add(9029000);
        }
    
        textList.get(0).add("nda4a2 chi3ñu3 ba42 nu14u3 nu14u3 i4xa3=na2 tan3 sa1a3 nda4-ya'1a3=na2 kwa'1an1=na1 tan42 i3in3 tan42 i3in3 chi3ñu3 kan4 tan3");
        textList.get(0).add("text2");
        textList.get(0).add("text3");
        textList.get(0).add("text4");
        textList.get(0).add("text5");
        
        textList.get(1).add("text6");
        textList.get(1).add("text7");
        textList.get(1).add("text8");
        textList.get(1).add("text9");
        textList.get(1).add("text10");
        
        textList.get(2).add("text11");
        textList.get(2).add("text12");
        textList.get(2).add("text13");
        textList.get(2).add("text14");
        textList.get(2).add("text15");
        
        textList.get(3).add("text16");
        textList.get(3).add("text17");
        textList.get(3).add("text18");
        textList.get(3).add("text19");
        textList.get(3).add("text20");

        for(int i = 0; i < 5; i++) {
            clips.add(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
        }
        
        for(int i = 0; i < 5; i++) {
            clips.add(new File("oGolden.wav"));
        }
        
        for(int i = 0; i < 5; i++) {
            clips.add(new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav"));
        }
        
        for(int i = 0; i < 5; i++) {
            clips.add(new File("oGolden.wav"));
        }
        
        initComponents();
        jMenu5.setText(user);
        this.setTitle("Mixtec Transcription: Passive Training");
        
        if(page == 1) {
            t = 0;
        }
        else if(page == 2) {
            t = 1;
        }
        else if(page == 3) {
            t = 2;
        }
        else {
            t = 3;
        }
        
        jTextPane1.setText(textList.get(t).get(0));
        jTextPane2.setText(textList.get(t).get(1));
        jTextPane3.setText(textList.get(t).get(2));
        jTextPane4.setText(textList.get(t).get(3));
        jTextPane5.setText(textList.get(t).get(4));
        
        //initTextFields();
        clipsList = backend.makeClips();

        
        initAudio();
    }

    public void initLists(){
        ArrayList<Clip> clips1 = new ArrayList<>();
        ArrayList<Clip> clips2 = new ArrayList<>();
        ArrayList<Clip> clips3 = new ArrayList<>();
        ArrayList<Clip> clips4 = new ArrayList<>();
        
        clipsList.add(clips1);
        clipsList.add(clips2);
        clipsList.add(clips3);
        clipsList.add(clips4);
        
        ArrayList<Timer> timers1 = new ArrayList<>();
        ArrayList<Timer> timers2 = new ArrayList<>();
        ArrayList<Timer> timers3 = new ArrayList<>();
        ArrayList<Timer> timers4 = new ArrayList<>();
        
        timersList.add(timers1);
        timersList.add(timers2);
        timersList.add(timers3);
        timersList.add(timers4);
        
        ArrayList<String> texts1 = new ArrayList<>();
        ArrayList<String> texts2 = new ArrayList<>();
        ArrayList<String> texts3 = new ArrayList<>();
        ArrayList<String> texts4 = new ArrayList<>();
        
        textList.add(texts1);
        textList.add(texts2);
        textList.add(texts3);
        textList.add(texts4);  
        
        ArrayList<Integer> times1 = new ArrayList<>();
        ArrayList<Integer> times2 = new ArrayList<>();
        ArrayList<Integer> times3 = new ArrayList<>();
        ArrayList<Integer> times4 = new ArrayList<>();
        
        timesList.add(times1);
        timesList.add(times2);
        timesList.add(times3);
        timesList.add(times4); 
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
        jTextPane5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jTextPane5.setAutoscrolls(false);
        jTextPane5.setFocusable(false);
        jTextPane5.setMaximumSize(new java.awt.Dimension(550, 70));
        jTextPane5.setMinimumSize(new java.awt.Dimension(550, 70));
        jTextPane5.setPreferredSize(new java.awt.Dimension(550, 70));
        jTextPane5.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(jTextPane5);

        jTextPane3.setEditable(false);
        jTextPane3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jTextPane3.setAutoscrolls(false);
        jTextPane3.setFocusable(false);
        jTextPane3.setMaximumSize(new java.awt.Dimension(550, 70));
        jTextPane3.setMinimumSize(new java.awt.Dimension(550, 70));
        jTextPane3.setPreferredSize(new java.awt.Dimension(550, 70));
        jTextPane3.setRequestFocusEnabled(false);
        jScrollPane3.setViewportView(jTextPane3);

        jTextPane2.setEditable(false);
        jTextPane2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jTextPane2.setAutoscrolls(false);
        jTextPane2.setFocusable(false);
        jTextPane2.setMaximumSize(new java.awt.Dimension(550, 70));
        jTextPane2.setMinimumSize(new java.awt.Dimension(550, 70));
        jTextPane2.setPreferredSize(new java.awt.Dimension(550, 70));
        jTextPane2.setRequestFocusEnabled(false);
        jScrollPane4.setViewportView(jTextPane2);

        jTextPane1.setEditable(false);
        jTextPane1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jTextPane1.setAutoscrolls(false);
        jTextPane1.setFocusable(false);
        jTextPane1.setMaximumSize(new java.awt.Dimension(550, 70));
        jTextPane1.setMinimumSize(new java.awt.Dimension(550, 70));
        jTextPane1.setPreferredSize(new java.awt.Dimension(550, 70));
        jTextPane1.setRequestFocusEnabled(false);
        jScrollPane5.setViewportView(jTextPane1);

        jTextPane4.setEditable(false);
        jTextPane4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jTextPane4.setAutoscrolls(false);
        jTextPane4.setFocusable(false);
        jTextPane4.setMaximumSize(new java.awt.Dimension(550, 70));
        jTextPane4.setMinimumSize(new java.awt.Dimension(550, 70));
        jTextPane4.setPreferredSize(new java.awt.Dimension(550, 70));
        jTextPane4.setRequestFocusEnabled(false);
        jScrollPane6.setViewportView(jTextPane4);

        playButton1.setBackground(new java.awt.Color(204, 204, 204));
        playButton1.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        playButton1.setForeground(new java.awt.Color(0, 153, 51));
        playButton1.setText("Play");
        playButton1.setFocusCycleRoot(true);
        playButton1.setFocusTraversalPolicyProvider(true);
        playButton1.setMaximumSize(new java.awt.Dimension(97, 29));
        playButton1.setMinimumSize(new java.awt.Dimension(97, 29));
        playButton1.setPreferredSize(new java.awt.Dimension(97, 29));
        playButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playButton1MouseReleased(evt);
            }
        });

        playButton2.setBackground(new java.awt.Color(204, 204, 204));
        playButton2.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        playButton2.setForeground(new java.awt.Color(0, 153, 51));
        playButton2.setText("Play");
        playButton2.setMaximumSize(new java.awt.Dimension(97, 29));
        playButton2.setMinimumSize(new java.awt.Dimension(97, 29));
        playButton2.setPreferredSize(new java.awt.Dimension(97, 29));
        playButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playButton2MouseReleased(evt);
            }
        });

        playButton3.setBackground(new java.awt.Color(204, 204, 204));
        playButton3.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        playButton3.setForeground(new java.awt.Color(0, 153, 51));
        playButton3.setText("Play");
        playButton3.setMaximumSize(new java.awt.Dimension(97, 29));
        playButton3.setMinimumSize(new java.awt.Dimension(97, 29));
        playButton3.setPreferredSize(new java.awt.Dimension(97, 29));
        playButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playButton3MouseReleased(evt);
            }
        });

        playButton4.setBackground(new java.awt.Color(204, 204, 204));
        playButton4.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        playButton4.setForeground(new java.awt.Color(0, 153, 51));
        playButton4.setText("Play");
        playButton4.setMaximumSize(new java.awt.Dimension(97, 29));
        playButton4.setMinimumSize(new java.awt.Dimension(97, 29));
        playButton4.setPreferredSize(new java.awt.Dimension(97, 29));
        playButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playButton4MouseReleased(evt);
            }
        });

        playButton5.setBackground(new java.awt.Color(204, 204, 204));
        playButton5.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        playButton5.setForeground(new java.awt.Color(0, 153, 51));
        playButton5.setText("Play");
        playButton5.setMaximumSize(new java.awt.Dimension(97, 29));
        playButton5.setMinimumSize(new java.awt.Dimension(97, 29));
        playButton5.setPreferredSize(new java.awt.Dimension(97, 29));
        playButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                playButton5MouseReleased(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(204, 204, 204));
        jButton7.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton7.setText("Page 2 >>");
        jButton7.setMaximumSize(new java.awt.Dimension(97, 30));
        jButton7.setMinimumSize(new java.awt.Dimension(97, 30));
        jButton7.setPreferredSize(new java.awt.Dimension(97, 30));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(204, 204, 204));
        jButton8.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jButton8.setText("Current");
        jButton8.setMaximumSize(new java.awt.Dimension(97, 30));
        jButton8.setMinimumSize(new java.awt.Dimension(97, 30));
        jButton8.setPreferredSize(new java.awt.Dimension(97, 30));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 254));

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
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 970, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(385, 385, 385)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(playButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane6)
                            .addComponent(jScrollPane2))))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(playButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(playButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(playButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(playButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(playButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void initAudio() {        
        clip1 = clipsList.get(page-1).get(0);
        clip2 = clipsList.get(page-1).get(1);
        clip3 = clipsList.get(page-1).get(2);
        clip4 = clipsList.get(page-1).get(3);
        clip5 = clipsList.get(page-1).get(4);
        
        timer1 = timersList.get(page-1).get(0);
        timer2 = timersList.get(page-1).get(1);
        timer3 = timersList.get(page-1).get(2);
        timer4 = timersList.get(page-1).get(3);
        timer5 = timersList.get(page-1).get(4);
    }
    
    public void initTextFields() {
        backend = new PassiveBE();
        currPageIndex = 0;
        phraseList = new ArrayList<ArrayList<String>>();
        for(int i = 0; i < 20; i++){
            String file = backend.findFile(1, 'a');
            ArrayList<String> phrase = backend.findPhrase(file);
            
            
            ArrayList<String> currList;
            if(phrase == null || phrase.get(1) == null){
                i--;
                continue;
            }
            boolean contains = false;
            int index = 0;
            if (i >= 15){
                index = 3;
                currList = textList.get(3);
                if(currList.contains(phrase.get(1))){
                    contains = true;
                }
            }else if (i >= 10){
                index = 2;
                currList = textList.get(2);
                if(currList.contains(phrase.get(1))){
                    contains = true;
                }
            }else if (i >= 5){
                index = 1;
                currList = textList.get(1);
                if(currList.contains(phrase.get(1))){
                    contains = true;
                }
            }else{
                index = 0;
                currList = textList.get(0);
                if(currList.contains(phrase.get(1))){
                    contains = true;
                }
            }
            if(contains == true){
                i--;
            }else{
                phraseList.add(phrase);
                currList.set(i % 5, phrase.get(1));
            }
            //Put clip and time info here - how are we getting the time information?
            //use getClips to return the clip names and files
            Float startTime = Float.parseFloat(phrase.get(0));
            int startNum = (int) (startTime * 1000000);
            
            timesList.get(index).set(i % 5, startNum);
            
            Float endTime = Float.parseFloat(phrase.get(2));
            int endNum = (int) (endTime * 1000);
            startNum = (int) (startTime * 1000);
            int length = endNum - startNum;
            
            System.out.println(length);
            timersList.get(index).set(i % 5, new Timer(length, listener));
        }
        
        clips = backend.getClips();
        System.out.println(clips);
        //System.out.println(clips);
        
        ArrayList<String> currList = textList.get(0);
        jTextPane1.setText(currList.get(0));
        jTextPane2.setText(currList.get(1));
        jTextPane3.setText(currList.get(2));
        jTextPane4.setText(currList.get(3));
        jTextPane5.setText(currList.get(4));
        
//        for(ArrayList<String> p : textList) {
//            System.out.println("text list p: " + p);
//        }
        backend.findWords(currList, wordsList);
        for(String w : wordsList) {
            System.out.println("Word: " + w);
        }
        try {
            highlightWord(wordsList, currList);
        } catch (BadLocationException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void highlightWord(ArrayList<String> words, ArrayList<String> phrases) throws BadLocationException {
        //String text = "tan3 u1bi1 ku4u4 na1 kan4 tu4u13 ran4, tan3 i3kan4 ndu4ku4=na2, ya1kan3";
        //jTextArea1.setText(text);
        
        Highlighter highlighter = null;
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.pink);
        
        String temp = "";
        String word = "";
        
        for(int i = 0; i < phrases.size(); i++) {
            //for(int j = 0; j < phrases.get(i).size(); j++) {
                if(i == 0) {
                    highlighter = jTextPane1.getHighlighter();
                    jTextPane1.setHighlighter(highlighter);
                }
                if(i == 1) {
                    highlighter = jTextPane2.getHighlighter();
                    jTextPane2.setHighlighter(highlighter);
                }
                if(i == 2) {
                    highlighter = jTextPane3.getHighlighter();
                    jTextPane3.setHighlighter(highlighter);
                }
                if(i == 3) {
                    highlighter = jTextPane4.getHighlighter();
                    jTextPane4.setHighlighter(highlighter);
                }
                if(i == 4) {
                    highlighter = jTextPane5.getHighlighter();
                    jTextPane5.setHighlighter(highlighter);
                }

                for(int k = 0; k < words.size(); k++) {
                    temp = phrases.get(i);
                    word = words.get(k);
                    int start = temp.indexOf(word);
                    while(start >= 0) {    
                        char[] chars = temp.toCharArray();
                        if(start != 0 && Character.isWhitespace(chars[start-1])){
                            try{
                                int end = start + word.length();
                                highlighter.addHighlight(start, end, painter);
                                if(i == 0) {
                                    jTextPane1.setCaretPosition(end);
                                }
                                if(i == 1) {
                                    jTextPane2.setCaretPosition(end);
                                }
                                if(i == 2) {
                                    jTextPane3.setCaretPosition(end);
                                }
                                if(i == 3) {
                                    jTextPane4.setCaretPosition(end);
                                }
                                if(i == 4) {
                                    jTextPane5.setCaretPosition(end);
                                }
                            }catch(BadLocationException e){
                                e.printStackTrace();
                            }
                            start = temp.indexOf(word, start+word.length());
                        }
                        else {
                            start = temp.indexOf(word, start+word.length());
                        }

                    }
                }
            //}
        }
 
    }

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        enc.dispose();
        nas.dispose();
        tone.dispose();
        new Home(user).setVisible(true);
        backend.closeAudio();
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
        clip3.stop();
        clip4.stop();
        clip5.stop();
        
        timer5.stop();
        timer2.stop();
        timer3.stop();
        timer4.stop();
        
        playButton5.setText("Play");
        playButton2.setText("Play");
        playButton3.setText("Play");
        playButton4.setText("Play");
        playButton2.setForeground(new java.awt.Color(0,153,51));
        playButton3.setForeground(new java.awt.Color(0,153,51));
        playButton4.setForeground(new java.awt.Color(0,153,51));
        playButton5.setForeground(new java.awt.Color(0,153,51));
        
        if (!clip1.isRunning()) {
            clip1.setMicrosecondPosition(timesList.get(t).get(0));
            clip1.start();
            timer1.restart();
            playButton1.setForeground(new java.awt.Color(255, 51, 51));
            playButton1.setText("Stop");
        }
        else {
            clip1.stop();
            timer1.stop();
            playButton1.setForeground(new java.awt.Color(0,153,51));
            playButton1.setText("Play");
        }
    }//GEN-LAST:event_playButton1MouseReleased

    private void playButton2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playButton2MouseReleased
        clip1.stop();
        clip3.stop();
        clip4.stop();
        clip5.stop();
        
        timer1.stop();
        timer5.stop();
        timer3.stop();
        timer4.stop();
        
        playButton1.setText("Play");
        playButton5.setText("Play");
        playButton3.setText("Play");
        playButton4.setText("Play");
        playButton1.setForeground(new java.awt.Color(0,153,51));
        playButton3.setForeground(new java.awt.Color(0,153,51));
        playButton4.setForeground(new java.awt.Color(0,153,51));
        playButton5.setForeground(new java.awt.Color(0,153,51));
        
        if (!clip2.isRunning()) {
            clip2.setMicrosecondPosition(timesList.get(t).get(1));
            clip2.start();
            timer2.restart();
            playButton2.setForeground(new java.awt.Color(255, 51, 51));
            playButton2.setText("Stop");
        }
        else {
            clip2.stop();
            timer2.stop();
            playButton2.setForeground(new java.awt.Color(0,153,51));
            playButton2.setText("Play");
        }
    }//GEN-LAST:event_playButton2MouseReleased

    private void playButton3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playButton3MouseReleased
        clip1.stop();
        clip2.stop();
        clip4.stop();
        clip5.stop();
        
        timer1.stop();
        timer2.stop();
        timer5.stop();
        timer4.stop();
        
        playButton1.setText("Play");
        playButton2.setText("Play");
        playButton5.setText("Play");
        playButton4.setText("Play");
        playButton1.setForeground(new java.awt.Color(0,153,51));
        playButton2.setForeground(new java.awt.Color(0,153,51));
        playButton4.setForeground(new java.awt.Color(0,153,51));
        playButton5.setForeground(new java.awt.Color(0,153,51));
        
        if (!clip3.isRunning()) {
            clip3.setMicrosecondPosition(timesList.get(t).get(2));
            clip3.start();
            timer3.restart();
            playButton3.setForeground(new java.awt.Color(255, 51, 51));
            playButton3.setText("Stop");
        }
        else {
            clip3.stop();
            timer3.stop();
            playButton3.setForeground(new java.awt.Color(0,153,51));
            playButton3.setText("Play");
        }
    }//GEN-LAST:event_playButton3MouseReleased

    private void playButton4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playButton4MouseReleased
        clip1.stop();
        clip2.stop();
        clip3.stop();
        clip5.stop();
        
        timer1.stop();
        timer2.stop();
        timer3.stop();
        timer5.stop();
        
        playButton1.setText("Play");
        playButton2.setText("Play");
        playButton3.setText("Play");
        playButton5.setText("Play");
        playButton1.setForeground(new java.awt.Color(0,153,51));
        playButton2.setForeground(new java.awt.Color(0,153,51));
        playButton3.setForeground(new java.awt.Color(0,153,51));
        playButton5.setForeground(new java.awt.Color(0,153,51));
        
        if (!clip4.isRunning()) {
            clip4.setMicrosecondPosition(timesList.get(t).get(3));
            clip4.start();
            timer4.restart();
            playButton4.setForeground(new java.awt.Color(255, 51, 51));
            playButton4.setText("Stop");
        }
        else {
            clip4.stop();
            timer4.stop();
            playButton4.setForeground(new java.awt.Color(0,153,51));
            playButton4.setText("Play");
        }
    }//GEN-LAST:event_playButton4MouseReleased

    private void playButton5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playButton5MouseReleased
        clip1.stop();
        clip2.stop();
        clip3.stop();
        clip4.stop();
        
        timer1.stop();
        timer2.stop();
        timer3.stop();
        timer4.stop();
        
        playButton1.setText("Play");
        playButton2.setText("Play");
        playButton3.setText("Play");
        playButton4.setText("Play");
        playButton1.setForeground(new java.awt.Color(0,153,51));
        playButton2.setForeground(new java.awt.Color(0,153,51));
        playButton3.setForeground(new java.awt.Color(0,153,51));
        playButton4.setForeground(new java.awt.Color(0,153,51));
        
        if (!clip5.isRunning()) {
            clip5.setMicrosecondPosition(timesList.get(t).get(4));
            clip5.start();
            timer5.restart();
            playButton5.setForeground(new java.awt.Color(255, 51, 51));
            playButton5.setText("Stop");
        }
        else {
            clip5.stop();
            timer5.stop();
            playButton5.setForeground(new java.awt.Color(0,153,51));
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
        }
        else if (page == 3) {
            jButton7.setText("Page 4 >>");
            jButton8.setText("<< Page 2");
        }
        else {
            jButton8.setText("<< Page 3");
            jButton7.setText("Current");
        }
        
        jTextPane1.setText(textList.get(page-1).get(0));
        jTextPane2.setText(textList.get(page-1).get(1));
        jTextPane3.setText(textList.get(page-1).get(2));
        jTextPane4.setText(textList.get(page-1).get(3));
        jTextPane5.setText(textList.get(page-1).get(4));
        
        clip1.stop();
        clip2.stop();
        clip3.stop();
        clip4.stop();
        clip5.stop();
        
        timer1.stop();
        timer2.stop();
        timer3.stop();
        timer4.stop();
        timer5.stop();
        
        playButton1.setForeground(new java.awt.Color(0,153,51));
        playButton2.setForeground(new java.awt.Color(0,153,51));
        playButton3.setForeground(new java.awt.Color(0,153,51));
        playButton4.setForeground(new java.awt.Color(0,153,51));
        playButton5.setForeground(new java.awt.Color(0,153,51));
     
        playButton1.setText("Play");
        playButton2.setText("Play");
        playButton3.setText("Play");
        playButton4.setText("Play");
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
         }
         else if(page == 2) {
             jButton7.setText("Page 3 >>");
             jButton8.setText("<< Page 1");
         }
         else if (page == 3) {
             jButton7.setText("Page 4 >>");
             jButton8.setText("<< Page 2");   
         }
        
        jTextPane1.setText(textList.get(page-1).get(0));
        jTextPane2.setText(textList.get(page-1).get(1));
        jTextPane3.setText(textList.get(page-1).get(2));
        jTextPane4.setText(textList.get(page-1).get(3));
        jTextPane5.setText(textList.get(page-1).get(4));
        
        clip1.stop();
        clip2.stop();
        clip3.stop();
        clip4.stop();
        clip5.stop();
        
        timer1.stop();
        timer2.stop();
        timer3.stop();
        timer4.stop();
        timer5.stop();
        
        playButton1.setForeground(new java.awt.Color(0,153,51));
        playButton2.setForeground(new java.awt.Color(0,153,51));
        playButton3.setForeground(new java.awt.Color(0,153,51));
        playButton4.setForeground(new java.awt.Color(0,153,51));
        playButton5.setForeground(new java.awt.Color(0,153,51));
     
        playButton1.setText("Play");
        playButton2.setText("Play");
        playButton3.setText("Play");
        playButton4.setText("Play");
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
