package com.R00107892.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Film {
	@Id
	@GeneratedValue
	private int filmId;
	@Column(nullable=false, unique=false)
	private String filmName;
	@Column(nullable=false, unique=false)
	private int releaseYear;
	
	public int getFilmId() {
		return filmId;
	}
	public void FilmId(int filmId) {
		this.filmId = filmId;
	}
	public String getFilmName() {
		return filmName;
	}
	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}
	public int getReleaseYear()
	{
		return releaseYear;
	}
	public void setReleaseYear(int releaseYear)
	{
		this.releaseYear=releaseYear;
	}
}

