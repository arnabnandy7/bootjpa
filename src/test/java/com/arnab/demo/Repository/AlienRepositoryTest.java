package com.arnab.demo.Repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.arnab.demo.Model.Alien;

@DataJpaTest
@ActiveProfiles("test")
public class AlienRepositoryTest {

	Logger logger = LoggerFactory.getLogger(AlienRepositoryTest.class);

	@Autowired
	private AlienRepository alienRepository;

	@Test
	public void testCreate() {
		Alien alienToBeSaved = Alien.builder().aname("sahid").tech("ruby").build();
		Alien alienToBeSaved1 = Alien.builder().aname("luis").tech("gcp").build();
		Alien savedAlien = alienRepository.save(alienToBeSaved);
		alienRepository.save(alienToBeSaved1);
		logger.info("-------:::::::Alien Created:::::::-------" + savedAlien.getAname());
		alienRepository.findAll().forEach(alien -> logger.info("Alien----->" + alien.getAname()));
		assertThat(savedAlien).isNotNull();
	}
}
