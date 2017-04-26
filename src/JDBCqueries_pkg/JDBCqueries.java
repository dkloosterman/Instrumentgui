package JDBCqueries_pkg;

import java.sql.*;
import java.util.*;

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

    public String getCartridgeMfgInfo(String forCartID) {

        String display = "Cartridge  Manufacturing Information \n";

        try {

            // get and display data for seleted Instrument ID
            sql = "SELECT * FROM Cartridge_Manufactured WHERE cartridge_id = " + forCartID;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {

                String cartridge_id = rs.getString("cartridge_id");
                java.sql.Timestamp manufactured_timestamp = rs.getTimestamp("manufactured_timestamp");
                String manufactured_location = rs.getString("manufactured_location");
                String assay_type = rs.getString("assay_type");
                String subsystem_1_id = rs.getString("subsystem_1_id");
                String subsystem_2_id = rs.getString("subsystem_2_id");
                String subsystem_3_id = rs.getString("subsystem_3_id");

                display += "\n\t Cartridge ID: " + cartridge_id
                        + "\n\t Mfg Location: " + manufactured_location
                        + "\n\t Cartridge Assay Type: " + assay_type
                        + "\n\t Sub 1 ID: " + subsystem_1_id
                        + "\n\t Sub 2 ID:" + subsystem_2_id
                        + "\n\t Sub 3 ID:: " + subsystem_3_id
                        + "\n\t Mfg. Timestamp: " + manufactured_timestamp + "\n";
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

    public String createCartridge() {
        String display = null;

        try {
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

            return (cartID);

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

    public String getInstrumentDeploymentInfo(String forInstrID) {

        String display = "Instrument Deployment Information";

        try {
            // get and display data for seleted Instrument ID
            sql = "SELECT * FROM Instrument_Deployed WHERE instrument_id = " + forInstrID;
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String instrumentID = rs.getString("instrument_id");
                java.sql.Timestamp time = rs.getTimestamp("installation_timestamp");
                String customer_id = rs.getString("customer_id");
                String customer_name = rs.getString("customer_name");
                String customer_location = rs.getString("customer_location");
                String contact_name = rs.getString("contact_name");
                String contact_telephone = rs.getString("contact_telephone");
                String contact_email = rs.getString("contact_email");
                java.sql.Date customer_since = rs.getDate("customer_since");
                String assay_types_enabled = rs.getString("assay_types_enabled");

                display += "\n\t ID: " + instrumentID
                        + "\n\t installed: " + time
                        + "\n\t customer id: " + customer_id
                        + "\n\t customer name: " + customer_name
                        + "\n\t customer location: " + customer_location
                        + "\n\t contact name: " + contact_name
                        + "\n\t contact phone: " + contact_telephone
                        + "\n\t contact email: " + contact_email
                        + "\n\t customer since: " + customer_since
                        + "\n\t assays enabled: " + assay_types_enabled + "\n";
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

    public String getInstrumentMfgInfo(String forInstrID) {

        String display = "Instrument  Manufacturing Information \n";

        try {
            // get and display data for seleted Instrument ID
            sql = "SELECT * FROM Instrument_Manufactured WHERE instrument_id = " + forInstrID;
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                String instrumentID = rs.getString("instrument_id");
                java.sql.Timestamp mfg_time = rs.getTimestamp("manufactured_timestamp");
                String location = rs.getString("manufactured_location");
                String sub1 = rs.getString("subsystem_1_id");
                String sub2 = rs.getString("subsystem_2_id");
                String sub3 = rs.getString("subsystem_3_id");
                display += "\t ID: " + instrumentID
                        + "\n\t timestamp: " + mfg_time
                        + "\n\t location: " + location
                        + "\n\t sub1: " + sub1
                        + "\n\t sub2: " + sub2
                        + "\n\t sub3: " + sub3
                        + "\n";
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

        }   //end finally try
        return (display);
    }

}
