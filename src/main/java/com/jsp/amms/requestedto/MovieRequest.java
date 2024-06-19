package com.jsp.amms.requestedto;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieRequest {
	
	@NotEmpty(message ="Title should not be empty")
	private String title;
	@NotEmpty(message ="Release Date should not be empty")
	private String releaseDate;
	@NotEmpty(message ="Genre should not be empty")
	private String genre;
	@NotEmpty(message =" Duration in minutes should not be empty")
	private int durationInMinutes;
	@NotEmpty(message ="Rating IMDb should not be empty")
	private double ratingIMDb;

}
