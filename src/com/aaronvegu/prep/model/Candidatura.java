package com.aaronvegu.prep.model;

public class Candidatura {
	
	private Integer id;
	private String nombre_cand;
	private String partido;
	private Integer local;
	private Integer federal;
	
	public Candidatura() {
		
	}
	
	public Candidatura(Integer id, String nombre_cand, String partido, Integer local, Integer federal) {
		this(nombre_cand, partido, local, federal);
		this.id = id;
	}

	public Candidatura(String nombre_cand, String partido, Integer local, Integer federal) {
		this.nombre_cand = nombre_cand;
		this.partido = partido;
		this.local = local;
		this.federal = federal;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNombre_cand() {
		return nombre_cand;
	}
	
	public void setNombre_cand(String nombre_cand) {
		this.nombre_cand = nombre_cand;
	}
	
	public String getPartido() {
		return partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}

	public Integer getLocal() {
		return local;
	}

	public void setLocal(Integer local) {
		this.local = local;
	}

	public Integer getFederal() {
		return federal;
	}

	public void setFederal(Integer federal) {
		this.federal = federal;
	}

	@Override
	public String toString() {
		return "Candidatura [id=" + id + ", nombre_cand=" + nombre_cand + ", partido=" + partido + ", local=" + local
				+ ", federal=" + federal + "]";
	}
	
}
