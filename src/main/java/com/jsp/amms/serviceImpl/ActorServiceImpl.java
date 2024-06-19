package com.jsp.amms.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.amms.entity.Actor;
import com.jsp.amms.entity.Movie;
import com.jsp.amms.exception.ActorNotFoundException;
import com.jsp.amms.exception.MovieNotFoundException;
import com.jsp.amms.mapper.ActorMapper;
import com.jsp.amms.repository.ActorRepository;
import com.jsp.amms.repository.MovieRepository;
import com.jsp.amms.requestedto.ActorRequest;
import com.jsp.amms.responsedto.ActorResponse;
import com.jsp.amms.service.ActorService;
import com.jsp.amms.utility.ResponseStructure;
@Service
public class ActorServiceImpl implements ActorService{
	
	@Autowired
	private ActorRepository actorRepository;
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private ActorMapper actorMapper;

	@Override
	public ResponseEntity<ResponseStructure<ActorResponse>> addActors(ActorRequest actorRequest) {
		
		Actor actor =actorMapper.mapToActorRequest(actorRequest, new Actor());
		
		actor = actorRepository.save(actor);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseStructure<ActorResponse>()
						.setData(actorMapper.mapTOActorResponse(actor))
						.setMessage("Actor added")
						.setStatus(HttpStatus.CREATED.value()));
	}

	@Override
	public ResponseEntity<ResponseStructure<ActorResponse>> assignMovieToActor(int movieId, int actorId) {
		Set<Movie> movieSet = null;
		Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException("Movie not found"));
		Actor actor = actorRepository.findById(actorId).orElseThrow(() -> new ActorNotFoundException("Actor not found"));
		
		movieSet =actor.getAssignedMovie();
		movieSet.add(movie);
		
		actor.setAssignedMovie(movieSet);
		actor = actorRepository.save(actor);
		
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new ResponseStructure<ActorResponse>()
						.setData(actorMapper.mapTOActorResponse(actor))
						.setMessage("Movie assigned to Actor")
						.setStatus(HttpStatus.CREATED.value()));
	}

	@Override
	public ResponseEntity<ResponseStructure<ActorResponse>> updateActor(ActorRequest actorRequest, int actorId) {
		
		return actorRepository.findById(actorId).map(actor -> {
			
		actor =	actorMapper.mapToActorRequest(actorRequest, actor);
		
		actor = actorRepository.save(actor);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseStructure<ActorResponse>()
						.setData(actorMapper.mapTOActorResponse(actor))
						.setMessage("Actor Updated")
						.setStatus(HttpStatus.OK.value()));
		}).orElseThrow(() -> new ActorNotFoundException("Actor not found"));

	}

	@Override
	public ResponseEntity<ResponseStructure<List<ActorResponse>>> actorFindAll() {
		
	List<ActorResponse> ac =actorRepository.findAll().stream().map(actor -> 
		actorMapper.mapTOActorResponse(actor)).toList();
		
	return ResponseEntity.status(HttpStatus.FOUND)
			.body(new ResponseStructure<List<ActorResponse>>()
					.setData(ac)
					.setMessage("Actors Found")
					.setStatus(HttpStatus.FOUND.value()));
	}

	@Override
	public ResponseEntity<ResponseStructure<ActorResponse>> actorDelete(int actorId) {
		
		return actorRepository.findById(actorId).map(actor -> {
			
			actorRepository.delete(actor);
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseStructure<ActorResponse>()
								.setData(actorMapper.mapTOActorResponse(actor))
								.setMessage("Actor Deleted")
								.setStatus(HttpStatus.OK.value()));
		}).orElseThrow(() -> new ActorNotFoundException(" Actor Deleted"));
	}

}
