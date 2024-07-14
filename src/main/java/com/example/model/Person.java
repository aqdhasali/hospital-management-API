/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author aqdha
 */

public class Person {
    //Initialize Attributes
    private String firstName;
    private String lastName;
    private long contactNum;
    private String address;
    
    
    //Initilaize constructor
    public Person(String firstName, String lastName, long contactNum, String address){
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNum = contactNum;
        this.address = address;   
    }
    
    //Initialize default constructor
    public Person(){}
    
    
    //Getter method for the first name
    public String getFirstName(){
        return this.firstName;
    }
   
    //Setter method for the first name
    public void setFirstName(String firstName){
        this.firstName  = firstName;
    }
    
    
    //Getter method for the last name
    public String getLastName(){
        return this.lastName;
    }
   
    //Setter method for the last name
    public void setLastName(String lastName){
        this.lastName  = lastName;
    }
    
    //getter method for the contact num
    public long getContactNum(){
        return this.contactNum;
    }
    
    // setter method for the contact num
    public void setContactNum(long contactNum){
        this.contactNum  = contactNum;
    }
    
    //getter method for the address
    public String getAddress(){
        return this.address;
    }
    
    //setter method for the address
    public void setAddress(String address){
        this.address = address;
    }

}
