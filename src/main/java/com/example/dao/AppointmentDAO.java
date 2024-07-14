/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

//importing necessary packages
import com.example.model.Appointment;
import com.example.model.Doctor;
import com.example.model.Patient;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author aqdha
 */


public class AppointmentDAO {
    
    //initialize a list to store the appointments
    private static List<Appointment> appointments = new ArrayList<>();
    

    static{
       
        // creating a dummy object 
        PatientDAO patientDAO = new PatientDAO();
        DoctorDAO  doctorDAO = new DoctorDAO();
        Patient patientOne   = patientDAO.getPatientById(1);
        Doctor doctorOne  = doctorDAO.getDoctorsById(1);
        String dateOne = "02-05-2024";
        String timeOne = "12:00";
        Appointment appointmentOne = new Appointment(1,dateOne,timeOne,patientOne,doctorOne);
        appointments.add(appointmentOne);
      

    }
    
    //method for getting all the available appointments
    public List<Appointment> getAllAppointments(){
        //returning the list of available appointments
        return appointments;
    }
    
    //method for getting an appointment by the ID
    public Appointment getAppointmentById(int id){
        //traversing through the list to find the matchig ID
        for(Appointment appointment : appointments){
            
            //returning the appointment if the id's are matching 
            if(appointment.getId() == id){
                return appointment;
            }
        }
        return null;       
    }
    
    
    //method for deleting an appointment by passing an id
    public void deleteAppointment(int id){
        //traversing throught the list to find the matching id
        for(Appointment appointment: appointments){
            //deleting appointment if the ID's are matching
            if(appointment.getId() == id){
                appointments.remove(appointment);
                break;
            }
        }
    }
    
    
    //method for schedualing a new appointment 
    public void addAppointment(Appointment appointment){
        //getting an new ID for the new appointment
        int newAppointmentId = getNextAppointmentId();
        //passing that ID as the ID for the new appointment
        appointment.setId(newAppointmentId);
        //adding the appointment to appointment list 
        appointments.add(appointment);
               
    }
    
    //method for updating an existing appointment 
    public void updateAppointment(Appointment updatedAppointment){
        //travesing through the available appointments
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);
            //checking if the appointment ID matches with updated appointment ID 
            if (appointment.getId() == updatedAppointment.getId()) {
                //applying the changes if the id matches
                appointments.set(i, updatedAppointment);
                System.out.println("Patient updated: " + updatedAppointment);
                return;
            }
        }
    }
    
   
    
    // method for getting the next avaialble appointment IF
     public int getNextAppointmentId() {
        // Initialize the maximum Appointment id with a value lower than any possible Appointment Id
        int maxAppointmentId = Integer.MIN_VALUE;

        // Iterate through the list to find the maximum appointment id.
        for (Appointment appointment : appointments) {
            int appointmentId = appointment.getId();
            if (appointmentId > maxAppointmentId) {
                maxAppointmentId = appointmentId;
            }
        }

        // Increment the maximum patient ID to get the next available patient ID
        return maxAppointmentId + 1;
    }
    
}
