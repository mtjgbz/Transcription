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
    File file;
    String user;
    long time1 = 9029000;
    long currentTime = 0;
    int count = 0;
    boolean pause = false;

    ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            clip1.stop();
            clip1.setMicrosecondPosition(time1);
            playButton1.setText("Play");
        }
    };
    Timer timer = new Timer(4428, listener);
    Timer timer1 = new Timer(4428, listener);
    Timer timer2;
    Timer timer3;
    Timer timer4;
    Timer timer5;

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
        file = new File("Yolox_Narra_EGS505_Servicio-en-el-pueblo_2010-12-15-s.wav");
        initComponents();
        jMenu5.setText(user);
        this.setTitle("Mixtec Transcription: Passive Training");
        jTextPane1.setText("nda4a2 chi3ñu3 ba42 nu14u3 nu14u3 i4xa3=na2 tan3 sa1a3 nda4-ya'1a3=na2 kwa'1an1=na1 tan42 i3in3 tan42 i3in3 chi3ñu3 kan4 tan3");
        try {
            audioIn = AudioSystem.getAudioInputStream(file);
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

        jButton7.setText("Next");
        jButton7.setMaximumSize(new java.awt.Dimension(97, 30));
        jButton7.setMinimumSize(new java.awt.Dimension(97, 30));
        jButton7.setPreferredSize(new java.awt.Dimension(97, 30));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Previous");
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
                .addGap(388, 388, 388))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(playButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void initAudio() {

    }

    public void initTextFields() {
        backend = new PassiveBE();
        System.out.println(backend.findFile(1, 'a'));
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

        if (!clip1.isRunning()) {
            clip1.start();
            timer1.start();
            playButton1.setText("Pause");
        } else {
            clip1.stop();
            timer.stop();
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
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
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
