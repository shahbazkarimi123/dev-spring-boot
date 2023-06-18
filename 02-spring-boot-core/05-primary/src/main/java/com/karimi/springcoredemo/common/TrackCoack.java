package com.karimi.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class TrackCoack implements Coach{

    

    @Override
    public String getDailyworkout() {
        return "Run a hard 5k";
    }
    
}
