package com.kpn.nl.repository;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kpn.nl.model.Movie;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryTest {

	@Autowired
	private MovieRepository movieRepository;
	
	@Test
	public void whenFindById_thenReturnNull() {
		Movie found = movieRepository.findMovieByTitle("test");
		assertNull("Movie searched is present", found);
	}
}

