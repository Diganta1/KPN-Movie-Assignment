package com.kpn.nl.model;

import java.util.ArrayList;
import java.util.List;

public class MoviesDTO {

	private List<MovieDTO> movieCategory;

	/**
	 * @return the movieCategory
	 */
	public List<MovieDTO> getMovieCategory() {
		if (null == movieCategory) {
			movieCategory = new ArrayList<>();
		}
		return movieCategory;
	}

	/**
	 * @param movieCategory the movieCategory to set
	 */
	public void setMovieCategory(List<MovieDTO> movieCategory) {
		this.movieCategory = movieCategory;
	}

}
