package com.R00107892.Services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.R00107892.Entities.Film;
import com.R00107892.daos.FilmDao;

//logic for the service layer goes here. 

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
   private FilmDao filmDao;
 
    public List<Film> getAllFilms() {
        List <Film> films = new ArrayList<Film>();
        filmDao.findAll().forEach(film -> films.add(film));
        return films;
    }
 
   //Should this be in the DAO?
    public Film getFilmById(int id) {
        return filmDao.findById(id).get();
    }
 
	@Override
	public Film findFilm(int id) {
			if (filmDao.existsByFilmId(id))
				return filmDao.findById(id).get();
			return null;
		}

	@Override
	public List<Film> listInChronologicalOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film saveOrUpdate(Film film) {
		if (filmDao.existsByFilmId(film.getFilmId()))
			return null;
		return filmDao.save(film);
	}

	@Override
	public boolean delete(Film film) {
		System.out.println(film);
		if (! filmDao.existsById(film.getFilmId()))
			return false;
		filmDao.delete(film);
		System.out.println(filmDao.existsByFilmName(film.getFilmName()));
		return true;
		
	};
}
