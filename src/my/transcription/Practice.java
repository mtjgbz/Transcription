/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.swing.Timer;
import javax.swing.text.BadLocationException;

/**
 *
 * @author Mike, Erica, Noah and Casey
 */
public class Practice extends javax.swing.JFrame {

    String user;
    Integer lesson;
    String subLesson;

    Clip clip;
    Timer timer;

    Enclitics enc = new Enclitics();
    Nasalizations nas = new Nasalizations();
    ToneTable tone = new ToneTable();
    NamaTable na;
    int NaMaCount = 0;
    
    private ActiveBE pbe;
    
    int page = 1;
    
    private ArrayList<String> textList = new ArrayList<>();
    Integer timesVar = 9029000;
    private ArrayList<String> phraseList;
    private ArrayList<String> wordsList = new ArrayList<String>();

    
    ActionListener listener = new ActionListener() {
        public void actionPerformed(ActionEvent event) {
            
            clip.stop();
            clip.setMicrosecondPosition(timesVar);
            playButton1.setForeground(new java.awt.Color(0, 153, 51));
            playButton1.setText("Play");
        }
    };

    /**
     * Creates new form Practice
     *
     * @param user
     */
    public Practice(String user, Integer lesson, String subLesson) {
        this.setTitle("Mixtec Transcription: Practice");
        initComponents();
        playButton1.setForeground(new java.awt.Color(0, 153, 51));
        this.user = user;
        this.lesson = lesson;
        this.subLesson = subLesson;
        jUserMenu.setText(user);
        jTextPane1.setText("text1");
        prevButton.setText("Current");
        prevButton.setEnabled(false);
        timer = new Timer(4428, listener);
        
        pbe = new ActiveBE(false);
        initAudio(); 
    }
    
    private void initAudio(){
        clip = pbe.makeClip(page);
        //timer = ;
    }
    
