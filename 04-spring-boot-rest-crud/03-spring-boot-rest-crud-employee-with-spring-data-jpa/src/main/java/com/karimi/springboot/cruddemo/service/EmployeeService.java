package com.karimi.springboot.cruddemo.service;

import java.util.List;

import com.karimi.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);
    
}
