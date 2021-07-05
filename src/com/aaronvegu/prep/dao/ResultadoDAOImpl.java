package com.aaronvegu.prep.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.aaronvegu.prep.model.Resultado;

public class ResultadoDAOImpl implements ResultadoDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public ResultadoDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Resultado> list() {
		String sql = "SELECT candidaturas.nombre_cand, candidaturas.partido, "
				+ "candidaturas.local, candidaturas.federal, casillas.tipo_casilla, "
				+ "casillas.municipio, casillas.sección, casillas.distrito, "
				+ "votos.cantidad FROM ((votos INNER JOIN casillas ON "
				+ "votos.casilla = casillas.id) INNER JOIN candidaturas ON "
				+ "votos.candidatura = candidaturas.id)";
		
		RowMapper<Resultado> rowMapper = new RowMapper<Resultado>() {

			@Override
			public Resultado mapRow(ResultSet rs, int rowNum) throws SQLException {
				String candidatura = rs.getString("nombre_cand");
				String partido = rs.getString("partido");
				Boolean local = rs.getBoolean("local");
				Boolean federal = rs.getBoolean("federal");
				String tipo = rs.getString("tipo_casilla");
				String municipio = rs.getString("municipio");
				Integer seccion = rs.getInt("sección");
				Integer distrito = rs.getInt("distrito");
				Integer cantidad = rs.getInt("cantidad");
				
				return new Resultado(candidatura, partido, local, federal, tipo,
						 municipio, seccion, distrito, cantidad);
			}
			
		};
		
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
	public List<Resultado> getResultsByParty() {
		String sql = "SELECT candidaturas.partido, votos.cantidad FROM votos "
				+ "INNER JOIN candidaturas ON votos.candidatura = candidaturas.id "
				+ "GROUP BY partido;";
		
		RowMapper<Resultado> rowMapper = new RowMapper<Resultado>() {

			@Override
			public Resultado mapRow(ResultSet rs, int rowNum) throws SQLException {
				String partido = rs.getString("partido");
				Integer cantidad = rs.getInt("cantidad");
				
				return new Resultado(partido, cantidad);
			}
			
		};
		
		return jdbcTemplate.query(sql, rowMapper);
	}

}
