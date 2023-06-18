package com.karimi.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    public BaseballCoach(){
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }
    @Override
    public String getDailyworkout(){
        return "Spend 30 minutes in batting practice.";
    }
    
}
