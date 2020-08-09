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
public class Director {
@Id 
@GeneratedValue
private int directorId;
@Column(nullable=false, unique=true)
private String directorFirstName;
@Column(nullable=false,unique=true)
private String directorSurname; //figure out how to make sure a director can share a first name/surname but have different surname/firstname

	public Director(String directorFirstName, String directorSurname, int id) {
	
	}

	public Director(String dName) {
	}

}