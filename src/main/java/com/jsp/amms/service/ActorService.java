package com.jsp.amms.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.jsp.amms.requestedto.ActorRequest;
import com.jsp.amms.responsedto.ActorResponse;
import com.jsp.amms.utility.ResponseStructure;

public interface ActorService {

	ResponseEntity<ResponseStructure<ActorResponse>> addActors(ActorRequest requestActor);

	ResponseEntity<ResponseStructure<ActorResponse>> assignMovieToActor(int movieId, int actorId);

	ResponseEntity<ResponseStructure<ActorResponse>> updateActor(ActorRequest actorRequest, int actorId);

	ResponseEntity<ResponseStructure<List<ActorResponse>>> actorFindAll();

	ResponseEntity<ResponseStructure<ActorResponse>> actorDelete(int actorId);

	ResponseEntity<ResponseStructure<ActorResponse>> actorFind(int actorId);

}
