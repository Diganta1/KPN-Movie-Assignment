package com.kpn.nl.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kpn.nl.model.Profile;

@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {

}
