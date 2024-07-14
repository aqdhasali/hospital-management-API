/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

//import necessary packages
import com.example.dao.PrescriptionDAO;
import com.example.model.Prescription;
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

@Path("/prescriptions")
public class PrescriptionResource {
    
    //initialize logger
    static Logger logger  = Logger.getLogger(PrescriptionResource.class.getName());
    
    //initialize prescription DAO
    PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
    
    //GET method for retrieving all prescriptions
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Prescription> getAllPrescriptions(){
        logger.info("Retrieving prescriptions..");
        return prescriptionDAO.getAllPrescriptions();
    }
   
    //GET method for retrieving prescriptions by ID
    @GET
    @Path("/{prescriptionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrescriptionById(@PathParam("prescriptionId") int prescriptionId){
        logger.info("Getting prescritpion by ID: "+prescriptionId);
        
        Prescription prescription = prescriptionDAO.getPrescriptionById(prescriptionId);
        
        if(prescription != null){
            logger.info("Successfully retreived prescription "+prescriptionId);
            return Response.status(Response.Status.OK).entity(prescription).build();
        } else{
            logger.severe("Error occured while fetching prescription "+prescriptionId);
            return Response.status(Response.Status.NOT_FOUND).entity("ID Not Found ").build();
        }
    }
    
    
    //PUT method for updating prescription
    @PUT
    @Path("update/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePrescription(@PathParam("id") int id, Prescription updatedPrescription){
        Prescription prescription = prescriptionDAO.getPrescriptionById(id);
        
        //checking if prescription exists 
        if(prescription != null){
            updatedPrescription.setId(id);
            prescriptionDAO.updateRescription(updatedPrescription);
            logger.info("Successfully updated Prescription "+id);
            //response message
            return Response.status(Response.Status.OK)
                .entity("Prescription "+id+" updated successfully.")
                .build();
        } else{
            //error occurence
            logger.severe("Unable to update Prescription "+id);
            return Response.status(Response.Status.NOT_FOUND)
                .entity("Prescription ID "+id+" Not Found")
                .build();     
        }
    }
    
    //DELETE method for deleting a prescription
    @DELETE
    @Path("delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePrescritpion(@PathParam("id") int id){
        
        Prescription prescription = prescriptionDAO.getPrescriptionById(id);
        
        if(prescription != null){
            //deleting prescription
            prescriptionDAO.deletePrescription(id);
            logger.info("Deleting prescription "+id);
            return Response.status(Response.Status.OK)
                .entity("Prescription "+id+" deleted successfully.")
                .build();
        } else{
            //for error occurence
            logger.severe("Prescription ID "+id+" not found. Unable to delete prescription");
            return Response.status(Response.Status.NOT_FOUND)
                .entity("Prescription "+id+" not found.")
                .build();
        }
        
        
    }
    
    //POST method for adding a new prescription 
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPrescritpion(Prescription prescription){
        prescriptionDAO.addPrescription(prescription);
        
        logger.info("Adding new prescription...");
        return Response.status(Response.Status.OK)
            .entity("Prescription added successfully.")
            .build();
    }
    
}
