package com.jsp.amms.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jsp.amms.entity.Actor;
import com.jsp.amms.mapper.ActorMapper;
import com.jsp.amms.repository.ActorRepository;
import com.jsp.amms.requestedto.ActorRequest;
import com.jsp.amms.responsedto.ActorResponse;
import com.jsp.amms.service.ActorService;
import com.jsp.amms.utility.ResponseStructure;

public class ActorServiceImpl implements ActorService{
	
	@Autowired
	private ActorRepository actorRepository;
	
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

}
