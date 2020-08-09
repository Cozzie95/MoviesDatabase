package com.R00107892.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Film {

	public Film(String filmTitle) {
	}
	
	@Id
	@GeneratedValue
	private int filmId;
	@Column(nullable=false, unique=false)
	private String filmName;
	@Column(nullable=false, unique=false)
	private int releaseYear;

}

