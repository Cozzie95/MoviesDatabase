package com.R00107892.Controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {

	@GetMapping(value= {"/", "/home"})
	public String homePageRequest (Model model) {
		return "home";
	}
}
