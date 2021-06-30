package com.aaronvegu.prep.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.aaronvegu.prep.model.Voto;

public class VotoDAOImpl implements VotoDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public VotoDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Voto voto) {
		String sql = "INSERT INTO votos (casilla, candidatura, cantidad) VALUES (?, ?, ?)";
		return jdbcTemplate.update(sql, voto.getCasilla(), voto.getCandidatura(), voto.getCantidad());
	}

	@Override
	public int update(Voto voto) {
		String sql = "UPDATE votos SET casilla=?, candidatura=?, cantidad=? WHERE id=?";
		return jdbcTemplate.update(sql, voto.getCasilla(), voto.getCandidatura(), 
				voto.getCantidad(), voto.getId());
	}

	@Override
	public Voto get(Integer id) {
		String sql = "SELECT * FROM votos WHERE id=" + id;
		
		ResultSetExtractor<Voto> extractor = new ResultSetExtractor<Voto>() {

			@Override
			public Voto extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					Integer casilla = rs.getInt("casilla");
					Integer candidatura = rs.getInt("candidatura");
					Integer cantidad = rs.getInt("cantidad");
					
					return new Voto(id, casilla, candidatura, cantidad);
				}
				
				return null;
			}
		};
		
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM votos WHERE id=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Voto> list() {
		String sql = "SELECT * FROM votos";
		
		RowMapper<Voto> rowMapper = new RowMapper<Voto>() {

			@Override
			public Voto mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				Integer casilla = rs.getInt("casilla");
				Integer candidatura = rs.getInt("candidatura");
				Integer cantidad = rs.getInt("cantidad");
				
				return new Voto(id, casilla, candidatura, cantidad);
			}
			
		};
		
		return jdbcTemplate.query(sql, rowMapper);
	}

}
