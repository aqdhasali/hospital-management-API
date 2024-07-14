/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

//importing necessary packages
import com.example.dao.BillingDAO;
import com.example.model.Billing;
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

@Path("/bills")
public class BillingResource {
    //initialize logger
    static Logger logger  = Logger.getLogger(BillingResource.class.getName());
    
    //initialize billing DAO 
    BillingDAO billingDAO = new BillingDAO();
    
    //GET method for retirieving bills
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Billing> getAllBills(){
        logger.info("Fethcing all bills..");
        return billingDAO.getAllBills();
    }
    
    //GET method for retirieving bills by ID
    @GET
    @Path("/{invoiceNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBillByInvoiceNo(@PathParam("invoiceNo")int invoiceNo){
        logger.log(Level.INFO, "Getting bill by bill no : ", invoiceNo);
        
        Billing bill = billingDAO.getBillByInvoice(invoiceNo);
        // checking if the bill is null 
        if(bill != null){
            //returning the bill if the values are matched
            logger.log(Level.INFO, "Successfully fetched bill ", invoiceNo);
            return Response.status(Response.Status.OK).entity(bill).build();
        } else {
            //for error occurence
            logger.log(Level.INFO, "Error Occured! Unable to fetch bill : ", invoiceNo);
            return Response.status(Response.Status.NOT_FOUND).entity("Invoice No "+invoiceNo+" Not Found ").build();
        }
    }

    //PUT method for updating existing bills
    @PUT
    @Path("update/{invoiceNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response udpateBill(@PathParam("invoiceNo") int invoiceNo, Billing  updatedBill){
        
        Billing bill = billingDAO.getBillByInvoice(invoiceNo);
        //cheking if the bill exists 
        if(bill != null){
            //updating the bill
            updatedBill.setInvoiceNo(invoiceNo);
            billingDAO.updateBill(updatedBill);
            //returning with a message
            return Response.status(Response.Status.OK)
                .entity("Bill with ID "+invoiceNo+ " updated successfully.")
                .build();  
            
        } else {
            //for error occurence 
             return Response.status(Response.Status.NOT_FOUND)
                .entity("Bill ID "+invoiceNo+" Not Found")
                .build();
        }
        
    }
    
   

    @DELETE
    @Path("delete/{invoiceNo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteBill(@PathParam("invoiceNo") int invoiceNo){
        
        Billing bill = billingDAO.getBillByInvoice(invoiceNo);
        
        if(bill != null){
            // deleting the appointment by passing the ID
            billingDAO.deleteBill(invoiceNo);
            //  returning with a message
            logger.info("Bill Deleted Successfully");
            return Response.status(Response.Status.OK)
                    .entity("Bill No " +invoiceNo+ " deleted successfully.")
                    .build();
        } else{
            logger.severe("Unable to delete bill. Bill ID "+invoiceNo+" not found.");
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Bill No " +invoiceNo+ " not found.")
                    .build();
        }
    }
    
    
    @POST
    @Path("create")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBill(Billing bill){
        //  adding the passed bill
        billingDAO.addBill(bill);
        //  returning with a message 
        logger.info("Bill added succesfully");
        return Response.status(Response.Status.OK)
                .entity("Patient added successfully.")
                .build();
    }
}
