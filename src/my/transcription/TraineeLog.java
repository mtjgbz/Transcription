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
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mike
 */
public class TraineeLog extends javax.swing.JFrame {

    private String user;
    private LogBE backend;
    private boolean selectLog;
    private ArrayList<ArrayList<String>> log;
    
    private JTable practiceTable;
    private JTable testTable;
    private JTabbedPane tabbedPane;
    
    private static final String[] LOG_NAMES = {"Date and Time Taken", "Lesson", "Sublesson", "Score"};
    private static final String[] ATTEMPT_NAMES = {"Question No.", "Attempt No.", "User Answer", "Correct Answer"};

    /**
     * Creates new form TraineeLog
     */
    public TraineeLog(String user) {
        this.user = user;
        initComponents();
        jMenu2.setText(user);
        backend = new LogBE(this);
        log = new ArrayList<>();
        selectLog = true;
        
        setupPane();
    }
    
    public void setupPane(){
        jPanel1.setLayout(new BorderLayout());
        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(jPanel1.getSize());
        tabbedPane.setVisible(true);
        
        setupTable(false);
        setupTable(true);
        
        JScrollPane practicePanel = new JScrollPane(practiceTable, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane testPanel = new JScrollPane(testTable,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        tabbedPane.addTab("Práctica", practicePanel);
        tabbedPane.addTab("Examen", testPanel);
        tabbedPane.repaint();
        jPanel1.add(tabbedPane);
        jPanel1.revalidate();
    }
    
    public void setupTable(boolean isTest){
        HashMap<ArrayList<String>, Integer> map = backend.pullResults(user, isTest);
        
        JTable table = new JTable(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        DefaultTableModel model = new DefaultTableModel(LOG_NAMES, 0);
        table.setModel(model);
        
        for (Map.Entry pair : map.entrySet()) {
            ArrayList<String> list = (ArrayList<String>) pair.getKey();
            model.addRow(list.toArray());
            log.add(list);
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
        JTable lastTable = new JTable(table.getModel());

        table.removeAll();
        DefaultTableModel model = new DefaultTableModel(ATTEMPT_NAMES, 0);
        table.setModel(model);
        
        if(selectLog == false){
            for (ArrayList<String> l : log){
                model.addRow(l.toArray());
            }
        } else{

            String date = (String) lastTable.getValueAt(selectedRow, 0);
            int id = backend.getID(date, isTest);
                
            if(id >= 0){
                ArrayList<ArrayList<String>> results = backend.traineeLog(id, isTest);

                if(results !=  null && selectLog == true){
                    for(ArrayList<String> r : results){
                        model.addRow(r.toArray());
                    }
                }
            }
        }
            
        if(isTest){
            testTable = table;
        }else{
            practiceTable = table;
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

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(665, 415));

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(jButton1)
                .addContainerGap(312, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(353, 353, 353)
                .addComponent(jButton1)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        jMenu1.setText("Hogar");
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        new Home(user).setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenu1MouseClicked

    private void jMenuItem1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseReleased
        new SignIn().setVisible(true);
        dispose();
    }//GEN-LAST:event_jMenuItem1MouseReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int index = tabbedPane.getSelectedIndex();
        if(selectLog){
            if(index == 0){
                updateTable(false);
            }else{
                updateTable(true);
            }
            jButton1.setText("Atrás");
            selectLog = false;
        }else{
            if(index == 0){
                updateTable(false);
            }else{
                updateTable(true);
            }
            
            jButton1.setText("Enviar");
            selectLog = true;
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
