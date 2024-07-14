/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author aqdha
 */
public class MedicalRecord {
    //Initialize Attributes
    private int id;
    private Patient patient;
    private double patientHeight;
    private double patientWeight;
    private int patientAge;
    private String patientBloodGroup;
    private String diagnose;
    private String treatment;

    //initialize constructor
    public MedicalRecord(int id, Patient patient, int age , double height, double weight,  String bloodGroup,String diagnose, String treatments){
        this.id = id;
        this.patient = patient;
        this.patientAge = age;
        this.patientHeight = height;
        this.patientWeight = weight;
        this.patientBloodGroup = bloodGroup;
        this.diagnose = diagnose;
        this.treatment = treatments;
    }
    
    //initialize default construtor
    public MedicalRecord(){}
    
    //getter method for id
    public int getId(){
        return this.id;
    }
    
    //setter emthod for id
    public void setId(int id){
        this.id = id;
    }
    
    //getter method for patient 
    public Patient getPatient(){
        return this.patient;
    }
    
    //setter method for patient
    public void setPatient(Patient patient){
        this.patient = patient;
    }
    
    //getter method for age
    public int getAge(){
        return this.patientAge;
    }
    
    //setter method for age
    public void setAge(int age){
        this.patientAge = age;
    }
    
    //geeter method for height
    public double getPatientHeight(){
        return this.patientHeight;
    }
    
    //setter emthod for height
    public void setPatientHeight(double height){
        this.patientHeight = height;
    }
    
    //setter method for weight
    public void setPatientWeight(double weight){
        this.patientWeight = weight;
    }
    
    //getter method for weight
    public double getPatientWeight(){
        return this.patientWeight;
    }
    
    //getter method for blood group 
    public String getPatientBloodGroup(){
        return this.patientBloodGroup;
    }
    
    //setter method for blood group
    public void setPatientBloodGroup(String bloodGroup){
        this.patientBloodGroup = bloodGroup;
    }
    
    //getter emthod for diagnose
    public String getDiagnose(){
        return this.diagnose;
    }
    
    //setter method for diagnose
    public void setDiagnose(String diagnose){
        this.diagnose = diagnose;
    }    
    
    //getter method for treatment
    public String getTreatment(){
        return this.treatment;
    }
    
    //setter method for treatment
    public void setTreatments(String treatments){
        this.treatment = treatments;
    }
    
    
 
    
}
