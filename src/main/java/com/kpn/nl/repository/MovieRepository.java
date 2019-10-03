package com.kpn.nl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kpn.nl.model.Movie;

@Repository

public interface MovieRepository extends JpaRepository<Movie,Long> {
	@Query("SELECT m FROM Movie m WHERE m.title = :title")
	public Movie findMovieByTitle(String title);
}

