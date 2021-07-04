package com.aaronvegu.prep.dao;

import java.util.List;

import com.aaronvegu.prep.model.Usuario;

public interface UsuarioDAO {

	public int save(Usuario casilla);
	
	public int update(Usuario casilla);
	
	public Usuario get(Integer id);
	
	public int delete(Integer id);
	
	public List<Usuario> list();
	
	public int checkUser(Integer id);
	
	public int addAdmin(Integer id);
	
}
