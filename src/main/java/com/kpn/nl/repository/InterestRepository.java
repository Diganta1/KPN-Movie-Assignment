package com.kpn.nl.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kpn.nl.model.Interests;

@Repository
public interface InterestRepository extends CrudRepository<Interests, Long> {

	@Query(value = "SELECT * FROM Interests u WHERE u._CUSTOMER_ID  = ?1", nativeQuery = true)
	Interests findbyProfileId(Long userId);
}
