package com.R00107892.FormObjects;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FilmForm {

	@Size(min=2, max=20)
	private String filmName;
	//add minimum year and max year (won't always be 2020, but can't allow films that are further then current year)
	private int releaseYear;
}
