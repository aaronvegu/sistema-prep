package com.aaronvegu.prep.model;

public class Casilla {

	private Integer id;
	private String tipoCasilla;
	private String municipio;
	private Integer seccion;
	private Integer distrito;
	
	public Casilla() {
		
	}
	
	public Casilla(Integer id, String tipoCasilla, String municipio, Integer seccion, Integer distrito) {
		this(tipoCasilla, municipio, seccion, distrito);
		this.id = id;
	}

	public Casilla(String tipoCasilla, String municipio, Integer seccion, Integer distrito) {
		this.tipoCasilla = tipoCasilla;
		this.municipio = municipio;
		this.seccion = seccion;
		this.distrito = distrito;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoCasilla() {
		return tipoCasilla;
	}

	public void setTipoCasilla(String tipoCasilla) {
		this.tipoCasilla = tipoCasilla;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public Integer getSeccion() {
		return seccion;
	}

	public void setSeccion(Integer seccion) {
		this.seccion = seccion;
	}

	public Integer getDistrito() {
		return distrito;
	}

	public void setDistrito(Integer distrito) {
		this.distrito = distrito;
	}

	@Override
	public String toString() {
		return "Casilla [id=" + id + ", tipoCasilla=" + tipoCasilla + ", municipio=" + municipio + ", seccion="
				+ seccion + ", distrito=" + distrito + "]";
	}
	
	

}
