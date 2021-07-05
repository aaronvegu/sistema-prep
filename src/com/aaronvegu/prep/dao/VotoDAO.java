package com.aaronvegu.prep.dao;

import java.util.List;

import com.aaronvegu.prep.model.Voto;

public interface VotoDAO {

	public int save(Voto voto);
	
	public int update(Voto voto);
	
	public Voto get(Integer id);
	
	public int delete(Integer id);
	
	public List<Voto> list();
	
	public int getTotalVotos();

}
