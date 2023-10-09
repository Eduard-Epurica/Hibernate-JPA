package com.eduard.cruddemo;

import com.eduard.cruddemo.dao.StudentDAO;
import com.eduard.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	//This will be executed after the spring beans have been loaded
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runnter -> {
			createStudent(studentDAO);
		};

	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object...");
		Student newStudent = new Student("Paul","Jon","paulie@gmail.com");

		//save the student object
		System.out.println("Saving the student...");
		studentDAO.save(newStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated ID: " + newStudent.getId());
	}


}
