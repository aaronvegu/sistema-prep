package com.aaronvegu.prep.dao;

import java.util.List;

import com.aaronvegu.prep.model.Candidatura;

public interface CandidaturaDAO {

	public int save(Candidatura candidatura);
	
	public int update(Candidatura candidatura);
	
	public Candidatura get(Integer id);
	
	public int delete(Integer id);
	
	public List<Candidatura> list();
	
}
