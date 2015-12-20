/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Noah, Erica, Casey, and Michael
 */
public class AdminHome extends javax.swing.JFrame {

    private String user;
    private AdminBE backend;
    private Map<String, String> userMap;
    private boolean selectLog;
    
    private JTabbedPane pane;
    private JTable practiceTable;
    private JTable testTable;
    
    private static final String[] LOG_NAMES = {"Date and Time Taken", "Lesson", "Sublesson", "Score"};
    private static final String[] ATTEMPT_NAMES = {"Question No.", "Attempt No.", "User Answer", "Correct Answer"};
    private static final int COLUMN_NUM = 4;

    /**
     * Creates new form AdminHome
     */
    public AdminHome() {
        initComponents();
        this.setTitle("Transcripción Mixteca: Hogar de Administración");
        selectLog = false;
        backend = new AdminBE(this);
        userSelection();
    }

    public AdminHome(String user) {
        this();
        this.user = user;
    }
    
    public void userSelection(){
        list1.removeAll();
        userMap = backend.createLogs();
        Iterator it = userMap.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry pair = (Map.Entry) it.next();
            String name = (String) pair.getKey();
            list1.add(name);
        }
    }
    
    public void createPane(){
        jPanel1.remove(list1);
        jPanel1.remove(jLabel1);
        jPanel1.setLayout(new BorderLayout());
        
        pane = new JTabbedPane();
        pane.setVisible(true);
        
        setupTable(false);
        setupTable(true);
        
        JScrollPane practicePanel = new JScrollPane(practiceTable);
        JScrollPane testPanel = new JScrollPane(testTable);
        
        pane.addTab("Práctica", practicePanel);
        pane.addTab("Examen", testPanel);
        jPanel1.add(pane);
        jPanel1.revalidate();
    }
    
    public void setupTable(boolean isTest){
        String studentUser = userMap.get(list1.getSelectedItem());
        HashMap<ArrayList<String>, Integer> practiceMap = backend.pullResults(studentUser, isTest);
        
        JTable table = new JTable(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        DefaultTableModel model = new DefaultTableModel(LOG_NAMES, 0);
        table.setModel(model);
        
        for (Map.Entry pair : practiceMap.entrySet()) {
            ArrayList<String> list = (ArrayList<String>) pair.getKey();
            System.out.println(list);
            model.addRow(list.toArray());
        }
        
        if(isTest){
            testTable = table;
        }else{
            practiceTable = table;
        }
    }
    
    public void updateTable(boolean isTest){
        JTable table;
        if(isTest){
            table = testTable;
        }else{
            table = practiceTable;
        }
        int selectedRow = table.getSelectedRow();
        String date = (String) table.getValueAt(selectedRow, 0);
        int practiceID = backend.getPracticeID(date);
        
        table.removeAll();
        DefaultTableModel model = new DefaultTableModel(ATTEMPT_NAMES, 0);
        table.setModel(model);
        
        if(practiceID >= 0){
            ArrayList<ArrayList<String>> results = backend.traineeLog(practiceID);
            
            if(results != null){
                for(ArrayList<String> r : results){
                    model.addRow(r.toArray());
                }
            }

            practiceTable.repaint();
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

        jRadioButton1 = new javax.swing.JRadioButton();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        list1 = new java.awt.List();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jBackButton = new javax.swing.JMenu();
        jLogOut = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jLoadText = new javax.swing.JMenuItem();
        jLoadTones = new javax.swing.JMenuItem();

        jRadioButton1.setText("jRadioButton1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/my/transcription/blue.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(153, 153, 153))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, Short.MAX_VALUE))
        );

        jBackButton.setText("Atrás ");
        jBackButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jBackButtonMousePressed(evt);
            }
        });
        jMenuBar1.add(jBackButton);

        jLogOut.setText("Cerrar sesión");
        jLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLogOutMousePressed(evt);
            }
        });
        jMenuBar1.add(jLogOut);

        jMenu3.setText("Archivo");

        jLoadText.setText("Texto de Carga");
        jLoadText.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLoadTextMousePressed(evt);
            }
        });
        jMenu3.add(jLoadText);

        jLoadTones.setText("Tonos de Carga ");
        jLoadTones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLoadTonesMousePressed(evt);
            }
        });
        jMenu3.add(jLoadTones);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(selectLog){
            updateTable(false);
        }else{
            createPane();
            selectLog = true;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jBackButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackButtonMousePressed
        AdminHome home2 = new AdminHome("admin");
        home2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBackButtonMousePressed

    private void jLogOutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogOutMousePressed
        new SignIn().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLogOutMousePressed

    private void jLoadTextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLoadTextMousePressed
        UpdateLessonFile window = new UpdateLessonFile();
        window.setVisible(true);
    }//GEN-LAST:event_jLoadTextMousePressed

    private void jLoadTonesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLoadTonesMousePressed
        UpdateTones window = new UpdateTones();
        window.setVisible(true);
    }//GEN-LAST:event_jLoadTonesMousePressed

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
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jBackButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jLoadText;
    private javax.swing.JMenuItem jLoadTones;
    private javax.swing.JMenu jLogOut;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private java.awt.List list1;
    // End of variables declaration//GEN-END:variables
}
