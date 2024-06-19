	package com.jsp.amms.requestedto;


import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ActorRequest {
	
	@NotEmpty(message = "Name is required")
	private String name;
	@NotEmpty(message = "DOB is required")
	private String dateOfBirth;
	@NotEmpty(message = "Gender is required")
	private String gender;
	@NotEmpty(message = "Nationality is required")
	private String nationality;

}
