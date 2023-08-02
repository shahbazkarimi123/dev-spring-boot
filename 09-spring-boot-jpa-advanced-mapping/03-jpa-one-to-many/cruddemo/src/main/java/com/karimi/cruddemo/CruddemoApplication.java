package com.karimi.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.karimi.cruddemo.dao.AppDao;
import com.karimi.cruddemo.entity.Course;
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
			deleteInstructor(appDao);
			// findInstructorDetail(appDao);
			// deleteInstructorDetail(appDao);
			// createInstructorWithCourses(appDao);
			// findInstructorWithCourses(appDao);
			// findCourseForInstructor(appDao);
			// findInstructorWithCoursesJoinFetch(appDao);
			// updateInstructor(appDao);
			// updateCourse(appDao);

		};
	}
	private void updateCourse(AppDao appDao) {
		int theId = 10;

		// find the courese
		System.out.println("Finding course id: "+ theId);
		Course tempCourse = appDao.findCourseById(theId);
		
		// update the courese
		System.out.println("updating course id: "+theId);
		tempCourse.setTitle("Enjoy the simple things");

		appDao.update(tempCourse);

		System.out.println("Done!");
	}

	private void updateInstructor(AppDao appDao){
		int theId = 1;
		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor = appDao.findInstructorById(theId);
		System.out.println("updating last name: "+"TESTER");
		tempInstructor.setLastName("TESTER");
		appDao.update(tempInstructor);
		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDao appDao) {
		int theId = 1;
		
		//find the instructor

		System.out.println("Finding instructor id: "+theId);
		Instructor tempInstructor = appDao.findInstructorByIdJoinFetch(theId);

		System.out.println("tempInstructor: "+ tempInstructor);

		System.out.println("the associated courses: "+tempInstructor.getCourses());

		System.out.println("Done!");
	}

	private void findCourseForInstructor(AppDao appDao) {

		int theId = 1;
		
		//find Instructor

		Instructor tempInstrucrot = appDao.findInstructorById(theId);
		System.out.println("tempInstructor: "+ tempInstrucrot);

		// find courses for instructor

		List<Course> courses = appDao.findCoursesByInstructorId(theId);
		
		// associate the objects

		tempInstrucrot.setCourses(courses);
		System.out.println("The associated courses: "+tempInstrucrot.getCourses());

		System.out.println("Done!");
		

	}

	private void findInstructorWithCourses(AppDao appDao) {
		int theId = 1;
		System.out.println("Finding instructor id: "+theId);

		Instructor tempInstructor = appDao.findInstructorById(theId);

		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses: "+ tempInstructor.getCourses());
		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDao appDao) {
		Instructor tempInstructor = new Instructor("aslam","ahmed","karimi@gmail.com");

		InstructorDetail instructorDetail = new InstructorDetail("http://www.instagram.com", "cricket");

		tempInstructor.setInstructorDetail(instructorDetail);

		// create some courses

		Course tempCourse1 = new Course("Learn Spring");
		Course tempCourse2 = new Course("Java Masterclass");

		// add Course to instructor

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		System.out.println("Saving instructor: "+ tempInstructor);
		System.out.println("The Courses: "+tempInstructor.getCourses());
		// save the instructor
		// Note this will also save courses
		// because of cascadeType.PERSIST
		appDao.save(tempInstructor);
		System.out.println("Done!");



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