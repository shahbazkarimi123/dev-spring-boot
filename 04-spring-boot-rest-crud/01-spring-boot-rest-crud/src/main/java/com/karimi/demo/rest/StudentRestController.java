package com.karimi.demo.rest;

import java.util.ArrayList;
import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karimi.demo.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @PostConsturctor to load the student data ... only once!

    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();
        theStudents.add(new Student("King of eagle", "Karimi"));
        theStudents.add(new Student("Aslam", "Karim"));
        theStudents.add(new Student("Raju", "Iqbal"));

    }

    // define endpoint for "/students"---- returns a list of student
    @GetMapping("/students")
    public List<Student> getStudents() {
        return theStudents;
    }

    // define endpoint or "/students/{studentId}" -- return student at index

    @GetMapping("/students/{studentId}")
    public Student getStudnet(@PathVariable int studentId) {

        // just index into the list ... keep it simple for now
        // check the studentId against list size

        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        return theStudents.get(studentId);

    }
    // Add an exception handler using @ExceptionHandler

}
