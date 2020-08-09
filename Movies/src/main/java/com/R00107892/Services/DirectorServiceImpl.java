package com.R00107892.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.R00107892.Entities.Director;
import com.R00107892.daos.DirectorDao;

@Service
public class DirectorServiceImpl implements DirectorService{

	@Autowired 
	private DirectorDao directorDao;


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

	@Override
	public List<Director> getAllDirectors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Director getDirectorById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Director saveOrUpdate(Director director) {
		// TODO Auto-generated method stub
		return director;
	}
	@Override
	public List<Director> findDirectorsWithFilmName(String filmName) {
		return directorDao.findDirectorsWithFilmName(filmName);
	}


}
