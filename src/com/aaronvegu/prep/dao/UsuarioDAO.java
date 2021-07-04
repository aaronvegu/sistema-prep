package com.aaronvegu.prep.dao;

import java.util.List;

import com.aaronvegu.prep.model.Usuario;

public interface UsuarioDAO {

	public int save(Usuario casilla);
	
	public int update(Usuario casilla);
	
	public Usuario get(Integer id);
	
	public Usuario getByMail(String correo);
	
	public int delete(Integer id);
	
	public List<Usuario> list();
	
	public int checkUser(String correo);
	
	public int addAdmin(Integer id);
	
}
