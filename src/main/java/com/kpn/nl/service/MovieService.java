package com.kpn.nl.service;

import java.util.List;

import com.kpn.nl.exception.UserNotExistsException;
import com.kpn.nl.model.Movie;

public interface MovieService {

	public List<Movie> findInterests(Long Id) throws UserNotExistsException;
}
