/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;
//TODO: Popup for mismatched password & incorrect login info

import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Erica, Noah, Casey and Mike
 */
public class Register extends javax.swing.JFrame {

    private RegisterBE backend;

    /**
     * Creates new form Register
     */
    public Register() {
        this.setTitle("Transcripción Mixteca: Registrar");
        getContentPane().setBackground(new Color(148, 189, 203));
        initComponents();
        backend = new RegisterBE();
        populateSecurityQuestions();
    }

    /*
     Error message when something is wrong
     */
    public static void errorMsg(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "Error: " + titleBar, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    /**
     * @author Casey Method pulls security questions with query from the
     * Database, executes the query, and populates the JComboBox with them
     */
    private void populateSecurityQuestions() {
        try {
            String query = "SELECT Question FROM SECURITY_QUESTIONS;";
            ResultSet rs = backend.stmt.executeQuery(query);
            while (rs.next()) {
                String question = rs.getString("Question");
                jSecurityQuestionComboBox.addItem(question);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFNTextField = new javax.swing.JTextField();
        jLNTextField = new javax.swing.JTextField();
        jUsernameTextField = new javax.swing.JTextField();
        jSecQuestAnswerField = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jReTypePassField = new javax.swing.JPasswordField();
        jSecurityQuestionComboBox = new javax.swing.JComboBox();
        jFirstNameLabel = new javax.swing.JLabel();
        jLastNameLabel = new javax.swing.JLabel();
        jUsernameLabel = new javax.swing.JLabel();
        jPasswordLabel = new javax.swing.JLabel();
        jRetypePassLabel = new javax.swing.JLabel();
        jRegisterButton = new javax.swing.JButton();
        jSecQuestionAnswerLabel = new javax.swing.JLabel();
        jBackground = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jBackButton = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 550));
        setResizable(false);

        jSecurityQuestionComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elegir una Pregunta de Seguridad" }));
        jSecurityQuestionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSecurityQuestionComboBoxActionPerformed(evt);
            }
        });

        jFirstNameLabel.setText("Nombre ");

        jLastNameLabel.setText("Apellido ");

        jUsernameLabel.setText("Nombre de Usuario");

        jPasswordLabel.setText("Contraseña");

        jRetypePassLabel.setText("Vuelva a Escribir la Contraseña ");

        jRegisterButton.setText("Registrar");
        jRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegisterButtonActionPerformed(evt);
            }
        });

        jSecQuestionAnswerLabel.setText("Responder a la Pregunta de Seguridad ");

        jBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/transcription/blue.png"))); // NOI18N

        jBackButton.setText("Atrás");
        jBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackButtonMouseClicked(evt);
            }
        });
        jMenuBar1.add(jBackButton);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRetypePassLabel)
                            .addComponent(jPasswordLabel)
                            .addComponent(jUsernameLabel)
                            .addComponent(jLastNameLabel)
                            .addComponent(jFirstNameLabel)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jSecurityQuestionComboBox, 0, 265, Short.MAX_VALUE)
                                .addComponent(jReTypePassField)
                                .addComponent(jSecQuestionAnswerLabel)
                                .addComponent(jPasswordField)
                                .addComponent(jUsernameTextField)
                                .addComponent(jLNTextField)
                                .addComponent(jFNTextField)
                                .addComponent(jSecQuestAnswerField))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jRegisterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(67, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 400, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jFirstNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jFNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLastNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLNTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jUsernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jPasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jRetypePassLabel)
                .addGap(5, 5, 5)
                .addComponent(jReTypePassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSecurityQuestionComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSecQuestionAnswerLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSecQuestAnswerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jRegisterButton)
                .addContainerGap(57, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 528, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegisterButtonActionPerformed
        //ECL: Getting login info and sending to insert
        String fname = jFNTextField.getText();
        String lname = jLNTextField.getText();
        String username = jUsernameTextField.getText();
        String password = jPasswordField.getText();
        String match = jReTypePassField.getText();
        int questionID = jSecurityQuestionComboBox.getSelectedIndex();
        String answer = jSecQuestAnswerField.getText();

        //ECL: Printing error messages
        String success = backend.setInfo(fname, lname, username, password, match,
                questionID, answer);
        if (success.equals("")) {
            dispose();
            new Home(username).setVisible(true);
        } else {
            System.out.println(success);
            //reset sensitive info when passwords don't match
            jPasswordField.setText("");
            jReTypePassField.setText("");
            jSecurityQuestionComboBox.setSelectedIndex(0);
            jSecQuestAnswerField.setText("");
            errorMsg(success, "Registrar");
        }
    }//GEN-LAST:event_jRegisterButtonActionPerformed

    /**
     * Security Question ComboBox
     * @param evt 
     */
    private void jSecurityQuestionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSecurityQuestionComboBoxActionPerformed
        // auto generated
    }//GEN-LAST:event_jSecurityQuestionComboBoxActionPerformed

    /**
     * Back to Sign in Button.
     * @param evt Closes the database, sets sign-in to visible and disposes of register
     */
    private void jBackButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackButtonMouseClicked
        //ECL: close the backend before moving to the other page
        backend.closeDB();
        new SignIn().setVisible(true);    // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBackButtonMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jBackButton;
    private javax.swing.JLabel jBackground;
    private javax.swing.JTextField jFNTextField;
    private javax.swing.JLabel jFirstNameLabel;
    private javax.swing.JTextField jLNTextField;
    private javax.swing.JLabel jLastNameLabel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JLabel jPasswordLabel;
    private javax.swing.JPasswordField jReTypePassField;
    private javax.swing.JButton jRegisterButton;
    private javax.swing.JLabel jRetypePassLabel;
    private javax.swing.JTextField jSecQuestAnswerField;
    private javax.swing.JLabel jSecQuestionAnswerLabel;
    private javax.swing.JComboBox jSecurityQuestionComboBox;
    private javax.swing.JLabel jUsernameLabel;
    private javax.swing.JTextField jUsernameTextField;
    // End of variables declaration//GEN-END:variables
}
