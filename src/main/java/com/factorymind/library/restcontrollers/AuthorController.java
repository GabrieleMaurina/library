/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factorymind.library.restcontrollers;

import com.factorymind.library.domain.Author;
import com.factorymind.library.repositories.IAuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author GMaurina
 */

@RestController
@RequestMapping(value = "/authors")
public class AuthorController {
        
    @Autowired
    private IAuthorRepository authorRepo;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Author> getAuthors() {
        return authorRepo.findAll();
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createAuthor(String name, String surname, String birthDate, String birthPlace, String biography) {
        try {
            Author author = new Author(name, surname, birthDate, birthPlace, biography);
            System.out.println(author.toString());
            authorRepo.save(author);
            return "Author succesfully created with id = " + author.getId();
        }
        catch (Exception ex) {
            return "Error creating author: " + ex.toString();
        }
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateAuthor(int id, String name, String surname, String birthDate, String birthPlace, String biography) {
        try {
            Author author = new Author(name, surname, birthDate, birthPlace, biography);
            author.setId(id);
            authorRepo.save(author);
            return "Author succesfully updated";
        }
        catch (Exception ex) {
            return "Error updating author: " + ex.toString();
        }
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteAuthor(int id) {
        try {
            authorRepo.delete(id);
            return "Author succesfully deleted";
        }
        catch (Exception ex) {
            return "Error deleting author: " + ex.toString();
        }
    }
}
