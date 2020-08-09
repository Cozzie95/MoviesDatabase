package com.R00107892.Services;

import java.util.List;

import com.R00107892.Entities.Director;


public interface DirectorService {


	public List<Director> getAllDirectors();
    public Director getDirectorById(int id);
    public Director saveOrUpdate(Director director);
	boolean existsByDirectorId(int directorId);
	List<Director> findDirectorsWithFilmName(String filmName);
	List<Director> listInAlphabeticalOrder();
	List<Director> listAllDirectors();
	boolean deleteDirector(Director director);
}
