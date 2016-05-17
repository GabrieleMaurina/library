/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factorymind.library.restcontrollers;

import com.factorymind.library.domain.User;
import com.factorymind.library.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author GMaurina
 */

@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    @Autowired
    private IUserRepository userRepo;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<User> getUsers() {
        return userRepo.findAll();
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createUser(String name, String surname, String birthDate, String birthPlace, String subscriptionDate) {
        try {
            User user = new User(name, surname, birthDate, birthPlace, subscriptionDate);
            System.out.println(user.toString());
            userRepo.save(user);
            return "User succesfully created with id = " + user.getId();
        }
        catch (Exception ex) {
            return "Error creating user: " + ex.toString();
        }
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateUser(int id, String name, String surname, String birthDate, String birthPlace, String subscriptionDate) {
        try {
            User user = new User(name, surname, birthDate, birthPlace, subscriptionDate);
            user.setId(id);
            userRepo.save(user);
            return "User succesfully updated";
        }
        catch (Exception ex) {
            return "Error updating user: " + ex.toString();
        }
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteUser(int id) {
        try {
            userRepo.delete(id);
            return "User succesfully deleted";
        }
        catch (Exception ex) {
            return "Error deleting user: " + ex.toString();
        }
    }
}
