/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factorymind.library.repositories;

import com.factorymind.library.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author GMaurina
 */

public interface IBookRepository extends CrudRepository<Book, Integer>{
    
}
