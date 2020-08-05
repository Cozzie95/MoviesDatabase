package com.R00107892.services;

import java.util.List;


import com.R00107892.entities.Director;


public interface DirectorService {

    
    Director findDirector(int directorId);
	boolean deleteDirector(int directorId);
	boolean existsByDirectorId(int directorId);
	String findDirectorName(int directorId);
	List<Director> findDirectorsWithFilmName(String filmName);
	Director save(Director director);
	List<Director> listInAlphabeticalOrder();
	List<Director> listAllDirectors();
	boolean deleteDirector(Director director);
}
