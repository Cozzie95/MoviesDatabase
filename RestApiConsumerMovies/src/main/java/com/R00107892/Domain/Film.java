package com.R00107892.Domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int filmId;
	@Column
	private String filmName;
	@Column
	private int releaseYear;
	@ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn
    @OnDelete(action = OnDeleteAction.CASCADE)
	Director director; 

	public Film (String fForm) {
	}

	public Film(Director director, String filmTitle,  int releaseYear) {
		this.director=director;
		this.filmName=filmTitle;
		this.releaseYear=releaseYear;
		
	}
	
}

