/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

//importing necessary packages
import com.example.dao.DoctorDAO;
import com.example.model.Doctor;
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

@Path("/doctors")
public class DoctorResource {
    
    //initialize logger
    static Logger logger  = Logger.getLogger(DoctorResource.class.getName());
    
    //initialize doctor DAO
    private DoctorDAO doctorDAO = new DoctorDAO();
    
   //GET method for retrieving all doctors 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Doctor> getAllDoctors(){
        logger.info("retrieving doctors.");
        return doctorDAO.getAllDoctors();
    }
    
    
    //GET method for retieving doctor by ID
    @GET
    @Path("/{doctorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDoctorById(@PathParam("doctorId") int doctorId){
        logger.info("Getting doctor by ID:  "+ doctorId);
        
        Doctor doctor  = doctorDAO.getDoctorsById(doctorId);
        //checking if the doctor exists 
        if(doctor != null){
            logger.info("Successfully Fetched Doctor with ID "+doctorId);
            //returing the doctor 
            return Response.status(Response.Status.OK).entity(doctor).build();
        } else{
            //for error occurence
            logger.severe("Error occured while fetching doctor with ID: "+doctorId);
            return Response.status(Response.Status.NOT_FOUND).entity("ID Not Found ").build();
        }
    }
    
    //POST method for creating a new doctor
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDoctor(Doctor doctor){
        //adding the doctor
        doctorDAO.addDoctor(doctor);
        
        //response message
        logger.info("Successfully added new doctor");
        return Response.status(Response.Status.OK)
                .entity("Doctor added successfully.")
                .build();
    }
    
    //PUT method for updating an existing doctor 
    @PUT
    @Path("update/{doctorId}")
    @Consumes
    public Response updateDoctor(@PathParam("doctorId") int doctorId, Doctor updatedDoctor){
        Doctor doctor  = doctorDAO.getDoctorsById(doctorId);
      
        //checking if the doctor exists
        if(doctor != null){
            //updating the doctor
            updatedDoctor.setDoctorId(doctorId);
            doctorDAO.updateDoctor(updatedDoctor);
            
            //response messages
            logger.info("Updated doctor successfully "+doctorId);
            return Response.status(Response.Status.OK)
                .entity("Doctor "+doctorId+" updated successfully.")
                .build();
        } else{
            //for error occurence
            logger.severe("Error occured while updating doctor");
            return Response.status(Response.Status.NOT_FOUND)
                .entity("Doctor ID "+ doctorId+" Not Found ")
                .build();
        }
    }
    
    //DELETE method for deleting a proper doctor
    @DELETE
    @Path("delete/{doctorId}")
    public Response deleteDoctor(@PathParam("doctorId") int doctorId){
        Doctor doctor  = doctorDAO.getDoctorsById(doctorId);
        
        if(doctor != null){
            //deleing a doctor by passing the ID
            doctorDAO.deleteDoctor(doctorId);
            //response messages
            logger.info("Successfully deleted doctor : "+doctorId);
            return Response.status(Response.Status.OK)
                    .entity("Doctor deleted successfully.")
                    .build();
        } else{
            logger.info("Unable to delete doctor "+ doctorId +" ID not found");
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Doctor ID "+doctorId+" not found.")
                    .build();
        }
                
                
        
    }
   
    
}