    public void initTextFields() {
//        pbe = new PassiveBE();
//        phraseList = new ArrayList<String>();
//        for (int i = 0; i < 20; i++) {
//            String file = pbe.findFile(lesson, subLesson);
//            ArrayList<String> phrase = pbe.findPhrase(file);
//
//            ArrayList<String> currList;
//            if (phrase == null || phrase.get(1) == null) {
//                i--;
//                continue;
//            }
//            boolean contains = false;
//            int index = 0;
//
//            if (contains == true) {
//                i--;
//            } else {
//                phraseList.add(phrase);
//                currList.set(i % 5, phrase.get(1));
//            }
//            
//            //Put clip and time info here - how are we getting the time information?
//            //use getClips to return the clip names and files
//            Float startTime = Float.parseFloat(phrase.get(0));
//            int startNum = (int) (startTime * 1000000);
//
//            timesList.add(startNum);
//
//            Float endTime = Float.parseFloat(phrase.get(2));
//            int endNum = (int) (endTime * 1000);
//            startNum = (int) (startTime * 1000);
//            int length = endNum - startNum;
//
//            timersList.add(new Timer(length, listener));
//        }
//
//        clip = pbe.getClip();
//        System.out.println(clip);
//
//        ArrayList<String> currList = textList.get(page - 1);
//        jTextArea1.setText(currList.get(page - 1));
//
//        pbe.findWords(currList, wordsList);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submitButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        prevButton = new javax.swing.JButton();
        playButton1 = new javax.swing.JButton();
        jPageLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jHomeMenu = new javax.swing.JMenu();
        jEncMenu = new javax.swing.JMenu();
        jNasMenu = new javax.swing.JMenu();
        jToneTableMenu = new javax.swing.JMenu();
        jNaMaMenu = new javax.swing.JMenu();
        jUserMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusableWindowState(false);
        setMinimumSize(new java.awt.Dimension(700, 430));
        setResizable(false);

        submitButton.setBackground(new java.awt.Color(255, 255, 255));
        submitButton.setText("Submit");
        submitButton.setMaximumSize(new java.awt.Dimension(97, 30));
        submitButton.setMinimumSize(new java.awt.Dimension(97, 30));
        submitButton.setPreferredSize(new java.awt.Dimension(97, 30));
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        nextButton.setBackground(new java.awt.Color(255, 255, 255));
        nextButton.setText("Next");
        nextButton.setMaximumSize(new java.awt.Dimension(97, 30));
        nextButton.setMinimumSize(new java.awt.Dimension(97, 30));
        nextButton.setPreferredSize(new java.awt.Dimension(97, 30));
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        prevButton.setBackground(new java.awt.Color(255, 255, 255));
        prevButton.setText("Previous");
        prevButton.setMaximumSize(new java.awt.Dimension(97, 30));
        prevButton.setMinimumSize(new java.awt.Dimension(97, 30));
        prevButton.setPreferredSize(new java.awt.Dimension(97, 30));
        prevButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prevButtonActionPerformed(evt);
            }
        });

        playButton1.setBackground(new java.awt.Color(255, 255, 255));
        playButton1.setText("Play");
        playButton1.setMaximumSize(new java.awt.Dimension(97, 29));
        playButton1.setMinimumSize(new java.awt.Dimension(97, 29));
        playButton1.setPreferredSize(new java.awt.Dimension(97, 29));
        playButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButton1ActionPerformed(evt);
            }
        });

        jPageLabel.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jPageLabel.setForeground(new java.awt.Color(204, 204, 204));
        jPageLabel.setText("Page 1");

        jTextField1.setMaximumSize(new java.awt.Dimension(14, 28));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setMaximumSize(new java.awt.Dimension(14, 28));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setMaximumSize(new java.awt.Dimension(14, 28));
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jTextField4.setMaximumSize(new java.awt.Dimension(14, 28));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel1.setText("4");

        jLabel2.setText("3");

        jLabel3.setText("2");

        jLabel4.setText("1");

        jTextPane1.setEditable(false);
        jTextPane1.setAutoscrolls(false);
        jTextPane1.setFocusable(false);
        jTextPane1.setMaximumSize(new java.awt.Dimension(550, 70));
        jTextPane1.setMinimumSize(new java.awt.Dimension(550, 70));
        jTextPane1.setPreferredSize(new java.awt.Dimension(550, 70));
        jTextPane1.setRequestFocusEnabled(false);
        jScrollPane5.setViewportView(jTextPane1);

        jHomeMenu.setText("Home");
        jHomeMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jHomeMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(jHomeMenu);

        jEncMenu.setActionCommand("Enclitics");
        jEncMenu.setLabel("Enclitics");
        jEncMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jEncMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(jEncMenu);

        jNasMenu.setText("Nasalization");
        jNasMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNasMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(jNasMenu);

        jToneTableMenu.setText("Tone Table");
        jToneTableMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToneTableMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(jToneTableMenu);

        jNaMaMenu.setText("NaMa");
        jNaMaMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jNaMaMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(jNaMaMenu);

        jUserMenu.setText("User");

        jMenuItem1.setText("Log out");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseReleased(evt);
            }
        });
        jUserMenu.add(jMenuItem1);

        jMenuBar1.add(jUserMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(playButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 52, Short.MAX_VALUE)
                        .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(223, 223, 223)
                        .addComponent(jPageLabel)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jLabel4)
                        .addGap(116, 116, 116)
                        .addComponent(jLabel3)
                        .addGap(118, 118, 118)
                        .addComponent(jLabel2)
                        .addGap(118, 118, 118)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(playButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPageLabel))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // pbe.submit(answerList);
    }                                            
    
    private void prevButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prevButtonActionPerformed
       page--;
       clip.stop();
       clip.close();
       timer.stop();
       jPageLabel.setText("Page " + page);
       pbe.closeAudio(); 
       clip = pbe.makeClip(page);
       if(page == 1){
           prevButton.setText("Current");
           prevButton.setEnabled(false);
       }else if(page == 19){
           nextButton.setEnabled(true);
           nextButton.setText("Next");
       }
       playButton1.setForeground(new java.awt.Color(0, 153, 51));
       playButton1.setText("Play");
       pbe.closeAudio();
       initAudio();
       //pbe.findWords(textList.get(page - 1), wordsList);
    }//GEN-LAST:event_prevButtonActionPerformed

    private void jHomeMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jHomeMenuMouseClicked
        enc.dispose();
        if(NaMaCount > 0) {
            na.dispose();
        }
        tone.dispose();
        na.dispose();
        new Home(user).setVisible(true);
        pbe.closeAudio();
        dispose();
    }//GEN-LAST:event_jHomeMenuMouseClicked

    private void jEncMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jEncMenuMouseClicked
        if(!enc.isShowing()) {
            enc.setVisible(true);
        } else {
            enc.toFront();
        }
    }//GEN-LAST:event_jEncMenuMouseClicked

    private void jNasMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNasMenuMouseClicked
        if(!nas.isShowing()) {
            nas.setVisible(true);
        } else {
            nas.toFront();
        }
    }//GEN-LAST:event_jNasMenuMouseClicked

    private void jToneTableMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToneTableMenuMouseClicked
        if(!tone.isShowing()) {
            tone.setVisible(true);
        } else {
            tone.toFront();
        }
    }//GEN-LAST:event_jToneTableMenuMouseClicked

    private void jMenuItem1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseReleased
        new SignIn().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1MouseReleased

    private void playButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButton1ActionPerformed
        playButton1.setText("Play");
        playButton1.setForeground(new java.awt.Color(0, 153, 51));
        if(!clip.isRunning()) {
            clip.setMicrosecondPosition(timesVar);
            clip.start();
            timer.start();
            playButton1.setForeground(new java.awt.Color(255, 51, 51));
            playButton1.setText("Stop");
        } else {
            clip.stop();
            timer.stop();
            playButton1.setForeground(new java.awt.Color(0, 153, 51));
            playButton1.setText("Play");
        }
    }//GEN-LAST:event_playButton1ActionPerformed

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        page++;
        clip.stop();
        clip.close();
        timer.stop();
        jPageLabel.setText("Page " + page);
        pbe.closeAudio();
        clip = pbe.makeClip(page);
        if(page==20) {
           nextButton.setText("Current");
           nextButton.setEnabled(false);
       } else if(page==2) {
           prevButton.setEnabled(true);
           prevButton.setText("Previous");
       }
       playButton1.setForeground(new java.awt.Color(0, 153, 51));
       playButton1.setText("Play");
       pbe.closeAudio();
       initAudio();
       //pbe.findWords(textList.get(page - 1), wordsList);
    }//GEN-LAST:event_nextButtonActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jNaMaMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jNaMaMenuMouseClicked
        if(NaMaCount == 0){
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
            java.util.logging.Logger.getLogger(Practice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Practice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Practice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Practice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Practice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jEncMenu;
    private javax.swing.JMenu jHomeMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu jNaMaMenu;
    private javax.swing.JMenu jNasMenu;
    private javax.swing.JLabel jPageLabel;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JMenu jToneTableMenu;
    private javax.swing.JMenu jUserMenu;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton playButton1;
    private javax.swing.JButton prevButton;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
