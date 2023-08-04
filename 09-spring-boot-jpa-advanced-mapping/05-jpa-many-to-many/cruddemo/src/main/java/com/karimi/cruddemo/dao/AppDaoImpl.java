package com.karimi.cruddemo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.karimi.cruddemo.entity.Course;
import com.karimi.cruddemo.entity.Instructor;
import com.karimi.cruddemo.entity.InstructorDetail;

import jakarta.transaction.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


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
    @Transactional
    public void deleteInstructorById(int theId) {

        // retrieve the instructor
        Instructor tempInstructor = entityManager.find(Instructor.class,theId);

        // get the courses
        List<Course> courses = tempInstructor.getCourses();


        // break associations of all  courses with instructor
        for(Course tempCourse: courses){
            tempCourse.setInstructor(null);
        }

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

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        
        // create query
        TypedQuery<Course> query = entityManager.createQuery(
            "from Course where instructor.id = :data",Course.class);
        query.setParameter("data",theId);

        //execute query

        List<Course> courses = query.getResultList();
        return courses;
     }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        
        // create query

        TypedQuery<Instructor>  query = entityManager.createQuery(
                "select i from Instructor i "+ "JOIN FETCH i.courses "+"where i.id = :data",Instructor.class);
        
        
        query.setParameter("data",theId);

        Instructor instructor = query.getSingleResult();
        return instructor;

        
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        
        entityManager.merge(instructor);
    }

    

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int theId) {
        return entityManager.find(Course.class, theId);
    }

    @Override
    @Transactional
    public void deleteCourseById(int theId) {
    
        // retrieve courses
        Course tempCourse = entityManager.find(Course.class,theId);

        // delete the course

        entityManager.remove(tempCourse);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewByCourseId(int theId) {
        
        TypedQuery<Course> query = entityManager.createQuery(
            "select c from Course c "
            +"JOIN FETCH c.review "
            +"where c.id= :data", Course.class);

        query.setParameter("data", theId);
        
        Course tempCourse = query.getSingleResult();
        return tempCourse;
    }
}
