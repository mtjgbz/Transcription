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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

/**
 *
 * @author Mike, Noah, Casey and Erica
 */
public class Passive extends javax.swing.JFrame {
    private static String path;
    private Integer lesson;
    int page = 1;
    String user;
    int t = 0;
    String subLesson;

    ArrayList<Clip> clipsList = new ArrayList<>();
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

    ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent event) {

            clip1.stop();
            clip1.setMicrosecondPosition(timesList.get(page - 1).get(0));
            clip2.stop();
            clip2.setMicrosecondPosition(timesList.get(page - 1).get(1));
            clip3.stop();
            clip3.setMicrosecondPosition(timesList.get(page - 1).get(2));
            clip4.stop();
            clip4.setMicrosecondPosition(timesList.get(page - 1).get(3));
            clip5.stop();
            clip5.setMicrosecondPosition(timesList.get(page - 1).get(4));
            playButton1.setForeground(new java.awt.Color(0, 153, 51));
            playButton2.setForeground(new java.awt.Color(0, 153, 51));
            playButton3.setForeground(new java.awt.Color(0, 153, 51));
            playButton4.setForeground(new java.awt.Color(0, 153, 51));
            playButton5.setForeground(new java.awt.Color(0, 153, 51));

            playButton1.setText("Play");
            playButton2.setText("Play");
            playButton3.setText("Play");
            playButton4.setText("Play");
            playButton5.setText("Play");
        }
    };

    Enclitics enc = new Enclitics();
    Nasalizations nas;
    NamaTable na;
    ToneTable tone;
    int NaMaCount = 0;

    private PassiveBE backend;

    /**
     * Creates new form Passive
     *
     * @param user the username of the user
     * @param lesson the lesson the user selected
     * @param subLesson the sub-lesson the user selected
     */
    public Passive(String user, Integer lesson, String subLesson) {
        this.user = user;
        getContentPane().setBackground(new Color(148, 189, 203));

        this.lesson = lesson;
        this.subLesson = subLesson;

        initLists();

        backend = new PassiveBE(this);

        for (int i = 0; i < 5; i++) {
            timersList.get(0).add(new Timer(4428, listener));
            timersList.get(1).add(new Timer(4428, listener));
            timersList.get(2).add(new Timer(4428, listener));
            timersList.get(3).add(new Timer(4428, listener));
            timesList.get(0).add(9029000);
            timesList.get(1).add(9029000);
            timesList.get(2).add(9029000);
            timesList.get(3).add(9029000);
        }

        textList.get(0).add("text1");
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

        initComponents();
        jUserButton.setText(user);
        this.setTitle("Mixtec Transcription: Passive Training");

        initTextFields();
        clipsList = backend.makeClips(1);

        initAudio();
        setupTones();
        nas = new Nasalizations(path);
        tone = new ToneTable(path);
        jBackButton.setEnabled(false);
    }

    private void setupTones() {
        try {
            Statement stmt = User.setupDB(this, getClass().getResource("TAA.db").toString());
            
            String newQuery1 = "SELECT FileList FROM LESSONS WHERE Lesson = 0;";
            ResultSet rsExp = stmt.executeQuery(newQuery1);
            path = (rsExp.getString("FileList"));
            stmt.execute(newQuery1);

            User.closeDB(stmt);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * initialize Lists method
     */
    public void initLists() {

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
        jNextButton = new javax.swing.JButton();
        jBackButton = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 40), new java.awt.Dimension(0, 40), new java.awt.Dimension(32767, 40));
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jHomeMenuButton = new javax.swing.JMenu();
        jEncliticMenuButton = new javax.swing.JMenu();
        jNasMenuButton = new javax.swing.JMenu();
        jTTMenuButton = new javax.swing.JMenu();
        jNaMaMenu = new javax.swing.JMenu();
        jUserButton = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(970, 600));
        setMinimumSize(new java.awt.Dimension(970, 600));
        setResizable(false);

        jTextPane5.setEditable(false);
        jTextPane5.setAutoscrolls(false);
        jTextPane5.setFocusable(false);
        jTextPane5.setMaximumSize(new java.awt.Dimension(550, 70));
        jTextPane5.setMinimumSize(new java.awt.Dimension(550, 70));
        jTextPane5.setPreferredSize(new java.awt.Dimension(550, 70));
        jTextPane5.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(jTextPane5);

        jTextPane3.setEditable(false);
        jTextPane3.setAutoscrolls(false);
        jTextPane3.setFocusable(false);
        jTextPane3.setMaximumSize(new java.awt.Dimension(550, 70));
        jTextPane3.setMinimumSize(new java.awt.Dimension(550, 70));
        jTextPane3.setPreferredSize(new java.awt.Dimension(550, 70));
        jTextPane3.setRequestFocusEnabled(false);
        jScrollPane3.setViewportView(jTextPane3);

        jTextPane2.setEditable(false);
        jTextPane2.setAutoscrolls(false);
        jTextPane2.setFocusable(false);
        jTextPane2.setMaximumSize(new java.awt.Dimension(550, 70));
        jTextPane2.setMinimumSize(new java.awt.Dimension(550, 70));
        jTextPane2.setPreferredSize(new java.awt.Dimension(550, 70));
        jTextPane2.setRequestFocusEnabled(false);
        jScrollPane4.setViewportView(jTextPane2);

        jTextPane1.setEditable(false);
        jTextPane1.setAutoscrolls(false);
        jTextPane1.setFocusable(false);
        jTextPane1.setMaximumSize(new java.awt.Dimension(550, 70));
        jTextPane1.setMinimumSize(new java.awt.Dimension(550, 70));
        jTextPane1.setPreferredSize(new java.awt.Dimension(550, 70));
        jTextPane1.setRequestFocusEnabled(false);
        jScrollPane5.setViewportView(jTextPane1);

        jTextPane4.setEditable(false);
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

        jNextButton.setBackground(new java.awt.Color(204, 204, 204));
        jNextButton.setText("Next");
        jNextButton.setMaximumSize(new java.awt.Dimension(97, 30));
        jNextButton.setMinimumSize(new java.awt.Dimension(97, 30));
        jNextButton.setPreferredSize(new java.awt.Dimension(97, 30));
        jNextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNextButtonActionPerformed(evt);
            }
        });

        jBackButton.setBackground(new java.awt.Color(204, 204, 204));
        jBackButton.setText("Current");
        jBackButton.setMaximumSize(new java.awt.Dimension(97, 30));
        jBackButton.setMinimumSize(new java.awt.Dimension(97, 30));
        jBackButton.setPreferredSize(new java.awt.Dimension(97, 30));
        jBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBackButtonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Page 1");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/transcription/blue.png"))); // NOI18N
        jLabel1.setFocusable(false);
        jLabel1.setRequestFocusEnabled(false);
        jLabel1.setVerifyInputWhenFocusTarget(false);

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 254));

        jHomeMenuButton.setText("Home");
        jHomeMenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jHomeMenuButtonMouseClicked(evt);
            }
        });
        jMenuBar1.add(jHomeMenuButton);

        jEncliticMenuButton.setActionCommand("Enclitics");
        jEncliticMenuButton.setLabel("Enclitics");
        jEncliticMenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEncliticMenuButtonMouseClicked(evt);
            }
        });
        jMenuBar1.add(jEncliticMenuButton);

        jNasMenuButton.setText("Nasalization");
        jNasMenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNasMenuButtonMouseClicked(evt);
            }
        });
        jMenuBar1.add(jNasMenuButton);

        jTTMenuButton.setText("Tone Table");
        jTTMenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTTMenuButtonMouseClicked(evt);
            }
        });
        jMenuBar1.add(jTTMenuButton);

        jNaMaMenu.setText("NaMa");
        jNaMaMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNaMaMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(jNaMaMenu);

        jUserButton.setText("User");

        jMenuItem1.setText("Log out");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseReleased(evt);
            }
        });
        jUserButton.add(jMenuItem1);

        jMenuBar1.add(jUserButton);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane2))
                .addGap(147, 147, 147))
            .addGroup(layout.createSequentialGroup()
                .addGap(385, 385, 385)
                .addComponent(jBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(240, 240, 240)
                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(20, 20, 20))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 972, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jNextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jBackButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(filler2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15))))
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
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 592, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * initialize audio method
     */
    public void initAudio() {
        clip1 = clipsList.get(0);
        clip2 = clipsList.get(1);
        clip3 = clipsList.get(2);
        clip4 = clipsList.get(3);
        clip5 = clipsList.get(4);

        timer1 = timersList.get(page - 1).get(0);
        timer2 = timersList.get(page - 1).get(1);
        timer3 = timersList.get(page - 1).get(2);
        timer4 = timersList.get(page - 1).get(3);
        timer5 = timersList.get(page - 1).get(4);
    }

    /**
     * initializes text field method
     */
    public void initTextFields() {
        backend = new PassiveBE(this);
        phraseList = new ArrayList<ArrayList<String>>();
        for (int i = 0; i < 20; i++) {
            //pulls the transcription file for searching
            String file = backend.findFile(lesson, subLesson);
            //pulls the start time, phrase, and end time from the file selected above
            ArrayList<String> phrase = backend.findPhrase(file);

            //if a phrase is not found, try again
            ArrayList<String> currList;
            if (phrase == null || phrase.get(1) == null) {
                i--;
                continue;
            }
            boolean contains = false;   //if the phrase has already been used
            int index = 0;              //index of the array list within arraylists
            //sets the index to the applicable spot, checks if the phrase has been used
            if (i >= 15) {
                index = 3;
                currList = textList.get(3);
                if (currList.contains(phrase.get(1))) {
                    contains = true;
                }
            } else if (i >= 10) {
                index = 2;
                currList = textList.get(2);
                if (currList.contains(phrase.get(1))) {
                    contains = true;
                }
            } else if (i >= 5) {
                index = 1;
                currList = textList.get(1);
                if (currList.contains(phrase.get(1))) {
                    contains = true;
                }
            } else {
                index = 0;
                currList = textList.get(0);
                if (currList.contains(phrase.get(1))) {
                    contains = true;
                }
            }
            if (contains == true) {
                i--;                //if the phrase has already been used, try again
            } else {
                phraseList.add(phrase);
                currList.set(i % 5, phrase.get(1)); //set the right arraylist position in textList
            }

            //Get the start time and add it to the list
            Float startTime = Float.parseFloat(phrase.get(0));
            int startNum = (int) (startTime * 1000000);

            timesList.get(index).set(i % 5, startNum);

            //Calculate the duration and add it to the list
            Float endTime = Float.parseFloat(phrase.get(2));
            int endNum = (int) (endTime * 1000);
            startNum = (int) (startTime * 1000);
            int length = endNum - startNum;

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

        backend.findWords(currList, wordsList);
        try {
            highlightWord(wordsList, textList.get(page - 1));
        } catch (BadLocationException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param words
     * @param phrases
     * @throws BadLocationException
     */
    public void highlightWord(ArrayList<String> words, ArrayList<String> phrases) throws BadLocationException {

        Highlighter highlighter = null;
        Highlighter.HighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter(Color.cyan);

        String temp = "";
        String word = "";

        for (int i = 0; i < phrases.size(); i++) {
            if (i == 0) {
                highlighter = jTextPane1.getHighlighter();
                jTextPane1.setHighlighter(highlighter);
            }
            if (i == 1) {
                highlighter = jTextPane2.getHighlighter();
                jTextPane2.setHighlighter(highlighter);
            }
            if (i == 2) {
                highlighter = jTextPane3.getHighlighter();
                jTextPane3.setHighlighter(highlighter);
            }
            if (i == 3) {
                highlighter = jTextPane4.getHighlighter();
                jTextPane4.setHighlighter(highlighter);
            }
            if (i == 4) {
                highlighter = jTextPane5.getHighlighter();
                jTextPane5.setHighlighter(highlighter);
            }

            for (int k = 0; k < words.size(); k++) {
                temp = phrases.get(i);
                word = words.get(k);
                int start = temp.indexOf(word);
                while (start >= 0) {
                    char[] chars = temp.toCharArray();
                    if (start != 0 && Character.isWhitespace(chars[start - 1])) {
                        try {
                            int end = start + word.length();
                            highlighter.addHighlight(start, end - 1, painter);
                            if (i == 0) {
                                jTextPane1.setCaretPosition(end);
                            }
                            if (i == 1) {
                                jTextPane2.setCaretPosition(end);
                            }
                            if (i == 2) {
                                jTextPane3.setCaretPosition(end);
                            }
                            if (i == 3) {
                                jTextPane4.setCaretPosition(end);
                            }
                            if (i == 4) {
                                jTextPane5.setCaretPosition(end);
                            }
                        } catch (BadLocationException e) {
                            e.printStackTrace();
                        }
                        start = temp.indexOf(word, start + word.length());
                    } else {
                        start = temp.indexOf(word, start + word.length());
                    }
                }
            }
        }
    }

    private void jHomeMenuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeMenuButtonMouseClicked
        enc.dispose();
        nas.dispose();
        tone.dispose();
        if (NaMaCount > 0) {
            na.dispose();
        }
        new Home(user).setVisible(true);
        backend.closeAudio();
        dispose();
    }//GEN-LAST:event_jHomeMenuButtonMouseClicked

    private void jEncliticMenuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEncliticMenuButtonMouseClicked
        if (!enc.isShowing()) {
            enc.setVisible(true);
        } else {
            enc.toFront();
        }
    }//GEN-LAST:event_jEncliticMenuButtonMouseClicked

    private void jNasMenuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNasMenuButtonMouseClicked
        if (!nas.isShowing()) {
            nas.setVisible(true);
        } else {
            nas.toFront();
        }
    }//GEN-LAST:event_jNasMenuButtonMouseClicked

    private void jTTMenuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTTMenuButtonMouseClicked
        if (!tone.isShowing()) {
            tone.setVisible(true);
        } else {
            tone.toFront();
        }
    }//GEN-LAST:event_jTTMenuButtonMouseClicked

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
        playButton2.setForeground(new java.awt.Color(0, 153, 51));
        playButton3.setForeground(new java.awt.Color(0, 153, 51));
        playButton4.setForeground(new java.awt.Color(0, 153, 51));
        playButton5.setForeground(new java.awt.Color(0, 153, 51));

        if (!clip1.isRunning()) {
            clip1.setMicrosecondPosition(timesList.get(t).get(0));
            clip1.start();
            timer1.restart();
            playButton1.setForeground(new java.awt.Color(255, 51, 51));
            playButton1.setText("Stop");
        } else {
            clip1.stop();
            timer1.stop();
            playButton1.setForeground(new java.awt.Color(0, 153, 51));
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
        playButton1.setForeground(new java.awt.Color(0, 153, 51));
        playButton3.setForeground(new java.awt.Color(0, 153, 51));
        playButton4.setForeground(new java.awt.Color(0, 153, 51));
        playButton5.setForeground(new java.awt.Color(0, 153, 51));

        if (!clip2.isRunning()) {
            clip2.setMicrosecondPosition(timesList.get(t).get(1));
            clip2.start();
            timer2.restart();
            playButton2.setForeground(new java.awt.Color(255, 51, 51));
            playButton2.setText("Stop");
        } else {
            clip2.stop();
            timer2.stop();
            playButton2.setForeground(new java.awt.Color(0, 153, 51));
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
        playButton1.setForeground(new java.awt.Color(0, 153, 51));
        playButton2.setForeground(new java.awt.Color(0, 153, 51));
        playButton4.setForeground(new java.awt.Color(0, 153, 51));
        playButton5.setForeground(new java.awt.Color(0, 153, 51));

        if (!clip3.isRunning()) {
            clip3.setMicrosecondPosition(timesList.get(t).get(2));
            clip3.start();
            timer3.restart();
            playButton3.setForeground(new java.awt.Color(255, 51, 51));
            playButton3.setText("Stop");
        } else {
            clip3.stop();
            timer3.stop();
            playButton3.setForeground(new java.awt.Color(0, 153, 51));
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
        playButton1.setForeground(new java.awt.Color(0, 153, 51));
        playButton2.setForeground(new java.awt.Color(0, 153, 51));
        playButton3.setForeground(new java.awt.Color(0, 153, 51));
        playButton5.setForeground(new java.awt.Color(0, 153, 51));

        if (!clip4.isRunning()) {
            clip4.setMicrosecondPosition(timesList.get(t).get(3));
            clip4.start();
            timer4.restart();
            playButton4.setForeground(new java.awt.Color(255, 51, 51));
            playButton4.setText("Stop");
        } else {
            clip4.stop();
            timer4.stop();
            playButton4.setForeground(new java.awt.Color(0, 153, 51));
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
        playButton1.setForeground(new java.awt.Color(0, 153, 51));
        playButton2.setForeground(new java.awt.Color(0, 153, 51));
        playButton3.setForeground(new java.awt.Color(0, 153, 51));
        playButton4.setForeground(new java.awt.Color(0, 153, 51));

        if (!clip5.isRunning()) {
            clip5.setMicrosecondPosition(timesList.get(t).get(4));
            clip5.start();
            timer5.restart();
            playButton5.setForeground(new java.awt.Color(255, 51, 51));
            playButton5.setText("Stop");
        } else {
            clip5.stop();
            timer5.stop();
            playButton5.setForeground(new java.awt.Color(0, 153, 51));
            playButton5.setText("Play");
        }
    }//GEN-LAST:event_playButton5MouseReleased

    private void jNextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNextButtonActionPerformed
        if (page >= 1 && page < 4) {
            page++;
        }

        jLabel2.setText("Page " + page);

        if (page == 4) {
            jNextButton.setText("Current");
            jNextButton.setEnabled(false);
        }

        if (page != 1) {
            jBackButton.setText("Back");
            jBackButton.setEnabled(true);
        }

        jTextPane1.setText(textList.get(page - 1).get(0));
        jTextPane2.setText(textList.get(page - 1).get(1));
        jTextPane3.setText(textList.get(page - 1).get(2));
        jTextPane4.setText(textList.get(page - 1).get(3));
        jTextPane5.setText(textList.get(page - 1).get(4));

        clip1.stop();
        clip2.stop();
        clip3.stop();
        clip4.stop();
        clip5.stop();

        clip1.close();
        clip2.close();
        clip3.close();
        clip4.close();
        clip5.close();

        timer1.stop();
        timer2.stop();
        timer3.stop();
        timer4.stop();
        timer5.stop();

        playButton1.setForeground(new java.awt.Color(0, 153, 51));
        playButton2.setForeground(new java.awt.Color(0, 153, 51));
        playButton3.setForeground(new java.awt.Color(0, 153, 51));
        playButton4.setForeground(new java.awt.Color(0, 153, 51));
        playButton5.setForeground(new java.awt.Color(0, 153, 51));

        playButton1.setText("Play");
        playButton2.setText("Play");
        playButton3.setText("Play");
        playButton4.setText("Play");
        playButton5.setText("Play");

        backend.closeAudio();
        clipsList = backend.makeClips(page);
        initAudio();
        backend.findWords(textList.get(page - 1), wordsList);
        try {
            highlightWord(wordsList, textList.get(page - 1));
        } catch (BadLocationException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jNextButtonActionPerformed

    private void jBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBackButtonActionPerformed
        if (page <= 4 && page > 1) {
            page--;
        }

        jLabel2.setText("Page " + page);

        if (page == 1) {
            jBackButton.setText("Current");
            jBackButton.setEnabled(false);
        }

        if (page != 1) {
            jNextButton.setText("Next");
            jNextButton.setEnabled(true);
        }

        jTextPane1.setText(textList.get(page - 1).get(0));
        jTextPane2.setText(textList.get(page - 1).get(1));
        jTextPane3.setText(textList.get(page - 1).get(2));
        jTextPane4.setText(textList.get(page - 1).get(3));
        jTextPane5.setText(textList.get(page - 1).get(4));

        clip1.stop();
        clip2.stop();
        clip3.stop();
        clip4.stop();
        clip5.stop();

        clip1.close();
        clip2.close();
        clip3.close();
        clip4.close();
        clip5.close();

        timer1.stop();
        timer2.stop();
        timer3.stop();
        timer4.stop();
        timer5.stop();

        playButton1.setForeground(new java.awt.Color(0, 153, 51));
        playButton2.setForeground(new java.awt.Color(0, 153, 51));
        playButton3.setForeground(new java.awt.Color(0, 153, 51));
        playButton4.setForeground(new java.awt.Color(0, 153, 51));
        playButton5.setForeground(new java.awt.Color(0, 153, 51));

        playButton1.setText("Play");
        playButton2.setText("Play");
        playButton3.setText("Play");
        playButton4.setText("Play");
        playButton5.setText("Play");

        backend.closeAudio();
        clipsList = backend.makeClips(page);
        initAudio();
        backend.findWords(textList.get(page - 1), wordsList);

        try {
            highlightWord(wordsList, textList.get(page - 1));
        } catch (BadLocationException ex) {
            Logger.getLogger(Passive.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jBackButtonActionPerformed

    private void jNaMaMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNaMaMenuMouseClicked
        if (NaMaCount == 0) {
            na = new NamaTable();
        }
        if (!na.isShowing()) {
            na.setVisible(true);
        } else {
            na.toFront();
        }
        NaMaCount++;
    }//GEN-LAST:event_jNaMaMenuMouseClicked

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
    private javax.swing.Box.Filler filler2;
    private javax.swing.JButton jBackButton;
    private javax.swing.JMenu jEncliticMenuButton;
    private javax.swing.JMenu jHomeMenuButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jNaMaMenu;
    private javax.swing.JMenu jNasMenuButton;
    private javax.swing.JButton jNextButton;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JMenu jTTMenuButton;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JTextPane jTextPane5;
    private javax.swing.JMenu jUserButton;
    private javax.swing.JButton playButton1;
    private javax.swing.JButton playButton2;
    private javax.swing.JButton playButton3;
    private javax.swing.JButton playButton4;
    private javax.swing.JButton playButton5;
    // End of variables declaration//GEN-END:variables
}
