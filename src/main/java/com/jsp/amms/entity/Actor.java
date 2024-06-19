package com.jsp.amms.entity;


import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Actor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int actorId;
	private String name;
	private String Gender;
	private String nationality;
	private String dateOfBirth;
	
	@ManyToMany
	@JoinTable(name ="actor_movie", joinColumns = @JoinColumn(name ="actorId"),
	inverseJoinColumns = @JoinColumn(name ="movieId")
	)
	private Set<Movie> assignedMovie = new HashSet<>();

	

}
