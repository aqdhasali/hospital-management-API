/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

//importing all the packages
import com.example.model.MedicalRecord;
import com.example.model.Patient;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aqdha
 */


public class MedicalRecordDAO {
    //intialize a list to store the medical records
    private static List<MedicalRecord> medicalRecords = new ArrayList<>();
    
    static{
        //creating dummy values
        PatientDAO patientDAO = new PatientDAO();
        Patient patientOne   = patientDAO.getPatientById(1);
        medicalRecords.add(new MedicalRecord(1,patientOne,45,5.5,76.8,"A+","Asthma"," Cipla Inhaler"));
   
    }
    
    //method to get all the available medical records
    public List<MedicalRecord> getAllMedicalRecords(){
        return medicalRecords;
    }
    
    //method to get the medical record by ID
    public MedicalRecord getMedicalRecordById(int id){
        //traversing through the list
        for(MedicalRecord medicalRecord: medicalRecords){
            //returnig the medical if the ID's are matching
            if(medicalRecord.getId() == id){
                return medicalRecord;
            }
        }
        return null;
    }
    
    
    //method for adding a new medical record 
    public void addMedicalRecord(MedicalRecord medicalRecord){
        //getting a new medical record
        int newMedicalRecordId = getNextMedicalRecordId();
        //setting that as ID for the new medical record
        medicalRecord.setId(newMedicalRecordId);
        //adding that to the list
        medicalRecords.add(medicalRecord);
    }
    
    //method for updating a medical record
    public void updateMedicalRecord(MedicalRecord updatedMedicalRecord){
        //traversing through the list  
        for (int i = 0; i < medicalRecords.size(); i++) {
            MedicalRecord medicalRecord = medicalRecords.get(i);
            //checking if an available Id matches with the updatedMedical record id
            if (medicalRecord.getId() == updatedMedicalRecord.getId()) {
                medicalRecords.set(i, updatedMedicalRecord);
               
            }
        }
    }
    
    //method for deleting a medical record
    public void deleteMedicalRecord(int id){
        //traversing through the list
        for(MedicalRecord medicalRecord : medicalRecords){
            //checking if the id matches if so removing them from the list
            if(medicalRecord.getId() == id){
                medicalRecords.remove(medicalRecord);
                break;
            }
        }
    }
    
    
    
    public int getNextMedicalRecordId() {
        // Initialize the maximum medical record id with a value lower than any possible medical record Id
        int maxMedicalRecordId = Integer.MIN_VALUE;

        // Iterate through the list to find the maximum medical record ID
        for (MedicalRecord medicalRecord : medicalRecords) {
            int medicalRecordId = medicalRecord.getId();
            if (medicalRecordId > maxMedicalRecordId) {
                maxMedicalRecordId = medicalRecordId;
            }
        }

        // Increment the maximum medical record ID to get the next available medical record ID
        return maxMedicalRecordId + 1;
    }
}
