package com.karimi.springcoredemo.common;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //@component annotation marks as spring bean 
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE )
public class CricketCoach implements Coach {

    public CricketCoach(){
        System.out.println("In constructor: "+ getClass().getSimpleName());
    }

    @Override
    public String getDailyworkout() {
        
        return "Practice 15 minuts fast balling for daily workout -:)";
    }

    
}
