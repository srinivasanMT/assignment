package com.filestore.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.filestore.assignment.entity.AssignmentData;
import com.filestore.assignment.service.DataStoreService;

@SpringBootApplication

public class AssignmentApplication {

	@Autowired
	private DataStoreService dataStoreService;

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}

	@Bean
	CommandLineRunner test() {
		return args -> {
			AssignmentData assignmentData = new AssignmentData();
			assignmentData.setKey("asadas");
			assignmentData.setValue("asdadasdadadasdas");
			dataStoreService.create(assignmentData);
			
			
			AssignmentData assObj=dataStoreService.read("asadas");
			System.out.println(assObj.getKey());
			
			
			
		};
	}

}
