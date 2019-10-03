package com.kpn.nl.batch.operation;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.kpn.nl.model.Movie;

/**
 * 
 * @author anant
 *
 */
@Component
public class MovieItemProcessor implements ItemProcessor<Movie, Movie> {

	@Override
	public Movie process(Movie movie) throws Exception {
		return movie;
	}

}
