package com.jsp.amms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.amms.requestedto.MovieRequest;
import com.jsp.amms.responsedto.MovieResponse;
import com.jsp.amms.service.MovieService;
import com.jsp.amms.utility.ResponseStructure;

@RestController
@RequestMapping("api/version1")
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	@PostMapping("/movies")
	public ResponseEntity<ResponseStructure<MovieResponse>> addMovie(@RequestBody MovieRequest movieRequest)
	{
		return movieService.addMovie(movieRequest);
	}
	
	@PutMapping("/movies/{movieId}")
	public ResponseEntity<ResponseStructure<MovieResponse>> updateMovie(@RequestBody MovieRequest movieRequest, @PathVariable int movieId)
	{
		return movieService.updateMovie(movieRequest, movieId);
	}
	
	@GetMapping("/movies/{movieId}")
	public ResponseEntity<ResponseStructure<MovieResponse>> findMovie(@PathVariable int movieId)
	{
		return movieService.findMovie(movieId);
	}
	
	@GetMapping("/movies")
	public ResponseEntity<ResponseStructure<List<MovieResponse>>> findAllMovie()
	{
		return movieService.findAllMovie();
	}
	
	@DeleteMapping("/movies/{movieId}")
	public ResponseEntity<ResponseStructure<MovieResponse>> deleteMovie(@PathVariable int movieId)
	{
		return movieService.deleteMovie(movieId);
	}

}
