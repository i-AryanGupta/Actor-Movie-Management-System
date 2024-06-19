package com.jsp.amms.responsedto;

import java.util.Date;
import java.util.Set;

import com.jsp.amms.entity.Movie;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActorResponse {
	
	private int actorId;
	private String name;
	private String dateOfBirth;
	private String gender;
	private String nationality;
	private Set<Movie> assignedMovie;

}
