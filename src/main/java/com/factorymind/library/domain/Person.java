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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author GMaurina
 */
@Entity
@Table(name = "person")
@Inheritance(strategy=InheritanceType.JOINED)
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "id_person")
    private int id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="surname")
    private String surname;
    
    @Column(name="birthDate")
    private String birthDate;
    
    @Column(name="birthPlace")
    private String birthPlace;
    
    public Person(){}

    public Person(String name, String surname, String birthDate, String birthPlace) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String username) {
        this.surname = username;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", birthDate=" + birthDate + ", birthPlace=" + birthPlace + '}';
    }
}
