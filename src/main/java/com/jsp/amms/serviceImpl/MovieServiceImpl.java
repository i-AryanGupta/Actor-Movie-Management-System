package com.jsp.amms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.amms.entity.Actor;
import com.jsp.amms.entity.Movie;
import com.jsp.amms.exception.ActorNotFoundException;
import com.jsp.amms.exception.MovieNotFoundException;
import com.jsp.amms.mapper.MovieMapper;
import com.jsp.amms.repository.MovieRepository;
import com.jsp.amms.requestedto.MovieRequest;
import com.jsp.amms.responsedto.ActorResponse;
import com.jsp.amms.responsedto.MovieResponse;
import com.jsp.amms.service.MovieService;
import com.jsp.amms.utility.ResponseStructure;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private MovieMapper movieMapper;

	@Override
	public ResponseEntity<ResponseStructure<MovieResponse>> addMovie(MovieRequest movieRequest) {
		
	Movie movie =	movieMapper.mapToMovieRequest(movieRequest, new Movie());
	movie = movieRepository.save(movie);
	
	return ResponseEntity.status(HttpStatus.CREATED)
			.body(new ResponseStructure<MovieResponse>()
					.setData(movieMapper.mapToMovieResponse(movie))
					.setMessage("Movie Data saved")
					.setStatus(HttpStatus.CREATED.value()));
	}

	@Override
	public ResponseEntity<ResponseStructure<MovieResponse>> updateMovie(MovieRequest movieRequest, int movieId) {
		
		return movieRepository.findById(movieId).map(movie -> {
			
		movie = movieMapper.mapToMovieRequest(movieRequest, movie);
		
		movie = movieRepository.save(movie);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseStructure<MovieResponse>()
						.setData(movieMapper.mapToMovieResponse(movie))
						.setMessage("Movie Updated")
						.setStatus(HttpStatus.OK.value()));
			
		}).orElseThrow(() -> new MovieNotFoundException("Movie not found"));
	}

	@Override
	public ResponseEntity<ResponseStructure<MovieResponse>> findMovie(int movieId) {
		
		return movieRepository.findById(movieId).map(movie ->{
		 MovieResponse response = movieMapper.mapToMovieResponse(movie);
		
			return ResponseEntity.status(HttpStatus.FOUND)
					.body(new ResponseStructure<MovieResponse>()
							.setData(response)
							.setMessage("Movie Found")
							.setStatus(HttpStatus.FOUND.value()));
		}).orElseThrow(() -> new MovieNotFoundException("Movie not Found"));
		
	}

	@Override
	public ResponseEntity<ResponseStructure<List<MovieResponse>>> findAllMovie() {
		
		List<MovieResponse> responses = movieRepository.findAll().stream().map(movie ->
			movieMapper.mapToMovieResponse(movie)).toList();
		
		if(responses.isEmpty())
		{
			throw new MovieNotFoundException("No movie Present");
		}
			
				return ResponseEntity.status(HttpStatus.FOUND)
						.body(new ResponseStructure<List<MovieResponse>>()
								.setData(responses)
								.setMessage("Movie Found")
								.setStatus(HttpStatus.FOUND.value()));
	}

	@Override
	public ResponseEntity<ResponseStructure<MovieResponse>> deleteMovie(int movieId) {
		
		return movieRepository.findById(movieId).map(movie -> {
			movieRepository.delete(movie);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseStructure<MovieResponse>()
								.setData(movieMapper.mapToMovieResponse(movie))
								.setMessage("Movie Deleted")
								.setStatus(HttpStatus.OK.value()));
		}).orElseThrow(() -> new MovieNotFoundException(" Movie not Found"));
	}

}
