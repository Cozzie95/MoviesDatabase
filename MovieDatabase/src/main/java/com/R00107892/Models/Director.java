package com.R00107892.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


//need to split to first name and surname 

@Entity
public class Director {
@Id 
@GeneratedValue
private int directorId;
@Column(nullable=false, unique=true)
private String directorFirstName;
@Column(nullable=false,unique=true)
private String directorSurname; //figure out how to make sure a director can share a first name/surname but have different surname/firstname

	public int getDirectorId() {
		return directorId;
	}
	public void setDirectorId(int directorId) {
		this.directorId = directorId;
	}
	public String getDirectorName() {
		return directorFirstName;
	}
	public void setDirectorName(String directorName) {
		this.directorFirstName = directorName;
	}
	public String getDirectorSurname() {
		return directorSurname;
	}
	public void setDirectorSurname(String directorSurnameName) {
		this.directorSurname = directorSurname;
	}
}