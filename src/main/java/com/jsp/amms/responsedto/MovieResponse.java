package com.jsp.amms.responsedto;

import java.util.Date;

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
public class MovieResponse {
	
	private int movieId;
	private String title;
	private String releaseDate;
	private String genre;
	private int durationInMinutes;
	private double ratingIMDb;

}
