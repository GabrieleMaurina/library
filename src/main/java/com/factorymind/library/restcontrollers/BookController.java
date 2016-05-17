/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factorymind.library.restcontrollers;

import com.factorymind.library.domain.Book;
import com.factorymind.library.repositories.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author GMaurina
 */

@RestController
@RequestMapping(value = "/books")
public class BookController {
    
    @Autowired
    public IBookRepository bookRepo;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Book> getBooks() {
        return bookRepo.findAll();
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createBook(String title, String subtitle, int year, String description) {
        try {            
            Book book = new Book(title, subtitle, year, description);
            bookRepo.save(book);
            return "Book succesfully created with id = " + book.getId();
        }
        catch (Exception ex) {
            return "Error creating book: " + ex.toString();
        }
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateBook(int id, String title, String subtitle, int year, String description) {
        try {
            Book book = new Book(title, subtitle, year, description);
            book.setId(id);
            bookRepo.save(book);
            return "Book succesfully updated";
        }
        catch (Exception ex) {
            return "Error updating book: " + ex.toString();
        }
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteBook(int id) {
        try {
            bookRepo.delete(id);
            return "Book succesfully deleted";
        }
        catch (Exception ex) {
            return "Error deleting book: " + ex.toString();
        }
    }
}
