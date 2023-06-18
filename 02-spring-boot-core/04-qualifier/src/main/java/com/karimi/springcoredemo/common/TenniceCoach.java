package com.karimi.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TenniceCoach implements Coach{

    

    @Override
    public String getDailyworkout() {
        return "Practice your backhand volley";
    }
    
}
