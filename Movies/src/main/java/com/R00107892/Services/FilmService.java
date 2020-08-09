package com.R00107892.Services;


import java.util.List;
import com.R00107892.Entities.Film;


//service layer is for business rules. Logic goes here. 
public interface FilmService {

	public List<Film> getAllFilms();
 
    public Film getFilmById(int id);

	Film findFilm(int id);
	
	public List<Film> listInChronologicalOrder();

	public Film saveOrUpdate(Film film);
	
	public boolean delete(Film film);
}
