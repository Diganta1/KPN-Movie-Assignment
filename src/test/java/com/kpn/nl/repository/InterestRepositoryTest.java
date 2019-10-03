package com.kpn.nl.repository;

import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kpn.nl.model.Interests;

@RunWith(SpringRunner.class)
@DataJpaTest
public class InterestRepositoryTest {

	@Autowired
	private InterestRepository interestRepository;

	
	@Test
	public void whenFindByUserId_thenReturnNull() {
		Interests found = interestRepository.findbyProfileId(1008L);
		assertNull("Movie searched is present",found);
	}
}