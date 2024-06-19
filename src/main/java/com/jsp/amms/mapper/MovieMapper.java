package com.jsp.amms.mapper;

import org.springframework.stereotype.Component;

import com.jsp.amms.entity.Movie;
import com.jsp.amms.requestedto.MovieRequest;
import com.jsp.amms.responsedto.MovieResponse;

@Component
public class MovieMapper {
	
	
	public Movie mapToMovieRequest(MovieRequest movieRequest, Movie movie)
	{
		movie.setTitle(movieRequest.getTitle());
		movie.setGenre(movieRequest.getGenre());
		movie.setReleaseDate(movieRequest.getReleaseDate());
		movie.setDurationInMinutes(movieRequest.getDurationInMinutes());
		movie.setRatingIMDb(movieRequest.getRatingIMDb());
		
		return movie;
	}
	
	public MovieResponse mapToMovieResponse(Movie movie)
	{
		return MovieResponse.builder()
				.movieId(movie.getMovieId())
				.title(movie.getTitle())
				.durationInMinutes(movie.getDurationInMinutes())
				.genre(movie.getGenre())
				.ratingIMDb(movie.getRatingIMDb())
				.assignedActor(movie.getAssignedActor())
				.build();
	}

}
