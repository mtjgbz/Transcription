/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.awt.Color;
import javax.swing.JOptionPane;
// TODO: Print error messages

/**
 *
 * @author Mike, Noah, Erica and Casey
 */
public class ForgottenPassword extends javax.swing.JFrame {

    private ForgottenPasswordBE backend;

    /**
     * Creates new form ForgottenPassword
     */
    public ForgottenPassword() {
        initComponents();
        jSecQuestTextField.setEditable(false);
        backend = new ForgottenPasswordBE();
        getContentPane().setBackground(new Color(148, 189, 203));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jUsernameTextField = new javax.swing.JTextField();
        jUsernameLabel = new javax.swing.JLabel();
        jYourPasswordTextField = new javax.swing.JTextField();
        jValidateButton = new javax.swing.JButton();
        jYourPasswordLabel = new javax.swing.JLabel();
        jSecQuestAnsLabel = new javax.swing.JLabel();
        jSecQuestTextField = new javax.swing.JTextField();
        jConfirmButton = new javax.swing.JButton();
        jSecQuestLabel = new javax.swing.JLabel();
        jSecQuestAnsTextField = new javax.swing.JTextField();
        jBackground = new javax.swing.JLabel();
        jSignIn = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jBackMenuButton = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(414, 350));

        jUsernameTextField.setMaximumSize(new java.awt.Dimension(198, 28));
        jUsernameTextField.setMinimumSize(new java.awt.Dimension(198, 28));
        jUsernameTextField.setPreferredSize(new java.awt.Dimension(198, 28));
        jUsernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUsernameTextFieldActionPerformed(evt);
            }
        });

        jUsernameLabel.setText("            Username:");
        jUsernameLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jValidateButton.setBackground(new java.awt.Color(255, 255, 255));
        jValidateButton.setText("Validate");
        jValidateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jValidateButtonActionPerformed(evt);
            }
        });

        jYourPasswordLabel.setText("Your Password:");

        jSecQuestAnsLabel.setText("            Security Question Answer:");
        jSecQuestAnsLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jSecQuestTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jSecQuestTextField.setText("SECURITY QUESTION");
        jSecQuestTextField.setMaximumSize(new java.awt.Dimension(300, 28));
        jSecQuestTextField.setMinimumSize(new java.awt.Dimension(300, 28));
        jSecQuestTextField.setPreferredSize(new java.awt.Dimension(300, 28));
        jSecQuestTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSecQuestTextFieldActionPerformed(evt);
            }
        });

        jConfirmButton.setBackground(new java.awt.Color(255, 255, 255));
        jConfirmButton.setText("Confirm");
        jConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jConfirmButtonActionPerformed(evt);
            }
        });

        jSecQuestLabel.setText("            Security Question:");
        jSecQuestLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jSecQuestAnsTextField.setMaximumSize(new java.awt.Dimension(198, 28));
        jSecQuestAnsTextField.setMinimumSize(new java.awt.Dimension(198, 28));
        jSecQuestAnsTextField.setPreferredSize(new java.awt.Dimension(198, 28));

        jBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/transcription/blue.png"))); // NOI18N

        jSignIn.setBackground(new java.awt.Color(204, 204, 204));
        jSignIn.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jSignIn.setText("Sign In");
        jSignIn.setEnabled(false);
        //jButton1.setBackground(Color.RED);
        jSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSignInActionPerformed(evt);
            }
        });

        jBackMenuButton.setText("Back");
        jBackMenuButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBackMenuButtonMouseClicked(evt);
            }
        });
        jMenuBar1.add(jBackMenuButton);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSecQuestAnsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSecQuestLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jUsernameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSecQuestTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jSecQuestAnsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jValidateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jYourPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 160, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jYourPasswordLabel)
                        .addGap(157, 157, 157))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSignIn)
                        .addGap(160, 160, 160))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jUsernameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jConfirmButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jUsernameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(jSecQuestLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSecQuestTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSecQuestAnsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jValidateButton)
                    .addComponent(jSecQuestAnsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jYourPasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jYourPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSignIn)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 328, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Creates an error message if anything is incorrect.
     * @param infoMessage   Message to appear in the window.
     * @param titleBar      Message to appear in the title bar.
     */
    public static void errorMsg(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "Error: " + titleBar, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Validates that the user's security question was answered correctly.
     * @param evt   Event of clicking on the validate button.
     */
    private void jValidateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jValidateButtonActionPerformed
        // Getting username and security question answer info and sending to validatePassword
        String username = jUsernameTextField.getText();
        String answer = jSecQuestAnsTextField.getText();

        //validate that the password is correct
        String password = backend.validatePassword(username, answer);
        if (password == "") {
            errorMsg("Security Answer is incorrect.", "Forgotten Password");
        } else {
            jYourPasswordTextField.setText(password);
            jSignIn.setEnabled(rootPaneCheckingEnabled);
        }


    }//GEN-LAST:event_jValidateButtonActionPerformed

    private void jUsernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUsernameTextFieldActionPerformed

    }//GEN-LAST:event_jUsernameTextFieldActionPerformed

    /**
     * Closes the backend and returns to the sign-in page
     * @param evt   Event of clicking on the back button
     */
    private void jBackMenuButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackMenuButtonMouseClicked
        //ECL: close the backend before moving to the other page
        backend.closeDB();
        new SignIn().setVisible(true);
        dispose();
    }//GEN-LAST:event_jBackMenuButtonMouseClicked

    private void jSecQuestTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSecQuestTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jSecQuestTextFieldActionPerformed

    /**
     * Confirms the username and then gets the question related to that username
     *
     * @param evt   Event of clicking on the confirm button.
     */
    private void jConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jConfirmButtonActionPerformed
        String username = jUsernameTextField.getText();
        String secQuestion = backend.retrieveSecurityQuestion(username);
        if (secQuestion == "") {
            errorMsg("Username not found.", "Forgotten Password");
        } else {
            jSecQuestTextField.setText(secQuestion);
        }

    }//GEN-LAST:event_jConfirmButtonActionPerformed

    /**
     * Brings the user to the home page after getting password from validation.
     * @param evt   Event of clicking on the sign in button.
     */
    private void jSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSignInActionPerformed
            Home home1 = new Home(jUsernameTextField.getText());
            home1.setVisible(true);
            dispose();
            backend.closeDB();
    }//GEN-LAST:event_jSignInActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jBackMenuButton;
    private javax.swing.JLabel jBackground;
    private javax.swing.JButton jConfirmButton;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel jSecQuestAnsLabel;
    private javax.swing.JTextField jSecQuestAnsTextField;
    private javax.swing.JLabel jSecQuestLabel;
    private javax.swing.JTextField jSecQuestTextField;
    private javax.swing.JButton jSignIn;
    private javax.swing.JLabel jUsernameLabel;
    private javax.swing.JTextField jUsernameTextField;
    private javax.swing.JButton jValidateButton;
    private javax.swing.JLabel jYourPasswordLabel;
    private javax.swing.JTextField jYourPasswordTextField;
    // End of variables declaration//GEN-END:variables
}
