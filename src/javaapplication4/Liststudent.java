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
import java.sql.Statement;
import java.util.Scanner;
import static javaapplication4.Createconnection.getConnection;


/**
 *
 * @author arshiagiri
 */
public class Liststudent implements Serializable{
    
    public void liststudent(Globalvariables global) throws ClassNotFoundException, SQLException {
        System.out.println("Listing students ");
        System.out.println("The students are: ");
        Connection con= getConnection();
        Statement joinstatement= null; 
        PreparedStatement countstatement= null;

        
        try {
            String countquery= "SELECT COUNT(Student_ID) FROM student";
            countstatement= con.prepareStatement(countquery);
            ResultSet countresult= countstatement.executeQuery();
        
        int studentcount=0;
        while (countresult.next()) {
            studentcount= countresult.getInt(1);
        }
           
        if (studentcount>0) {
            joinstatement = con.createStatement();
            ResultSet joinresult = joinstatement.executeQuery("Select * from student s JOIN Subjects j ON s.Student_ID = j.Student_ID JOIN Contactnumbers c ON j.Student_ID = c.student_ID");
        
        while (joinresult.next()){   
        String studentid= joinresult.getString("Student_ID");
        String name= joinresult.getString("Name");
        String taddress= joinresult.getString("Temporary_address");
        String paddress= joinresult.getString("Permanent_address");
        String email= joinresult.getString("Email");
        String subject= joinresult.getString("subjectname");
        String number1= joinresult.getString("Contactnumber1");
        String number2= joinresult.getString("Contactnumber2");
        String number3= joinresult.getString("Contactnumber3");
        System.out.println(studentid + ", " + name + ", "+ taddress + ", " + paddress + ", " + email + ", "+ subject +", "+  number1+", "+ number2 +", "+number3);
        }
        
    
    }
        else{
            System.out.println("Student data does not exist");
        }
        }
       catch (Exception e){
           System.out.println(e);
           System.out.println("Error occured, try again.");
       }
       finally{
            joinstatement.close();
            con.close();
       }
        
    }
}

 