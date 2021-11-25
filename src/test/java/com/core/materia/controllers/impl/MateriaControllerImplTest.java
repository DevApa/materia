package com.core.materia.controllers.impl;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.core.materia.controllers.dto.MateriaDTO;
import com.core.materia.repository.contract.IMateriaRepository;
import com.core.materia.repository.models.Materia;
import com.core.materia.utils.ModelMap;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class MateriaControllerImplTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private IMateriaRepository repository;
	
	private File datosJson;	
	
	@BeforeEach
	void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		this.datosJson = new  File("src/test/resources/materias.json");
	}

	@AfterEach
	void tearDown() throws Exception {
		repository.deleteAll();
		this.datosJson = null;
		this.mockMvc = null;
	}

	@Test
	void testGetList() throws Exception{
		List<Materia> materias = objectMapper.readValue(datosJson, new TypeReference<List<Materia>>() {});
		
		repository.saveAll(materias);
		
		this.mockMvc.perform(MockMvcRequestBuilders
				.get("/api/es/secoed/materia/list")
				.accept(MediaType.APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void testCreate() throws Exception{		
			MateriaDTO materiaDTO = objectMapper.readValue(datosJson, new TypeReference<List<MateriaDTO>>() {}).get(0);
			
			this.mockMvc.perform(MockMvcRequestBuilders
					.post("/api/es/secoed/materia/create")
					.content(objectMapper.writeValueAsString(materiaDTO))
					.contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON))
			.andDo(MockMvcResultHandlers.print())
			.andExpect(MockMvcResultMatchers.status().isCreated());
	}

	@Test
	void testUpdate() throws Exception{		
		Materia materia = objectMapper.readValue(datosJson, new TypeReference<List<Materia>>() {}).get(0);
		MateriaDTO materiaDTO = ModelMap.modelToDto(repository.save(materia));
		
		materiaDTO.setName("Facultad Ciencias Matemáticas y Físicas");
		
		this.mockMvc.perform(MockMvcRequestBuilders
				.put("/api/es/secoed/materia/update")
				.content(objectMapper.writeValueAsString(materiaDTO))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	void testDelete() throws Exception{
		Materia materia = objectMapper.readValue(datosJson, new TypeReference<List<Materia>>(){}).get(0);
		materia = repository.save(materia);
		
		this.mockMvc.perform(MockMvcRequestBuilders				
				.delete("/api/es/secoed/materia/delete/{id}", materia.getId().intValue())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
		.andDo(MockMvcResultHandlers.print())
		.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
