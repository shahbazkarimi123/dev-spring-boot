package com.karimi.springcoredemo.common;


import org.springframework.stereotype.Component;

@Component

public class TrackCoack implements Coach{

    public TrackCoack(){
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyworkout() {
        return "Run a hard 5k";
    }
    
}
