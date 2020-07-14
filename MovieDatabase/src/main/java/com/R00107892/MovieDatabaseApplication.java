package com.R00107892;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.R00107892.entities.Director;
import com.R00107892.services.DirectorService;

@SpringBootApplication
public class MovieDatabaseApplication {

	@Autowired
	private DirectorService directorService;
	
	public static void main(String[] args) {
		SpringApplication.run(MovieDatabaseApplication.class, args);
	}
	
	public void loadData() {
		Director one = new Director("John", "Smith", 0); //how do I make the id  not be specified?		
		directorService.saveOrUpdate(one);
		
		
	}


}
