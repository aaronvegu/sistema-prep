package com.aaronvegu.prep.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.aaronvegu.prep.model.Casilla;

public class CasillaDAOImpl implements CasillaDAO {

	private JdbcTemplate jdbcTemplate;
	
	public CasillaDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int save(Casilla casilla) {
		String sql = "INSERT INTO casillas (tipo_casilla, municipio, sección, "
				+ "distrito) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, casilla.getTipoCasilla(), 
				casilla.getMunicipio(), casilla.getSeccion(), casilla.getDistrito());
	}

	@Override
	public int update(Casilla casilla) {
		String sql = "UPDATE casillas SET tipo_casilla=?, municipio=?, sección=?, "
				+ "distrito=? WHERE id=?";
		return jdbcTemplate.update(sql, casilla.getTipoCasilla(), casilla.getMunicipio(),
				casilla.getSeccion(), casilla.getDistrito(), casilla.getId());
	}

	@Override
	public Casilla get(Integer id) {
		String sql = "SELECT * FROM casillas WHERE id=" + id;
		
		ResultSetExtractor<Casilla> extractor = new ResultSetExtractor<Casilla>() {

			@Override
			public Casilla extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String tipoCasilla = rs.getString("tipo_casilla");
					String municipio = rs.getString("municipio");
					Integer seccion = rs.getInt("sección");
					Integer casilla = rs.getInt("distrito");
					
					return new Casilla(id, tipoCasilla, municipio, seccion, casilla);
				}
				
				return null;
			}
		};
		
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM casillas WHERE id=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Casilla> list() {
		String sql = "SELECT * FROM casillas";
		
		RowMapper<Casilla> rowMapper = new RowMapper<Casilla>() {

			@Override
			public Casilla mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				String tipoCasilla = rs.getString("tipo_casilla");
				String municipio = rs.getString("municipio");
				Integer seccion = rs.getInt("sección");
				Integer casilla = rs.getInt("distrito");
				
				return new Casilla(id, tipoCasilla, municipio, seccion, casilla);
			}
			
		};
		
		return jdbcTemplate.query(sql, rowMapper);
	}

}
