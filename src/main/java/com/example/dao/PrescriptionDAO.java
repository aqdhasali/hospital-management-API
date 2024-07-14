/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Prescription;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aqdha
 */

public class PrescriptionDAO {
    //initilaize a list to the available prescriptions
    private static List<Prescription> prescriptions = new ArrayList<>();
    
    static{
        //initialize dummy values
        prescriptions.add(new Prescription(1,"Aspirin","100mg","Take one tablet daily with food",30));
        
    }
    
    // method for getting the available prescriptions
    public List<Prescription> getAllPrescriptions(){
        return prescriptions;
    }
    
    //method for getting the prescription by ID
    public Prescription getPrescriptionById(int id ){
        //travesing through the list to find if the id's are matching
        for(Prescription prescription: prescriptions){
            if(prescription.getId() == id){
                //returning the prescription if the ID's are matching
                return prescription;
            }
        }
        return null;
    }
    

    //method for updating an available prescription
    public void updateRescription(Prescription updatedPrescription){
        //travesing through the prescription list
        for (int i = 0; i < prescriptions.size(); i++) {
            Prescription prescription = prescriptions.get(i);
            //checkig if an available id matches with the updated prescription ID
            if (prescription.getId() == updatedPrescription.getId()){
                // setting the changes if the ID matches
                prescriptions.set(i, updatedPrescription);
                System.out.println("Prescription updated: " + updatedPrescription);
                return;
            }
        }
    }
    
    //method for deleting a prescription 
    public String deletePrescription(int id){
        //travesing throught the prescirption list to identify if the ID's are matching
        for(Prescription prescription: prescriptions){
            //if the ID's are matching removing the prescription from the list 
            if(prescription.getId() == id){
                prescriptions.remove(prescription);
            } else{
                return "Prescirption ID not found";
            }
        }
        return null;
    }
    
    
    //method for adding a new prescription
    public void addPrescription(Prescription prescription){
        //getting a new ID
        int newPrescriptionID = getNextPrescriptionId();
        //setting that ID as the ID for the new prescription
        prescription.setId(newPrescriptionID);
        //adding the prescription to the list
        prescriptions.add(prescription);
                
                
    }
    
    
    public int getNextPrescriptionId() {
        // Initialize the maximum prescription id with a value lower than any possible prescription Id
        int maxPrescriptionId = Integer.MIN_VALUE;

        // Iterate through the list to find the maximum prescription ID
        for (Prescription prescription : prescriptions) {
            int prescriptionId = prescription.getId();
            if (prescriptionId > maxPrescriptionId) {
                maxPrescriptionId = prescriptionId;
            }
        }

        // Increment the maximum prescription ID to get the next available prescription ID
        return maxPrescriptionId + 1;
    }
     
    
}
