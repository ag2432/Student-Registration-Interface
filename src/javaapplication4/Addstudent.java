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
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import static javaapplication4.Createconnection.getConnection;

/**
 *
 * @author arshiagiri
 */
public class Addstudent implements Serializable{
   
    public void addstudent(Globalvariables global, Studentdata studentdata) throws ClassNotFoundException, SQLException {
            
        Connection con= getConnection();
        PreparedStatement insertstudentstatement= null;
        PreparedStatement selectstudentstatement= null;
        PreparedStatement insertcontactnumbersstatement= null;
        PreparedStatement insertsubjectsstatement= null;
        
    try{
         
        System.out.println("Please enter student id: ");
        Scanner a = new Scanner(System.in);
        int id = a.nextInt();
        
        System.out.println("Please enter name: ");
        Scanner b = new Scanner(System.in);
        String name= b.nextLine();    
        
        System.out.println("Please enter temporary address: ");
        Scanner t = new Scanner(System.in);
        String taddress = t.nextLine();  
        
        System.out.println("Please enter permanent address: ");
        Scanner p = new Scanner(System.in);
        String paddress = p.nextLine();     
        Address ad= new Address(taddress, paddress);
        
        System.out.println("Please enter email: ");
        Scanner d = new Scanner(System.in);
        String email = d.nextLine();    
        
        System.out.println("Please enter number of subjects: ");
        Scanner e = new Scanner(System.in);
        int numberofsubjects = e.nextInt();
        Set<String> subjects = new HashSet<>(numberofsubjects);
        List<Subjects> subjectList = new ArrayList<>(numberofsubjects);
        
        for (int i =0; i < numberofsubjects; i++) {
            System.out.println("Please enter subject ");
            Scanner f = new Scanner(System.in);
            subjects.add(f.nextLine());
        }
        
        int j= 0;
        for(String subj : subjects){
            Subjects one = new Subjects(subj);
            subjectList.add(j, one);
            j++;
        }
        
        System.out.println("Please enter three contact numbers: ");
        Set<String> contactnumb = new HashSet<>(3);
        List<ContactNumber> contactList = new ArrayList<>(3);
        
        for (int i =0; i < 3; i++) {
            System.out.println("Please enter number: ");
            Scanner h = new Scanner(System.in);
            contactnumb.add(h.nextLine());
        }
        
        int k= 0;
        for(String numb : contactnumb){
            ContactNumber two = new ContactNumber(numb);
            contactList.add(k, two);
            k++;
        }
            
        String insertstudentquery= "insert into Student(Student_ID, Name, Temporary_address, Permanent_address, Email) values (?,?,?,?,?)";
        String selectstudentquery= "select * from Student where Student_ID= ?"; 
        insertstudentstatement= con.prepareStatement(insertstudentquery); 
        selectstudentstatement= con.prepareStatement(selectstudentquery); 
        selectstudentstatement.setInt(1, id);
        ResultSet selectstudentresult= selectstudentstatement.executeQuery();

        if (selectstudentresult.next() == false){
        insertstudentstatement.setInt(1, id);
        insertstudentstatement.setString(2, name);
        insertstudentstatement.setString(3, taddress);
        insertstudentstatement.setString(4, paddress);
        insertstudentstatement.setString(5, email);
        int insertstudentcount = insertstudentstatement.executeUpdate();

        String insertcontactnumbersquery= "insert into Contactnumbers (contactnumber1, contactnumber2, contactnumber3, Student_ID) values (?, ?, ?, ?)"; 
        insertcontactnumbersstatement= con.prepareStatement(insertcontactnumbersquery); 
        insertcontactnumbersstatement.setString(1, contactList.get(0).getContactnumber());
        insertcontactnumbersstatement.setString(2, contactList.get(1).getContactnumber());
        insertcontactnumbersstatement.setString(3, contactList.get(2).getContactnumber());
        insertcontactnumbersstatement.setInt(4, id);
        int insertcontactnumberscount= insertcontactnumbersstatement.executeUpdate();

        for(Subjects subj : subjectList){
        String insertsubjectsquery= "insert into Subjects (Subjectname, Student_ID) values (?,?)";
        insertsubjectsstatement= con.prepareStatement(insertsubjectsquery); 
        insertsubjectsstatement.setString(1, subj.getName());
        insertsubjectsstatement.setInt(2, id);
        int coun = insertsubjectsstatement.executeUpdate();
        }
        }
    }
        
        catch (Exception e){
            System.out.println("You entered invalid data");
            studentdata.studentdata(global,studentdata);
        }
            
        finally{
            insertstudentstatement.close();
            selectstudentstatement.close();
            insertcontactnumbersstatement.close();
            insertsubjectsstatement.close();
            con.close();
    }
    }    
    }

    
    
    

