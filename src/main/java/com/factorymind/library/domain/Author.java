/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factorymind.library.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author GMaurina
 */

@Entity
@Table(name="author")
@PrimaryKeyJoinColumn(referencedColumnName = "id_person", name = "id_person", foreignKey = @ForeignKey(name = "id_person"))
public class Author extends Person{
    
    @Column(name="biography")
    public String biography;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="author_writes_book", 
                joinColumns={@JoinColumn(name="id_person")}, 
                inverseJoinColumns={@JoinColumn(name="id_book")})
    private Set<Book> books = new HashSet<Book>();
    
    public Author() {}

    public Author(String name, String surname, String birthDate, String birthPlace, String biography) {
        super(name, surname, birthDate, birthPlace);
        this.biography = biography;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "Author{person=" + super.toString() + ", biography=" + biography + '}';
    }
}
