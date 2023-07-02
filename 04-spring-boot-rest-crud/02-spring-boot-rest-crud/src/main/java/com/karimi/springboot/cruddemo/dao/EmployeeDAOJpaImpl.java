package com.karimi.springboot.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karimi.springboot.cruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    // define field for entitymanager

    private EntityManager entityManager;


    // set up constructor injection

    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
        this.entityManager = theEntityManager;

    }

    @Override
    public List<Employee> findAll() {

        // Create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee",Employee.class);
        

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        //return the results
        return employees;

    }

    @Override
    public Employee findById(int theId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Employee save(Employee theEmployee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void deleteById(int theId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

}
 