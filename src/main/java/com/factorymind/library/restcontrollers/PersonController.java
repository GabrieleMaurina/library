/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factorymind.library.restcontrollers;

import com.factorymind.library.domain.Person;
import com.factorymind.library.repositories.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author GMaurina
 */

@RestController
@RequestMapping(value = "/people")
public class PersonController {
    
    @Autowired
    private IPersonRepository personRepo;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Person> getPeople() {
        return personRepo.findAll();
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createPerson(String name, String surname, String birthDate, String birthPlace) {
        try {
            Person person = new Person(name, surname, birthDate, birthPlace);
            personRepo.save(person);
            return "Person succesfully created with id = " + person.getId();
        }
        catch (Exception ex) {
            return "Error creating person: " + ex.toString();
        }
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updatePerson(int id, String name, String surname, String birthDate, String birthPlace) {
        try {
            Person person = new Person(name, surname, birthDate, birthPlace);
            person.setId(id);
            personRepo.save(person);
            return "Person succesfully updated";
        }
        catch (Exception ex) {
            return "Error updating person: " + ex.toString();
        }
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.DELETE)
    public String deletePerson(int id) {
        try {
            personRepo.delete(id);
            return "Person succesfully deleted";
        }
        catch (Exception ex) {
            return "Error deleting person: " + ex.toString();
        }
    }
}
