package com.aaronvegu.prep.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.aaronvegu.prep.model.Resultado;

class ResultadoDAOTest {

	private DriverManagerDataSource dataSource;
	private ResultadoDAO dao;
	
	@BeforeEach
	void setupBeforeEach() {
		dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sistema_prep_d");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		dao = new ResultadoDAOImpl(dataSource);
	}
	
	@Test
	void testList() {
		List<Resultado> listResultado = dao.list();
		
		for(Resultado aResultado : listResultado) {
			System.out.println(aResultado);
		}
		
		assertTrue(!listResultado.isEmpty());
	}

}
