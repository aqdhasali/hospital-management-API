/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

import com.example.dao.PatientDAO;
import com.example.model.Patient;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author aqdha
 */

@Path("/patients")
public class PatientResource {
    
    //Initialize logger 
    static Logger logger  =  Logger.getLogger(PatientResource.class.getName());
    //Initialize DAO
    private PatientDAO patientDAO = new PatientDAO();
    
    
    //GET method for retrieving all the students
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> getAllPatients(){
        return patientDAO.getAllPatient();
    }
    
    //GET method for retrieving Patients by ID
    @GET
    @Path("/{patientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientById(@PathParam("patientId") int patientId) {
        logger.info("Getting user by ID: " + patientId );
        
        Patient patient  = patientDAO.getPatientById(patientId);
     
        //checking if the patient exists 
        if(patient != null){
            logger.info("Fetching Patient with ID "+patientId);   
            return Response.status(Response.Status.OK).entity(patient).build();
        } else {
            // for error occurence
            logger.severe("Error Occured! Unable to fetch patient with ID "+patientId);
            return Response.status(Response.Status.NOT_FOUND).entity("ID "+patientId+" Not Found ").build();
        }      
    }    
    
    //POST method to add a new patient 
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPatient(Patient patient){
        patientDAO.addPatient(patient);
        // response messages
        return Response.status(Response.Status.OK)
                .entity("Patient added successfully.")
                .build();
    }
    
    //PUT method to update a patient
    @PUT
    @Path("update/{patientId}")
    @Consumes
    public Response updatePatient(@PathParam("patientId") int patientId, Patient updatedPatient){
        Patient patient  = patientDAO.getPatientById(patientId);
      // checking if the patient exists
        if(patient != null){
            updatedPatient.setPatientId(patientId);
            patientDAO.updatePatient(updatedPatient);
            
            //response messages
            logger.info("updating patient with ID "+patientId);
            return Response.status(Response.Status.OK)
                .entity("Patient under ID "+patientId+" updated successfully.")
                .build();
        } else{
            //error occurence
            logger.severe("unable to update patient "+patientId);
            return Response.status(Response.Status.NOT_FOUND)
                .entity("Patient ID "+patientId+" Not Found")
                .build();
        }
    }
    
    //DELETE method to delete a patient
    @DELETE
    @Path("delete/{patientId}")
    public Response deletePatient(@PathParam("patientId") int patientId){
        Patient patient  = patientDAO.getPatientById(patientId);
        
        if(patient != null){
            //deleting patient
            logger.info("deleting patient with ID "+patientId);
            patientDAO.deletePatient(patientId);
            return Response.status(Response.Status.OK)
                    .entity("Patient under ID "+patientId+"deleted successfully.")
                    .build();
        } else{
            logger.severe("Patient ID "+patientId+ " not found. Unable to delete patient");
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Patient under ID "+patientId+ " not found.")
                    .build();
        }
        
    }
    
}
