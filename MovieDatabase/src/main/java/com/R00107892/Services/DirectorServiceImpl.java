package com.R00107892.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.R00107892.Models.Director;
import com.R00107892.Models.Film;
import com.R00107892.Repositorys.DirectorRepository;
import com.R00107892.Repositorys.FilmRepository;

@Service
public class DirectorServiceImpl implements DirectorService{

	@Autowired
    DirectorRepository directorRepository;
 
	public List getAllDirectors() {
        List directors = new ArrayList();
        directorRepository.findAll().forEach(director -> directors.add(director));
        return directors;
    }
 
    public Director getDirectorById(int id) {
        return directorRepository.findById(id).get();
    }
 
    public void saveOrUpdate(Director director) {
    	directorRepository.save(director);
    }
 
    public void delete(int id) {
    	directorRepository.deleteById(id);
    }
}
