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
@Table(name="user")
@PrimaryKeyJoinColumn(referencedColumnName = "id_person", name = "id_person", foreignKey = @ForeignKey(name = "id_person"))
public class User extends Person{
    
    @Column(name="subscription_date")
    private String subscriptionDate;
    
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="user_borrows_book", 
                joinColumns={@JoinColumn(name="id_person")}, 
                inverseJoinColumns={@JoinColumn(name="id_book")})
    private Set<Book> books = new HashSet<Book>();
    
    public User(){}

    public User(String name, String surname, String birthDate, String birthPlace, String subscriptionDate) {
        super(name, surname, birthDate, birthPlace);
        this.subscriptionDate = subscriptionDate;
    }

    public String getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(String subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    @Override
    public String toString() {
        return "User{person=" + super.toString() + ", subscriptionDate=" + subscriptionDate + '}';
    }
}
