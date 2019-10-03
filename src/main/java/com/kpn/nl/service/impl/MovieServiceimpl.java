package com.kpn.nl.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kpn.nl.exception.UserNotExistsException;
import com.kpn.nl.model.Actor;
import com.kpn.nl.model.Interests;
import com.kpn.nl.model.Movie;
import com.kpn.nl.repository.InterestRepository;
import com.kpn.nl.repository.MovieRepository;
import com.kpn.nl.repository.ProfileRepository;
import com.kpn.nl.service.MovieService;

@Service
public class MovieServiceimpl implements MovieService {

	private static final String NOT_EXIST="User ID: %s does not exists";
	@Autowired
	ProfileRepository profileRepository;

	@Autowired
	InterestRepository interestRepository;

	@Autowired
	MovieRepository movieRepository;

	/*
	 * @Autowired InterestRepository interestRepository;
	 */

	@Override
	public List<Movie> findInterests(Long id) throws UserNotExistsException{
		Interests interests = interestRepository.findbyProfileId(id);
		if (interests == null) {
			throw new UserNotExistsException(String.format(NOT_EXIST,id));
		}
		List<Movie> movies = movieRepository.findAll();
		List<Movie> intresetedMovie = new ArrayList<>();
		for (Movie movie : movies) {
			boolean matched = false;
			if (!StringUtils.isEmpty(interests.getActors())) {
				for (Actor actor : movie.getActor()) {
					if (actor.getName().equalsIgnoreCase(interests.getActors()))
						matched = true;
					break;
				}
			}
			if (!StringUtils.isEmpty(interests.getActors())) {
				for (Actor actor : movie.getActor()) {
					if (actor.getGender().equalsIgnoreCase(interests.getGender()))
						matched = true;
					break;
				}
			}
			if (!StringUtils.isEmpty(interests.getGenre())) {
				matched = movie.getGenre().stream().anyMatch(str -> str.trim().equals(interests.getGenre()));
			}
			if (!StringUtils.isEmpty(interests.getRatings())) {
				if (movie.getRating() >= Double.valueOf(interests.getRatings().replaceAll("[^0-9]+", " "))) {
					matched = true;
				}
			}
			if (!StringUtils.isEmpty(interests.getRuntime())) {
				if (movie.getRuntime() >= Double.valueOf(interests.getRuntime().replaceAll("[^0-9]+", " "))) {
					matched = true;
				}
			}
			if (matched) {
				intresetedMovie.add(movie);
			}
		}
		return intresetedMovie;
	}

}
