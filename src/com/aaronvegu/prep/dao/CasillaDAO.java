package com.aaronvegu.prep.dao;

import com.aaronvegu.prep.model.Casilla;
import java.util.List;

public interface CasillaDAO {
	
	public int save(Casilla casilla);
	
	public int update(Casilla casilla);
	
	public Casilla get(Integer id);
	
	public int delete(Integer id);
	
	public List<Casilla> list();

}
