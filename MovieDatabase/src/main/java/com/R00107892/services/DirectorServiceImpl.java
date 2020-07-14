package com.R00107892.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.R00107892.daos.DirectorDao;
import com.R00107892.daos.FilmRepository;
import com.R00107892.entities.Director;
import com.R00107892.entities.Film;

@Service
public class DirectorServiceImpl implements DirectorService{

	@Autowired 
	private DirectorDao directorDao;
	
	@Override
	public Director findDirector(int directorId) {
		if (directorDao.existsById(directorId))
			return directorDao.findById(directorId).get();
		return null;
	}

	@Override
	public boolean deleteDirector(int directorId) {
		if (directorDao.existsById(directorId))
		{
			directorDao.deleteById(directorId);
			return true;
		}
		return false;

	}

	@Override
	public String findDirectorName(int directorId) {
		if (directorDao.existsById(directorId))
			return directorDao.findNameOfDirectorById(directorId);
		return null;
	}

	@Override
	public List<Director> findDirectorsWithFilmName(String filmName) {
		return directorDao.findDirectorWithFilmName(filmName);
	}

	@Override
	public Director save(Director director) {
		if (directorDao.existsByDirectorId(director.getDirectorId()))
			return null;
		return directorDao.save(director);
	}

	@Override
	public boolean deleteDirector(Director director) {
		System.out.println(director);
		if (! directorDao.existsById(director.getDirectorId()))
			return false;
		directorDao.delete(director);
		System.out.println(directorDao.existsByDirectorId(director.getDirectorId()));
		return true;
	}

	@Override
	public List<Director> listAllDirectors() {
		return directorDao.findAll();
	}
	
	@Override
	public List<Director> listInAlphabeticalOrder() {
		return directorDao.findAllByOrderByDirectorIdAsc();		
	}

	@Override
	public boolean existsByDirectorId(int directorId) {
		return directorDao.existsById(directorId);
	}

}
