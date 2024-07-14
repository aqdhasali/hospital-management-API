/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

//importing necessary packages 
import com.example.dao.MedicalRecordDAO;
import com.example.model.MedicalRecord;
import java.util.List;
import java.util.logging.Level;
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

@Path("/medicalrecords")
public class MedicalRecordResource {
    
    //intialize logger
    static Logger logger  =  Logger.getLogger(MedicalRecordResource.class.getName());

    //initialize DAO
    private MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();
    
    //GET method for retrieving all the medical records
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<MedicalRecord> getAllMedicalRecords(){
        logger.info("Fetching medical records");
        return medicalRecordDAO.getAllMedicalRecords();
    }
    
    //GET method for retrieving medical records by id
    @GET
    @Path("/{medicalRecordId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicalRecordById(@PathParam("medicalRecordId") int id) {
        logger.log(Level.INFO, "Getting medical record by ID: "+ id);
        
        MedicalRecord medicalRecord  = medicalRecordDAO.getMedicalRecordById(id);
        
        //Checking if medical record exists
        if(medicalRecord != null){
            //returning the medical record
            return Response.status(Response.Status.OK).entity(medicalRecord).build();
        } else{
            //for error occurence
            logger.severe("Error Occured! Unable to fetch medical record "+id);
            return Response.status(Response.Status.NOT_FOUND).entity("ID "+id+" Not Found ").build();
        }
    }
    
    //POST method for creating a medical record 
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMedicalRecord(MedicalRecord medicalRecord){
        //adding a medical record
        medicalRecordDAO.addMedicalRecord(medicalRecord);
        //response message
        logger.info("Succesfully added medical record");
        return Response.status(Response.Status.OK)
                .entity("Medical Record added successfully.")
                .build();
    }
    
   
    //PUT method for creating a medical record
    @PUT
    @Path("update/{medicalRecordId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateMedical(@PathParam("medicalRecordId") int id, MedicalRecord updatedMedicalRecord){
        MedicalRecord  medicalRecord  = medicalRecordDAO.getMedicalRecordById(id);
        
        //checking if medical record exists 
        if(medicalRecord != null){
            //updating the medical record
            updatedMedicalRecord.setId(id);
            medicalRecordDAO.updateMedicalRecord(updatedMedicalRecord);
            
            logger.info("Medical record updated successfully");
            return Response.status(Response.Status.OK)
                .entity("Medical Record"+id+" updated successfully.")
                .build();
        } else{
            //error occurence
            logger.severe("Error Occrured! Unable to update medical record");
            return Response.status(Response.Status.NOT_FOUND)
                .entity("Medical Record ID "+id+" Not Found")
                .build();
        }
        
    } 
    
    //DELETE method for deleting a medical record
    @DELETE
    @Path("delete/{medicalRecordId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteRecord(@PathParam("medicalRecordId") int medicalRecordId){
        MedicalRecord medicalRecord = medicalRecordDAO.getMedicalRecordById(medicalRecordId);
        
        if(medicalRecord != null){
            //deleting medical record
            medicalRecordDAO.deleteMedicalRecord(medicalRecordId);
            logger.log(Level.INFO, "Deleted Medical Record ", medicalRecordId);
            return Response.status(Response.Status.OK)
                    .entity("Medical Record "+medicalRecordId+" deleted successfully.")
                    .build();
        } else{
            logger.log(Level.SEVERE, "Medical Record under ID "+medicalRecordId+ " not found");
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Medical Record "+medicalRecordId+" not found.")
                    .build();
        }

    }
    
    
    
}