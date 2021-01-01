package com.arnab.demo.Repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.arnab.demo.Model.Alien;

// Turn Off all Swagger2 annotations and configurations to execute this repository test case

@DataJpaTest
@ActiveProfiles("test")
public class AlienRepositoryTest {

	Logger logger = LoggerFactory.getLogger(AlienRepositoryTest.class);

	@Autowired
	private AlienRepository alienRepository;

	@Test
	public void testCreate() {
		Alien alienToBeSaved = new Alien();
		Alien alienToBeSaved1 = new Alien();
		alienToBeSaved.setAid(Integer.parseInt("110"));
		alienToBeSaved.setAname("sahid");
		alienToBeSaved.setTech("ruby");
		
		alienToBeSaved.setAid(Integer.parseInt("111"));
		alienToBeSaved.setAname("luis");
		alienToBeSaved.setTech("gcp");
		
		Alien savedAlien = alienRepository.save(alienToBeSaved);
		alienRepository.save(alienToBeSaved1);
		logger.info("-------:::::::Alien Created:::::::-------" + savedAlien.getAname());
		alienRepository.findAll().forEach(alien -> logger.info("Alien----->" + alien.getAname()));
		assertThat(savedAlien).isNotNull();
	}

	@Test
	public void testFindByTechnology() {
		int totalCountByTech = alienRepository.findByTech("java").size();
		logger.error("count::" + totalCountByTech);
		assertEquals(totalCountByTech, 3);
	}
}
