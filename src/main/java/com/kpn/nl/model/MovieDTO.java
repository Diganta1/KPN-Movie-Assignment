package com.kpn.nl.model;

public class MovieDTO {
	
	public MovieDTO(String title, String imdb) {
		super();
		this.title = title;
		this.imdb = imdb;
	}

	private String title;
	private String imdb;
	
	

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the imdb
	 */
	public String getImdb() {
		return imdb;
	}

	/**
	 * @param imdb the imdb to set
	 */
	public void setImdb(String imdb) {
		this.imdb = imdb;
	}



}
