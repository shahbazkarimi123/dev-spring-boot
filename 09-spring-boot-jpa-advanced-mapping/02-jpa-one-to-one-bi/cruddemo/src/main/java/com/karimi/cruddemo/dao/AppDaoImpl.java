package com.karimi.cruddemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karimi.cruddemo.entity.Instructor;
import com.karimi.cruddemo.entity.InstructorDetail;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDaoImpl implements AppDao{

    // define field for entity manager

    // inject entity manager using constructor injection


    private EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int theId) {
        Instructor tempInstructor = entityManager.find(Instructor.class,theId);
        return tempInstructor;
        
    }

    @Override
    public void deleteInstructorById(int theId) {

        Instructor tempInstructor = entityManager.find(Instructor.class,theId);
        entityManager.remove(tempInstructor);
        
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class,theId);
        
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        // retrieve the associate object reference

        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class,theId);

        //remove the associated object referance
        // break bi-directional link

        tempInstructorDetail.getInstructor().setInstructorDetail(null);
        
        entityManager.remove(tempInstructorDetail);
    
    }

    
}
