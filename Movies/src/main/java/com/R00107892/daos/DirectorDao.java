package com.R00107892.daos;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.R00107892.Entities.Director;

public interface DirectorDao extends JpaRepository<Director, Integer> {
	
	Director findByDirectorId(int id);
	boolean existsByDirectorId(int id);
	List<Director> findAllByOrderByDirectorIdAsc();
	
	@Query(value ="SELECT d.directorFirstName AND d.directorSurname FROM Director d where d.directorId = :id", nativeQuery=true) 
	Director getDirectorById(@Param("id") int id);

	@Query(value ="SELECT d.directorId FROM Director d JOIN Film f WHERE f.filmName=:filmName")
	List<Director> findDirectorsWithFilmName(@Param("filmName") String filmName);

	
	
}
