/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author arshiagiri
 */
public class Studentdata implements Serializable {
    
    public void studentdata(Globalvariables global, Studentdata studentdata) throws ClassNotFoundException, SQLException{
        
        
        try{
        
        System.out.println("Admin Access Point");
        System.out.println("Press 1 to add student");
        System.out.println("Press 2 to update student");
        System.out.println("Press 3 to delete student");
        System.out.println("Press 4 to list student");
        Scanner adminchoice = new Scanner(System.in);
        int choice = adminchoice.nextInt();
           
        switch (choice) {
            
            case 1:
                Addstudent addstud= new Addstudent();
                addstud.addstudent(global, studentdata);
                studentdata(global, studentdata);
                break;
                
            case 2:
                Updatestudent updatestud= new Updatestudent();
                updatestud.updatestudent();
                studentdata(global, studentdata);
                break;
                
            case 3:
                Deletestudent deletestud=new Deletestudent();
                deletestud.deletestudent();
                studentdata(global, studentdata);
                break;
                
            case 4:
                Liststudent liststud= new Liststudent();
                liststud.liststudent(global);
                studentdata(global, studentdata);
                break;
                
            default:
                break;
        }
        }
    
    catch (Exception e){
            System.out.println("You entered invalid data");
            System.out.println("");
            studentdata(global, studentdata);
            
}
}
}
