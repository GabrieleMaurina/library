/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factorymind.library.restcontrollers;

import com.factorymind.library.domain.Genre;
import com.factorymind.library.repositories.IGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author GMaurina
 */

@RestController
@RequestMapping(value = "/genres")
public class GenreController {
    
    @Autowired
    private IGenreRepository genreRepo;
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Genre> getGenres() {
        return genreRepo.findAll();
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createGenre(String name, String description) {
        try {
            Genre genre = new Genre(name, description);
            System.out.println(genre.toString());
            genreRepo.save(genre);
            return "Genre succesfully created with id = " + genre.getId();
        }
        catch (Exception ex) {
            return "Error creating genre: " + ex.toString();
        }
    }
    
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public String updateGenre(int id, String name, String description) {
        try {
            Genre genre = new Genre(name, description);
            genre.setId(id);
            genreRepo.save(genre);
            return "Genre succesfully udated";
        }
        catch (Exception ex) {
            return "Error updating genre: " + ex.toString();
        }
    }
    
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public String deleteGenre(int id) {
        try {
            genreRepo.delete(id);
            return "Genre succesfully deleted";
        }
        catch (Exception ex) {
            return "Error deleting genre: " + ex.toString();
        }
    }
}
