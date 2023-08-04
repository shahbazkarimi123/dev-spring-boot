package com.karimi.cruddemo.dao;



import java.util.List;

import com.karimi.cruddemo.entity.Course;
import com.karimi.cruddemo.entity.Instructor;
import com.karimi.cruddemo.entity.InstructorDetail;

public interface AppDao {
    void save(Instructor instructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);
    
    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId); 

    void update(Instructor instructor);
    
    void update(Course course);

    Course findCourseById(int theId);

    void deleteCourseById(int theId);
    
    void save(Course theCourse);
    
    Course findCourseAndReviewByCourseId(int theId);

    
}
