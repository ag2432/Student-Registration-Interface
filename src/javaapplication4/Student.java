/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author arshiagiri
 */
public class Student implements Serializable{

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", permanent address=" + address.getPermanentAddress() + ", temporary address=" + address.getTemporaryAddress() + ", email=" + email + ", subjects=" + subjects.toString() + ", contactNumber=" + contactNumber.toString() + '}';
    }

    
    private int id;
    private String name;
    private Address address;
    private String email;
    private List<Subjects> subjects;
    private List<ContactNumber> contactNumber;

    public Student(int id, String name, Address address, String email, List<Subjects> subjects, List<ContactNumber> contactNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.subjects = subjects;
        this.contactNumber = contactNumber;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }

    public List<ContactNumber> getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(List<ContactNumber> contactNumber) {
        this.contactNumber = contactNumber;
    }
    

    
    }
    

