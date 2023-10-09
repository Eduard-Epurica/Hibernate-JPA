package com.eduard.cruddemo;

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
	public CommandLineRunner commandLineRunner(String[] args){

		return runnter -> {
			System.out.println("Hello wrold");
		};
	}

}
