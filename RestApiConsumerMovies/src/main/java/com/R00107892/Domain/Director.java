package com.R00107892.Domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Director {
	private int directorId;
	private String directorFirstName;
	private String directorSurname;
    private List<Film> films = new ArrayList<>(); 
	
	}