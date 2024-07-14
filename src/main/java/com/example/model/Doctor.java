/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author aqdha
 */
public class Doctor extends Person {
    //Initialize attributes
    private int id;
    private String specialization;
    private String email;
 
    //intitialize default constructor
    public Doctor(){}
    
    //initialize constructor
    public Doctor(String firstName, String lastName,  int contactNum, String address , int id, String specialization, String email){
        super(firstName,lastName,contactNum,address);
        this.id  = id;
        this.specialization  = specialization;
        this.email = email;
    }
    
    //getter method for doctor id
    public int getDoctorId(){
        return this.id;
    }
    
    //setter method for doctor id
    public void setDoctorId(int id){
        this.id  = id;
    }
    
    //getter method for secialization
    public String getSpecialization(){
        return this.specialization;
    }
   
    //setter emthod for specialization
    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }
   
    //getter method for email
    public String getDoctorEmail(){
       return this.email;
    }
   
    //setter emthod for doctor email
    public void setDoctorEmail(String email){
       this.email = email;
    }
    
}
