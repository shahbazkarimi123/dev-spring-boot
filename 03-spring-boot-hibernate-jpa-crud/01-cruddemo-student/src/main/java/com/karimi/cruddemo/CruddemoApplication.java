package com.karimi.cruddemo;
import java.util.List;
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
			// createStudent(studentDAO);
			createmultipleStudent(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// updateStudent(studentDAO);
			// deleteStudent(studentDAO);
			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted  = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
		
	}
	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: "+ studentId);
		studentDAO.delete(studentId);
	}
	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);

		//change first name to "Scooby" 
		System.out.println("Updating student ....");
		myStudent.setFirstName("Scooby");

		// update the student;

		studentDAO.update(myStudent);

		//display the updated student
		System.out.println("Updated Student: " + myStudent);

	}
	private void queryForStudents(StudentDAO studentDAO) {

		//get a list of student
		List<Student> theStudents = studentDAO.findAll();

		//display list of student
		for(Student tempStudent:theStudents){
			System.out.println(tempStudent);
		}
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
		Student myStudent = studentDAO.findById(theId);

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
