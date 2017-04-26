/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Instrument_pkg;

import java.util.Date;

/**
 *
 * @author David Kloosterman
 */
public class Instrument {

    /*
    CREATE TABLE Instrument_Deployed (
       instrument_id VARCHAR (20),
       installation_timestamp TIMESTAMP,
       customer_id VARCHAR (20),
       customer_name VARCHAR (50),
       customer_location TEXT,
       contact_name VARCHAR (50),
       contact_telephone VARCHAR (25),
       contact_email VARCHAR (50),
       customer_since DATE DEFAULT '0000-00-00',
       assay_types_enabled VARCHAR (50),
       PRIMARY KEY (instrument_id )  );
     */
    String instrument_id;
    Date installation_timestamp;
    String customer_id;
    String customer_name;
    String customer_location;
    String contact_telephone;
    String contact_email;
    Date customer_since;
    String assay_types_enabled;

    @Override
    public String toString() {
        return "Instrument{" + "instrument_id=" + instrument_id + ", installation_timestamp=" + installation_timestamp + ", customer_id=" + customer_id + ", customer_name=" + customer_name + ", customer_location=" + customer_location + ", contact_telephone=" + contact_telephone + ", contact_email=" + contact_email + ", customer_since=" + customer_since + ", assay_types_enabled=" + assay_types_enabled + '}';
    }

    public Date getInstallation_timestamp() {
        return installation_timestamp;
    }

    public void setInstallation_timestamp(Date installation_timestamp) {
        this.installation_timestamp = installation_timestamp;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_location() {
        return customer_location;
    }

    public void setCustomer_location(String customer_location) {
        this.customer_location = customer_location;
    }

    public String getContact_telephone() {
        return contact_telephone;
    }

    public void setContact_telephone(String contact_telephone) {
        this.contact_telephone = contact_telephone;
    }

    public String getContact_email() {
        return contact_email;
    }

    public void setContact_email(String contact_email) {
        this.contact_email = contact_email;
    }

    public Date getCustomer_since() {
        return customer_since;
    }

    public void setCustomer_since(Date customer_since) {
        this.customer_since = customer_since;
    }

    public String getAssay_types_enabled() {
        return assay_types_enabled;
    }

    public void setAssay_types_enabled(String assay_types_enabled) {
        this.assay_types_enabled = assay_types_enabled;
    }

    public String getInstrument_id() {
        return instrument_id;
    }

    public void setInstrument_id(String instrument_id) {
        this.instrument_id = instrument_id;
    }
    
}
