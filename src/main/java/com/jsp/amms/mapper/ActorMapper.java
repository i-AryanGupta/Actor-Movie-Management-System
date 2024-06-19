package com.jsp.amms.mapper;

import org.springframework.stereotype.Component;

import com.jsp.amms.entity.Actor;
import com.jsp.amms.requestedto.ActorRequest;
import com.jsp.amms.responsedto.ActorResponse;

@Component
public class ActorMapper {
	
	public Actor mapToActorRequest(ActorRequest actorRequest, Actor actor)
	{
		actor.setName(actorRequest.getName());
		actor.setDateOfBirth(actorRequest.getDateOfBirth());
		actor.setGender(actorRequest.getGender());
		actor.setNationality(actorRequest.getNationality());
		
		return actor;
	}
	
	public ActorResponse mapTOActorResponse(Actor actor)
	{
		return ActorResponse.builder()
				.actorId(actor.getActorId())
				.name(actor.getName())
				.dateOfBirth(actor.getDateOfBirth())
				.gender(actor.getGender())
				.nationality(actor.getNationality())
				.assignedMovie(actor.getAssignedMovie())
				.build();
	}

}
