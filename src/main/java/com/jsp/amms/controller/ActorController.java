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
import org.springframework.web.bind.annotation.RestController;

import com.jsp.amms.requestedto.ActorRequest;
import com.jsp.amms.responsedto.ActorResponse;
import com.jsp.amms.service.ActorService;
import com.jsp.amms.utility.ResponseStructure;

@RestController
@RequestMapping("api/version1")
public class ActorController {
	
	@Autowired
	private ActorService actorService;
	
	@PostMapping("/actors")
	public ResponseEntity<ResponseStructure<ActorResponse>> addActors(@RequestBody ActorRequest requestActor)
	{
		return actorService.addActors(requestActor);	
	}
	
	@PutMapping("/movies/{movieId}/actors/{actorId}")
	public ResponseEntity<ResponseStructure<ActorResponse>> assignMovieToActor(@PathVariable int movieId, @PathVariable int actorId)
	{
		return actorService.assignMovieToActor(movieId, actorId);
	}
	
	@PutMapping("/actors/{actorId}")
	public ResponseEntity<ResponseStructure<ActorResponse>> updateActor(@RequestBody ActorRequest actorRequest, @PathVariable int actorId)
	{
		return actorService.updateActor(actorRequest, actorId);
	}
	
	@GetMapping("/actors/{actorId}")
	public ResponseEntity<ResponseStructure<ActorResponse>> actorFind(@PathVariable int actorId)
	{
		return actorService.actorFind(actorId);
	}
	
	@GetMapping("/actors")
	public ResponseEntity<ResponseStructure<List<ActorResponse>>> actorFindAll()
	{
		return actorService.actorFindAll();
	}
	
	@DeleteMapping("/actors/{actorId}")
	public ResponseEntity<ResponseStructure<ActorResponse>> actorDelete(@PathVariable int actorId)
	{
		return actorService.actorDelete(actorId);
	}
	
	
	
	
	
	

}
