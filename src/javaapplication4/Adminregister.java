/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.Serializable;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;     
import static javaapplication4.Createconnection.getConnection;

/**
 *
 * @author arshiagiri
 */
public class Adminregister implements Serializable{
    
  
    public void adminregister (Globalvariables global, Mainmenu mainmenu, Studentdata studentdata) throws ClassNotFoundException, SQLException{
        
        Connection con= getConnection();
        PreparedStatement admininsertstatement= null;
        boolean inputValid = false;
        while (!inputValid){

        
        try {
            
        System.out.println("Please enter name: ");
        Scanner b = new Scanner(System.in);
        String name= b.nextLine();    
        
        System.out.println("Please enter email: ");
        Scanner c = new Scanner(System.in);
        String email = c.nextLine();        
        
        System.out.println("Please enter mobile number: ");
        Scanner d = new Scanner(System.in);
        String mobileNumber = d.nextLine();    
        
        System.out.println("Please enter username: ");
        Scanner e = new Scanner(System.in);
        String username = e.nextLine();    
        
        System.out.println("Please enter password: ");
        Scanner f = new Scanner(System.in);
        String password= f.nextLine();    
        
        System.out.println("Please confirm password: ");
        Scanner g = new Scanner(System.in);
        String confirmPassword = g.nextLine();    
        
        
        if (password.equals(confirmPassword)) {
            inputValid = true;
            String admininsertquery= "insert into Admins(Name, Email, Mobile_number, Username, Password) values (?,?,?,?,?)";
            admininsertstatement= con.prepareStatement(admininsertquery); 
            admininsertstatement.setString(1, name);
            admininsertstatement.setString(2, email);
            admininsertstatement.setString(3, mobileNumber);
            admininsertstatement.setString(4, username);
            admininsertstatement.setString(5, password);
            int count = admininsertstatement.executeUpdate();
            mainmenu.mainme(global, mainmenu, studentdata);
        }
        
        else {
            System.out.println("Password don't match.");
            System.out.println("Enter data again.");
            System.out.println("");
            
        }
        
        } catch (Exception e) {
        System.out.println("You didn't enter a valid data ");
        System.out.println("Enter data again.");
        System.out.println("");
}
    finally{
        admininsertstatement.close();
        con.close();
    }
        }
        }}
        
       