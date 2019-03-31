package io.springboot.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApiApp {
	public static void main(String[] args) {
		//creates a servlet and runs the application on the servlet
		SpringApplication.run(CourseApiApp.class, args);
	}
}
