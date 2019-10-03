package com.kpn.nl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kpn.nl.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {
}

