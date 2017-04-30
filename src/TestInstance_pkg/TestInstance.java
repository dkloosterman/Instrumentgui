/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestInstance_pkg;

import Cartridge_pkg.Cartridge;
import Instrument_pkg.Instrument;
import java.sql.Timestamp;
import java.util.Date;
import JDBCqueries_pkg.JDBCqueries;

/**
 *
 * @author David Kloosterman
 */
public class TestInstance {

    /*
    CREATE TABLE Clinical_Test_Instance (
       cartridge_id VARCHAR (20),
       instrument_id VARCHAR (20),
       patient_id VARCHAR (20),
       technician_id VARCHAR (20),
       doctor_id VARCHAR (20),
       raw_assay_data VARCHAR (100),
       analysis_result VARCHAR (100),
       clinical_test_timestamp TIMESTAMP,
       PRIMARY KEY (cartridge_id ) );
     */
    
    long   clinical_test_counter = 0;
    String cartridge_id = null;
    String instrument_id = null;
    String patient_id = null;
    String technician_id = null;
    String doctor_id = null;
    String raw_assay_data = null;
    double analysis_result = 0;
    Date clinical_test_timestamp = null;
    
    DICOM dicom = null;
    JDBCqueries queries = null;

    public TestInstance() {
        queries = new JDBCqueries();

    }

    public void processTest(Instrument instrument, Cartridge cartridge) {
        this.instrument_id = instrument.getInstrument_id();
        this.cartridge_id = cartridge.getCartridge_id();
        
        // insert future code to verify this cartridge with this instrument
        
        this.patient_id = "5555555555";
        this.technician_id = "Jane Technician";
        this.doctor_id = "Joe Doctor";
        this.raw_assay_data = "pointerToImage";
        
        // insert future algorithm logic here
        
        this.analysis_result = Math.random();
        
        this.clinical_test_timestamp = new Timestamp(System.currentTimeMillis());
        
        this.dicom = new DICOM();
        this.dicom.patient_id = this.patient_id;
        this.dicom.timestamp = this.clinical_test_timestamp;
        this.dicom.image = null;
        
        queries.insertTestInstance(this);
        queries.getTestInstanceCounter(this, this.cartridge_id);
     }

    @Override
    public String toString() {
        return "Test Instance"
                + "\n   clinical_test_counter = \t\t" + clinical_test_counter
                + "\n   cartridge_id = \t\t" + cartridge_id
                + "\n   instrument_id = \t" + instrument_id
                + "\n   patient_id = \t\t" + patient_id
                + "\n   technician_id = \t" + technician_id
                + "\n   doctor_id = \t\t" + doctor_id
                + "\n   raw_assay_data = \t" + raw_assay_data
                + "\n   analysis_result = \t" + analysis_result
                + "\n   clinical_test_timestamp = \t" + clinical_test_timestamp
                + "\n"
                + dicom.toString();
    }

    public long getClinical_test_counter() {
        return clinical_test_counter;
    }
    
    public void setClinical_test_counter(long clinical_test_counter) {
        this.clinical_test_counter = clinical_test_counter;
    }

    public String getCartridge_id() {
        return cartridge_id;
    }

    public void setCartridge_id(String cartridge_id) {
        this.cartridge_id = cartridge_id;
    }

    public String getInstrument_id() {
        return instrument_id;
    }

    public void setInstrument_id(String instrument_id) {
        this.instrument_id = instrument_id;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public String getTechnician_id() {
        return technician_id;
    }

    public void setTechnician_id(String technician_id) {
        this.technician_id = technician_id;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getRaw_assay_data() {
        return raw_assay_data;
    }

    public void setRaw_assay_data(String raw_assay_data) {
        this.raw_assay_data = raw_assay_data;
    }

    public double getAnalysis_result() {
        return analysis_result;
    }

    public void setAnalysis_result(double analysis_result) {
        this.analysis_result = analysis_result;
    }

    public Date getClinical_test_timestamp() {
        return clinical_test_timestamp;
    }

    public void setClinical_test_timestamp(Date clinical_test_timestamp) {
        this.clinical_test_timestamp = clinical_test_timestamp;
    }

}
