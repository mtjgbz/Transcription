/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Michael, Noah, Casey & Erica
 */
public class Home extends javax.swing.JFrame {
    private int lesson;
    private String sublesson;
    private String user;
    private static String path;
    private int furthestLesson;
    private String furthestSublesson;
    private boolean NaMaOpen = false;
    private HashMap<Integer, ArrayList<String>> sublessonMap;

    Active act;
    ChangePass pass1;
    Enclitics enc;
    Nasalizations nas;
    ToneTable tone;
    NamaTable na;
    ArrayList<Integer> lessonList;
   
    Timer timer1;

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        this.setTitle("Transcripción Mixteca: Hogar");
    }

    /**
     * Constructor
     *
     * @param user  username of the person passed through from sign in
     */
    public Home(String user) {
        initComponents();
        this.setTitle("Transcripción Mixteca: Hogar");
        this.user = user;
        getContentPane().setBackground(new Color(148, 189, 203));
        jUsernameMenuDropDown.setText(user);
        act = new Active(this, user);
        enc = new Enclitics();
        jLabel1.setText(" ");

        //create lists for lesson numbers
        lessonList = new ArrayList<>();
        sublessonMap = new HashMap<>();
        jlessonBox.removeAllItems();
        jsubLessonBox.removeAllItems();

        setupLessons();
        
        nas = new Nasalizations(path);
        tone = new ToneTable(path);

    }

    /**
     * Sets up the lesson combo boxes
     */
    private void setupLessons() {
        try {
            Statement stmt = User.setupDB(this, getClass().getResource("TAA.db").toString());
            String query = "SELECT Lesson, Sublesson FROM LESSONS;";
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<String> subList = new ArrayList<>();
            while (rs.next()) {
                int currLesson = rs.getInt("Lesson");
                String subL = rs.getString("Sublesson");
                if (currLesson < 1) {
                    continue;
                }
                if (!lessonList.contains(currLesson)) {
                    if (currLesson > 1) {
                        subList.add("Final");
                    }
                    lessonList.add(currLesson);
                    sublessonMap.put(currLesson, new ArrayList());
                }
                if (!subL.equals("Final")) {
                    subList = sublessonMap.get(currLesson);
                    subList.add(subL);
                }
            }
            String newQuery1 = "SELECT FileList FROM LESSONS WHERE Lesson = 0;";
            ResultSet rsExp = stmt.executeQuery(newQuery1);
            path = (rsExp.getString("FileList"));
            stmt.execute(newQuery1);

            query = "SELECT * FROM LESSON_TRACK WHERE Username LIKE '"
                    + user + "'; ";
            rs = stmt.executeQuery(query);
            int latestLesson = rs.getInt("LatestLesson");
            String latestSublesson = rs.getString("LatestSublesson");
            furthestLesson = rs.getInt("FurthestLesson");
            furthestSublesson = rs.getString("FurthestSublesson");

            jlessonBox.removeAll();
            for (int l : lessonList) {
                if (l <= furthestLesson) {
                    jlessonBox.addItem(l);
                }
            }
            jlessonBox.setSelectedItem(latestLesson);

            int index = (int) jlessonBox.getSelectedItem();
            ArrayList<String> currList = sublessonMap.get(index);
            for (String subL : currList) {
                if (subL.equals("Final")
                        && currList.indexOf(subL) == currList.size() - 1) {
                    jsubLessonBox.addItem(subL);
                } else if (!currList.contains(furthestSublesson)
                        || currList.indexOf(furthestSublesson) >= currList.indexOf(subL)) {
                    jsubLessonBox.addItem(subL);
                }
                System.out.println(subL + ", " + currList.contains(subL)
                        + ", " + currList.indexOf(furthestSublesson) + ", " + currList.indexOf(subL));
            }
            jsubLessonBox.setSelectedItem(latestSublesson);
            User.closeDB(stmt, rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jlessonBox = new javax.swing.JComboBox();
        jsubLessonBox = new javax.swing.JComboBox();
        jLessonLabel = new javax.swing.JLabel();
        jSubLessonLabel = new javax.swing.JLabel();
        jLogOutButton = new javax.swing.JButton();
        jPassiveButton = new javax.swing.JButton();
        jActiveButton = new javax.swing.JButton();
        jTraineeLogButton = new javax.swing.JButton();
        jTonesButton = new javax.swing.JButton();
        jNasalizationButton = new javax.swing.JButton();
        jEncliticButton = new javax.swing.JButton();
        jBackground = new javax.swing.JLabel();
        jNaMaButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jUsernameMenuDropDown = new javax.swing.JMenu();
        jChangePassword = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(665, 400));
        setResizable(false);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/transcription/TTPictures/Grey.png"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(338, 2));
        jLabel2.setMinimumSize(new java.awt.Dimension(338, 2));
        jLabel2.setPreferredSize(new java.awt.Dimension(338, 2));

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("Cargando...");

        jlessonBox.setBackground(new java.awt.Color(204, 204, 204));
        jlessonBox.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jlessonBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Lesson 1", "Lesson 2", "Lesson 3", "Lesson 4" }));
        jlessonBox.setPreferredSize(new java.awt.Dimension(130, 30));
        jlessonBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jlessonBoxActionPerformed(evt);
            }
        });

        jsubLessonBox.setBackground(new java.awt.Color(204, 204, 204));
        jsubLessonBox.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jsubLessonBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jsubLessonBox.setPreferredSize(new java.awt.Dimension(130, 30));

        jLessonLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLessonLabel.setText("Lección");

        jSubLessonLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jSubLessonLabel.setText("Sub-Lección");

        jLogOutButton.setBackground(new java.awt.Color(204, 204, 204));
        jLogOutButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jLogOutButton.setText("Juega");
        jLogOutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jLogOutButtonActionPerformed(evt);
            }
        });

        jPassiveButton.setBackground(new java.awt.Color(204, 204, 204));
        jPassiveButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jPassiveButton.setText("Pasivo");
        jPassiveButton.setPreferredSize(new java.awt.Dimension(130, 30));
        jPassiveButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPassiveButtonMousePressed(evt);
            }
        });
        jPassiveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPassiveButtonActionPerformed(evt);
            }
        });

        jActiveButton.setBackground(new java.awt.Color(204, 204, 204));
        jActiveButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jActiveButton.setText("Activo");
        jActiveButton.setPreferredSize(new java.awt.Dimension(130, 30));
        jActiveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jActiveButtonActionPerformed(evt);
            }
        });

        jTraineeLogButton.setBackground(new java.awt.Color(204, 204, 204));
        jTraineeLogButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jTraineeLogButton.setText("Registro de Aprendiz");
        jTraineeLogButton.setPreferredSize(new java.awt.Dimension(130, 30));
        jTraineeLogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTraineeLogButtonActionPerformed(evt);
            }
        });

        jTonesButton.setBackground(new java.awt.Color(204, 204, 204));
        jTonesButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jTonesButton.setText("Tonos");
        jTonesButton.setPreferredSize(new java.awt.Dimension(130, 30));
        jTonesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTonesButtonActionPerformed(evt);
            }
        });

        jNasalizationButton.setBackground(new java.awt.Color(204, 204, 204));
        jNasalizationButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jNasalizationButton.setText("Nasalización");
        jNasalizationButton.setPreferredSize(new java.awt.Dimension(130, 30));
        jNasalizationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNasalizationButtonActionPerformed(evt);
            }
        });

        jEncliticButton.setBackground(new java.awt.Color(204, 204, 204));
        jEncliticButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jEncliticButton.setText("Enclíticos");
        jEncliticButton.setPreferredSize(new java.awt.Dimension(130, 30));
        jEncliticButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jEncliticButtonActionPerformed(evt);
            }
        });

        jBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/transcription/blue.png"))); // NOI18N
        jBackground.setFocusable(false);
        jBackground.setRequestFocusEnabled(false);
        jBackground.setVerifyInputWhenFocusTarget(false);

        jNaMaButton.setBackground(new java.awt.Color(204, 204, 204));
        jNaMaButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jNaMaButton.setText("NaMa");
        jNaMaButton.setPreferredSize(new java.awt.Dimension(130, 30));
        jNaMaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNaMaButtonActionPerformed(evt);
            }
        });

        jMenuBar1.setBackground(new java.awt.Color(255, 255, 254));

        jUsernameMenuDropDown.setText("User");

        jChangePassword.setText("Cambiar la Contraseña ");
        jChangePassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jChangePasswordMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jChangePasswordMouseClicked(evt);
            }
        });
        jUsernameMenuDropDown.add(jChangePassword);

        jMenuBar1.add(jUsernameMenuDropDown);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(181, 181, 181)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jNasalizationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPassiveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jlessonBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jNaMaButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLessonLabel)
                                        .addGap(43, 43, 43)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jActiveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTonesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jEncliticButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jsubLessonBox, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(jSubLessonLabel))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(186, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLogOutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(292, 292, 292))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTraineeLogButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(250, 250, 250))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 671, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLessonLabel)
                    .addComponent(jSubLessonLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlessonBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jsubLessonBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPassiveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jActiveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTonesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jNaMaButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNasalizationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jEncliticButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTraineeLogButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLogOutButton)
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 391, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jlessonBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jlessonBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jlessonBoxActionPerformed

    /**
     * Log out button
     *
     * @param evt   Event of clicking on log out button
     */
    private void jLogOutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jLogOutButtonActionPerformed
        act.dispose();
        enc.dispose();
        nas.dispose();
        tone.dispose();
        if (NaMaOpen) {
            na.dispose();
        }

        new SignIn().setVisible(true);
        dispose();
    }//GEN-LAST:event_jLogOutButtonActionPerformed

    /**
     * Trainee Log Button
     *
     * @param evt   event of clicking on the trainee log.
     */
    private void jTraineeLogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTraineeLogButtonActionPerformed
        act.dispose();
