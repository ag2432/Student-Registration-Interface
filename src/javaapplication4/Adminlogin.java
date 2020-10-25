/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import static javaapplication4.Createconnection.getConnection;
/**
 *
 * @author arshiagiri
 */
public class Adminlogin implements Serializable {
    
    
    
     public void adminlogin (Globalvariables global, Mainmenu mainmenu, Studentdata studentdata) throws SQLException, ClassNotFoundException{
        
        System.out.println("Please enter username: ");
        Scanner e = new Scanner(System.in);
        String username = e.nextLine();    
        
        System.out.println("Please enter password: ");
        Scanner f = new Scanner(System.in);
        String passw= f.nextLine();
        
        Connection con= getConnection();
        PreparedStatement s= null;
        
        try{
            
            
            String quer = "SELECT Admin_ID AS adminid, Name AS name, Email AS email, Mobile_number AS mobilenumber, Username AS usernam, Password AS password FROM Admins WHERE Username= ?";
            s= con.prepareStatement(quer);
            s.setString(1, username);
            ResultSet rs= s.executeQuery();
            AdminDto adminDto = new AdminDto();
            
            while (rs.next()) {
                
                adminDto.setAdminid(rs.getInt("adminid"));
                adminDto.setName(rs.getString("name"));
                adminDto.setEmail(rs.getString("email"));
                adminDto.setMobilenumber(rs.getString("mobilenumber"));
                adminDto.setUsername(rs.getString("usernam"));
                adminDto.setPassword(rs.getString("password"));
                
           
        }
            if (adminDto.getPassword().equals(passw)){
                studentdata.studentdata(global, studentdata);
            }
            
            
        
            else {
            mainmenu.mainme(global, mainmenu, studentdata);
            }   
            
        }
        
        catch (Exception e1){
            System.out.println("You entered invalid data");
            mainmenu.mainme(global, mainmenu, studentdata);
        }
        finally{
            s.close();
            con.close();
        }
        }}