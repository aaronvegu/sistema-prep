package com.aaronvegu.prep.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.aaronvegu.prep.model.Casilla;

class CasillaDAOTest {

	private DriverManagerDataSource dataSource;
	private CasillaDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sistema_prep_d");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		dao = new CasillaDAOImpl(dataSource);
	}
	
	@Test
	void testSave() {
		Casilla casilla = new Casilla("especial", "zapopan", 2684, 11);
		int result = dao.save(casilla);
		
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Casilla casilla = new Casilla(6, "contigua", "tonala", 2686, 11);
		int result = dao.update(casilla);
		
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 6;
		Casilla casilla = dao.get(id);
		
		if(casilla != null)
			System.out.println(casilla);
		
		assertNotNull(casilla);
	}

	@Test
	void testDelete() {
		Integer id = 3;
		int result = dao.delete(id);
		
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Casilla> listCasillas = dao.list();
		
		for(Casilla aCasilla : listCasillas) {
			System.out.println(aCasilla);
		}
		
		assertTrue(!listCasillas.isEmpty());
	}

}
