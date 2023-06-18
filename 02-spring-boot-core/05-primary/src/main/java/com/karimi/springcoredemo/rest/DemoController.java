package com.karimi.springcoredemo.rest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karimi.springcoredemo.common.Coach;

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
    public DemoController(Coach theCoach){
        this.myCoach = theCoach;
    }

    
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyworkout();
    }
    
    
}
