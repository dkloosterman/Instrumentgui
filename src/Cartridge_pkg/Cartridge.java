/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartridge_pkg;

import java.util.Date;

/**
 *
 * @author David Kloosterman
 */
public class Cartridge {
    
    /*
    CREATE TABLE Cartridge_Manufactured (
       cartridge_id VARCHAR (20),
       manufactured_timestamp TIMESTAMP,
       manufactured_location TEXT,
       assay_type VARCHAR (50),
       subsystem_1_id VARCHAR (20),
       subsystem_2_id VARCHAR (20),
       subsystem_3_id VARCHAR (20),
       PRIMARY KEY (cartridge_id ) );
    */
    String cartridge_id;
    Date manufactured_timestamp;
    String manufactured_location;
    String assay_type;
    String subsystem_1_id;
    String subsystem_2_id;
    String subsystem_3_id;

    @Override
    public String toString() {
        return "Cartridge{" + "cartridge_id=" + cartridge_id + ", manufactured_timestamp=" + manufactured_timestamp + ", manufactured_location=" + manufactured_location + ", assay_type=" + assay_type + ", subsystem_1_id=" + subsystem_1_id + ", subsystem_2_id=" + subsystem_2_id + ", subsystem_3_id=" + subsystem_3_id + '}';
    }

    public String getCartridge_id() {
        return cartridge_id;
    }

    public void setCartridge_id(String cartridge_id) {
        this.cartridge_id = cartridge_id;
    }

    public Date getManufactured_timestamp() {
        return manufactured_timestamp;
    }

    public void setManufactured_timestamp(Date manufactured_timestamp) {
        this.manufactured_timestamp = manufactured_timestamp;
    }

    public String getManufactured_location() {
        return manufactured_location;
    }

    public void setManufactured_location(String manufactured_location) {
        this.manufactured_location = manufactured_location;
    }

    public String getAssay_type() {
        return assay_type;
    }

    public void setAssay_type(String assay_type) {
        this.assay_type = assay_type;
    }

    public String getSubsystem_1_id() {
        return subsystem_1_id;
    }

    public void setSubsystem_1_id(String subsystem_1_id) {
        this.subsystem_1_id = subsystem_1_id;
    }

    public String getSubsystem_2_id() {
        return subsystem_2_id;
    }

    public void setSubsystem_2_id(String subsystem_2_id) {
        this.subsystem_2_id = subsystem_2_id;
    }

    public String getSubsystem_3_id() {
        return subsystem_3_id;
    }

    public void setSubsystem_3_id(String subsystem_3_id) {
        this.subsystem_3_id = subsystem_3_id;
    }
    
}