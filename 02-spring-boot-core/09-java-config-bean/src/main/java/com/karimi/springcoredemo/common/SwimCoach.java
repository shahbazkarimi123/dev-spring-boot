package com.karimi.springcoredemo.common;

public class SwimCoach implements Coach{
    
    public SwimCoach(){
        System.out.println("In Constructor: "+ getClass().getSimpleName());
    }
    
    
    @Override
    public String getDailyworkout(){
        return  "Swim 100 meters as a warm up";
    }


    
    
}
