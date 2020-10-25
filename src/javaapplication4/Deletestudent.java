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
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import static javaapplication4.Createconnection.getConnection;

/**
 *
 * @author arshiagiri
 */
public class Deletestudent implements Serializable{
    public void deletestudent() throws ClassNotFoundException, SQLException {
        
        Connection con= getConnection();
        PreparedStatement deletesubjectstatement = null;
        PreparedStatement deletecontactnumbersstatement = null;
        PreparedStatement deletestudentstatement = null;
        PreparedStatement countstatement= null;
         
    try {
        System.out.println("Deleting a student");
        System.out.println("Enter student id of the student you want to delete: ");
        Scanner f = new Scanner(System.in);
        int deletestudentid = f.nextInt();
        
        String countquery= "SELECT COUNT(Student_ID) FROM student where Student_ID= ?";
        countstatement= con.prepareStatement(countquery);
        countstatement.setInt(1, deletestudentid);
        ResultSet countresult= countstatement.executeQuery();
        
        int studentcount=0;
        while (countresult.next()) {
            studentcount= countresult.getInt(1);
        }
           
        if (studentcount>0) {
        String deletesubjectquery= "DELETE FROM Subjects WHERE Student_ID = ?"; 
        deletesubjectstatement= con.prepareStatement(deletesubjectquery);
        deletesubjectstatement.setInt(1, deletestudentid);
        int deletesubjectcount = deletesubjectstatement.executeUpdate(); 
        
        String deletecontactnumbersquery= "DELETE FROM Contactnumbers WHERE Student_ID = ?"; 
        deletecontactnumbersstatement= con.prepareStatement(deletecontactnumbersquery);
        deletecontactnumbersstatement.setInt(1, deletestudentid);
        int deletecontactnumberscount = deletecontactnumbersstatement.executeUpdate(); 
        
        String deletestudentquery= "DELETE FROM student WHERE Student_ID = ?"; 
        deletestudentstatement= con.prepareStatement(deletestudentquery);
        deletestudentstatement.setInt(1, deletestudentid);
        int deletestudentcount = deletestudentstatement.executeUpdate(); 
    
    }
        else{
            System.out.println("Student data doesn't existt");
        }
    }
        catch (Exception e) {
            e.printStackTrace();
            System.out.println("Student data is invalid");
            
        }
    finally {
        deletesubjectstatement.close();
        deletecontactnumbersstatement.close();
        deletestudentstatement.close();
        con.close();
    }
    }
}
