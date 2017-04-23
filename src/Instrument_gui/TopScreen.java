/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instrument_gui;

import java.sql.*;
import java.util.*;
import java.text.*;
import JDBCqueries_pkg.*;


/**
 *
 * @author David Kloosterman
 */
public class TopScreen extends javax.swing.JFrame {

    /**
     * Creates new form TopScreen
     */
    public TopScreen() {
        initComponents();
        InfoPanel.setVisible(false);
        CartridgeInfoButton.setVisible(false);
        
        JDBCqueries queries = new JDBCqueries();
        String test = null;
        test = queries. test();
        String hello = test;
        System.out.println(hello);
        
    }

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/sensodx_sql_db?useSSL=false";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "rootMysql151";

    //String display = null;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        InfoPanel = new javax.swing.JPanel();
        CloseInfoButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        InfoTextArea = new javax.swing.JTextArea();
        SelectComboBox = new javax.swing.JComboBox<>();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        InstrumentInfoButton = new javax.swing.JButton();
        InsertCartridgeButton = new javax.swing.JButton();
        CartridgeInfoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SensoDx Topscreen");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setSize(new java.awt.Dimension(900, 600));

        InfoPanel.setBackground(new java.awt.Color(204, 204, 255));
        InfoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        CloseInfoButton.setText("Close");
        CloseInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseInfoButtonActionPerformed(evt);
            }
        });

        InfoTextArea.setColumns(20);
        InfoTextArea.setRows(5);
        InfoTextArea.setText("Information");
        jScrollPane1.setViewportView(InfoTextArea);

        SelectComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout InfoPanelLayout = new javax.swing.GroupLayout(InfoPanel);
        InfoPanel.setLayout(InfoPanelLayout);
        InfoPanelLayout.setHorizontalGroup(
            InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(InfoPanelLayout.createSequentialGroup()
                        .addComponent(SelectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CloseInfoButton)))
                .addContainerGap())
            .addGroup(InfoPanelLayout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(247, Short.MAX_VALUE))
        );
        InfoPanelLayout.setVerticalGroup(
            InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CloseInfoButton)
                    .addComponent(SelectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        InstrumentInfoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Instrument_gui/Instrument.png"))); // NOI18N
        InstrumentInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstrumentInfoButtonActionPerformed(evt);
            }
        });

        InsertCartridgeButton.setBackground(new java.awt.Color(255, 255, 153));
        InsertCartridgeButton.setText("Press here to simulate inserting a cartridge");
        InsertCartridgeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InsertCartridgeButtonActionPerformed(evt);
            }
        });

        CartridgeInfoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Instrument_gui/Cartridge.png"))); // NOI18N
        CartridgeInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CartridgeInfoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(InsertCartridgeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CartridgeInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(InstrumentInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(InfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(248, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CartridgeInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(InfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(InstrumentInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(InsertCartridgeButton))))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseInfoButtonActionPerformed
        // TODO add your handling code here:
        InfoPanel.setVisible(false);
    }//GEN-LAST:event_CloseInfoButtonActionPerformed

    private void InstrumentInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstrumentInfoButtonActionPerformed

        // load Combo Box with list of all Intrument IDs
        Connection conn;
        String sql;
        Statement stmt;
        ResultSet rs;
        String display = null;

        try {
            JDBCqueries queries = new JDBCqueries();
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            sql = "SELECT instrument_id FROM Instrument_Manufactured";
            rs = stmt.executeQuery(sql);
            SelectComboBox.removeAllItems();

            while (rs.next()) {
                String instrumentID = rs.getString("instrument_id");
                SelectComboBox.addItem(instrumentID);
            } // end while (rs.next()) 

            // Populate the Instrument Info Panel with Instrument's Mfg. Info
            String selectedInstrumentID = (String) SelectComboBox.getSelectedItem();
            display = queries.getInstrumentMfgInfo(selectedInstrumentID);

            // Display Instrument Deployment Info.
            display += queries.getInstrumentDeploymentInfo(selectedInstrumentID);

        } // end try
        catch (ClassNotFoundException e) {
            // handle the error
            display += "\n" + "Class Not Found Exception " + e.getMessage();
            System.exit(0);
        } catch (SQLException e) {
            // handle the error
            display += "\n" + "SQL Exception " + e.getMessage();
            System.exit(0);
        } catch (Exception e) {
            // handle the error
            display += "\n" + "General Exception " + e.getMessage();
            System.exit(0);
        } finally {
            //finally block used to close resources

        }   //end finally

        InfoTextArea.setText(display);

        // Make Instrument Info Panel visible
        SelectComboBox.setVisible(true);
        InfoPanel.setVisible(true);
    }//GEN-LAST:event_InstrumentInfoButtonActionPerformed

    private void SelectComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectComboBoxActionPerformed

        // update Instrument Info Text Area with selected Instrument ID
        JDBCqueries queries = new JDBCqueries();
        String selectedInstrumentID = (String) SelectComboBox.getSelectedItem();
        String display = queries.getInstrumentMfgInfo(selectedInstrumentID);
        display += queries.getInstrumentDeploymentInfo(selectedInstrumentID);
        InfoTextArea.setText(display);
    }//GEN-LAST:event_SelectComboBoxActionPerformed

    private void InsertCartridgeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertCartridgeButtonActionPerformed
        // Make Instrument Info Panel visible
        CartridgeInfoButton.setVisible(true);
        InsertCartridgeButton.setVisible(false);
    }//GEN-LAST:event_InsertCartridgeButtonActionPerformed

    private void CartridgeInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CartridgeInfoButtonActionPerformed
        Connection conn;
        String sql;
        Statement stmt;
        ResultSet rs;
        String display = null;
        

        try {
            JDBCqueries queries = new JDBCqueries();
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            sql = "SELECT cartridge_id FROM Cartridge_Manufactured";
            rs = stmt.executeQuery(sql);
//            SelectComboBox.removeAllItems();

//            while (rs.next()) {
//                String instrumentID = rs.getString("instrument_id");
//                SelectComboBox.addItem(instrumentID);
//            } // end while (rs.next()) 
            // Populate the Instrument Info Panel with Instrument's Mfg. Info
//            String selectedInstrumentID = (String) SelectComboBox.getSelectedItem();
            rs.last();
            display = queries.getCartridgeMfgInfo(rs.getString("cartridge_id"));

            // Display Instrument Deployment Info.
//            display += getInstrumentDeploymentInfo(selectedInstrumentID);
        } // end try
        catch (ClassNotFoundException e) {
            // handle the error
            display += "\n" + "Class Not Found Exception " + e.getMessage();
            System.exit(0);
        } catch (SQLException e) {
            // handle the error
            display += "\n" + "SQL Exception " + e.getMessage();
            System.exit(0);
        } catch (Exception e) {
            // handle the error
            display += "\n" + "General Exception " + e.getMessage();
            System.exit(0);
        } finally {
            //finally block used to close resources

        }   //end finally

        InfoTextArea.setText(display);

        // Make Instrument Info Panel visible
        SelectComboBox.setVisible(false);
        InfoPanel.setVisible(true);
    }//GEN-LAST:event_CartridgeInfoButtonActionPerformed

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
            java.util.logging.Logger.getLogger(TopScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TopScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TopScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TopScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new TopScreen().setVisible(true);
            }
        });

    } // end main


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CartridgeInfoButton;
    private javax.swing.JButton CloseInfoButton;
    private javax.swing.JPanel InfoPanel;
    private javax.swing.JTextArea InfoTextArea;
    private javax.swing.JButton InsertCartridgeButton;
    private javax.swing.JButton InstrumentInfoButton;
    private javax.swing.JComboBox<String> SelectComboBox;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
