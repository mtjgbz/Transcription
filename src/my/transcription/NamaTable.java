/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.transcription;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import static javax.sound.sampled.LineEvent.Type.STOP;
import javax.sound.sampled.LineListener;

/**
 *
 * @author mike
 */
public class NamaTable extends javax.swing.JFrame {

    ArrayList<Clip> cliplist;
    ArrayList<LineListener> listenerlist = new ArrayList<>();
    
    
    LineListener listener1 = new LineListener() {
        @Override
        public void update(LineEvent event) {
            if(event.getType()==STOP){
                cliplist.get(1).start();
            }
        }
    };
    
    /**
     * Creates new form NamaTable
     */
    public NamaTable() {
        initComponents();
        NamaLoader loader = new NamaLoader();
        cliplist = loader.load();
        listenerlist=listeners();
    }
    
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice defaultScreen = ge.getDefaultScreenDevice();
    Rectangle rect = defaultScreen.getDefaultConfiguration().getBounds();

    int x = (int) rect.getMaxX();
    int y = 0;
    
    public ArrayList<LineListener> listeners(){
        ArrayList<LineListener> listeners = new ArrayList<>();
        
       
        LineListener listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(1).start();
                }
            }
        };
        listeners.add(listener);
    
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(2).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(3).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(4).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(5).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(6).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(7).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(8).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(9).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(10).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(11).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(12).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(13).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(14).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(15).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(16).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(17).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(18).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(19).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(20).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(21).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(22).start();
                }
            }
        };
        listeners.add(listener);
        
        listener = new LineListener() {
                
            @Override
            public void update(LineEvent event) {
                if(event.getType()==STOP){
                    cliplist.get(23).start();
                }
            }
        };
        listeners.add(listener);
        
        return listeners;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        playAllButton = new javax.swing.JButton();

        setLocation(new java.awt.Point(x, y));
        setResizable(false);

        jButton1.setText("na3ma3");
        jButton1.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton1.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton1.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton1.setSize(new java.awt.Dimension(110, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("na4ma4");
        jButton2.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton2.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton2.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton2.setSize(new java.awt.Dimension(110, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("na4ma4");
        jButton3.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton3.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton3.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton3.setSize(new java.awt.Dimension(110, 30));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("na4ma2");
        jButton4.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton4.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton4.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton4.setSize(new java.awt.Dimension(110, 30));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("na4ma3");
        jButton5.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton5.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton5.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton5.setSize(new java.awt.Dimension(110, 30));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("na3ma2");
        jButton6.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton6.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton6.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton6.setSize(new java.awt.Dimension(110, 30));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("na3ma2");
        jButton7.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton7.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton7.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton7.setSize(new java.awt.Dimension(110, 30));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("na1ma3");
        jButton8.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton8.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton8.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton8.setSize(new java.awt.Dimension(110, 30));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("na1ma4");
        jButton9.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton9.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton9.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton9.setSize(new java.awt.Dimension(110, 30));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("na3ma4");
        jButton10.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton10.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton10.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton10.setSize(new java.awt.Dimension(110, 30));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("na3ma4");
        jButton11.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton11.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton11.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton11.setSize(new java.awt.Dimension(110, 30));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("na14ma2");
        jButton12.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton12.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton12.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton12.setSize(new java.awt.Dimension(110, 30));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("na14ma3");
        jButton13.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton13.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton13.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton13.setSize(new java.awt.Dimension(110, 30));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("na14ma4");
        jButton14.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton14.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton14.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton14.setSize(new java.awt.Dimension(110, 30));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("na14ma13");
        jButton15.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton15.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton15.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton15.setSize(new java.awt.Dimension(110, 30));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("na14ma132");
        jButton16.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton16.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton16.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton16.setSize(new java.awt.Dimension(110, 30));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setText("na14ma42");
        jButton17.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton17.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton17.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton17.setSize(new java.awt.Dimension(110, 30));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("na1ma32");
        jButton18.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton18.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton18.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton18.setSize(new java.awt.Dimension(110, 30));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("na1ma42");
        jButton19.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton19.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton19.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton19.setSize(new java.awt.Dimension(110, 30));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setText("na3ma42");
        jButton20.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton20.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton20.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton20.setSize(new java.awt.Dimension(110, 30));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setText("na4ma13");
        jButton21.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton21.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton21.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton21.setSize(new java.awt.Dimension(110, 30));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setText("na4ma132");
        jButton22.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton22.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton22.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton22.setSize(new java.awt.Dimension(110, 30));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setText("na4ma42");
        jButton23.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton23.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton23.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton23.setSize(new java.awt.Dimension(110, 30));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setText("na4ma42");
        jButton24.setMaximumSize(new java.awt.Dimension(110, 30));
        jButton24.setMinimumSize(new java.awt.Dimension(110, 30));
        jButton24.setPreferredSize(new java.awt.Dimension(110, 30));
        jButton24.setSize(new java.awt.Dimension(110, 30));
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        playAllButton.setText("Play All");
        playAllButton.setMaximumSize(new java.awt.Dimension(110, 30));
        playAllButton.setMinimumSize(new java.awt.Dimension(110, 30));
        playAllButton.setPreferredSize(new java.awt.Dimension(110, 30));
        playAllButton.setSize(new java.awt.Dimension(110, 30));
        playAllButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playAllButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(playAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(playAllButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!cliplist.get(0).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(0).setMicrosecondPosition(0);
            cliplist.get(0).start();
        } else {
            cliplist.get(0).stop();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!cliplist.get(1).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(1).setMicrosecondPosition(0);
            cliplist.get(1).start();
        } else {
            cliplist.get(1).stop();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(!cliplist.get(2).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(2).setMicrosecondPosition(0);
            cliplist.get(2).start();
        } else {
            cliplist.get(2).stop();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(!cliplist.get(3).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(3).setMicrosecondPosition(0);
            cliplist.get(3).start();
        } else {
            cliplist.get(3).stop();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(!cliplist.get(4).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(4).setMicrosecondPosition(0);
            cliplist.get(4).start();
        } else {
            cliplist.get(4).stop();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(!cliplist.get(5).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(5).setMicrosecondPosition(0);
            cliplist.get(5).start();
        } else {
            cliplist.get(5).stop();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(!cliplist.get(6).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(6).setMicrosecondPosition(0);
            cliplist.get(6).start();
        } else {
            cliplist.get(6).stop();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if(!cliplist.get(7).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(7).setMicrosecondPosition(0);
            cliplist.get(7).start();
        } else {
            cliplist.get(7).stop();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if(!cliplist.get(8).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(8).setMicrosecondPosition(0);
            cliplist.get(8).start();
        } else {
            cliplist.get(8).stop();
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if(!cliplist.get(9).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(9).setMicrosecondPosition(0);
            cliplist.get(9).start();
        } else {
            cliplist.get(9).stop();
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        if(!cliplist.get(10).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(10).setMicrosecondPosition(0);
            cliplist.get(10).start();
        } else {
            cliplist.get(10).stop();
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        if(!cliplist.get(11).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(11).setMicrosecondPosition(0);
            cliplist.get(11).start();
        } else {
            cliplist.get(11).stop();
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        if(!cliplist.get(12).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(12).setMicrosecondPosition(0);
            cliplist.get(12).start();
        } else {
            cliplist.get(12).stop();
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        if(!cliplist.get(13).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(13).setMicrosecondPosition(0);
            cliplist.get(13).start();
        } else {
            cliplist.get(13).stop();
        }
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        if(!cliplist.get(14).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(14).setMicrosecondPosition(0);
            cliplist.get(14).start();
        } else {
            cliplist.get(14).stop();
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        if(!cliplist.get(15).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(15).setMicrosecondPosition(0);
            cliplist.get(15).start();
        } else {
            cliplist.get(15).stop();
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        if(!cliplist.get(16).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(16).setMicrosecondPosition(0);
            cliplist.get(16).start();
        } else {
            cliplist.get(16).stop();
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        if(!cliplist.get(17).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(17).setMicrosecondPosition(0);
            cliplist.get(17).start();
        } else {
            cliplist.get(17).stop();
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        if(!cliplist.get(18).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(18).setMicrosecondPosition(0);
            cliplist.get(18).start();
        } else {
            cliplist.get(18).stop();
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        if(!cliplist.get(19).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(19).setMicrosecondPosition(0);
            cliplist.get(19).start();
        } else {
            cliplist.get(19).stop();
        }
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        if(!cliplist.get(20).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(20).setMicrosecondPosition(0);
            cliplist.get(20).start();
        } else {
            cliplist.get(20).stop();
        }
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        if(!cliplist.get(21).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(21).setMicrosecondPosition(0);
            cliplist.get(21).start();
        } else {
            cliplist.get(21).stop();
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        if(!cliplist.get(22).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(22).setMicrosecondPosition(0);
            cliplist.get(22).start();
        } else {
            cliplist.get(22).stop();
        }
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        if(!cliplist.get(23).isRunning()){
            for(Clip clip:cliplist){
                clip.stop();
            }
            cliplist.get(23).setMicrosecondPosition(0);
            cliplist.get(23).start();
        } else {
            cliplist.get(23).stop();
        }
    }//GEN-LAST:event_jButton24ActionPerformed

    private void playAllButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playAllButtonActionPerformed
        for(Clip clip:cliplist){
            clip.setMicrosecondPosition(0);
            if(cliplist.indexOf(clip)<23){
                clip.addLineListener(listenerlist.get(cliplist.indexOf(clip)));
            }
        }
        cliplist.get(0).start();
        
    }//GEN-LAST:event_playAllButtonActionPerformed

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
            java.util.logging.Logger.getLogger(NamaTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NamaTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NamaTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NamaTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NamaTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton playAllButton;
    // End of variables declaration//GEN-END:variables
}
