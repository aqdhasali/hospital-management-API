/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;




/**
 *
 * @author aqdha
 */

public class Appointment {
    
    //Initialize Attributes
    private int id;
    private String date;
    private String time;
    private Patient patient;
    private Doctor doctor;

    
    //Initialize constructor
    public Appointment(int id, String date, String time, Patient patient, Doctor doctor){
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.time = time;
    }
    
    //Initialize default constructor
    public Appointment(){}
    
    //Getter method for the ID
    public int getId(){
        return this.id;
    }
    
    //Setter method for the ID
    public void setId(int id){
        this.id = id;
    }
    
    //Getter method for the doctor
    public Doctor getDoctor(){
        return this.doctor;
    }
    
    //Setter method for the doctor
    public void setDoctor(Doctor doctor){
        this.doctor = doctor;
    }
    
    //Getter emthod for the patient
    public Patient getPatient(){
        return this.patient;
    }
    
    //Setter method for the patient
    public void setPatient(Patient patient){
        this.patient = patient;
    }
    
    //getter method for the time
    public String getTime(){
        return this.time;
    }
    
    //setter metod for the time
    public void setTime(String time){
        this.time = time;
    }
    
    //getter method for the date
    public String getDate(){
        return this.date;
    }
    
    //setter method for the date
    public void setDate(String date){
        this.date = date;
    }
    

}
