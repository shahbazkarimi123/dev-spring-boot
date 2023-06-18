package com.karimi.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TenniceCoach implements Coach{

    public TenniceCoach(){
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyworkout() {
        return "Practice your backhand volley";
    }
    
}
