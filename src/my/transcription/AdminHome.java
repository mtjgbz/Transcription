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
    private LogBE backend;
    private Map<String, String> userMap;
    private boolean selectLog;
    
    private JTabbedPane pane;
    private JTable practiceTable;
    private JTable testTable;
    
    private static final String[] LOG_NAMES = {"Fecha y Hora Tomado", "Lección", "Sub-lección", "Puntuación"};
    private static final String[] ATTEMPT_NAMES = {"Question No.", "Attempt No.", "User Answer", "Correct Answer"};

    /**
     * Creates new form AdminHome
     */
    public AdminHome() {
        initComponents();
        this.setTitle("Transcripción Mixteca: Hogar de Administración");
        selectLog = false;
        backend = new LogBE(this);
        userSelection();
    }

    /**
     * Creates the window with the given user.
     * @param user  Admin username passed through from sign-in.
     */
    public AdminHome(String user) {
        this();
        this.user = user;
    }
    
    /**
     * Populates the list with the names of users from the database.
     */
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
    
    /**
     * Creates the tabbed pane with the table within.
     */
    public void createPane(){
        jPanel1.remove(list1);
        jPanel1.remove(jLabel1);
        jPanel1.setLayout(new BorderLayout());
        
        pane = new JTabbedPane();
        pane.setPreferredSize(jPanel1.getSize());
        pane.setVisible(true);
        
        setupTable(false);
        setupTable(true);
        
        JScrollPane practicePanel = new JScrollPane(practiceTable, 
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane testPanel = new JScrollPane(testTable,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        pane.addTab("Práctica", practicePanel);
        pane.addTab("Examen", testPanel);
        jPanel1.add(pane);
        jPanel1.revalidate();
    }
    
    /**
     * Initially sets up the table with list of practice/test logs.
     * @param isTest    True if table is for test, false if for practice.
     */
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
            model.addRow(list.toArray());
        }
        
        if(isTest){
            testTable = table;
        }else{
            practiceTable = table;
        }
    }
    
    /**
     * Updates the table to reveal attempt information.
     * @param isTest    True if table is for test, false if for practice.
     */
    public void updateTable(boolean isTest){
        JTable table;
        if(isTest){
            table = testTable;
        }else{
            table = practiceTable;
        }
        int selectedRow = table.getSelectedRow();
        String date = (String) table.getValueAt(selectedRow, 0);
        int id = backend.getID(date, isTest);
        System.out.println("ID: " + id);
        
        table.removeAll();
        DefaultTableModel model = new DefaultTableModel(ATTEMPT_NAMES, 0);
        table.setModel(model);
        
        if(id >= 0){
            ArrayList<ArrayList<String>> results = backend.traineeLog(id, isTest);
            
            if(results != null){
                for(ArrayList<String> r : results){
                    System.out.println(r);
                    model.addRow(r.toArray());
                }
            }
            
            if(isTest){
                testTable = table;
                testTable.repaint();
            }else{
                practiceTable = table;
                practiceTable.repaint();
            }
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
        jAddLesson = new javax.swing.JMenuItem();

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
                .addContainerGap(31, Short.MAX_VALUE))
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

        jLogOut.setText("Juega");
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

        jAddLesson.setText("Añadir / Actualizar Lección");
        jAddLesson.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jAddLessonMousePressed(evt);
            }
        });
        jMenu3.add(jAddLesson);

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

    /**
     * Updates the log once name submitted, updated once row in log selected.
     * @param evt   Event of mouse clicking.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(selectLog){
            int index = pane.getSelectedIndex();
            if(index == 0){
                updateTable(false);
            }else{
                updateTable(true);
            }
        }else{
            createPane();
            selectLog = true;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Returns the admin to the admin home page.
     * @param evt   Event clicked to return home.
     */
    private void jBackButtonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBackButtonMousePressed
        AdminHome home2 = new AdminHome("admin");
        home2.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBackButtonMousePressed

    /**
     * Logs the user out, and returns to sign in page.
     * @param evt   Event of clicking on log out button.
     */
    private void jLogOutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLogOutMousePressed
        new SignIn().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLogOutMousePressed

    /**
     * Opens the window to load transcriptions into the database.
     * @param evt   Event of clicking on load text button.
     */
    private void jLoadTextMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLoadTextMousePressed
        UpdateLessonFile window = new UpdateLessonFile();
        window.setVisible(true);
    }//GEN-LAST:event_jLoadTextMousePressed

    /**
     * Opens the window to load tone audio files into the database.
     * @param evt   Event of clicking on the load tones button.
     */
    private void jLoadTonesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLoadTonesMousePressed
        UpdateTones window = new UpdateTones();
        window.setVisible(true);
    }//GEN-LAST:event_jLoadTonesMousePressed

    /**
     * Opens the window to add a lesson to the database.
     * @param evt   Event of clicking on the add lesson button.
     */
    private void jAddLessonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jAddLessonMousePressed
       AddLesson window = new AddLesson();
       window.setVisible(true);
    }//GEN-LAST:event_jAddLessonMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem jAddLesson;
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
