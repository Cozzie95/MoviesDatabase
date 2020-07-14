package com.R00107892.daos;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.R00107892.entities.Director;

public interface DirectorDao extends JpaRepository<Director, Integer> {
	
	Director findByDirectorId(int id);
	boolean existsByDirectorId(int id);
	List<Director> findAllByOrderByDirectorIdAsc();
	
	@Query("SELECT d.directorName FROM Director d where d.directorId = :id") 
	String findNameOfDirectorById(@Param("id") int id);

	@Query("SELECT d FROM Director c JOIN Film f ON f.director=d WHERE f.filmName=:filmName")
	List<Director> findDirectorWithFilmName(@Param("filmName") String filmName);
	Director findByDirectorName(String directorFirstName, String directorSurname);
}
