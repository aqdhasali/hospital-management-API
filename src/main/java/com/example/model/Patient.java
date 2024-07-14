/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author aqdha
 */
public class Patient extends Person {
    
    //intialize attributes
    private int patientId;
    private String medicalHistory;
    private String healthStatus;
    
    //initialize constructor
    public Patient(String firstName,String lastName, int contactNum, String address, int patientId , String medicalHistory, String healthStatus){
        super(firstName,lastName,contactNum,address);
        this.patientId = patientId;
        this.medicalHistory = medicalHistory;
        this.healthStatus = healthStatus;
    }
    
    //initialize default constructor
    public Patient(){}
    
    //getter method for  patient id 
    public int getPatientId(){
        return this.patientId;
    }
    
    //setter method for patient id 
    public void setPatientId(int patientId){
        this.patientId = patientId;
    }
    
    //getter method for medical history
    public String getMedicalHistory(){
        return this.medicalHistory;
    }
    
    //setter method for medical history
    public void setMedicalHistory(String medicalHistory){
        this.medicalHistory = medicalHistory;
    }
    
    //getter method ffor health status 
    public String getHealthStatus(){
        return this.healthStatus;
    }
    
    //setter method for health status
    public void setHealthStatus(String healthStatus){
        this.healthStatus = healthStatus;
    }
    
    
}
