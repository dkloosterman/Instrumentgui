package Instrument_gui;

import Cartridge_pkg.Cartridge;
import Instrument_pkg.Instrument;
import TestInstance_pkg.*;
import JDBCqueries_pkg.JDBCqueries;
import Errors_pkg.Errors;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


// for SAX Parser
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author David Kloosterman
 */
public class InstrumentUI extends javax.swing.JFrame {

    public static final String TESTFILE_SAMPLE = ".\\boats.tif";
////    public static final String TESTFILE_SAMPLE = null;    
    public static final String TESTFILE_SAMPLE_2 = ".\\bridge.tif";
    public static final String TESTFILE_SAMPLE_3 = ".\\einstein.tif";

    public static final int WATCH_FOLDER_RATE_MS = 1000;
    public static final String APP_WATCH_FOLDER_LOCATION = ".\\AppWatchFolder";
    File folder = new File(APP_WATCH_FOLDER_LOCATION);

    public static final String MC_WATCH_FOLDER_LOCATION = ".\\MC_WatchFolder";

    public static final String DIAG_ALG_WATCH_FOLDER_LOCATION = ".\\DiagAlg_WatchFolder";
    public static final boolean SIMULATE_DIAG_ALG_RESULT = true;

    public TestInstance test;
    Cartridge cartridge;
    Instrument instrument;

