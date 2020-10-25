/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

/**
 *
 * @author arshiagiri
 */
public class Globalvariables {
    
    private Collection admindat;
    private Collection studentdat;
    private Adminregister adminregister;
    private Adminlogin adminlogin;
    
   
    
    public Collection getAdmindat() {
        if (admindat== null){
            admindat= new Collection();
                }
        return admindat;
    }

    public void setAdmindat(Collection admindat) {
        this.admindat = admindat;
    }

    public Collection getStudentdat() {
        if (studentdat== null){
            studentdat= new Collection();
                }
        return studentdat;
    }

    public void setStudentdat(Collection studentdat) {
        this.studentdat = studentdat;
    }

    public Adminregister getAdminregister() {
        if (adminregister== null){
           adminregister= new Adminregister();
       }
        return adminregister;
    }

    public void setAdminregister(Adminregister adminregister) {
        this.adminregister = adminregister;
    }
    
    public Adminlogin getAdminlogin() {
        if (adminlogin== null){
           adminlogin= new Adminlogin();
       }
        return adminlogin;
    }

    public void setAdminlogin(Adminlogin adminlogin) {
        this.adminlogin = adminlogin;
    }
    
    public Collection getstud(){
         return studentdat;
     }
    
    public Collection getAdmin(){
        return admindat;
    }
    
    
}
