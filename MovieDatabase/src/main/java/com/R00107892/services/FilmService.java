package com.R00107892.services;

import java.util.ArrayList;
import java.util.List;

import com.R00107892.entities.Film;
import com.R00107892.services.FilmServiceImpl;

public interface FilmService {

	public List getAllFilms();
 
    public Film getFilmById(int id);
 
    public void saveOrUpdate(Film film);
 
    public void delete(int id);
}
