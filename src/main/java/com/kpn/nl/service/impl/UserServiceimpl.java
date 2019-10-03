package com.kpn.nl.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kpn.nl.model.Profile;
import com.kpn.nl.repository.ProfileRepository;

@Service
public class UserServiceimpl {

	private ProfileRepository profileRepository;

	public UserServiceimpl(ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}

	public Iterable<Profile> save(List<Profile> profiles) {
		return profileRepository.saveAll(profiles);
	}

}
