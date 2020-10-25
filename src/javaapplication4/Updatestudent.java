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
import java.sql.Statement;
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
public class Updatestudent implements Serializable{
    
    public void updatestudent() throws ClassNotFoundException, SQLException {
        
        
        Connection con= getConnection();
        
        PreparedStatement updatesubjectsstatement= null;
        PreparedStatement selectstudentstatement= null;
        PreparedStatement subjectidstatement= null;
        PreparedStatement countstatement= null;
        PreparedStatement updatecontactnumbersstatement= null;
        PreparedStatement updatestudentstatement= null;
        
        try{
        System.out.println("Updating values in the data");
        System.out.println("Enter student ID of student: ");
        Scanner f = new Scanner(System.in);
        int studentid = f.nextInt();
        
        String selectstudentquery= "Select * from student where Student_id= ?";
        selectstudentstatement = con.prepareStatement(selectstudentquery);
        selectstudentstatement.setInt(1, studentid);
        ResultSet selectstudentresult= selectstudentstatement.executeQuery();
        
        while (selectstudentresult.next()){
        System.out.println("Please enter new name: ");
        Scanner b = new Scanner(System.in);
        String newname= b.nextLine();    
        
        System.out.println("Please enter new temporary address: ");
        Scanner t = new Scanner(System.in);
        String temp= t.nextLine();
        System.out.println("Please enter new permanent address: ");
        Scanner p = new Scanner(System.in);
        String perm= p.nextLine();
        Address addr= new Address(temp, perm);
       
        System.out.println("Please enter new email: ");
        Scanner d = new Scanner(System.in); 
        String newemail= d.nextLine();
        
        String countquery= "SELECT COUNT(SubjectID) FROM Subjects where Student_ID=? ";
        countstatement= con.prepareStatement(countquery);
        countstatement.setInt(1, studentid);
        ResultSet countresult= countstatement.executeQuery();
        
        int subjectcount=0;
        while (countresult.next()) {
            subjectcount= countresult.getInt(1);
        }
       
        Set<String> subjects = new HashSet<>(subjectcount);
        List<Subjects> subjectList = new ArrayList<>(subjectcount);
        
        for (int i =0; i < subjectcount; i++) {
            System.out.println("Please enter subject ");
            Scanner x = new Scanner(System.in);
            subjects.add(x.nextLine());
        }
        
        int j= 0;
        for(String subj : subjects){
            Subjects one = new Subjects(subj);
            subjectList.add(j, one);
            j++;
        }
            String subbjectidquery= "SELECT SubjectID FROM Subjects where Student_ID=? ";
            subjectidstatement= con.prepareStatement(subbjectidquery);
            subjectidstatement.setInt(1, studentid);
            ResultSet subjectidresults= subjectidstatement.executeQuery();
            
            int k= 0;
            while (subjectidresults.next()){
                String updatesubjectsquery= "update subjects set subjectname = ? where Student_ID = ? and SubjectID= ?";
                updatesubjectsstatement= con.prepareStatement(updatesubjectsquery);
                updatesubjectsstatement.setString(1, subjectList.get(k).getName());
                updatesubjectsstatement.setInt(2, studentid);
                updatesubjectsstatement.setInt(3, subjectidresults.getInt(1)); 
                int updatesubjectscount = updatesubjectsstatement.executeUpdate();
                k++;
        }
            

        System.out.println("Please enter three contact numbers: ");
        Set<String> contactnumb = new HashSet<>(3);
        List<ContactNumber> contactList = new ArrayList<>(3);
        
        for (int i =0; i < 3; i++) {
            System.out.println("Please enter number: ");
            Scanner h = new Scanner(System.in);
            contactnumb.add(h.nextLine());
        }
        
        int l= 0;
        for(String numb : contactnumb){
            ContactNumber two = new ContactNumber(numb);
            contactList.add(l, two);
            l++;
        }
         
        String updatestudentquery = "UPDATE student SET Name= ?, Temporary_address= ?, Permanent_address= ?, Email= ? WHERE Student_ID = ?"; 
        updatestudentstatement= con.prepareStatement(updatestudentquery);
        updatestudentstatement.setString(1, newname);
        updatestudentstatement.setString(2, temp);
        updatestudentstatement.setString(3, perm); 
        updatestudentstatement.setString(4, newemail);
        updatestudentstatement.setInt(5, studentid);
        int updatestudentcount = updatestudentstatement.executeUpdate();
        
        String updatecontactnumbersquery= "Update Contactnumbers SET Contactnumber1 = ?, Contactnumber2= ?, Contactnumber3= ? WHERE Student_ID= ?"; 
        updatecontactnumbersstatement= con.prepareStatement(updatecontactnumbersquery); 
        updatecontactnumbersstatement.setString(1, contactList.get(0).getContactnumber());
        updatecontactnumbersstatement.setString(2, contactList.get(1).getContactnumber());
        updatecontactnumbersstatement.setString(3, contactList.get(2).getContactnumber());
        updatecontactnumbersstatement.setInt(4, studentid);
        int updatecontactnumberscount= updatecontactnumbersstatement.executeUpdate();
        }
        }
        
        catch (Exception e) {
            System.out.println(e);
            System.out.println("Student data is invalid");
        }
        
        finally {
            updatesubjectsstatement.close();
            selectstudentstatement.close();
            subjectidstatement.close();
            countstatement.close();
            updatecontactnumbersstatement.close();
            updatestudentstatement.close();
            con.close();
        }
        
        
}
}

