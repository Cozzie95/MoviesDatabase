package com.R00107892.FormObjects;

import javax.validation.constraints.Min;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import com.R00107892.Domain.Director;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilmForm {

	@Size(min=2, max=20)
	@NotEmpty
	@NotBlank
	private String filmName;
	//add minimum year and max year (won't always be 2020, but can't allow films that are further then current year)
	@PastOrPresent
	@NotBlank
	@Min(1888)
	private int releaseYear;
	@NotEmpty
	private Director director;
	
	public void filmForm(String filmName, int releaseYear, Director director) {
		this.filmName =filmName;
		this.releaseYear=releaseYear;
		this.director=director;
	}
	
}
