package com.jsp.amms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	
	
	
	

}
