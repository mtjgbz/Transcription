/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.awt.Color;
import javax.swing.JOptionPane;
//import javax.swing.JDialog
//TODO: Figure out how to carry username throughout windows

/**
 *
 * @author Michael, Erica, Noah and Casey
 */
public class SignIn extends javax.swing.JFrame {

    private SignInBE backend;

    /**
     * Creates new form SignIn
     */
    public SignIn() {
        this.setTitle("Mixtec Transcription: Sign-in");
        initComponents();
        //ECL: Create SignInBE here
        backend = new SignInBE();
        backend.setupDB();

        //how to set the color of the JFrame
        getContentPane().setBackground(new Color(148, 189, 203));
        jForgottenPassword.setForeground(new java.awt.Color(200, 200, 200));

    }

    /**
     * This method is called when the trainee/admin inputs incorrect credentials
     * It pops up an error message window with an error message.
     *
     * @param infoMessage Message displayed
     * @param titleBar Title of pop up window
     * @author CAU
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSignIn = new javax.swing.JButton();
        jRegisterButton = new javax.swing.JButton();
        jUserNameField = new javax.swing.JTextField();
        jPasswordLabel = new javax.swing.JLabel();
        jUserNameLabel = new javax.swing.JLabel();
        jPasswordField = new javax.swing.JPasswordField();
        jForgottenPassword = new javax.swing.JLabel();
        jBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(400, 340));

        jSignIn.setBackground(new java.awt.Color(204, 204, 204));
        jSignIn.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jSignIn.setText("Sign In");
        //jButton1.setBackground(Color.RED);
        jSignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSignInActionPerformed(evt);
            }
        });

        jRegisterButton.setBackground(new java.awt.Color(204, 204, 204));
        jRegisterButton.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jRegisterButton.setText("Register");
        jRegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRegisterButtonActionPerformed(evt);
            }
        });

        jUserNameField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N

        jPasswordLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jPasswordLabel.setText("Password");

        jUserNameLabel.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jUserNameLabel.setText("User Name");

        jPasswordField.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
        jPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldKeyPressed(evt);
            }
        });

        jForgottenPassword.setBackground(new java.awt.Color(255, 255, 255));
        jForgottenPassword.setForeground(new java.awt.Color(102, 102, 102));
        jForgottenPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jForgottenPassword.setText("Forgotten Password?");
        jForgottenPassword.setForeground(new Color(54,91,143));
        jForgottenPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jForgottenPasswordMouseClicked(evt);
            }
        });

        jBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/transcription/blue.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jUserNameLabel)
                .addGap(163, 163, 163))
            .addGroup(layout.createSequentialGroup()
                .addGap(142, 142, 142)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSignIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jRegisterButton, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                .addGap(142, 142, 142))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jUserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jPasswordLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jForgottenPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 400, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jUserNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jUserNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPasswordLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jSignIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRegisterButton)
                .addGap(18, 18, 18)
                .addComponent(jForgottenPassword)
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 340, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSignInActionPerformed
        //ECL: Checking username and password
        //CAU: Checking if admin or not
        String username = jUserNameField.getText();
        char[] password = jPasswordField.getPassword();

        String pass = "";
        for (char a : password) {
            pass = pass + a;
        }

        /**
         * if the entered username matches the password then open the users home
         * page else if admin is trying to login else error message
         */
        if (backend.checkPassword(username, pass)) {
            Home home1 = new Home(jUserNameField.getText());
            home1.setVisible(true);
            dispose();
            backend.closeDB();

        } else if (backend.checkAdmin(username)) {

            AdminHome home2 = new AdminHome(jUserNameField.getText());
            home2.setVisible(true);
            backend.closeDB();
            dispose();
        } else {
            errorMsg("Sign-in failed.  Please try again.", "Sign-in");
        }

    }//GEN-LAST:event_jSignInActionPerformed

    private void jRegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRegisterButtonActionPerformed
        //ECL: Close the DB
        backend.closeDB();
        Register reg = new Register();
        reg.setVisible(true);
        dispose();
    }//GEN-LAST:event_jRegisterButtonActionPerformed


    private void jPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldKeyPressed
        if (evt.getKeyCode() == 10) {
            String username = jUserNameField.getText();
            String password = jPasswordField.getText();

            if (backend.checkPassword(username, password)) {

                Home home1 = new Home(jUserNameField.getText());
                home1.setVisible(true);
                backend.closeDB();
                dispose();
                //need to add the admin page
            } else if (backend.checkAdmin(username)) {
                AdminHome home2 = new AdminHome(jUserNameField.getText());
                home2.setVisible(true);
                backend.closeDB();
                dispose();
            } else {
                errorMsg("Sign-in failed.  Please try again.", "Sign-in");
            }
        }
    }//GEN-LAST:event_jPasswordFieldKeyPressed

    private void jForgottenPasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jForgottenPasswordMouseClicked
        new ForgottenPassword().setVisible(true);
        dispose();
    }//GEN-LAST:event_jForgottenPasswordMouseClicked

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
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SignIn().setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jBackground;
    private javax.swing.JLabel jForgottenPassword;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JLabel jPasswordLabel;
    private javax.swing.JButton jRegisterButton;
    private javax.swing.JButton jSignIn;
    private javax.swing.JTextField jUserNameField;
    private javax.swing.JLabel jUserNameLabel;
    // End of variables declaration//GEN-END:variables
}
