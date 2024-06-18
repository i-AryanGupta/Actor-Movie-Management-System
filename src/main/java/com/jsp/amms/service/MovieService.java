package com.jsp.amms.service;

import org.springframework.http.ResponseEntity;

import com.jsp.amms.requestedto.MovieRequest;
import com.jsp.amms.responsedto.MovieResponse;
import com.jsp.amms.utility.ResponseStructure;

public interface MovieService {

	ResponseEntity<ResponseStructure<MovieResponse>> addMovie(MovieRequest movieRequest);

}
