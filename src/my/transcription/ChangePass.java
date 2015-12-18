/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static my.transcription.SignIn.errorMsg;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteDataSource;

/**
 *
 * @author Noah
 */
public class ChangePass extends javax.swing.JFrame {
    private String currentPass = "";
    private String newPass1 = "";
    private String newPass2 = "";
    private Connection conn;
    private Statement stmt;
    private ResultSet rs;
    private int reqSize = 4;
    String user;
    
    
    /**
     * Creates new form ChangePass
     */
    public ChangePass(String user) {
        this.user = user;
        initComponents();
        getContentPane().setBackground(new Color(148, 189, 203));
    }
    
    
    public void setupDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            SQLiteConfig config = new SQLiteConfig();
            config.enableFullSync(true);
            config.setReadOnly(false);
            SQLiteDataSource ds = new SQLiteDataSource(config);
            ds.setUrl("jdbc:sqlite::resource:" + getClass().getResource("TAA.db").toString());
            conn = ds.getConnection();
            stmt = conn.createStatement();
        } catch (Exception e) {
            errorMsg(e.toString(), "Database error");
        }
    }

    public void closeDB() {
        try {
            stmt.close();
            if (rs != null) {
                rs.close();
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public boolean getCurrentPassword(String password) {
        try {
            String query = "SELECT COUNT(*) AS Users FROM USERS WHERE USERNAME = '" + user + "' AND PASSWORD = '" + password + "';";
            ResultSet rsExp = stmt.executeQuery(query);
            if (rsExp.getInt("Users") == 1) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
     public void addNewPassword() {
        try {
            String newQuery = "UPDATE USERS SET Password = '" + newPass1 + "' WHERE Username = '" + user + "';";
            System.out.println(newQuery);
            stmt.execute(newQuery);
        } catch (SQLException e) {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jSetPassword = new javax.swing.JButton();
        jBackground = new javax.swing.JLabel();
        jCurrentPassword = new javax.swing.JPasswordField();
        jNewPassword1 = new javax.swing.JPasswordField();
        jNewPassword2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(430, 300));

        jLabel1.setText("Current Password");

        jLabel2.setText("New Password");

        jLabel3.setText("  Verify New Password");

        jSetPassword.setBackground(new java.awt.Color(255, 255, 255));
        jSetPassword.setText("Set Password");
        jSetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jSetPasswordActionPerformed(evt);
            }
        });

        jBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/transcription/blue.png"))); // NOI18N

        jCurrentPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCurrentPasswordActionPerformed(evt);
            }
        });

        jNewPassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewPassword1ActionPerformed(evt);
            }
        });

        jNewPassword2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNewPassword2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jNewPassword1, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(jNewPassword2, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                            .addComponent(jCurrentPassword)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSetPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel1)))
                .addContainerGap(144, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCurrentPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNewPassword1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jNewPassword2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSetPassword)
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 300, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jSetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jSetPasswordActionPerformed
        setupDB();
        char[] pass1 = jCurrentPassword.getPassword();
        for(char c :pass1){
            currentPass+=c;
        }
        char[] pass2 = jNewPassword1.getPassword();
        for(char c :pass2){
            newPass1+=c;
        }
        
        char[] pass3 = jNewPassword2.getPassword();
        for(char c :pass3){
            newPass2+=c;
        }

        if(getCurrentPassword(currentPass)) {
            if(newPass1.equals(newPass2)) {
                if(newPass1.length() >= reqSize) {
                    System.out.println("All good.");
                    addNewPassword();
                    this.dispose();
                    success("Your password has successfully been changed.", "Change Password");
                } 
                else {
                    this.dispose();
                System.out.println("The new Password you have entered has to be 4 or more characters.");
                errorMsg("The new password you have entered needs to contain 4 or more characters, Please Try Again.", "Change Password");
                }
            }
            else {
                this.dispose();
                System.out.println("The new Passwords you have entered do not match.");
                errorMsg("The new Passwords you have entered do not match, Please Try Again.", "Change Password");
            }
        }
        else {
            this.dispose();
            System.out.println("The Current Password you typed in is incorrect.");
            errorMsg("Your Current Password that you typed in is incorrect, Please Try Again.", "Change Password");
            
        }
        closeDB(); 
    }//GEN-LAST:event_jSetPasswordActionPerformed

    private void jCurrentPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCurrentPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCurrentPasswordActionPerformed

    private void jNewPassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewPassword1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNewPassword1ActionPerformed

    private void jNewPassword2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNewPassword2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jNewPassword2ActionPerformed

    public static void errorMsg(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "Error: " + titleBar, JOptionPane.ERROR_MESSAGE);
    }
    
    public static void success(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "Success: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jBackground;
    private javax.swing.JPasswordField jCurrentPassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jNewPassword1;
    private javax.swing.JPasswordField jNewPassword2;
    private javax.swing.JButton jSetPassword;
    // End of variables declaration//GEN-END:variables
}
