package com.jsp.amms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.amms.requestedto.MovieRequest;
import com.jsp.amms.responsedto.MovieResponse;
import com.jsp.amms.utility.ResponseStructure;

public interface MovieService {

	ResponseEntity<ResponseStructure<MovieResponse>> addMovie(MovieRequest movieRequest);

	ResponseEntity<ResponseStructure<MovieResponse>> updateMovie(MovieRequest movieRequest, int movieId);

	ResponseEntity<ResponseStructure<MovieResponse>> findMovie(int movieId);

	ResponseEntity<ResponseStructure<List<MovieResponse>>> findAllMovie();

	ResponseEntity<ResponseStructure<MovieResponse>> deleteMovie(int movieId);

}
