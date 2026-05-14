package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// CommandLineRunner runner() {
	// 	return args -> {
	// 		Run run = new Run("Prima corsa", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 5.0,
	// 				Location.OUTDOOR);
	// 		System.out.println(run);
	// 	};
	// }

}
