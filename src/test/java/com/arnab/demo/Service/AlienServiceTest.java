package com.arnab.demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;

import com.arnab.demo.Model.Alien;
import com.arnab.demo.Repository.AlienRepository;

@ExtendWith(MockitoExtension.class)
//@RunWith(MockitoJUnitRunner.class)
@ActiveProfiles("test")
public class AlienServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(AlienServiceTest.class);

	@InjectMocks
	private AlienService alienService = new AlienServiceImpl();

	@Mock
	private AlienRepository alienRepository;

	@Test
	public void testFindByTechnology() {
		// Stubbing
		Alien alien = Alien.builder().aname("arnab").tech("java").aid(101).build();
		when(alienRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(alien));
		logger.error("alienWithName1::" + alien.getTech() + "::" + alien.getAid() + "::" + alien.getAname());
		// Actual Call
		Alien alienWithName = alienService.findByName(alien.getAid());

		logger.error("alienWithName2::" + alienWithName.getTech() + "::" + alienWithName.getAid() + "::"
				+ alienWithName.getAname());

		// Assertion
		assertEquals("cpp", alienWithName.getTech());

		ArgumentCaptor<Integer> intArgumentCaptor = ArgumentCaptor.forClass(Integer.class);
		logger.error("Argument Captor::" + intArgumentCaptor.getAllValues());
		assertEquals(new Integer(101), intArgumentCaptor.getAllValues().get(0));
		assertEquals(new Integer(104), intArgumentCaptor.getAllValues().get(1));
	}
}
