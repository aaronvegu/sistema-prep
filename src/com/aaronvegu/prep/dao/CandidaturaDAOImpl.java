package com.aaronvegu.prep.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.aaronvegu.prep.model.Candidatura;

public class CandidaturaDAOImpl implements CandidaturaDAO {

	private JdbcTemplate jdbcTemplate;
	
	public CandidaturaDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public int save(Candidatura candidatura) {
		String sql = "INSERT INTO candidaturas (nombre_cand, partido, local, federal) VALUES (?, ?, ?, ?)";
		return jdbcTemplate.update(sql, candidatura.getNombre_cand(), candidatura.getPartido(), 
				candidatura.getLocal(), candidatura.getFederal());
	}

	@Override
	public int update(Candidatura candidatura) {
		String sql = "UPDATE candidaturas SET nombre_cand=?, partido=?, local=?, federal=? WHERE id=?";
		return jdbcTemplate.update(sql, candidatura.getNombre_cand(), candidatura.getPartido(), 
				candidatura.getLocal(), candidatura.getFederal(), candidatura.getId());
	}

	@Override
	public Candidatura get(Integer id) {
		String sql = "SELECT * FROM candidaturas WHERE id=" + id;
		
		ResultSetExtractor<Candidatura> extractor = new ResultSetExtractor<Candidatura>() {

			@Override
			public Candidatura extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String nombreCandidatura = rs.getString("nombre_cand");
					String partido = rs.getString("partido");
					Integer local = rs.getInt("local");
					Integer federal = rs.getInt("federal");
					
					return new Candidatura(id, nombreCandidatura, partido, local, federal);
				}
				
				return null;
			}
		};
		
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM candidaturas WHERE id=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Candidatura> list() {
		String sql = "SELECT * FROM candidaturas";
		
		RowMapper<Candidatura> rowMapper = new RowMapper<Candidatura>() {

			@Override
			public Candidatura mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				String nombreCand = rs.getString("nombre_cand");
				String partido = rs.getString("partido");
				Integer local = rs.getInt("local");
				Integer federal = rs.getInt("federal");
				
				return new Candidatura(id, nombreCand, partido, local, federal);
			}
			
		};
		
		return jdbcTemplate.query(sql, rowMapper);
	}

}
