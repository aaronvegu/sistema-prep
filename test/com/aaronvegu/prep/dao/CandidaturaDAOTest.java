package com.aaronvegu.prep.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.aaronvegu.prep.model.Candidatura;

class CandidaturaDAOTest {

	private DriverManagerDataSource dataSource;
	private CandidaturaDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sistema_prep_d");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		dao = new CandidaturaDAOImpl(dataSource);
	}
	
	@Test
	void testSave() {
		Candidatura candidatura = new Candidatura("diputacion", "MORENA", 0, 1);
		int result = dao.save(candidatura);
		
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Candidatura candidatura = new Candidatura(1, "diputacion federal", "mc", 0, 1);
		int result = dao.update(candidatura);
		
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 1;
		Candidatura candidatura = dao.get(id);
		
		if(candidatura != null)
			System.out.println(candidatura);
		
		assertNotNull(candidatura);
	}

	@Test
	void testDelete() {
		Integer id = 1;
		int result = dao.delete(id);
		
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Candidatura> listCandidaturas = dao.list();
		
		for(Candidatura aCandidatura : listCandidaturas) {
			System.out.println(aCandidatura);
		}
		
		assertTrue(!listCandidaturas.isEmpty());
	}

}
