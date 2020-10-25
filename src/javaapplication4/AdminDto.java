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
public class AdminDto {
    int adminid;
    String name;
    String Email;
    String email;
    String mobilenumber; 
    String Username; 
    String password; 

    public AdminDto(int adminid, String name, String Email, String email, String mobilenumber, String Username, String password) {
        this.adminid = adminid;
        this.name = name;
        this.Email = Email;
        this.email = email;
        this.mobilenumber = mobilenumber;
        this.Username = Username;
        this.password = password;
    }

    public AdminDto() {
    }

    public int getAdminid() {
        return adminid;
    }

    public void setAdminid(int adminid) {
        this.adminid = adminid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }


    public String getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
            
    
}
