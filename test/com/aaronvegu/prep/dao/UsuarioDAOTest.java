package com.aaronvegu.prep.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.aaronvegu.prep.model.Usuario;
import com.aaronvegu.prep.model.Usuario;

class UsuarioDAOTest {
	
	private DriverManagerDataSource dataSource;
	private UsuarioDAO dao;

	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sistema_prep_d");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		dao = new UsuarioDAOImpl(dataSource);
	}	
	
	@Test
	void testSave() {
		Usuario usuario = new Usuario("Aldo", "Garcia Hernandez", "aldo.josue@gmail.com", 
				"aldo", "palmas", "Centro", 14, 0, "Tonala", "Jalisco", 
				47810, false, false);
		int result = dao.save(usuario);
		
		assertTrue(result > 0);
	}

	@Test
	void testUpdate() {
		Usuario usuario = new Usuario(1, "Joseph", "Velazquez Gurrola", "aaronvegu@gmail.com", 
				"aaron", "panama", "Villas del sol", 110, 13, "Tonala", "Jalisco", 
				44100, false, false);
		int result = dao.update(usuario);
		
		assertTrue(result > 0);
	}

	@Test
	void testGet() {
		Integer id = 1;
		Usuario usuario = dao.get(id);
		
		if(usuario != null)
			System.out.println(usuario);
		
		assertNotNull(usuario);
	}

	@Test
	void testDelete() {
		Integer id = 2;
		int result = dao.delete(id);
		
		assertTrue(result > 0);
	}

	@Test
	void testList() {
		List<Usuario> listUsuarios = dao.list();
		
		for(Usuario aUsuario : listUsuarios) {
			System.out.println(aUsuario);
		}
		
		assertTrue(!listUsuarios.isEmpty());
	}

	@Test
	void testCheckUser() {
		fail("Not yet implemented");
	}

	@Test
	void testAddAdmin() {
		fail("Not yet implemented");
	}

}
