/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.factorymind.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author GMaurina
 */

@RestController
@SpringBootApplication
public class Main {
    
    @RequestMapping("")
    public String home() {
        return "Welcome to my Library!";
    }
    
    public static void main(String... args)
    {
        SpringApplication.run(Main.class, args);
    }
}