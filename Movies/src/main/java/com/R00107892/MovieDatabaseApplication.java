package com.R00107892;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.R00107892.Entities.Director;
import com.R00107892.Services.DirectorService;

@SpringBootApplication
public class MovieDatabaseApplication {

	@Autowired
	private DirectorService directorService;
	
	public static void main(String[] args) {
		SpringApplication.run(MovieDatabaseApplication.class, args);
	}
	
	public void loadData() {
		Director one = new Director("John", "Smith", 1); //how do I make the id  not be specified?		
		directorService.saveOrUpdate(one);
		
		//add comments where necessary, finish controllers and html, then forms and lang change. Then do Form validation and security. Then Rest API.
		
		//fragments has to be changed to your navigation menu in all the html
	}


}
