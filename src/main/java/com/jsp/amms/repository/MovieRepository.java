package com.jsp.amms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.amms.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}
