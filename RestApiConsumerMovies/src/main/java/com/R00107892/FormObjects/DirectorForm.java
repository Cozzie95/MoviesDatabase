package com.R00107892.FormObjects;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DirectorForm {

	@Size(min=2, max=20)
	@NotEmpty
	private String directorFirstName;
	@Size(min=2, max=20)
	@NotEmpty
	private String directorSurname;
}