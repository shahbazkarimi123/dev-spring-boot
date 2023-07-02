package com.karimi.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
import com.karimi.springboot.cruddemo.entity.Employee;
import com.karimi.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    // define field
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        this.employeeService = theEmployeeService;
    }

    // expose "/employee" and return a list of employees

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

}
