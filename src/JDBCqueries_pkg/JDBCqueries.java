package JDBCqueries_pkg;

import java.sql.*;
import java.util.*;
import Instrument_pkg.Instrument;
import Cartridge_pkg.Cartridge;
import TestInstance_pkg.*;
import java.io.*;
import java.util.Date;

/**
 *
 * @author David Kloosterman
 */
public class JDBCqueries {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/sensodx_sql_db?useSSL=false";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "rootMysql151";

    Connection conn = null;
    String sql = null;
    Statement stmt = null;
    ResultSet rs = null;

    public JDBCqueries() {

        String display = null;

        try {
//            get JDBC ready for SQL queries
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (ClassNotFoundException e) {
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
    }

    // Cartridge queries
    public void getCartridgeMfgInfo(Cartridge cartridge) {

        String display = "Cartridge  Manufacturing Information \n";

        try {

            // get and display data for seleted Instrument ID
            sql = "SELECT * FROM Cartridge_Manufactured WHERE cartridge_id = " + cartridge.getCartridge_id();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                cartridge.setCartridge_id(rs.getString("cartridge_id"));
                cartridge.setManufactured_timestamp(rs.getTimestamp("manufactured_timestamp"));
                cartridge.setManufactured_location(rs.getString("manufactured_location"));
                cartridge.setAssay_type(rs.getInt("assay_type"));
                cartridge.setSubsystem_1_id(rs.getString("subsystem_1_id"));
                cartridge.setSubsystem_2_id(rs.getString("subsystem_2_id"));
                cartridge.setSubsystem_3_id(rs.getString("subsystem_3_id"));
            }

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

        }   //end finally try
//        return (display);
    }

    public void insertCartridge(Cartridge cartridge) {
        String display = null;

        try {
            sql = "INSERT INTO Cartridge_Manufactured VALUES "
                    + "('" + cartridge.getCartridge_id()
                    + "', '" + cartridge.getManufactured_timestamp()
                    + "', '" + cartridge.getManufactured_location()
                    + "', '" + cartridge.getAssay_type()
                    + "', '" + cartridge.getSubsystem_1_id()
                    + "', '" + cartridge.getSubsystem_2_id()
                    + "', '" + cartridge.getSubsystem_3_id() + "')";

            // get and display data for seleted Instrument ID
            stmt.executeUpdate(sql);

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

        }   //end finally try

    }

    // Instrument quesries
    public String getInstrumentDeploymentInfo(String instrID, Instrument instrument) {

        String display = "Instrument Deployment Information";

        try {
            // get and display data for seleted Instrument ID
            sql = "SELECT * FROM Instrument_Deployed WHERE instrument_id = " + instrID;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                instrument.setInstrument_id(rs.getString("instrument_id"));
                instrument.setInstallation_timestamp(rs.getTimestamp("installation_timestamp"));
                instrument.setCustomer_id(rs.getString("customer_id"));
                instrument.setCustomer_name(rs.getString("customer_name"));
                instrument.setCustomer_location(rs.getString("customer_location"));
                instrument.setContact_telephone(rs.getString("contact_telephone"));
                instrument.setContact_email(rs.getString("contact_email"));
                instrument.setCustomer_since(rs.getTimestamp("customer_since"));
                instrument.setAssay_types_enabled(rs.getInt("assay_types_enabled"));
            }

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

        }   //end finally try
        return (display);
    }

    public ArrayList getAllInstrumentIDs() {

        String display = null;
        ArrayList<String> allInstrIDs = new ArrayList<String>();

        try {

            sql = "SELECT instrument_id FROM Instrument_Manufactured";
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                allInstrIDs.add(rs.getString("instrument_id"));
            } // end while (rs.next()) 

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
        return (allInstrIDs);
    }

    public String getInstrumentMfgInfo(String forInstrID, Instrument instrument) {

        String display = "Instrument  Manufacturing Information \n";

        try {
            // get and display data for seleted Instrument ID
            sql = "SELECT * FROM Instrument_Manufactured WHERE instrument_id = " + forInstrID;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                instrument.setInstrument_id(rs.getString("instrument_id"));
                instrument.setManufactured_timestamp(rs.getTimestamp("manufactured_timestamp"));
                instrument.setManufactured_location(rs.getString("manufactured_location"));
                instrument.setSubsystem_1_id(rs.getString("subsystem_1_id"));
                instrument.setSubsystem_2_id(rs.getString("subsystem_2_id"));
                instrument.setSubsystem_3_id(rs.getString("subsystem_3_id"));
            }

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

        }   //end finally try
        return (display);
    }

    // Test Instance queries
    public void insertTestInstance(TestInstance test) {
        String display = null;

        try {
            /*
             (cartridge_id, instrument_id, patient_id, technician_id, doctor_id, 
             raw_assay_data, analysis_result, clinical_test_timestamp)
             */
            sql = "INSERT INTO Clinical_Test_Instance "
                    + "(cartridge_id, instrument_id, patient_id, technician_id, doctor_id, raw_assay_data, analysis_result, clinical_test_timestamp) "
                    + "VALUES "
                    + "('" + test.getCartridge_id() + "', '" + test.getInstrument_id()
                    + "', '" + test.getPatient_id() + "', '" + test.getTechnician_id()
                    + "', '" + test.getDoctor_id() + "', '" + test.getRaw_assay_data()
                    + "', '" + test.getAnalysis_result()
                    + "', '" + test.getClinical_test_timestamp() + "')";

            // get and display data for seleted Instrument ID
            stmt.executeUpdate(sql);
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

        }   //end finally try
    }

    public void getTestInstanceCounter(TestInstance test, String cartidgeID) {

        String display = null;

        try {
            sql = "SELECT * FROM Clinical_Test_Instance WHERE cartridge_id = " + cartidgeID;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                test.setClinical_test_counter(rs.getLong("clinical_test_counter"));

            }

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

        }   //end finally try
    }

    public long insertClinicalTestImage(DICOM dicom) {
        String display = null;
        long image_id = 0;
        PreparedStatement psmnt = null;

        try {
            /*
                CREATE TABLE Clinical_Test_Images (
                       clinical_test_image_counter        BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
                       image           blob,
                       image_timestamp VARCHAR (25),
                       PRIMARY KEY (image_id )
                );
             */
            String currentTimestamp = dicom.getTimestamp().toString();
            currentTimestamp = currentTimestamp.replace(" ", "");
            currentTimestamp = currentTimestamp.replace(":", "");
            currentTimestamp = currentTimestamp.replace(".", "");
            currentTimestamp = currentTimestamp.replace("-", "");

            File imageFile = new File(dicom.getClinicalTestFilePathInInstrument());
            FileInputStream fis = new FileInputStream(imageFile);
            psmnt = conn.prepareStatement("INSERT INTO Clinical_Test_Images(image, image_timestamp) " + "VALUES(?,?)");
            psmnt.setBinaryStream(1, (InputStream) fis, (int) (imageFile.length()));
            psmnt.setString(2,currentTimestamp);
            int s = psmnt.executeUpdate();
            if (s > 0) {
                sql = "SELECT * FROM Clinical_Test_Images WHERE image_timestamp = " + currentTimestamp;
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    image_id = rs.getLong("clinical_test_image_counter");
                    dicom.setClinicalTestImage_id(image_id);
                    dicom.setClinicalTestImage_length(imageFile.length());
                }
                System.out.println("Image Uploaded successfully !");
            } else {
                System.out.println("unsucessfull to upload image.");
            }
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
            return (image_id);
        }   //end finally try
    }
}
