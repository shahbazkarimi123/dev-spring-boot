package com.karimi.cruddemo.doa;

import com.karimi.cruddemo.entity.Student;

public interface StudentDAO {
    void save(Student theStudent);

    Student findByid(Integer id);
}
