/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

//importing necessay packages
import static com.example.dao.PersonDAO.persons;
import com.example.model.Patient;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aqdha
 */


public class PatientDAO {
    //initializse list to store the patients
    private static List<Patient> patients = new ArrayList<>();
    
    static{
        //creating dummy values 
        patients.add(new Patient("John","Stones",71234657,"Manchester UK",1,"Asthma","Normal"));
        persons.add(new Patient("John","Stones",71234657,"Manchester UK",1,"Asthma","Normal"));
       
    }
    

    //method for getting availablel patients
    public List<Patient> getAllPatient(){
        return patients;
    }
    
    
    //method for gettig the patient by Id
    public Patient getPatientById(int id){
        //traversing the patient list 
        for(Patient patient : patients){
            //returning the patient if ID's are matching
            if(patient.getPatientId() == id){
                return patient;
            }
        }
        return null;
    }
    
    //method for deleting a patient 
    public void deletePatient(int id){
        //traversing throught the list 
        for(Patient patient : patients){
            //remove the patient from the list if the ID's are matching
            if(patient.getPatientId() == id){
                patients.remove(patient);
                break;
            }
        }
      
    }
    
    //method for adding a new patient 
    public void addPatient(Patient patient){
        //getting a new patientId
        int newPatientId = getNextPatientId();
        //setting that ID as the ID for the new patient
        patient.setPatientId(newPatientId);
        //adding that patient to both the patient and persons list
        patients.add(patient);
        persons.add(patient);
        
    }
    
    //method for  updating an avaialable patient
    public void updatePatient(Patient updatedPatient) {
        //traverisng throught the patients list
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            //if the available patient's ID matched witht updated patients ID applying the change
            if (patient.getPatientId() == updatedPatient.getPatientId()) {
                patients.set(i, updatedPatient);
                System.out.println("Patient updated: " + updatedPatient);
                return;
            }
        }
    }
    
    
    public int getNextPatientId() {
        // Initialize the maximum patient id with a value lower than any possible patientId
        int maxPatientId = Integer.MIN_VALUE;

        // Iterate through the list to find the maximum patientId
        for (Patient patient : patients) {
            int patientId = patient.getPatientId();
            if (patientId > maxPatientId) {
                maxPatientId = patientId;
            }
        }

        // Increment the maximum patient ID to get the next available patient ID
        return maxPatientId + 1;
    }
    
    
    
    
}
