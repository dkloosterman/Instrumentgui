package JDBCqueries_pkg;

import java.sql.*;
import java.util.*;
import Instrument_pkg.Instrument;
import Cartridge_pkg.Cartridge;

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
                cartridge.setAssay_type(rs.getString("assay_type"));
                cartridge.setSubsystem_1_id(rs.getString("subsystem_1_id"));
                cartridge.setSubsystem_2_id(rs.getString("subsystem_2_id"));
                cartridge.setSubsystem_3_id(rs.getString("subsystem_3_id"));
            }

//            while (rs.next()) {
//
//                String cartridge_id = rs.getString("cartridge_id");
//                java.sql.Timestamp manufactured_timestamp = rs.getTimestamp("manufactured_timestamp");
//                String manufactured_location = rs.getString("manufactured_location");
//                String assay_type = rs.getString("assay_type");
//                String subsystem_1_id = rs.getString("subsystem_1_id");
//                String subsystem_2_id = rs.getString("subsystem_2_id");
//                String subsystem_3_id = rs.getString("subsystem_3_id");
//
//                display += "\n\t Cartridge ID: " + cartridge_id
//                        + "\n\t Mfg Location: " + manufactured_location
//                        + "\n\t Cartridge Assay Type: " + assay_type
//                        + "\n\t Sub 1 ID: " + subsystem_1_id
//                        + "\n\t Sub 2 ID:" + subsystem_2_id
//                        + "\n\t Sub 3 ID:: " + subsystem_3_id
//                        + "\n\t Mfg. Timestamp: " + manufactured_timestamp + "\n";
//            }

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

    public void createCartridge(Cartridge cartridge) {
        String display = null;

        try {
            // temp code : create a cartridge ID from the current timestamp
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String cartID = timestamp.toString();

            cartID = cartID.replace(" ", "");
            cartID = cartID.replace(":", "");
            cartID = cartID.replace(".", "");
            cartID = cartID.replace("-", "");

            sql = "INSERT INTO Cartridge_Manufactured VALUES "
                    + "('" + cartID + "', '2017-03-29 08:59:00', 'Perinton, NY', '0010 0000 0000 0000', "
                    + "'0000000010000002', '0000000020000002', '0000000030000002')";

            // get and display data for seleted Instrument ID
            stmt.executeUpdate(sql);
            
            cartridge.setCartridge_id(cartID);

//            return (cartridge);

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
                instrument.setAssay_types_enabled(rs.getString("assay_types_enabled"));
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

}
