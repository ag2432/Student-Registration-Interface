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
public class Mainmenu implements Serializable {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Mainmenu mainm= new Mainmenu();
        Globalvariables global= new Globalvariables();
        Studentdata studentdata= new Studentdata();
        Connection con= getConnection();
        PreparedStatement createadminstatement= null;
        PreparedStatement createstudentstatement= null;
        PreparedStatement createsubjectsstatement= null;   
        PreparedStatement createcontactnumbersstatement= null;
        
        try{
        String createadminquery= "CREATE TABLE IF NOT EXISTS Admins (" +
"       Admin_ID int NOT NULL AUTO_INCREMENT," +
"       Name varchar(255) NOT NULL," +
"       Email varchar(255)," +
"       Mobile_number varchar(255)," + 
"       Username varchar(255)," +
"       Password varchar(255)," + 
"       PRIMARY KEY (Admin_ID))";
        createadminstatement= con.prepareStatement(createadminquery);
        int createadmincount = createadminstatement.executeUpdate(); 
    
        String createstudentquery= "CREATE TABLE IF NOT EXISTS Student (" +
"       Student_ID int NOT NULL," +
"       Name varchar(255) NOT NULL," +
"       Temporary_address varchar(255)," +
"       Permanent_address varchar(255)," + 
"       Email varchar(255)," + 
"       PRIMARY KEY (Student_ID))";
        createstudentstatement= con.prepareStatement(createstudentquery);
        int createstudentcount = createstudentstatement.executeUpdate(); 
        
        String createsubjectsquery= "CREATE TABLE IF NOT EXISTS Subjects (SubjectID int NOT NULL AUTO_INCREMENT, Subjectname varchar(255), Student_ID int, PRIMARY KEY (SubjectID), FOREIGN KEY (Student_ID) REFERENCES Student(Student_ID))";
        createsubjectsstatement= con.prepareStatement(createsubjectsquery);
        int createsubjectscount = createsubjectsstatement.executeUpdate(); 
        
        String createcontactnumbersquery= "CREATE TABLE IF NOT EXISTS Contactnumbers (ContactID int NOT NULL AUTO_INCREMENT, Contactnumber1 varchar(255), Contactnumber2 varchar(255), Contactnumber3 varchar(255), Student_ID int, PRIMARY KEY (ContactID), FOREIGN KEY (Student_ID) REFERENCES Student(Student_ID))";
        createcontactnumbersstatement= con.prepareStatement(createcontactnumbersquery);
        int createcontactnumberscount = createcontactnumbersstatement.executeUpdate(); 
        
        mainm.mainme(global, mainm, studentdata);
        }
        catch (Exception e){
            System.out.println("You entered invalid data.");
            System.out.println("Please enter again");
            mainm.mainme(global, mainm, studentdata);
                   
        }
        finally{
            createadminstatement.close();
            createstudentstatement.close();
            createsubjectsstatement.close();  
            createcontactnumbersstatement.close();
            con.close();
        }
    }
    
    public void mainme(Globalvariables global, Mainmenu mainmenu, Studentdata studentdata) throws SQLException, ClassNotFoundException{
            
        try{
                
            System.out.println("Main Menu");
            System.out.println("Press 1 to register an admin");
            System.out.println("Press 2 to login an admin");
            Scanner a = new Scanner(System.in);
    
            int value = a.nextInt();
            if (value == 1 ){
                Adminregister adminregister = global.getAdminregister();   
                adminregister.adminregister(global, mainmenu, studentdata);
                mainme(global, mainmenu, studentdata);
            }
            
            if (value== 2){
                Adminlogin adminlogin = global.getAdminlogin();   
                adminlogin.adminlogin(global, mainmenu, studentdata);
            }
            
            else{
                mainme(global, mainmenu, studentdata);
            }
        }
        
        catch(Exception e){
            System.out.println("You entered invalid data");
            System.out.println("");
            mainme(global, mainmenu, studentdata);
        }
    
    }
    }

