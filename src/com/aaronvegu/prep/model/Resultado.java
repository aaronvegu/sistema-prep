package com.aaronvegu.prep.model;

public class Resultado {

	private String candidatura;
	private String partido;
	private Boolean local;
	private Boolean federal;
	private String tipo;
	private String municipio;
	private Integer seccion;
	private Integer distrito;
	private Integer cantidad;
	
	
	public Resultado() {
		
	}
	
	public Resultado(String candidatura, String partido, Boolean local, Boolean federal, String tipo, String municipio,
			Integer seccion, Integer distrito, Integer cantidad) {
		this.candidatura = candidatura;
		this.partido = partido;
		this.local = local;
		this.federal = federal;
		this.tipo = tipo;
		this.municipio = municipio;
		this.seccion = seccion;
		this.distrito = distrito;
		this.cantidad = cantidad;
	}
	
	
	public String getCandidatura() {
		return candidatura;
	}
	public void setCandidatura(String candidatura) {
		this.candidatura = candidatura;
	}
	public String getPartido() {
		return partido;
	}
	public void setPartido(String partido) {
		this.partido = partido;
	}
	public Boolean getLocal() {
		return local;
	}
	public void setLocal(Boolean local) {
		this.local = local;
	}
	public Boolean getFederal() {
		return federal;
	}
	public void setFederal(Boolean federal) {
		this.federal = federal;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
	
	@Override
	public String toString() {
		return "Resultado [candidatura=" + candidatura + ", partido=" + partido + ", local=" + local + ", federal="
				+ federal + ", tipo=" + tipo + ", municipio=" + municipio + ", seccion=" + seccion + ", distrito="
				+ distrito + ", cantidad=" + cantidad + "]";
	}
	
}
