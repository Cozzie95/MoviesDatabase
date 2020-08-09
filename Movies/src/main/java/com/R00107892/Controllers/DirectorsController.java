package com.R00107892.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.R00107892.Entities.Director;
import com.R00107892.FormObjects.DirectorForm;
import com.R00107892.Services.DirectorService;
import com.R00107892.daos.DirectorDao;


public class DirectorsController {
	//make sure there is html for every / option
	
			@Autowired
			private  DirectorService directorService;
			
			@Autowired
			private DirectorDao directorDao;
			
			
			@GetMapping("/directors") 
			public String showDirectors(Model model)
			{
				List<Director> directors = directorService.listInAlphabeticalOrder(); 
				return "directors";
			}
			
			@GetMapping("/director/{id}") 
			public String showDirector(@PathVariable(name="id") int id, Model model)
			{
				if (directorDao.existsByDirectorId(id)) {
					Director director = directorService.getDirectorById(id); //is this under another name?
					model.addAttribute("director", director);
					return "director";
				}
				model.addAttribute("id", id);
				return "notfounderror";
			}
			
			@GetMapping("/newdirector")
			public String addNewDirectorForm(Model model)
			{
				model.addAttribute("aDirectorForm", new DirectorForm());
				return "newdirector";
			}
			
			@PostMapping("/newdirector")
			public String addNewDirectorSave(@Valid @ModelAttribute("aDirectorForm") DirectorForm directorForm, BindingResult binding, RedirectAttributes redirectAttributes)
			{
				if (binding.hasErrors())
					return "newdirector";
				Director director = new Director(directorForm.getDirectorFirstName() + (directorForm.getDirectorSurname())); 
				if (director != null)
					return "redirect:director/"+ director.getDirectorId();
				else
					redirectAttributes.addFlashAttribute("duplicate", true);
					return "redirect:newdirector";	
			}
			

}
