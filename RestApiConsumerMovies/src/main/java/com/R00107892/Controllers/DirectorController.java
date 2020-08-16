package com.R00107892.Controllers;

import java.util.List;



import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.R00107892.Domain.Director;
import com.R00107892.Domain.Film;
@Controller
@RequestMapping("/api") //means api doesn't have to be typed for every @GetMapping it will auto come before
public class DirectorController {
	@GetMapping("/directorslists")
	public String showDirectors(Model model)
	{
		try {
			RestTemplate restTemplate = new RestTemplate();
			String URL = "http://localhost:8080/api/directorslists"; //visible on port 9090 as well
			ResponseEntity<List<Director>> responseEntity= restTemplate.exchange(
					URL, 
					HttpMethod.GET, 
					null, 
					new ParameterizedTypeReference<List<Director>>() {});
			List<Director> directors = responseEntity.getBody();
			model.addAttribute("directors", directors);
		return "directors";
		}
		catch (HttpClientErrorException ex) {	
			model.addAttribute("exception", ex);
			return "notfounderror";
		}
	} 

}

