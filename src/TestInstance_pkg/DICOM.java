/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestInstance_pkg;

//import java.awt.Image.*;
import java.awt.image.BufferedImage;
import java.util.Date;

/**
 *
 * @author David Kloosterman
 */
public class DICOM {
    
    String patient_id = null;
    Date timestamp = null;
    BufferedImage image = null;

     public DICOM() {
        
    }
    
    @Override
    public String toString() {
        return "\nDICOM" 
                + "\n   patient_id =\t\t" + patient_id 
                + "\n   timestamp =\t\t" + timestamp 
                + "\n   image =\t\t" + image;
    }

    public String getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(String patient_id) {
        this.patient_id = patient_id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
   
}
