/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.sound.sampled.Clip;
import javax.swing.Timer;

/**
 *
 * @author mike
 */
public class Test extends javax.swing.JFrame {
    private static String path;
    String user;
    Integer lesson;
    String subLesson;

    Clip clip;
    Timer timer;

    Enclitics enc = new Enclitics();
    Nasalizations nas;
    ToneTable tone;

    private ActiveBE tbe;

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
     * Creates new form Test
     *
     * @param user
     */
    public Test(String user, Integer lesson, String subLesson) {
        this.setTitle("Mixtec Transcription: Examen");
        initComponents();
        playButton1.setForeground(new java.awt.Color(0, 153, 51));
        this.user = user;
        this.lesson = lesson;
        this.subLesson = subLesson;
        jMenu2.setText(user);
        jTextPane1.setText("text1");
        prevButton.setText("Current");
        prevButton.setEnabled(false);
        timer = new Timer(4428, listener);

        tbe = new ActiveBE(false);
        initAudio();
        setupTones();
        nas = new Nasalizations(path);
        tone = new ToneTable(path);
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
    
    private void initAudio() {
        clip = tbe.makeClip(page);
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

        prevButton = new javax.swing.JButton();
        submitButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        playButton1 = new javax.swing.JButton();
        jPageLabel = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 23, 665, 420));
        setMaximumSize(new java.awt.Dimension(700, 410));
        setMinimumSize(new java.awt.Dimension(700, 410));
        setPreferredSize(new java.awt.Dimension(700, 410));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 410));

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

        submitButton.setBackground(new java.awt.Color(255, 255, 255));
        submitButton.setText("Check Answers");
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
        jPageLabel.setText("Page 1/ 20");

        jTextPane1.setEditable(false);
        jTextPane1.setAutoscrolls(false);
        jTextPane1.setFocusable(false);
        jTextPane1.setMaximumSize(new java.awt.Dimension(480, 163));
        jTextPane1.setMinimumSize(new java.awt.Dimension(480, 163));
        jTextPane1.setPreferredSize(new java.awt.Dimension(490, 13));
        jTextPane1.setRequestFocusEnabled(false);
        jTextPane1.setSize(new java.awt.Dimension(470, 163));
        jScrollPane5.setViewportView(jTextPane1);

        jMenu1.setText("Home");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        jMenu2.setText("User");

        jMenuItem1.setText("Log out");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseReleased(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(290, 290, 290))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPageLabel)
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(playButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(playButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(submitButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prevButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jPageLabel)
                .addContainerGap(31, Short.MAX_VALUE))
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
        tbe.closeAudio();
        clip = tbe.makeClip(page);
        if (page == 1) {
            prevButton.setText("Current");
            prevButton.setEnabled(false);
        } else if (page == 19) {
            nextButton.setEnabled(true);
            nextButton.setText("Next");
        }
        playButton1.setForeground(new java.awt.Color(0, 153, 51));
        playButton1.setText("Play");
        tbe.closeAudio();
        initAudio();
        //pbe.findWords(textList.get(page - 1), wordsList);
    }//GEN-LAST:event_prevButtonActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        new Home(user).setVisible(true);
        tbe.closeAudio();
        dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenuItem1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseReleased
        new SignIn().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1MouseReleased

    private void playButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButton1ActionPerformed
        playButton1.setText("Play");
        playButton1.setForeground(new java.awt.Color(0, 153, 51));
        if (!clip.isRunning()) {
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
        tbe.closeAudio();
        clip = tbe.makeClip(page);
        if (page == 20) {
            nextButton.setText("Current");
            nextButton.setEnabled(false);
        } else if (page == 2) {
            prevButton.setEnabled(true);
            prevButton.setText("Previous");
        }
        playButton1.setForeground(new java.awt.Color(0, 153, 51));
        playButton1.setText("Play");
        tbe.closeAudio();
        initAudio();
        //pbe.findWords(textList.get(page - 1), wordsList);
    }//GEN-LAST:event_nextButtonActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel jPageLabel;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton playButton1;
    private javax.swing.JButton prevButton;
    private javax.swing.JButton submitButton;
    // End of variables declaration//GEN-END:variables
}
