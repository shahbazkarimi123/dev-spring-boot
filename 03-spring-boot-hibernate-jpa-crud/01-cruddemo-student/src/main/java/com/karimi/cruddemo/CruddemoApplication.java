package com.karimi.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.karimi.cruddemo.doa.StudentDAO;
import com.karimi.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner-> {
			//createStudent(studentDAO);
			// createmultipleStudent(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {

		//create student object

		System.out.println("Creating new student object ... ");
		Student tempStudent = new Student("Raju","sonu","Raju@sonu.com");

		//save the student

		System.out.println("Saving the student ....");
		studentDAO.save(tempStudent);

		// display id of the saved student

		int theId = tempStudent.getId();
		System.out.println("Saved Student. Generated id: " + theId);

		// retrive student based on the id : primary key
		System.out.println("Retrieving student with id: "+ theId);
		Student myStudent = studentDAO.findByid(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}
	private void createmultipleStudent(StudentDAO studentDAO) {
		// create multiple student
		System.out.println("Creating new students object ....");
		
		Student tempStudent1 = new Student("mohit","rathor","mr@gmail.com");
		Student tempStudent2 = new Student("ahmed","ansari","ansri@gmail.com");
		Student tempStudent3 = new Student("bilal","ansari","bilal@gmail.com");
		//save the student objects

		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}
	private void createStudent(StudentDAO studentDAO) {
		//create the student object
		
		System.out.println("Creating new student object ....");
		
		Student tempStudent = new Student("karimi","shahbaz","karimi@gmail.com");


		//save the student object
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);


		//display id of the student object
		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}

}
