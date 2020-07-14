package com.R00107892.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.R00107892.daos.FilmRepository;
import com.R00107892.entities.Film;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
    FilmRepository filmRepository;
 
    public List getAllFilms() {
        List films = new ArrayList();
        filmRepository.findAll().forEach(film -> films.add(film));
        return films;
    }
 
    public Film getFilmById(int id) {
        return filmRepository.findById(id).get();
    }
 
    public void saveOrUpdate(Film film) {
    	filmRepository.save(film);
    }
 
    public void delete(int id) {
    	filmRepository.deleteById(id);
    }
}
