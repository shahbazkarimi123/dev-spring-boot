package com.karimi.springcoredemo.common;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component //@component annotation marks as spring bean 

public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }

    //define init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartupStuff(): "+getClass().getSimpleName() );
    }
    //define our destroy method
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
    }


    @Override
    public String getDailyworkout() {
        
        return "Practice 15 minuts fast balling for daily workout -:)";
    }

    
}
