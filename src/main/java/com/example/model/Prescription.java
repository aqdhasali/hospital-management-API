/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

/**
 *
 * @author aqdha
 */

public class Prescription {
    
    //Initialize Attributes
    private int id;
    private String medication;
    private String dosage;
    private String instructions;
    private int duration;
    
    
    //Initialize Constructor
    public Prescription(int id, String medication, String dosage, String instructions, int duration){
        this.id = id;
        this.medication = medication;
        this.dosage = dosage;
        this.instructions = instructions;
        this.duration = duration;
    }
    
    //Initialize Default Constructor
    public Prescription(){}
    
    // Getter Method for getting the prescription ID
    public int getId(){
        return this.id;
    }
    
    //Setter method for setting the prescription ID
    public void setId(int id){
        this.id = id;
    }
    
    //Getter method for getting the medication
    public String getMedication(){
        return this.medication;
    }
    
    //Setter method for setting the medication
    public void setMedication(String medication){
        this.medication = medication;
    }
    
    //Getter method for getting the dosage
    public String getDosage(){
        return this.dosage;
    }
    
    //Setter method for setting the dosage
    public void setDosage(String dosage){
        this.dosage = dosage;
    }
    
    //Getter method for getting the instructions
    public String getInstructions(){
        return this.instructions;
    }
    
    //Setter method for setting the instructions
    public void setInstructions(String instructions){
       this.instructions = instructions;
    }
    
    //Getter method for getting the duration
     public int getDuration(){
        return this.duration;
    }
    
    // Setter method for setting the duration
    public void setDuration(int duration){
        this.duration = duration;
    }
    
   
    
    
    
    
}
