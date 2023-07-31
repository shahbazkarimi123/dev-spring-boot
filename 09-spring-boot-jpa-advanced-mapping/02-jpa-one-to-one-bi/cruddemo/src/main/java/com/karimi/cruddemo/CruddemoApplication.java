package com.karimi.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.karimi.cruddemo.dao.AppDao;
import com.karimi.cruddemo.entity.Instructor;
import com.karimi.cruddemo.entity.InstructorDetail;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao){
		return runner->{
			// createInstructor(appDao);
			// findInstructor(appDao);
			// deleteInstructor(appDao);
			// findInstructorDetail(appDao);
			deleteInstructorDetail(appDao);

		};
	}

	private void deleteInstructorDetail(AppDao appDao) {
		int theId = 5;
		System.out.println("Deleting instructor detail id: "+theId);
		appDao.deleteInstructorDetailById(theId);
		System.out.println("Done!");
		
	}

	private void findInstructorDetail(AppDao appDao) {
		// get the instructor object
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDao.findInstructorDetailById(theId);

		// print the instructor detail
		System.out.println("tempInstructorDetail: "+ tempInstructorDetail);

		// print the associated instructor
		System.out.println("the associated instructor: "+ tempInstructorDetail.getInstructor()); 
	}

	private void deleteInstructor(AppDao appDao) {
		int theId = 1;
		System.out.println("Deleting instructor id: "+theId);
		appDao.deleteInstructorById(theId);
		System.out.println("Done!");
	}

	private void findInstructor(AppDao appDao) {
		Instructor tempInstructor = appDao.findInstructorById(1);
		System.out.println(tempInstructor);


	}

	private void createInstructor(AppDao appDao) {
		

		// create instructor

		Instructor instructor = new Instructor("aslam","ahmed","karimi@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("www.youtue.com", "cricket");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor:  "+instructor);
		appDao.save(instructor);

		System.out.println("Done!");


		

	}

}