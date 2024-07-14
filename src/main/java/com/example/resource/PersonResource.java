/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.resource;

//import necessary packages
import com.example.dao.PersonDAO;
import com.example.model.Patient;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author aqdha
 */

@Path("/persons")
public class PersonResource {
    //initialize personDAO
    PersonDAO personDAO = new PersonDAO();
    
    //GET method for retrieving all persons
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Patient> getAllPersons(){
        return personDAO.getAllPersons();
    }
}
