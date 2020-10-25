/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author arshiagiri
 */
public class Collection {
    private Map <Integer, Student> studentdata = new HashMap<>();
    private Map <String, Admin> admindata;
    
    public Map<Integer, Student> getStudentdata() {
        return studentdata;
    }
    
    public void addstudents(int id, Student student){
        studentdata.put(id, student);
    }
    
    public void setStudentdata(Map<Integer, Student> studentdata) {
        studentdata = studentdata;
    }
    
    

    public Map<String, Admin> getAdmindata() {
        if (admindata== null){
            admindata = new HashMap<>();
        }
        
        return admindata;
    }

    public void setAdmindata(Map<String, Admin> admindata) {
        this.admindata = admindata;
    }
    
    public void addadmin(String name, Admin admin){
        admindata.put(name, admin);
    }
    
    
}
