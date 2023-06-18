package com.karimi.spring.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + "Team name: "+ teamName;
    }
    @GetMapping("/")
    public String homePage(){
        return "This is Home Page";
    }
    @GetMapping("/workout")
    public String getDailyWorkOut(){
        return "Do 20 Push Ups Daily.";
    }
    
}
