/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

//importing necessary packages
import com.example.dao.AppointmentDAO;
import com.example.model.Appointment;
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

@Path("/appointments")
public class AppointmentResource {
    //setting up logger
    static Logger logger  = Logger.getLogger(AppointmentResource.class.getName());
    
    //create an instance of the appointment DAO
    private AppointmentDAO appointmentDAO = new AppointmentDAO();
    
    
    //GET method to retrieve appointments
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Appointment> getAllAppointments(){
        logger.info("Fetching Appointments...");
        return appointmentDAO.getAllAppointments();
    }
    
    //GET method to retrieve appointments by ID
    @GET
    @Path("/{appointmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAppointmentById(@PathParam("appointmentId") int appointmentId){
        logger.info("Getting appointment by ID: "+appointmentId);
        
        Appointment appointment  = appointmentDAO.getAppointmentById(appointmentId);
        //checking if the appointment is there if so returning 
        if(appointment != null){
            logger.info("Fetching appointment by ID...");
            return Response.status(Response.Status.OK).entity(appointment).build();
        } else{
            logger.severe("Unable to fetch appointment");
            return Response.status(Response.Status.NOT_FOUND).entity("No Appointment found in ID : " + appointmentId).build();
        }
    }
    

    //POST method to create an appointment
    @POST
    @Path("/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAppointment(Appointment appointment){
       
        //checking if the appointment consists with values
        if(appointment != null){
            //adding the appointment using the addAppointment method
             appointmentDAO.addAppointment(appointment);
             logger.info("Adding new appointment.");
             return Response.status(Response.Status.OK)
                .entity("Appointment added successfully.")
                .build();
        } else{
            //for error occurence 
            logger.severe("Unable to add appointment");
            return Response.status(Response.Status.NOT_FOUND)
                .entity("Error Occured! Unable to add appointment .")
                .build();
        }
        
    }
    
    //PUT method to update an appointment 
    @PUT
    @Path("update/{appointmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAppointment(@PathParam("appointmentId")int appointmentId, Appointment updatedAppointment) {
        Appointment appointment  = appointmentDAO.getAppointmentById(appointmentId);
        
        //checking if the appointment is not null
        if(appointment != null){
            // setting the id for the updated appointment and applying the changes
            updatedAppointment.setId(appointmentId);
            appointmentDAO.updateAppointment(updatedAppointment);
            
            logger.info("Updating appointment "+appointmentId);
            return Response.status(Response.Status.OK)
               .entity("Appointment updated successfully.")
               .build();
        } else{
            // for error occurence
            logger.severe("Unable to update appointment.");
            return Response.status(Response.Status.NOT_FOUND)
                .entity("Appointment ID "+appointmentId+" Not Found")
                .build();
        }
    }
    
    //DELETE method to delete an appointment
    @DELETE
    @Path("delete/{appointmentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteAppointment(@PathParam("appointmentId") int appointmentId){
        Appointment appointment  = appointmentDAO.getAppointmentById(appointmentId);
        
        if(appointment != null){
            // deleting the appointment by passing the id
            appointmentDAO.deleteAppointment(appointmentId);
            logger.info("Appointment with ID "+appointmentId+ " deleted successfully.");
            return Response.status(Response.Status.OK)
                    .entity("Appointment with ID "+appointmentId+" deleted successfully.")
                    .build();
        } else {
            logger.severe("Appointment with ID "+appointmentId+ "not found.");

            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Appointment with ID "+appointmentId+" not found.")
                    .build();
        }
        
    }
    
}
