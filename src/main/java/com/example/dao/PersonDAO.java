/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.dao;

import com.example.model.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aqdha
 */
public class PersonDAO {
    //initialize a list store the persons
    public static List<Person> persons = new ArrayList<>();
    
  
    //Get list of all persons in the system
    public List getAllPersons(){
        return persons;
    }
    
   
    
    
}
