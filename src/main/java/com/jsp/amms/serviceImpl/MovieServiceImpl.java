package com.jsp.amms.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.amms.entity.Actor;
import com.jsp.amms.entity.Movie;
import com.jsp.amms.mapper.MovieMapper;
import com.jsp.amms.repository.MovieRepository;
import com.jsp.amms.requestedto.MovieRequest;
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
//	List<Actor> a1  =movie.getActor();
//	for( Actor actor : a1)
//	{
//		movie.getActor().add(actor);
//	}
	
	movie = movieRepository.save(movie);
	
	return ResponseEntity.status(HttpStatus.CREATED)
			.body(new ResponseStructure<MovieResponse>()
					.setData(movieMapper.mapToMovieResponse(movie))
					.setMessage("Movie Data saved")
					.setStatus(HttpStatus.CREATED.value()));
	}

}
