package com.R00107892.Controllers;

import java.util.List;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.R00107892.Domain.Film;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/api")
@Slf4j
public class FilmController {
	@GetMapping("/films/{releaseYear}")
	public String showFilmsByYear(@PathVariable(name="releaseYear") int releaseYear, Model model)
	{
		try {
			RestTemplate restTemplate = new RestTemplate();
			String URL="http://localhost:8080/api/viewFilmsByYear/" + releaseYear;
			ParameterizedTypeReference<List<Film>> listOfFilms = new ParameterizedTypeReference<List<Film>>(){};
			ResponseEntity<List<Film>> responseEntity = restTemplate.exchange(URL, HttpMethod.GET, null, listOfFilms );
			List<Film> films = responseEntity.getBody();
			log.info(responseEntity.getHeaders().toString());
			model.addAttribute("films", films);
			return "films";
		}
		catch (HttpClientErrorException ex) {	
			model.addAttribute("exception", ex); //exception isnt handled because hiting whitelabel
			return "notfound";
		}
	}
		@GetMapping("filmsByDirector/{id}") 
		public String findFilmsByDirectorId(@PathVariable("name =id") int id, Model model)
		{
				try {
					RestTemplate restTemplate = new RestTemplate();
					String URL = "http://localhost:8080/api/filmsByDirector/{id}";
					ResponseEntity<List<Film>> responseEntity= restTemplate.exchange(
							URL, 
							HttpMethod.GET, 
							null, 
							new ParameterizedTypeReference<List<Film>>() {});
					List<Film> films = responseEntity.getBody();
					model.addAttribute("films", films);
				return "films";
				}
				catch (HttpClientErrorException ex) {	
					model.addAttribute("exception", ex);
					return "notfounderror";
				}
	} 
}	