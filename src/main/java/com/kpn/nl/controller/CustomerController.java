package com.kpn.nl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kpn.nl.exception.UserNotExistsException;
import com.kpn.nl.model.Movie;
import com.kpn.nl.model.MovieDTO;
import com.kpn.nl.model.MoviesDTO;
import com.kpn.nl.service.MovieService;

@CrossOrigin
@RestController
public class CustomerController {
	
	@Autowired
	private MovieService movieService;

	@GetMapping("/api/yourapp/v1/movie/suggestion/customer/id/{id}")
	public ResponseEntity<MoviesDTO> getMovieBasedOnInterest(@PathVariable Long id) throws UserNotExistsException{
		MoviesDTO movies = new MoviesDTO();
		List<Movie> interests = movieService.findInterests(id);
		interests.forEach(movie -> {
			movies.getMovieCategory().add(new MovieDTO(movie.getTitle(), movie.getImdb()));
		});
		return ResponseEntity.ok(movies);
	}

}
