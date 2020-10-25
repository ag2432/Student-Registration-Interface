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

    
class Admin {
    
    private int id;
    private String name;
    private String email;
    private String mobileNumber;
    private String username;
    String password;
    
    Admin(int a, String b, String c, String d, String e, String f){
        id= a;
        name= b;
        email= c;
        mobileNumber= d;
        username= e;
        password= f;
        
    }
    
    public String getUsername(){
       
        return username;
    }
    
    public String getPassword(){
        return password;
    }
}

    




  
        
    
    

