package com.karimi.cruddemo.dao;

import com.karimi.cruddemo.entity.Instructor;

public interface AppDao {
    void save(Instructor instructor);

    Instructor findInstructorById(int theId);

    void deleteInstructorById(int theId);
}
