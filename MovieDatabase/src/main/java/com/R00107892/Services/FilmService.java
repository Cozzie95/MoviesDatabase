package com.R00107892.Services;

import java.util.ArrayList;
import java.util.List;
import com.R00107892.Services.FilmServiceImpl;

import com.R00107892.Models.Film;

public interface FilmService {

	public List getAllFilms();
 
    public Film getFilmById(int id);
 
    public void saveOrUpdate(Film film);
 
    public void delete(int id);
}
