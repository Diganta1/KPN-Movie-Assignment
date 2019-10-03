/*package com.kpn.nl.service;

import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.kpn.nl.model.Actor;
import com.kpn.nl.model.Movie;
import com.kpn.nl.repository.InterestRepository;
import com.kpn.nl.repository.MovieRepository;
import com.kpn.nl.service.impl.MovieServiceimpl;

public class MovieServiceTest {

	@InjectMocks
	private MovieServiceimpl movieServiceImpl;
	
	@Mock
	MovieRepository movieRepository;
	
	@Mock
	InterestRepository interestRepository;
	
	@Test
	public void whenFindById_thenReturnMovie() {
		Movie movie = new Movie();
		List<Actor> actor = new ArrayList<Actor>();
		List<String> genre = new ArrayList<String>();
		actor.add(new Actor(2L,"Digi", "Male"));
		movie.setImdb("xyz");
		movie.setRating(10);
		movie.setRuntime(110);
		movie.setTitle("Titan");
		movie.setActor(actor);
		movie.setGenre(genre);

		doReturn(movie).when(interestRepository).findbyProfileId(1001L);

	}

}
*/