package com.R00107892.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.R00107892.Entities.Film;
import com.R00107892.FormObjects.FilmForm;
import com.R00107892.Services.FilmService;
import com.R00107892.daos.FilmDao;

@Controller
public class FilmsController {
	
	//make sure there is html for every / option
	
		@Autowired
		private  FilmService filmService;
		
		@Autowired
		private FilmDao filmDao;
		
		
		@GetMapping("/films") 
		public String showFilms(Model model)
		{
			List<Film> films = filmService.listInChronologicalOrder(); //this should be chronological need to update and make method
			model.addAttribute("film", films);
			return "films";
		}
		
		@GetMapping("/film/{id}") 
		public String showFilm(@PathVariable(name="id") int id, Model model)
		{
			if (filmDao.existsByFilmId(id)) {
				Film film = filmService.findFilm(id);
				model.addAttribute("film", film);
				return "film";
			}
			model.addAttribute("id", id);
			return "notfounderror";
		}
		
		@GetMapping("/newFilm")
		public String addNewFilmForm(Model model)
		{
			model.addAttribute("aFilmForm", new FilmForm());
			return "newfilm";
		}
		
		@PostMapping("/newfilm")
		public String addNewFilmSave(@Valid @ModelAttribute("aFilmForm") FilmForm filmForm, BindingResult binding, RedirectAttributes redirectAttributes)
		{
			if (binding.hasErrors())
				return "newfilm";
			Film film = new Film(filmForm.getFilmName()); 
			Film newFilm = filmService.saveOrUpdate(film);
			if (newFilm != null)
				return "redirect:film/"+newFilm.getFilmId();
			else
				redirectAttributes.addFlashAttribute("duplicate", true);
				return "redirect:newfilm";	
		}
		

	}
