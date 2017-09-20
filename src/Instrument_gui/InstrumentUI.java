package Instrument_gui;

import Cartridge_pkg.Cartridge;
import Instrument_pkg.Instrument;
import TestInstance_pkg.TestInstance;
import JDBCqueries_pkg.JDBCqueries;
import Errors_pkg.Errors;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author David Kloosterman
 */
public class InstrumentUI extends javax.swing.JFrame {

    public static final String TESTFILE_SAMPLE = ".\\TestImage.tif";

    TestInstance test;
    Cartridge cartridge;
    Instrument instrument;

    /**
     * Creates new form TopScreen
     */
    public InstrumentUI() {
        initComponents();

        try {
            this.instrument = new Instrument();

            InfoPanel.setVisible(false);
            CartridgeInfoButton.setVisible(false);
            EndTestButton.setVisible(false);
            TestInfoButton.setVisible(false);
            GetImageButton.setVisible(false);

            // load combobox with all instr IDs
            ArrayList<String> allInstrIDs = new ArrayList<String>();
            JDBCqueries queries = new JDBCqueries();

            SelectObjectComboBox.removeAllItems();
            allInstrIDs = queries.getAllInstrumentIDs();
            for (String ID : allInstrIDs) {
                SelectObjectComboBox.addItem(ID);
            }

        } catch (Exception e) {
            // handle the error
            System.out.println("\n" + "General Exception " + e.getMessage());
            System.exit(0);
        } finally {
            //finally block used to close resources

        }   //end finally
    }

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
        SelectObjectComboBox = new javax.swing.JComboBox<>();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        EndTestButton = new javax.swing.JButton();
        InstrumentInfoButton = new javax.swing.JButton();
        InsertCartridgeButton = new javax.swing.JButton();
        CartridgeInfoButton = new javax.swing.JButton();
        TestInfoButton = new javax.swing.JButton();
        GetImageButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SensoDx Topscreen, test 3");
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

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        InfoTextArea.setColumns(20);
        InfoTextArea.setRows(5);
        InfoTextArea.setText("Information");
        jScrollPane1.setViewportView(InfoTextArea);

        SelectObjectComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectObjectComboBoxActionPerformed(evt);
            }
        });

        EndTestButton.setText("End Test");
        EndTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EndTestButtonActionPerformed(evt);
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
                        .addComponent(EndTestButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SelectObjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CloseInfoButton)))
                .addContainerGap())
            .addGroup(InfoPanelLayout.createSequentialGroup()
                .addGap(251, 251, 251)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(368, Short.MAX_VALUE))
        );
        InfoPanelLayout.setVerticalGroup(
            InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InfoPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(InfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CloseInfoButton)
                    .addComponent(SelectObjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EndTestButton))
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

        TestInfoButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Instrument_gui/test.png"))); // NOI18N
        TestInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TestInfoButtonActionPerformed(evt);
            }
        });

        GetImageButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Instrument_gui/GetImage.png"))); // NOI18N
        GetImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetImageButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(InsertCartridgeButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(GetImageButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TestInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CartridgeInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(InstrumentInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(InfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(InfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(InstrumentInfoButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CartridgeInfoButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TestInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(InsertCartridgeButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(GetImageButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CloseInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseInfoButtonActionPerformed

        InfoPanel.setVisible(false);
    }//GEN-LAST:event_CloseInfoButtonActionPerformed

    private void InstrumentInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstrumentInfoButtonActionPerformed

        try {
            JDBCqueries queries = new JDBCqueries();

            queries.getInstrumentMfgInfo((String) SelectObjectComboBox.getSelectedItem(), this.instrument);
            queries.getInstrumentDeploymentInfo((String) SelectObjectComboBox.getSelectedItem(), this.instrument);

            InfoTextArea.setText(this.instrument.toString());

            SelectObjectComboBox.setVisible(true);
            InfoPanel.setVisible(true);
        } catch (Exception e) {
            // handle the error
            System.out.println("\n" + "General Exception " + e.getMessage());
            System.exit(0);
        } finally {
            //finally block used to close resources

        }   //end finally
    }//GEN-LAST:event_InstrumentInfoButtonActionPerformed

    private void SelectObjectComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectObjectComboBoxActionPerformed

        try {
            JDBCqueries queries = new JDBCqueries();

            this.instrument = null;
            this.instrument = new Instrument();

            // update Instrument Info Text Area with selected Instrument ID
            queries.getInstrumentMfgInfo((String) SelectObjectComboBox.getSelectedItem(), this.instrument);
            queries.getInstrumentDeploymentInfo((String) SelectObjectComboBox.getSelectedItem(), this.instrument);
            InfoTextArea.setText(this.instrument.toString());

        } catch (Exception e) {
            // handle the error
            System.out.println("\n" + "General Exception " + e.getMessage());
            System.exit(0);
        } finally {
            //finally block used to close resources

        }   //end finally 
    }//GEN-LAST:event_SelectObjectComboBoxActionPerformed

    private void InsertCartridgeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InsertCartridgeButtonActionPerformed

        try {
            this.cartridge = new Cartridge();

            // temp code until real cartridges exist
            this.createTestCartridge(this.cartridge);

            // update Instrument Info Text Area with selected Instrument ID
            JDBCqueries queries = new JDBCqueries();
            queries.insertCartridge(this.cartridge);
            queries.getCartridgeMfgInfo(this.cartridge.getCartridge_id(), this.cartridge);
            if (TESTFILE_SAMPLE != null) {
                File f = new File(TESTFILE_SAMPLE);
                if (f.exists() && !f.isDirectory()) {

                    this.test = new TestInstance(TESTFILE_SAMPLE);

                    if (test.processTest(this.instrument, this.cartridge)) {
                        InfoTextArea.setText(this.test.getTestResultString() + "\n\n" + this.test.toString());
                    } else {
                        InfoTextArea.setText(this.test.getTestResultString());
                    }

                } else {
                    Errors error = new Errors();

                    error.buildErrorObject_ClinicalTestImageNotFound(this.instrument.getInstrument_id(),
                            this.cartridge.getCartridge_id(),
                            null,
                            TESTFILE_SAMPLE);

                    queries.insertError(error);

                    InfoTextArea.setText(error.toString());
                    error = null;
                }
            } else {
                Errors error = new Errors();

                error.buildErrorObject_ClinicalTestImageSetToNull(this.instrument.getInstrument_id(),
                        this.cartridge.getCartridge_id(),
                        null);

                queries.insertError(error);

                InfoTextArea.setText(error.toString());
                error = null;

                InfoTextArea.setText("Error: Unable to run test because input clinical test image "
                        + "is set to null");
            }

            // update view
            CartridgeInfoButton.setVisible(true);
            SelectObjectComboBox.setVisible(false);
            InsertCartridgeButton.setVisible(false);
            InfoPanel.setVisible(true);
            EndTestButton.setVisible(true);
            GetImageButton.setVisible(true);
            TestInfoButton.setVisible(true);
        } catch (Exception e) {
            // handle the error
            System.out.println("\n" + "General Exception " + e.getMessage());
            System.exit(0);
        } finally {
            //finally block used to close resources

        }   //end finally 
    }//GEN-LAST:event_InsertCartridgeButtonActionPerformed

    public void createTestCartridge(Cartridge cartridge) {

        try {
            // temp code : create a cartridge ID from the current timestamp
            /*
            (cartridge_id, manufactured_timestamp, manufactured_location, assay_type,
                             subsystem_1_id, subsystem_2_id, subsystem_3_id)
             */
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String cartID = timestamp.toString();

            cartID = cartID.replace(" ", "");
            cartID = cartID.replace(":", "");
            cartID = cartID.replace(".", "");
            cartID = cartID.replace("-", "");
            cartridge.setCartridge_id(cartID);
            cartridge.setManufactured_timestamp(new Timestamp(System.currentTimeMillis()));
            cartridge.setDeployment_type(Cartridge.DeploymentType.Virtual.toString());
            cartridge.setManufactured_location("Perinton, NY");
            cartridge.setAssay_type(test.CARDIAC_WELLNESS_TEST);
            cartridge.setSubsystem_1_id("0000000010000002");
            cartridge.setSubsystem_2_id("0000000020000002");
            cartridge.setSubsystem_3_id("0000000030000002");

        } catch (Exception e) {
            // handle the error
            System.out.println("\n" + "General Exception " + e.getMessage());
            System.exit(0);
        } finally {
            //finally block used to close resources

        }   //end finally try
    }

    private void CartridgeInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CartridgeInfoButtonActionPerformed

        try {

            JDBCqueries queries = new JDBCqueries();
            queries.getCartridgeMfgInfo(this.cartridge.getCartridge_id(), this.cartridge);
            InfoTextArea.setText(this.cartridge.toString());

            SelectObjectComboBox.setVisible(false);

            InfoPanel.setVisible(true);
        } catch (Exception e) {
            // handle the error
            System.out.println("\n" + "General Exception " + e.getMessage());
            System.exit(0);
        } finally {
            //finally block used to close resources

        }   //end finally     
    }//GEN-LAST:event_CartridgeInfoButtonActionPerformed

    private void EndTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EndTestButtonActionPerformed
        InfoPanel.setVisible(false);
        InsertCartridgeButton.setVisible(true);
        CartridgeInfoButton.setVisible(false);
        EndTestButton.setVisible(false);
        GetImageButton.setVisible(false);
        TestInfoButton.setVisible(false);
        this.test = null;
        this.cartridge = null;
    }//GEN-LAST:event_EndTestButtonActionPerformed

    private void GetImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetImageButtonActionPerformed
        try {

            // update Instrument Info Text Area with selected Instrument ID
            JDBCqueries queries = new JDBCqueries();

            String filePath = ".\\retrievedTestImage.tif";
            long fileLength = queries.getClinicalTestImage(this.test.getRaw_assay_data(), filePath);
            System.out.println("Retrieved clinical test file to: " + filePath);
            InfoTextArea.setText(InfoTextArea.getText()
                    + "\n\nRetrieved clinical test file to: " + filePath
                    + " of length " + fileLength);

        } catch (Exception e) {
            // handle the error
            System.out.println("\n" + "General Exception " + e.getMessage());
            System.exit(0);
        } finally {
            //finally block used to close resources

        }   //end finally 
    }//GEN-LAST:event_GetImageButtonActionPerformed

    private void TestInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TestInfoButtonActionPerformed
        SelectObjectComboBox.setVisible(false);
        InfoTextArea.setText(this.test.toString());
        TestInfoButton.setVisible(true);
    }//GEN-LAST:event_TestInfoButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InstrumentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InstrumentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InstrumentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InstrumentUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                new InstrumentUI().setVisible(true);
            }
        });

    } // end main


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CartridgeInfoButton;
    private javax.swing.JButton CloseInfoButton;
    private javax.swing.JButton EndTestButton;
    private javax.swing.JButton GetImageButton;
    private javax.swing.JPanel InfoPanel;
    private javax.swing.JTextArea InfoTextArea;
    private javax.swing.JButton InsertCartridgeButton;
    private javax.swing.JButton InstrumentInfoButton;
    private javax.swing.JComboBox<String> SelectObjectComboBox;
    private javax.swing.JButton TestInfoButton;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
