/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factorymind.library.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author GMaurina
 */

@Entity
@Table(name="genre")
public class Genre {
    
    @Id
    @GeneratedValue
    @Column(name="id_genre")
    private int id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String description;
    
    public Genre(){}

    public Genre(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Genre{" + "id=" + id + ", name=" + name + ", description=" + description + '}';
    }
}
