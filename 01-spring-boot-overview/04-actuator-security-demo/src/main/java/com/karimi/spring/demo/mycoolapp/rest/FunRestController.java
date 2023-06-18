package com.karimi.spring.demo.mycoolapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @GetMapping("/")
    public String homePage(){
        return "This is Home Page";
    }
    @GetMapping("/workout")
    public String getDailyWorkOut(){
        return "Do 20 Push Ups Daily.";
    }
    
}
