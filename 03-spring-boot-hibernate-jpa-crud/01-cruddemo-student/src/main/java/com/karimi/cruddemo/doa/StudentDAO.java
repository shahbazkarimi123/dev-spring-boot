package com.karimi.cruddemo.doa;

import java.util.List;

import com.karimi.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    void update(Student theStudent);

    void delete(Integer id);
    int deleteAll();
}
