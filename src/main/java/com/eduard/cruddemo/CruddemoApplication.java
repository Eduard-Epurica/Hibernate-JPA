package com.eduard.cruddemo;

import com.eduard.cruddemo.dao.StudentDAO;
import com.eduard.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	//This will be executed after the spring beans have been loaded
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runnter -> {

			//createStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO, 3);
			//deleteStudent(studentDAO, 2);
			deleteAllStudents(studentDAO);
		};

	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");

		int result = studentDAO.deleteAll();

		System.out.println("Deleted " + result + " students");
	}

	private void deleteStudent(StudentDAO studentDAO,Integer ID) {
		//retrieve student based on the id: primary key
		System.out.println("Deleting student with id " + ID);

		studentDAO.delete(ID);
		System.out.println("Deleting process finished");
	}

	private void updateStudent(StudentDAO studentDAO, Integer ID) {
		//retrieve student based on the id: primary key
		System.out.println("Getting student with id " + ID);
		Student myStudent  = studentDAO.findById(ID);

		//change first name to scooby
		System.out.println("Updating student...");
		myStudent.setFirstName("Scooby");

		//update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get the list of students
		List<Student> studentList = studentDAO.findByLastName("Epurica");
		System.out.println("Students with LastName Epurica: ");
		//display list of students
		for(Student student: studentList){
			System.out.println(student);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.findAll();
		System.out.println("Students: ");
		for(Student student: studentList){
			System.out.println(student);
		}
		//System.out.println(studentList);
	}

	private void readStudent(StudentDAO studentDAO) {
		//create the student object
		System.out.println("Creating new student object...");
		Student newStudent = new Student("Reader","Pon","reader.pon@gmail.com");

		//save the student
		System.out.println("Saving the student...");
		studentDAO.save(newStudent);

		//display ID of the saved student
		System.out.println("Saved student. Generated ID: " + newStudent.getId());

		//retrieve student based on the id: primary key
		//display student
		System.out.println("Retrieveing the student based on ID " + newStudent.getId() + "...");
		System.out.println("Student is: " + studentDAO.findById(newStudent.getId()));


	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object...");
		Student newStudent = new Student("Ana","Safta","ana.safta@gmail.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(newStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated ID: " + newStudent.getId());
	}


}
