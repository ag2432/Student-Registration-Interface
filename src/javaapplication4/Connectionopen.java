/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author arshiagiri
 */
public class Connectionopen {
    
    public void connectionopen () throws ClassNotFoundException, SQLException{
        
        String url = "jdbc:mysql://localhost:3306/admin"; 
        Class.forName("com.mysql.jdbc.Driver");
        String uname= "root";
        String pass= "root";
        Connection con= DriverManager.getConnection(url, uname, pass);
        
}}
