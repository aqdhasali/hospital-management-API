/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

//import necessary packages
import static com.example.dao.PersonDAO.persons;
import com.example.model.Doctor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aqdha
 */
public class DoctorDAO {
    
    //initialize a list to store th doctors
    private static List<Doctor> doctors = new ArrayList<>();
    
    static{
        //create dummy values
        doctors.add(new Doctor("Cristiano","Ronaldo",7564321,"Stamford Bridge, Chelsea",1,"Cardiologist","cris76@gmail.com"));
    }
    
    //method to get all the available doctors
    public List<Doctor> getAllDoctors(){
        return doctors;
    }
    
    //method for gettng a doctor by Id
    public Doctor getDoctorsById(int id){
        //traversing throug the list
        for(Doctor doctor : doctors){
            //return the doctor if the ID's are matching
            if(doctor.getDoctorId() == id){
                return doctor;
          
            }
        } 
        return null;
    }
    
    
 
    //method for deleting a doctor 
    public void deleteDoctor(int id ){
        //traversing through the list
        for(Doctor doctor : doctors){
            //cheking if the ID's are matching. if so removing the doctor from the list
            if(doctor.getDoctorId() == id ){
                doctors.remove(doctor);
                break;
                
            }      
        }
    }
    
    //method for adding a new doctor 
    public void addDoctor(Doctor doctor){
        //getting a new ID
        int newDoctorId = getNextDoctorId();
        
        // setting that as the id for the new doctor        
        doctor.setDoctorId(newDoctorId);
        //adding the doctor to both doctor and persons list 
        doctors.add(doctor);
        persons.add(doctor);                
    }
    
    //method for updating a doctor
    public void updateDoctor(Doctor updatedDoctor){
        //traversing throug the doctor list 
         for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            // checking if the id's are matching if so applying the change
            if (doctor.getDoctorId() == updatedDoctor.getDoctorId()) {
                doctors.set(i, updatedDoctor);
            }
        }
    }
   
    
     public int getNextDoctorId() {
        // Initialize the maximum doctor id with a value lower than any possible doctor id
        int maxDoctorId = Integer.MIN_VALUE;

        // Iterate through the list to find the maximum doctor Id
        for (Doctor doctor : doctors) {
            int doctorId = doctor.getDoctorId();
            if (doctorId > maxDoctorId) {
                maxDoctorId = doctorId;
            }
        }

        // Increment the maximum doctor ID to get the next available doctor ID
        return maxDoctorId + 1;
    }
    
    
}
