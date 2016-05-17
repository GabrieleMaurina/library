/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factorymind.library.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author GMaurina
 */

@Entity
@Table(name="book")
public class Book {
    
    @Id
    @GeneratedValue
    @Column(name="id_book")
    private int id;
    
    @Column(name="title")
    private String title;
    
    @Column(name="subtitle")
    private String subtitle;
    
    @Column(name="year")
    private int year;
    
    @Column(name="description")
    private String description;
    
    @ManyToMany(mappedBy="books")
    private Set<Author> authors = new HashSet<Author>();
    
    @ManyToMany(mappedBy="books")
    private Set<User> users = new HashSet<User>();
    
    public Book(){}

    public Book(String title, String subtitle, int year, String description) {
        this.title = title;
        this.subtitle = subtitle;
        this.year = year;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", title=" + title + ", subtitle=" + subtitle + ", year=" + year + ", description=" + description + '}';
    }
}
