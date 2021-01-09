package com.zooapi.Zooapi;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase
class ZooapiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void smoke() {
		assertTrue(true);
	}

	@Test
  	public void addAnimaltoZooTest() throws Exception {
		Zoo zoo = new Zoo();
		Animal animal = new Animal("tiger", "walking");
		zoo.setAnimal(animal);
		mockMvc.perform(post("/api/zoo")
				.content(objectMapper.writeValueAsString(zoo))
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.id").exists())
				.andExpect(jsonPath("$.animal.animalId").exists());


	}
    @Test
  	public void getAllAnimalsTest() throws Exception {
		addAnimaltoZooTest();
		mockMvc.perform(get("/api/zoo"))
				.andExpect(status().isOk())
				.andDo(print())
				.andExpect(jsonPath("$.*", hasSize(1)));

}

}
