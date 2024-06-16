package com.jsp.amms.service;

import org.springframework.http.ResponseEntity;

import com.jsp.amms.requestedto.ActorRequest;
import com.jsp.amms.responsedto.ActorResponse;
import com.jsp.amms.utility.ResponseStructure;

public interface ActorService {

	ResponseEntity<ResponseStructure<ActorResponse>> addActors(ActorRequest requestActor);

}
