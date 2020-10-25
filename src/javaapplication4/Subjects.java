/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author arshiagiri
 */
class Subjects implements Serializable{
    String name;

    @Override
    public String toString() {
        return "{" + "name=" + name + '}';
    }

    public Subjects(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   
    
    
    
    
}
