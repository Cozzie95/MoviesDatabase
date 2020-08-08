package com.R00107892.Services;

import java.util.List;

import com.R00107892.Models.Director;

public interface DirectorService {

	public List getAllDirectors();
	 
    public Director getDirectorById(int id);
 
    public void saveOrUpdate(Director director);
 
    public void delete(int id);
}
