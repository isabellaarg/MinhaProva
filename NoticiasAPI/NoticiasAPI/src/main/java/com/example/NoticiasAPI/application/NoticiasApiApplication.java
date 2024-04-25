package com.example.NoticiasAPI.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages = {"com.example"})
@EnableMongoRepositories("com.example.NoticiasAPI.repository")
public class NoticiasApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoticiasApiApplication.class, args);
	}

}
