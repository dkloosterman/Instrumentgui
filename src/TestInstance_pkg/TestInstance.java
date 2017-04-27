/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestInstance_pkg;

import java.util.Date;

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
    String cartridge_id = null;
    String instrument_id = null;
    String patient_id = null;
    String technician_id = null;
    String doctor_id = null;
    String raw_assay_data = null;
    String analysis_result = null;
    Date clinical_test_timestamp = null;
    DICOM dicom = null;

    public TestInstance() {

    }

    @Override
    public String toString() {
        return  "TestInstance" 
                + "\n   cartridge_id = \t" + cartridge_id 
                + "\n   instrument_id = \t" + instrument_id 
                + "\n   patient_id = \t" + patient_id 
                + "\n   technician_id = \t" + technician_id 
                + "\n   doctor_id = \t" + doctor_id 
                + "\n   raw_assay_data = \t" + raw_assay_data 
                + "\n   analysis_result = \t" + analysis_result 
                + "\n   clinical_test_timestamp = \t" + clinical_test_timestamp
                + "\n"
                + dicom.toString();
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

    public String getAnalysis_result() {
        return analysis_result;
    }

    public void setAnalysis_result(String analysis_result) {
        this.analysis_result = analysis_result;
    }

    public Date getClinical_test_timestamp() {
        return clinical_test_timestamp;
    }

    public void setClinical_test_timestamp(Date clinical_test_timestamp) {
        this.clinical_test_timestamp = clinical_test_timestamp;
    }

}
