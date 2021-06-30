package com.aaronvegu.prep.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.aaronvegu.prep.model.Voto;

class VotoDAOImplTest {

	private DriverManagerDataSource dataSource;
	private VotoDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sistema_prep_d");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		dao = new VotoDAOImpl(dataSource);
	}
	
	@Test
	void testSave() {
		Voto voto = new Voto(3, 2, 2155);
		int result = dao.save(voto);
		
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Voto voto = new Voto(3, 3, 2, 2686);
		int result = dao.update(voto);
		
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 2;
		Voto voto = dao.get(id);
		
		if(voto != null)
			System.out.println(voto);
		
		assertNotNull(voto);
	}

	@Test
	void testDelete() {
		Integer id = 3;
		int result = dao.delete(id);
		
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Voto> listVotos = dao.list();
		
		for(Voto aVoto : listVotos) {
			System.out.println(aVoto);
		}
		
		assertTrue(!listVotos.isEmpty());
	}
	
	@Test
	void testGetTotalVotos() {
		int totalVotos = dao.getTotalVotos();
		
		if(totalVotos != 0)
			System.out.println(totalVotos);
		
		assertNotNull(totalVotos);
	}

}
