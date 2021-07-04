package com.aaronvegu.prep.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.aaronvegu.prep.model.Usuario;

public class UsuarioDAOImpl implements UsuarioDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public UsuarioDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public int save(Usuario u) {
		String sql = "INSERT INTO usuarios (nombre, apellidos, correo, password, "
				+ "calle, colonia, num_int, num_ext, municipio, estado, codigo_postal, "
				+ "aprobado, admin) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		return jdbcTemplate.update(sql, u.getNombre(), u.getApellidos(), u.getCorreo(),
				u.getPassword(), u.getCalle(), u.getColonia(), u.getNumInt(), u.getNumExt(),
				u.getMunicipio(), u.getEstado(), u.getCodigoPostal(), u.getAprobado(), 
				u.getAdmin());
	}

	@Override
	public int update(Usuario u) {
		String sql = "UPDATE usuarios SET nombre=?, apellidos=?, correo=?, password=?,"
				+ " calle=?, colonia=?, num_int=?, num_ext=?, municipio=?, estado=?,"
				+ " codigo_postal=?, aprobado=?, admin=? WHERE id=?";
		return jdbcTemplate.update(sql, u.getNombre(), u.getApellidos(), u.getCorreo(),
				u.getPassword(), u.getCalle(), u.getColonia(), u.getNumInt(), u.getNumExt(),
				u.getMunicipio(), u.getEstado(), u.getCodigoPostal(), u.getAprobado(), 
				u.getAdmin(), u.getId());
	}

	@Override
	public Usuario get(Integer id) {
		String sql = "SELECT * FROM usuarios WHERE id=" + id;
		
		ResultSetExtractor<Usuario> extractor = new ResultSetExtractor<Usuario>() {

			@Override
			public Usuario extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					String nombre = rs.getString("nombre");
					String apellidos = rs.getString("apellidos");
					String correo = rs.getString("correo");
					String password = rs.getString("password");
					String calle = rs.getString("calle");
					String colonia = rs.getString("colonia");
					Integer numInt = rs.getInt("num_int");
					Integer numExt = rs.getInt("num_ext");
					String municipio = rs.getString("municipio");
					String estado = rs.getString("estado");
					Integer codigoPostal = rs.getInt("codigo_postal");
					Boolean aprobado = rs.getBoolean("aprobado");
					Boolean admin = rs.getBoolean("admin");
					
					return new Usuario(id, nombre, apellidos, correo, password, 
							calle, colonia, numInt, numExt, municipio, estado, 
							codigoPostal, aprobado, admin);
				}
				
				return null;
			}
		};
		
		return jdbcTemplate.query(sql, extractor);
	}

	@Override
	public Usuario getByMail(String correo) {
		String sql = "SELECT * FROM usuarios WHERE correo='" + correo + "'";
		
		ResultSetExtractor<Usuario> extractor = new ResultSetExtractor<Usuario>() {

			@Override
			public Usuario extractData(ResultSet rs) throws SQLException, DataAccessException {
				if(rs.next()) {
					Integer id = rs.getInt("id");
					String nombre = rs.getString("nombre");
					String apellidos = rs.getString("apellidos");
					String password = rs.getString("password");
					String calle = rs.getString("calle");
					String colonia = rs.getString("colonia");
					Integer numInt = rs.getInt("num_int");
					Integer numExt = rs.getInt("num_ext");
					String municipio = rs.getString("municipio");
					String estado = rs.getString("estado");
					Integer codigoPostal = rs.getInt("codigo_postal");
					Boolean aprobado = rs.getBoolean("aprobado");
					Boolean admin = rs.getBoolean("admin");
					
					return new Usuario(id, nombre, apellidos, correo, password, 
							calle, colonia, numInt, numExt, municipio, estado, 
							codigoPostal, aprobado, admin);
				}
				
				return null;
			}
		};
		
		return jdbcTemplate.query(sql, extractor);
	}
	
	@Override
	public int delete(Integer id) {
		String sql = "DELETE FROM usuarios WHERE id=" + id;
		return jdbcTemplate.update(sql);
	}

	@Override
	public List<Usuario> list() {
		String sql = "SELECT * FROM usuarios";
		
		RowMapper<Usuario> rowMapper = new RowMapper<Usuario>() {

			@Override
			public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String apellidos = rs.getString("apellidos");
				String correo = rs.getString("correo");
				String password = rs.getString("password");
				String calle = rs.getString("calle");
				String colonia = rs.getString("colonia");
				Integer numInt = rs.getInt("num_int");
				Integer numExt = rs.getInt("num_ext");
				String municipio = rs.getString("municipio");
				String estado = rs.getString("estado");
				Integer codigoPostal = rs.getInt("codigo_postal");
				Boolean aprobado = rs.getBoolean("aprobado");
				Boolean admin = rs.getBoolean("admin");
				
				return new Usuario(id, nombre, apellidos, correo, password, 
						calle, colonia, numInt, numExt, municipio, estado, 
						codigoPostal, aprobado, admin);
			}
			
		};
		
		return jdbcTemplate.query(sql, rowMapper);
	}

	@Override
	public int checkUser(String correo, String password) {
		Usuario u = this.getByMail(correo);
		
		if(u.getCorreo() == correo && u.getAprobado() == true)
			return 1;
		else
			return 0;
	}

	@Override
	public int addAdmin(Integer id) {
		Usuario u = this.get(id);
		u.setAprobado(true);
		
		return this.update(u);
	}

}