    /**
     * Creates new form TopScreen
     */
    public InstrumentUI() {
        initComponents();

        try {
            this.instrument = new Instrument();

            leftSideInfoPanel.setVisible(true);

            // load combobox with all instr IDs
            ArrayList<String> allInstrIDs = new ArrayList<String>();
            JDBCqueries queries = new JDBCqueries();
            
            String locationOfDB = "";
            if (queries.isUseLocalDB()) {
                    locationOfDB = "Local Database";
                    this.UseLocalDBcheckBox.setSelected(true);
                } else {
                    locationOfDB = "Cloud Database";
                    this.UseLocalDBcheckBox.setSelected(false);
                }
            this.UseLocalDBcheckBox.setEnabled(true);

            if (!queries.isConnectedToDB()) {
         
                this.InfoTextArea.setText("Unable to connect to " + locationOfDB);

                this.SimulateInsertCartridgeButton.setEnabled(false);
                this.SelectObjectComboBox.setEnabled(false);
                this.CartridgeInfoButton.setEnabled(false);
                this.InstrumentInfoButton.setEnabled(false);
                this.TestInfoButton.setEnabled(false);
                this.GetImageButton.setEnabled(false);
            } else {
                SelectObjectComboBox.removeAllItems();
                allInstrIDs = queries.getAllInstrumentIDs();
                for (String ID : allInstrIDs) {
                    SelectObjectComboBox.addItem(ID);
                }
                instrumentIDTextField.setText(this.instrument.getInstrument_id());
            }

            cartridgeIDTextField.setText("0");
            imageIDTextField.setText("0");
            testIDTextField.setText("0");

            // create App watch folder if it's not already there
            File file = new File(APP_WATCH_FOLDER_LOCATION);
            if (!file.exists()) {
                if (file.mkdir()) {
                    System.out.println("Directory " + APP_WATCH_FOLDER_LOCATION + " is created!");
                } else {
                    System.out.println("Failed to create directory: " + APP_WATCH_FOLDER_LOCATION);
                }
            }

            // create Machine Control watch folder if it's not already there
            File MCfile = new File(MC_WATCH_FOLDER_LOCATION);
            if (!MCfile.exists()) {
                if (MCfile.mkdir()) {
                    System.out.println("Directory " + MC_WATCH_FOLDER_LOCATION + " is created!");
                } else {
                    System.out.println("Failed to create directory: " + MC_WATCH_FOLDER_LOCATION);
                }
            }

            // create Diagnostic Algorithm watch folder if it's not already there
            File DAfile = new File(DIAG_ALG_WATCH_FOLDER_LOCATION);
            if (!DAfile.exists()) {
                if (DAfile.mkdir()) {
                    System.out.println("Directory " + DIAG_ALG_WATCH_FOLDER_LOCATION + " is created!");
                } else {
                    System.out.println("Failed to create directory: " + DIAG_ALG_WATCH_FOLDER_LOCATION);
                }
            }

            //  set up schedule to update the lower text area
            ScheduledExecutorService execService
                    = Executors.newScheduledThreadPool(1);

            execService.scheduleAtFixedRate(() -> {

                //The repetitive task... 
                this.appWatchFolder();

            }, 0, WATCH_FOLDER_RATE_MS, TimeUnit.MILLISECONDS);

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

        leftSideInfoPanel = new javax.swing.JPanel();
        Info_ScrollPane = new javax.swing.JScrollPane();
        InfoTextArea = new javax.swing.JTextArea();
        SelectObjectComboBox = new javax.swing.JComboBox<>();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jLabel1 = new javax.swing.JLabel();
        rightSide = new javax.swing.JPanel();
        WatchFolderPanel = new javax.swing.JPanel();
        WatchFolderScrollPane = new javax.swing.JScrollPane();
        watchFolderTextArea = new javax.swing.JTextArea();
        Panel1_Panel = new javax.swing.JPanel();
        Panel1_ScrollPane = new javax.swing.JScrollPane();
        Panel1_TextArea = new javax.swing.JTextArea();
        Panel2_Panel = new javax.swing.JPanel();
        Panel2_ScrollPane = new javax.swing.JScrollPane();
        Panel2_TextArea = new javax.swing.JTextArea();
        instrumentButtons = new javax.swing.JPanel();
        InsertCartridge_Panel = new javax.swing.JPanel();
        UseLocalDBcheckBox = new javax.swing.JCheckBox();
        SimulateInsertCartridgeButton = new javax.swing.JButton();
        Buttons_Panel = new javax.swing.JPanel();
        GetImageButton = new javax.swing.JButton();
        TestInfoButton = new javax.swing.JButton();
        CartridgeInfoButton = new javax.swing.JButton();
        InstrumentInfoButton = new javax.swing.JButton();
        QueryPanel = new javax.swing.JPanel();
        imageIDTextField = new javax.swing.JTextField();
        testIDTextField = new javax.swing.JTextField();
        cartridgeIDTextField = new javax.swing.JTextField();
        instrumentIDTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SensoDx Instrument");
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setSize(new java.awt.Dimension(900, 600));
        getContentPane().setLayout(new java.awt.GridLayout(1, 2));

        leftSideInfoPanel.setBackground(new java.awt.Color(204, 204, 255));
        leftSideInfoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Info_ScrollPane.setBackground(new java.awt.Color(255, 255, 255));

        InfoTextArea.setColumns(20);
        InfoTextArea.setRows(5);
        InfoTextArea.setText("Information");
        Info_ScrollPane.setViewportView(InfoTextArea);

        SelectObjectComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectObjectComboBoxActionPerformed(evt);
            }
        });

        jLabel1.setText("Available Instruments");

        javax.swing.GroupLayout leftSideInfoPanelLayout = new javax.swing.GroupLayout(leftSideInfoPanel);
        leftSideInfoPanel.setLayout(leftSideInfoPanelLayout);
        leftSideInfoPanelLayout.setHorizontalGroup(
            leftSideInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftSideInfoPanelLayout.createSequentialGroup()
                .addGroup(leftSideInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Info_ScrollPane)
                    .addGroup(leftSideInfoPanelLayout.createSequentialGroup()
                        .addGroup(leftSideInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(leftSideInfoPanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1)
                                .addGap(36, 36, 36)
                                .addComponent(SelectObjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(leftSideInfoPanelLayout.createSequentialGroup()
                                .addGap(251, 251, 251)
                                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 6225, Short.MAX_VALUE)))
                .addContainerGap())
        );
        leftSideInfoPanelLayout.setVerticalGroup(
            leftSideInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftSideInfoPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Info_ScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 4226, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(leftSideInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectObjectComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        getContentPane().add(leftSideInfoPanel);

        rightSide.setLayout(new java.awt.GridLayout(4, 1));

        WatchFolderPanel.setLayout(new java.awt.GridLayout(1, 0));

        WatchFolderScrollPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        watchFolderTextArea.setColumns(20);
        watchFolderTextArea.setRows(5);
        watchFolderTextArea.setText("Watch Folder");
        WatchFolderScrollPane.setViewportView(watchFolderTextArea);

        WatchFolderPanel.add(WatchFolderScrollPane);

        rightSide.add(WatchFolderPanel);

        Panel1_Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel1_Panel.setLayout(new java.awt.GridLayout(1, 0));

        Panel1_TextArea.setColumns(20);
        Panel1_TextArea.setRows(5);
        Panel1_TextArea.setText("Panel 1");
        Panel1_ScrollPane.setViewportView(Panel1_TextArea);

        Panel1_Panel.add(Panel1_ScrollPane);

        rightSide.add(Panel1_Panel);

        Panel2_Panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Panel2_Panel.setLayout(new java.awt.GridLayout(1, 0));

        Panel2_TextArea.setColumns(20);
        Panel2_TextArea.setRows(5);
        Panel2_TextArea.setText("Panel 2");
        Panel2_ScrollPane.setViewportView(Panel2_TextArea);

        Panel2_Panel.add(Panel2_ScrollPane);

        rightSide.add(Panel2_Panel);

        instrumentButtons.setLayout(new java.awt.GridLayout(3, 1));

        InsertCartridge_Panel.setLayout(new java.awt.GridLayout(1, 2));

        UseLocalDBcheckBox.setText("Use Local Database");
        UseLocalDBcheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UseLocalDBcheckBoxActionPerformed(evt);
            }
        });
        InsertCartridge_Panel.add(UseLocalDBcheckBox);

        SimulateInsertCartridgeButton.setBackground(new java.awt.Color(255, 255, 153));
        SimulateInsertCartridgeButton.setText("Press here to simulate Test");
        SimulateInsertCartridgeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        SimulateInsertCartridgeButton.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        SimulateInsertCartridgeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimulateInsertCartridgeButtonActionPerformed(evt);
            }
        });
        InsertCartridge_Panel.add(SimulateInsertCartridgeButton);

        instrumentButtons.add(InsertCartridge_Panel);

        Buttons_Panel.setLayout(new java.awt.GridLayout(1, 4));

        GetImageButton.setText("Image ID");
        GetImageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GetImageButtonActionPerformed(evt);
            }
        });
        Buttons_Panel.add(GetImageButton);

        TestInfoButton.setText("Test ID");
        TestInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TestInfoButtonActionPerformed(evt);
            }
        });
        Buttons_Panel.add(TestInfoButton);

        CartridgeInfoButton.setText("Cartridge ID");
        CartridgeInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CartridgeInfoButtonActionPerformed(evt);
            }
        });
        Buttons_Panel.add(CartridgeInfoButton);

        InstrumentInfoButton.setText("Instrument ID");
        InstrumentInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstrumentInfoButtonActionPerformed(evt);
            }
        });
        Buttons_Panel.add(InstrumentInfoButton);

        instrumentButtons.add(Buttons_Panel);

        QueryPanel.setLayout(new java.awt.GridLayout(1, 4));

        imageIDTextField.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        imageIDTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        imageIDTextField.setText("Test Image ID");
        QueryPanel.add(imageIDTextField);

        testIDTextField.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        testIDTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        testIDTextField.setText("Diagnostic Test ID");
        QueryPanel.add(testIDTextField);

        cartridgeIDTextField.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        cartridgeIDTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        cartridgeIDTextField.setText("Cartridge ID");
        QueryPanel.add(cartridgeIDTextField);

        instrumentIDTextField.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        instrumentIDTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        instrumentIDTextField.setText("Instrument ID");
        QueryPanel.add(instrumentIDTextField);

        instrumentButtons.add(QueryPanel);

        rightSide.add(instrumentButtons);

        getContentPane().add(rightSide);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createTestCartridge(Cartridge cartridge, Cartridge.DeploymentType deployType) {

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
            cartridge.setDeployment_type(deployType.toString());
            cartridge.setManufactured_location("Perinton, NY");
            cartridge.setAssay_type(test.TRUST_ME_ASSAYS_ENABLED);
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
            this.cartridge = null;
            this.cartridge = new Cartridge();

            if (queries.getCartridgeMfgInfo(cartridgeIDTextField.getText(), this.cartridge)) {
                InfoTextArea.setText(this.cartridge.toString());
            } else {
                InfoTextArea.setText("Cartridge: " + cartridgeIDTextField.getText() + " not found in database");
            }

        } catch (Exception e) {
            // handle the error
            System.out.println("\n" + "General Exception " + e.getMessage());
        } finally {
            //finally block used to close resources

        }   //end finally
    }//GEN-LAST:event_CartridgeInfoButtonActionPerformed

    private void TestInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TestInfoButtonActionPerformed
        try {
            JDBCqueries queries = new JDBCqueries();

            List<String> imagePaths = new ArrayList<String>();
            TestInstance test = new TestInstance(imagePaths);

            if (queries.getTestInstanceInfo(testIDTextField.getText(), test, true, true)) {
                InfoTextArea.setText(test.toString());

                instrumentIDTextField.setText(test.getInstrument_id());
                cartridgeIDTextField.setText(test.getCartridge_id());
//                testIDTextField.setText(Long.toString(test.getClinical_test_instance_counter()));

                List<TestImage> imageIDList = test.dicom.getTestImages();
                imageIDTextField.setText(Long.toString(imageIDList.get(0).getClinicalTestImage_id()));
            } else {
                InfoTextArea.setText("Test: " + testIDTextField.getText() + " not found in database");
            }
        } catch (Exception e) {
            // handle the error
            System.out.println("\n" + "General Exception " + e.getMessage());
        } finally {
            //finally block used to close resources

        }   //end finally

    }//GEN-LAST:event_TestInfoButtonActionPerformed

    private void InstrumentInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstrumentInfoButtonActionPerformed

        try {
            JDBCqueries queries = new JDBCqueries();
            this.instrument = null;
            this.instrument = new Instrument();

            if (queries.getInstrumentMfgInfo(instrumentIDTextField.getText(), this.instrument)) {

                queries.getInstrumentDeploymentInfo(instrumentIDTextField.getText(), this.instrument);

                InfoTextArea.setText(this.instrument.toString());

                SelectObjectComboBox.setVisible(true);
            } else {
                InfoTextArea.setText("Instrument: " + instrumentIDTextField.getText() + " not found in database");
            }
        } catch (Exception e) {
            // handle the error
            System.out.println("\n" + "General Exception " + e.getMessage());

        } finally {
            //finally block used to close resources

        }   //end finally
    }//GEN-LAST:event_InstrumentInfoButtonActionPerformed

    private void SimulateInsertCartridgeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimulateInsertCartridgeButtonActionPerformed

        JDBCqueries queries = new JDBCqueries();

        this.cartridge = new Cartridge();
        this.createTestCartridge(this.cartridge, Cartridge.DeploymentType.Virtual);
        queries.insertCartridge(this.cartridge);

        BufferedWriter bw = null;
        FileWriter fw = null;
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        try {
            fw = new FileWriter(APP_WATCH_FOLDER_LOCATION + "\\simulateJobSubmit.xml");
            bw = new BufferedWriter(fw);
            String resultString = "<SensoDx>\n"
                    + "<Test>\n"
                    + "<Instrument InstrumentID=\"" + this.instrument.getInstrument_id() + "\">"
                    + "</Instrument>\n"
                    + "<Cartridge CartridgeID=\"" + cartridge.getCartridge_id() + "\">"
                    + "</Cartridge>\n"
                    + "<TestImages>\n"
                    + "<Image>" + TESTFILE_SAMPLE + "</Image>\n"
                    + "<Image>" + TESTFILE_SAMPLE_2 + "</Image>\n"
                    + "<Image>" + TESTFILE_SAMPLE_3 + "</Image>\n"
                    + "</TestImages>\n"
                    + "<Timestamp>" + timestamp.toString() + "</Timestamp>\n"
                    + "</Test>\n"
                    + "<InfoPanel1>" + "Simulating a test" + "</InfoPanel1>\n"
                    + "<InfoPanel2>" + "Using Simulate Test button" + "</InfoPanel2>\n"
                    + "</SensoDx>\n";

            bw.write(resultString);

        } catch (Exception e) {
            // handle the error
            System.out.println("\n" + "General Exception " + e.getMessage());
        } finally {

            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }   //end finally
    }//GEN-LAST:event_SimulateInsertCartridgeButtonActionPerformed

    private void GetImageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GetImageButtonActionPerformed
        try {

            JDBCqueries queries = new JDBCqueries();

            String filePath = ".\\retrieved\\" + imageIDTextField.getText() + ".tif";
            long fileLength = queries.getClinicalTestImage(Long.parseLong(imageIDTextField.getText()), filePath);

            if (fileLength > 0) {
                System.out.println("Retrieved clinical test file to: " + filePath);
                InfoTextArea.setText(InfoTextArea.getText()
                        + "\n\nRetrieved clinical test file to: " + filePath
                        + " of length " + fileLength);
            } else {
                InfoTextArea.setText("Test Image: " + Long.parseLong(imageIDTextField.getText()) + " not found in database");
            }

        } catch (Exception e) {
            // handle the error
            System.out.println("\n" + "General Exception " + e.getMessage());
            System.exit(0);
        } finally {
            //finally block used to close resources

        }   //end finally
    }//GEN-LAST:event_GetImageButtonActionPerformed

    private void SelectObjectComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelectObjectComboBoxActionPerformed

        try {
            JDBCqueries queries = new JDBCqueries();

            this.instrument = null;
            this.instrument = new Instrument();

            // update Instrument Info Text Area with selected Instrument ID
            queries.getInstrumentMfgInfo((String) SelectObjectComboBox.getSelectedItem(), this.instrument);
            queries.getInstrumentDeploymentInfo((String) SelectObjectComboBox.getSelectedItem(), this.instrument);
            InfoTextArea.setText(this.instrument.toString());
            instrumentIDTextField.setText(this.instrument.getInstrument_id());

        } catch (Exception e) {
            // handle the error
            System.out.println("\n" + "General Exception " + e.getMessage());

        } finally {
            //finally block used to close resources

        }   //end finally
    }//GEN-LAST:event_SelectObjectComboBoxActionPerformed

    private void UseLocalDBcheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UseLocalDBcheckBoxActionPerformed

        JDBCqueries queries = new JDBCqueries();
        String locationOfDB = "";

        if (this.UseLocalDBcheckBox.isSelected()) {
            locationOfDB = "Local Database";
            queries.setUseLocalDB(true);
        } else {
            locationOfDB = "Cloud Database";
            queries.setUseLocalDB(false);
        }
        queries = null;

        JDBCqueries queriesNew = new JDBCqueries();

        if (!queriesNew.isConnectedToDB()) {
            this.InfoTextArea.setText("Unable to connect to " + locationOfDB);
            this.SimulateInsertCartridgeButton.setEnabled(false);
            this.SelectObjectComboBox.setEnabled(false);
            this.CartridgeInfoButton.setEnabled(false);
            this.InstrumentInfoButton.setEnabled(false);
            this.TestInfoButton.setEnabled(false);
            this.GetImageButton.setEnabled(false);
//            try {
//                sleep(5000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(InstrumentUI.class.getName()).log(Level.SEVERE, null, ex);
//            }
        } else {
            SelectObjectComboBox.removeAllItems();
            // load combobox with all instr IDs
            ArrayList<String> allInstrIDs = new ArrayList<String>();
            allInstrIDs = queriesNew.getAllInstrumentIDs();
            for (String ID : allInstrIDs) {
                SelectObjectComboBox.addItem(ID);
            }
            instrumentIDTextField.setText(this.instrument.getInstrument_id());
            this.InfoTextArea.setText("Successfully Connected to " + locationOfDB);

            this.SimulateInsertCartridgeButton.setEnabled(true);
            this.SelectObjectComboBox.setEnabled(true);
            this.CartridgeInfoButton.setEnabled(true);
            this.InstrumentInfoButton.setEnabled(true);
            this.TestInfoButton.setEnabled(true);
            this.GetImageButton.setEnabled(true);
        }
    }//GEN-LAST:event_UseLocalDBcheckBoxActionPerformed

    private void appWatchFolder() {
        File[] listOfFiles = folder.listFiles();

        Arrays.sort(listOfFiles, Comparator.comparingLong(File::lastModified));
        for (File aFile : listOfFiles) {

            String saveText = watchFolderTextArea.getText();
            java.util.Date date = new java.util.Date();

            if (aFile.isFile()) {
                try {
                    String buildFile = "";

                    File newFile = new File(APP_WATCH_FOLDER_LOCATION + '\\' + aFile.getName());
                    try (BufferedReader reader = new BufferedReader(new FileReader(newFile))) {
                        String lineInFile;

                        while ((lineInFile = reader.readLine()) != null) {
                            buildFile += lineInFile + '\n';
                        }

                        String extension = aFile.getName().substring(aFile.getName().lastIndexOf(".") + 1).toLowerCase();

                        watchFolderTextArea.setText("File submitted: \"" + aFile.getName()
                                + "\" at " + date.toString() + '\n'
                                + buildFile
                                + '\n' + saveText);

                        switch (extension) {
                            case ("xml"):
                                System.out.println("Submitted XML File");
                                processXMLfile(APP_WATCH_FOLDER_LOCATION + '\\' + aFile.getName());
                                break;
                            default:
                                System.out.println("Submitted File Type: " + extension);
                                break;

                        }

                    }

                    if (newFile.delete()) {
                        System.out.println("File deleted successfully from: " + APP_WATCH_FOLDER_LOCATION);
                    } else {
                        System.out.println("Failed to delete the file from: " + APP_WATCH_FOLDER_LOCATION);
                    }
                } catch (Exception e) {
                    // handle the error
                    System.out.println("General Exception " + e.getMessage());

                } finally {
                } //end finally
            } else if (aFile.isDirectory()) {
                watchFolderTextArea.setText("Directory submitted: \"" + aFile.getName()
                        + "\" at " + date.toString() + '\n'
                        + '\n' + saveText);
            }
        }
    }

    private boolean processXMLfile(String xmlFile) {
        boolean fileProcessed = false;

        System.out.println("Prepare to parse: " + xmlFile);

        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {

                boolean bSensoDx = false;
                boolean bTest = false;
                boolean bInstrument = false;
                boolean bCartridge = false;
                boolean bAssayType = false;
                boolean bTestImages = false;
                boolean bImage = false;
                boolean bTimestamp = false;
                boolean bInfoPanel1 = false;
                boolean bInfoPanel2 = false;
                boolean bIsCartridgeValid = false;
                boolean bDiagTestResult = false;
                boolean bTestID = false;
                boolean bResultScore = false;

                String Instrument_attr_name = "";
                String Instrument_attr_value = "";
                String Cartridge_attr_name = "";
                String Cartridge_attr_value = "";
                String isCartridgeIDvalid = "";
                List<String> testImages;
                String imagePath = null;
                String testJobID = "";
                String testResultScore = "";

                List<String> imagePaths = new ArrayList<>();
                boolean allTestFilesFound = false;

                public void startElement(String uri, String localName, String qName,
                        Attributes attributes) throws SAXException {

//                    System.out.println("Start Element :" + qName);
                    if (qName.equalsIgnoreCase("SensoDx")) {
                        bSensoDx = true;
                    } else if (qName.equalsIgnoreCase("Test")) {
                        testImages = new ArrayList<>();
                        allTestFilesFound = true;
                        bTest = true;
                    } else if (qName.equalsIgnoreCase("Instrument")) {
                        bInstrument = true;
                        Instrument_attr_name = attributes.getQName(0);
                        Instrument_attr_value = attributes.getValue(0);
                        System.out.println("\t Instrument attr : " + Instrument_attr_name + " = " + Instrument_attr_value);

                    } else if (qName.equalsIgnoreCase("Cartridge")) {
                        bCartridge = true;
                        Cartridge_attr_name = attributes.getQName(0);
                        Cartridge_attr_value = attributes.getValue(0);
                        System.out.println("\t Cartridge attr : " + Cartridge_attr_name + " = " + Cartridge_attr_value);

                    } else if (qName.equalsIgnoreCase("AssayType")) {
                        bAssayType = true;
                    } else if (qName.equalsIgnoreCase("TestImages")) {
                        bTestImages = true;
                    } else if (qName.equalsIgnoreCase("Image")) {
                        bImage = true;
                    } else if (qName.equalsIgnoreCase("Timestamp")) {
                        bTimestamp = true;
                    } else if (qName.equalsIgnoreCase("InfoPanel1")) {
                        bInfoPanel1 = true;
                    } else if (qName.equalsIgnoreCase("InfoPanel2")) {
                        bInfoPanel2 = true;
                    } else if (qName.equalsIgnoreCase("isCartridgeValid")) {
                        bIsCartridgeValid = true;
                    } else if (qName.equalsIgnoreCase("DiagTestResult")) {
                        bDiagTestResult = true;
                    } else if (qName.equalsIgnoreCase("TestID")) {
                        bTestID = true;
                    } else if (qName.equalsIgnoreCase("ResultScore")) {
                        bResultScore = true;
                    }

                }

                public void endElement(String uri, String localName,
                        String qName) throws SAXException {

//                    System.out.println("End Element :" + qName);
                    if (qName.equalsIgnoreCase("Test")) {
                        Cartridge cartridge = new Cartridge();
                        Instrument instrument = new Instrument();
                        JDBCqueries queries = new JDBCqueries();

                        Panel2_TextArea.setText("Processing a Diagnostic Test\n"
                                + Panel2_TextArea.getText());

                        if (queries.isInstrumentInDatabase(Instrument_attr_value)) {

                            queries.getInstrumentMfgInfo(Instrument_attr_value, instrument);
                            queries.getInstrumentDeploymentInfo(Instrument_attr_value, instrument);

//                        instrument.setCartridgeTrustMeAllowed(false);
                            // if CartridgeID is TrustMe, create a "TrustMe" cartridge
                            boolean trustMeFailed = false;
                            if (Cartridge_attr_value.equals("TrustMe")) {
                                if (instrument.getCartridgeTrustMeAllowed()) {
                                    createTestCartridge(cartridge, Cartridge.DeploymentType.TrustMe);
                                    queries.insertCartridge(cartridge);
                                } else {
                                    // This instrument not configured to accept a "TrustMe" cartridge
                                    trustMeFailed = true;
                                }
                            } else {
                                cartridge.setCartridge_id(Cartridge_attr_value);
                                queries.getCartridgeMfgInfo(Cartridge_attr_value, cartridge);
                            }

                            // continue job processing if all test images in the job are present in file system
                            if (allTestFilesFound && !trustMeFailed) {

                                // verify >= 1 valid image
                                if (!testImages.isEmpty()) {
                                    TestInstance test = new TestInstance(testImages);

                                    if (SIMULATE_DIAG_ALG_RESULT) {
                                        test.setPatient_id("XYZ_HF");
                                        test.setTechnician_id("Mike HF Technician");
                                        test.setDoctor_id("Susan HF Doctor");
                                    }

                                    test.setClinical_test_timestamp(new Timestamp(System.currentTimeMillis()));

                                    if (test.verifyTestParameters(instrument, cartridge)) {

                                        queries.insertClinicalTestInstance(test);

                                        // request Diagnostic Test Result
                                        //    put test parameters in an xml file into watch folder
                                        BufferedWriter bw = null;
                                        FileWriter fw = null;
                                        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                                        try {
                                            String imagePathString = "";
                                            for (TestImage image : test.dicom.getTestImages()) {
                                                imagePathString += "<ImagePath>\n"
                                                        + image.getTestImagePath()
                                                        + "</ImagePath>\n";
                                            }

                                            fw = new FileWriter(DIAG_ALG_WATCH_FOLDER_LOCATION + "\\requestDiagResult.xml");
                                            bw = new BufferedWriter(fw);
                                            String resultString = "<SensoDx>\n"
                                                    + "<RequestDiagResult>\n"
                                                    + "<TestID>\n"
                                                    + test.getClinical_test_instance_counter()
                                                    + "</TestID>\n"
                                                    + "<AssayType>\n"
                                                    + cartridge.getAssay_type()
                                                    + "</AssayType>\n"
                                                    + "<TestImages>\n"
                                                    + imagePathString
                                                    + "</TestImages>\n"
                                                    + "<Timestamp>\n"
                                                    + timestamp.toString()
                                                    + "</Timestamp>\n"
                                                    + "</RequestDiagResult>\n"
                                                    + "</SensoDx>\n\n";

                                            bw.write(resultString);

                                        } catch (Exception e) {
                                            // handle the error
                                            System.out.println("\n" + "General Exception " + e.getMessage());
                                        } finally {

                                            try {
                                                if (bw != null) {
                                                    bw.close();
                                                }
                                                if (fw != null) {
                                                    fw.close();
                                                }
                                            } catch (IOException ex) {
                                                ex.printStackTrace();
                                            }
                                        }   //end finally

                                        if (SIMULATE_DIAG_ALG_RESULT) {
                                            // write a response in watchfolder that contains diag test result
                                            // into APP_WATCH_FOLDER_LOCATION
                                            try {
                                                String randomDiagResult = Double.toString(Math.random());
                                                Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
                                                fw = new FileWriter(APP_WATCH_FOLDER_LOCATION + "\\diagTestResult.xml");
                                                bw = new BufferedWriter(fw);
                                                String resultString = "<SensoDx>\n"
                                                        + "<DiagTestResult>\n"
                                                        + "<TestID>"
                                                        + test.getClinical_test_instance_counter()
                                                        + "</TestID>\n"
                                                        + "<ResultScore>"
                                                        + randomDiagResult
                                                        + "</ResultScore>\n"
                                                        + "<Timestamp>"
                                                        + timestamp2.toString()
                                                        + "</Timestamp>\n"
                                                        + "</DiagTestResult>\n"
                                                        + "</SensoDx>\n\n";

                                                bw.write(resultString);

                                            } catch (Exception e) {
                                                // handle the error
                                                System.out.println("\n" + "General Exception " + e.getMessage());
                                            } finally {

                                                try {
                                                    if (bw != null) {
                                                        bw.close();
                                                    }
                                                    if (fw != null) {
                                                        fw.close();
                                                    }
                                                } catch (IOException ex) {
                                                    ex.printStackTrace();
                                                }
                                            }   //end finally
                                        }
                                    }

                                    InfoTextArea.setText(test.getTestResultString());
                                } else {
                                    Errors error = new Errors();
//           
                                    error.buildErrorObject_JobWithNoTestImages(Instrument_attr_value,
                                            Cartridge_attr_value, null);

                                    queries.insertError(error);

                                    InfoTextArea.setText(error.toString());
//                                InfoTextArea.setText("Unable to process test with zero valid images provided\n");
                                }
                            } else if (trustMeFailed) {
                                Errors error = new Errors();

                                error.buildErrorObject_InstrumentNotTrustMeConfigured(Instrument_attr_value,
                                        Cartridge_attr_value, null);

                                queries.insertError(error);

                                InfoTextArea.setText(error.toString());

//                                InfoTextArea.setText(test.getTestResultString());
                            }
                        } else {
                            Errors error = new Errors();

                            error.buildErrorObject_InstrumentNotInDatabase(Instrument_attr_value,
                                    Cartridge_attr_value,
                                    null);

                            queries.insertError(error);

                            InfoTextArea.setText(error.toString());

                            error = null;
                        }

                        Panel2_TextArea.setText("Finished Processing a Diagnostic Test\n"
                                + Panel2_TextArea.getText());

                        System.out.println("END OF TEST INPUT");

                    } else if (qName.equalsIgnoreCase("isCartridgeValid")) {
                        System.out.println("END OF isCartridgeValid");

                        BufferedWriter bw = null;
                        FileWriter fw = null;
                        try {
                            JDBCqueries queries = new JDBCqueries();
//                            isCartridgeIDvalid = "TestCart"; // uncomment for testing only
                            boolean result
                                    = queries.isCartridgeInDatabase(isCartridgeIDvalid)
                                    && !queries.hasCartridgeBeenUsedInPreviousTest(isCartridgeIDvalid);

                            fw = new FileWriter(MC_WATCH_FOLDER_LOCATION + "\\validCartridge.xml");
                            bw = new BufferedWriter(fw);
                            String resultString = "<SensoDx>\n"
                                    + "   <isCartridgeValid_response cartridgeID=\""
                                    + isCartridgeIDvalid
                                    + "\">"
                                    + result
                                    + "</isCartridgeValid_response>\n"
                                    + "</SensoDx>\n\n";

                            bw.write(resultString);
                            Panel2_TextArea.setText(resultString + Panel2_TextArea.getText());

                            System.out.println(isCartridgeIDvalid + " is Valid? - " + result);

                        } catch (Exception e) {
                            // handle the error
                            System.out.println("\n" + "General Exception " + e.getMessage());
                        } finally {

                            try {
                                if (bw != null) {
                                    bw.close();
                                }
                                if (fw != null) {
                                    fw.close();
                                }
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }   //end finally
                    } else if (qName.equalsIgnoreCase("Image")) {
                        if (allTestFilesFound) {
                            File f = new File(imagePath);

                            if (f.exists()) {
                                testImages.add(imagePath);
                            } else {
                                allTestFilesFound = false;

                                Errors fileNotFoundError = new Errors();
                                JDBCqueries queries = new JDBCqueries();

                                fileNotFoundError.buildErrorObject_ClinicalTestImageNotFound(Instrument_attr_value,
                                        Cartridge_attr_value, null, imagePath);

                                queries.insertError(fileNotFoundError);

                                InfoTextArea.setText(fileNotFoundError.toString());
                                System.out.println("File " + imagePath + " not found!");
                            }
                        }

                    } else if (qName.equalsIgnoreCase("TestImages")) {
                        System.out.println("Test Images received: " + testImages.toString());
                    } else if (qName.equalsIgnoreCase("DiagTestResult")) {
//                        System.out.println("DiagTestResult: ");

                        JDBCqueries queries = new JDBCqueries();
                        List<String> images = new ArrayList<>();
                        TestInstance test = new TestInstance(images);

                        boolean getTestImages = true;
                        boolean deleteTestImages = true;
                        queries.getTestInstanceInfo(testJobID, test, getTestImages, deleteTestImages);

                        test.setAnalysis_result(Double.parseDouble(testResultScore));
                        queries.updateClinicalTestInstanceResultScore(test);

//                        InfoTextArea.setText(InfoTextArea.getText() + "\n\n" + test.toString());
                        InfoTextArea.setText(test.toString());
                        instrumentIDTextField.setText(test.getInstrument_id());
                        cartridgeIDTextField.setText(test.getCartridge_id());
                        testIDTextField.setText(Long.toString(test.getClinical_test_instance_counter()));

                        List<TestImage> imageIDList = test.dicom.getTestImages();
                        imageIDTextField.setText(Long.toString(imageIDList.get(0).getClinicalTestImage_id()));
                    }
                }

                public void characters(char ch[], int start, int length) throws SAXException {

                    java.util.Date date = new java.util.Date();

                    if (bSensoDx) {
//                        System.out.println("SensoDx : " + new String(ch, start, length));
                        bSensoDx = false;
                    } else if (bTest) {
//                        System.out.println("Test : " + new String(ch, start, length));
                        bTest = false;
                    } else if (bInstrument) {
//                        System.out.println("Instrument : " + new String(ch, start, length));
                        bInstrument = false;
                    } else if (bCartridge) {
//                        System.out.println("Cartridge : " + new String(ch, start, length));
                        bCartridge = false;
                    } else if (bAssayType) {
                        System.out.println("AssayType : " + new String(ch, start, length));
                        bAssayType = false;
                    } else if (bTestImages) {
//                        System.out.println("TestImages : " + new String(ch, start, length));
                        bTestImages = false;
                    } else if (bImage) {
                        imagePath = new String(ch, start, length);
//                        System.out.println("Image : " + imagePath);
                        bImage = false;
                    } else if (bTimestamp) {
                        System.out.println("Timestamp : " + new String(ch, start, length));
                        bTimestamp = false;
                    } else if (bInfoPanel1) {
                        System.out.println("InfoPanel1 : " + new String(ch, start, length));
                        Panel1_TextArea.setText(date.toString() + '\n'
                                + new String(ch, start, length) + '\n' + '\n'
                                + Panel1_TextArea.getText());
                        bInfoPanel1 = false;
                    } else if (bInfoPanel2) {
                        System.out.println("InfoPanel2 : " + new String(ch, start, length));
                        Panel2_TextArea.setText(date.toString() + '\n'
                                + new String(ch, start, length) + '\n' + '\n'
                                + Panel2_TextArea.getText());
                        bInfoPanel2 = false;
                    } else if (bIsCartridgeValid) {
                        isCartridgeIDvalid = new String(ch, start, length);
                        System.out.println("isCartridgeValid : " + isCartridgeIDvalid);
                        bIsCartridgeValid = false;
                    } else if (bTestID) {
                        testJobID = new String(ch, start, length);
                        System.out.println("Test ID : " + testJobID);
                        bTestID = false;
                    } else if (bResultScore) {
                        testResultScore = new String(ch, start, length);
                        System.out.println("Result Score : " + testResultScore);
                        bResultScore = false;
                    }

                }

            };

            saxParser.parse(xmlFile, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }

/////////////////
        fileProcessed = true;

        return (fileProcessed);
    }

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
            java.util.logging.Logger.getLogger(InstrumentUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InstrumentUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InstrumentUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InstrumentUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JPanel Buttons_Panel;
    private javax.swing.JButton CartridgeInfoButton;
    private javax.swing.JButton GetImageButton;
    private javax.swing.JTextArea InfoTextArea;
    private javax.swing.JScrollPane Info_ScrollPane;
    private javax.swing.JPanel InsertCartridge_Panel;
    private javax.swing.JButton InstrumentInfoButton;
    private javax.swing.JPanel Panel1_Panel;
    private javax.swing.JScrollPane Panel1_ScrollPane;
    private javax.swing.JTextArea Panel1_TextArea;
    private javax.swing.JPanel Panel2_Panel;
    private javax.swing.JScrollPane Panel2_ScrollPane;
    private javax.swing.JTextArea Panel2_TextArea;
    private javax.swing.JPanel QueryPanel;
    private javax.swing.JComboBox<String> SelectObjectComboBox;
    private javax.swing.JButton SimulateInsertCartridgeButton;
    private javax.swing.JButton TestInfoButton;
    private javax.swing.JCheckBox UseLocalDBcheckBox;
    private javax.swing.JPanel WatchFolderPanel;
    private javax.swing.JScrollPane WatchFolderScrollPane;
    private javax.swing.JTextField cartridgeIDTextField;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JTextField imageIDTextField;
    private javax.swing.JPanel instrumentButtons;
    private javax.swing.JTextField instrumentIDTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel leftSideInfoPanel;
    private javax.swing.JPanel rightSide;
    private javax.swing.JTextField testIDTextField;
    private javax.swing.JTextArea watchFolderTextArea;
    // End of variables declaration//GEN-END:variables
}
