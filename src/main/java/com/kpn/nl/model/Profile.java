package com.kpn.nl.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Profile {

	@Id
	@JsonProperty("customer_id")
	private long customerId;

	@JsonProperty("name")
	private String name;
	
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "_customerId", referencedColumnName = "customerId")
	private List<Interests> interests;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Interests> getInterests() {
		if (null == interests) {
			interests = new ArrayList<>();
		}
		return interests;
	}

	public void setInterests(List<Interests> interests) {
		this.interests = interests;
	}

	public void addInterests(Interests intersets) {
		interests.add(intersets);
		intersets.setProfile(this);
	}
}
