package com.karimi.springcoredemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;

    @Autowired
    public DemoController(Coach coach){
        this.myCoach = coach; 

    }

    
    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyworkout();
    }
    
    
}
