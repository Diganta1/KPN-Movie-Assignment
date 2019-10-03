package com.kpn.nl.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@XmlRootElement(name = "movie")
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie {

	@Id
	@GeneratedValue
	private Long id;

	private String title;

	@XmlElementWrapper(name = "genres")
    //@OneToMany(cascade = CascadeType.ALL)
    @ElementCollection(targetClass=String.class)
	private List<String> genre;

	@XmlElementWrapper(name = "actors")
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "_id", referencedColumnName = "id")
	private List<Actor> actor;

	private double rating;

	private double runtime;

	private String imdb;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getGenre() {
		return genre;
	}

	public void setGenre(List<String> genres) {
		this.genre = genres;
	}

	public List<Actor> getActor() {
		return actor;
	}

	public void setActor(List<Actor> actors) {
		this.actor = actors;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getRuntime() {
		return runtime;
	}

	public void setRuntime(double runtime) {
		this.runtime = runtime;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

}
