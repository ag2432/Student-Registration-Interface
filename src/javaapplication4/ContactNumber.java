/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.Serializable;

/**
 *
 * @author arshiagiri
 */

class ContactNumber implements Serializable {
    private String contactnumber;

    @Override
    public String toString() {
        return "{" + "contactnumber=" + contactnumber + '}';
    }

    public ContactNumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    
    
   

    
    
}