//        pass1.dispose();
        enc.dispose();
        nas.dispose();
        tone.dispose();
        if (NaMaOpen) {
            na.dispose();
        }

        new TraineeLog(user).setVisible(true);
        dispose();
    }//GEN-LAST:event_jTraineeLogButtonActionPerformed


    /**
     * Passive Training Button
     *
     * @param evt   Event of clicking on the passive button.
     */
    private void jPassiveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPassiveButtonActionPerformed
        act.dispose();
        enc.dispose();
        nas.dispose();
        tone.dispose();
        if (NaMaOpen) {
            na.dispose();
        }
        lesson = lessonList.get((int) jlessonBox.getSelectedIndex());
        sublesson = sublessonMap.get(lesson).get(jsubLessonBox.getSelectedIndex());

        Passive pass = new Passive(user, lesson, sublesson);
        pass.setVisible(true);
        dispose();
    }//GEN-LAST:event_jPassiveButtonActionPerformed

    /**
     * Active Training Button and Pop-Up
     *
     * @param evt   Event of clicking on the active button
     */
    private void jActiveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jActiveButtonActionPerformed
        lesson = lessonList.get(jlessonBox.getSelectedIndex());
        sublesson = sublessonMap.get(lesson).get(jsubLessonBox.getSelectedIndex());

        enc.dispose();
        nas.dispose();
        tone.dispose();
        if (NaMaOpen) {
            na.dispose();
        }
        if (!act.isShowing()) {
            act.setLesson(lesson);
            act.setSubLesson(sublesson);
            act.setVisible(true);
        } else {
            act.toFront();
        }
    }//GEN-LAST:event_jActiveButtonActionPerformed

    /**
     * Tone Table Button
     *
     * @param evt   Event of clicking on the tone table button
     */
    private void jTonesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTonesButtonActionPerformed
        if (!tone.isShowing()) {
            tone.setVisible(true);
        } else {
            tone.toFront();
        }
    }//GEN-LAST:event_jTonesButtonActionPerformed

    /**
     * Brings up the nasalization table
     * @param evt   Event of clicking the nasalization table button
     */
    private void jNasalizationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNasalizationButtonActionPerformed
        if (!nas.isShowing()) {
            nas.setVisible(true);
        } else {
            nas.toFront();
        }
    }//GEN-LAST:event_jNasalizationButtonActionPerformed

    /**
     * Enclitic Button
     *
     * @param evt   event of clicking the enclitics button
     */
    private void jEncliticButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jEncliticButtonActionPerformed
        if (!enc.isShowing()) {
            enc.setVisible(true);
            
        } else {
            enc.toFront();
            
        }
    }//GEN-LAST:event_jEncliticButtonActionPerformed

    /**
     * Change Password page
     *
     * @param evt
     */
    private void jChangePasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChangePasswordMouseClicked

    }//GEN-LAST:event_jChangePasswordMouseClicked

    /**
     * Change Password page
     *
     * @param evt   event of clicking the change password button
     */
    private void jChangePasswordMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jChangePasswordMouseReleased
        act.dispose();

        enc.dispose();
        nas.dispose();
        tone.dispose();
        pass1 = new ChangePass(user);
        pass1.setVisible(true);
    }//GEN-LAST:event_jChangePasswordMouseReleased

    /**
     * Displays the loading text.
     * @param evt   event of clicking on the passive button.
     */
    private void jPassiveButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPassiveButtonMousePressed
        jLabel1.setText("Cargando...");
    }//GEN-LAST:event_jPassiveButtonMousePressed

    /**
     * Brings up the nama table
     * @param evt   event of clicking on the nama table button
     */
    private void jNaMaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNaMaButtonActionPerformed
        if (!NaMaOpen) {
            na = new NamaTable();
            NaMaOpen=true;
        }
        if (!na.isShowing()) {
            na.setVisible(true);
        } else {
            na.toFront();
        }
    }//GEN-LAST:event_jNaMaButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jActiveButton;
    private javax.swing.JLabel jBackground;
    private javax.swing.JMenuItem jChangePassword;
    private javax.swing.JButton jEncliticButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLessonLabel;
    private javax.swing.JButton jLogOutButton;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JButton jNaMaButton;
    private javax.swing.JButton jNasalizationButton;
    private javax.swing.JButton jPassiveButton;
    private javax.swing.JLabel jSubLessonLabel;
    private javax.swing.JButton jTonesButton;
    private javax.swing.JButton jTraineeLogButton;
    private javax.swing.JMenu jUsernameMenuDropDown;
    private javax.swing.JComboBox jlessonBox;
    private javax.swing.JComboBox jsubLessonBox;
    // End of variables declaration//GEN-END:variables
}
