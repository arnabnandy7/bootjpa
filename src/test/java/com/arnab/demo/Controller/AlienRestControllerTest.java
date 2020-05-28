package com.arnab.demo.Controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.arnab.demo.Model.Alien;
import com.arnab.demo.Service.AlienService;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <strong>The test of AlienRestController class is a unit test as per the
 * type.</strong> Difference between unit test and integration test case of
 * controller is loading the entire application using @SpringBootTest. Now that
 * is our integration testing. For @WebMvcTest and other slice annotation, we
 * are only loading our application partially to test different units of our
 * application. <br>
 * <br>
 * <strong>Reference :</strong>
 * {@link https://medium.com/@thankgodukachukwu/unit-and-integrated-testing-spring-boot-and-junit-5-99b9745b782a
 * }
 * 
 * @author arnab
 *
 */

@WebMvcTest(AlienRestController.class)
public class AlienRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AlienService alienService;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void testCreate() throws Exception {
		// Stubbing
		Alien alien = Alien.builder().aid(110).aname("Farhan").tech("Java").build();
		when(alienService.create(alien)).thenReturn(alien);
		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/alien").content(objectMapper.writeValueAsString(alien))
						.contentType(MediaType.APPLICATION_JSON))
				.andDo(print()).andExpect(status().isCreated())
				.andExpect(MockMvcResultMatchers.jsonPath("$.aid").value(alien.getAid()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.aname").value(alien.getAname()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.tech").value(alien.getTech()));

		ArgumentCaptor<Alien> alienArgumentCaptor = ArgumentCaptor.forClass(Alien.class);
		verify(alienService, times(1)).create(alienArgumentCaptor.capture());
	}
}
