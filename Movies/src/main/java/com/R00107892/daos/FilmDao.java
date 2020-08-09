package com.R00107892.daos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.R00107892.Entities.Film;

//DAO layer is for access to DB. So save, update, delete, select options - no logic! 

public interface FilmDao extends JpaRepository<Film, Integer> {
	
	Film findByFilmName(String filmName); //write query
	
	boolean existsByFilmName(String filmName); //write query
	
	@Query(value ="SELECT f.filmName FROM Film f WHERE f.filmId=:filmId", nativeQuery=true) 
	String findNameOfFilmById(@Param("filmId") int filmId);

	@Query(value="SELECT f FROM Film f JOIN Film f ON f.director=d WHERE d.directorId=:directorId", nativeQuery=true)
	List<Film> findFilmsWithDirectorId(@Param("directorId") int directorId);
	
	boolean existsByFilmId(int filmId); //query

}
