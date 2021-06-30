package com.aaronvegu.prep.model;

public class Voto {
	
	private Integer id;
	private Integer casilla;
	private Integer candidatura;
	private Integer cantidad;
	
	public Voto() {
		
	}
	
	public Voto(Integer id, Integer casilla, Integer candidatura, Integer cantidad) {
		this(casilla, candidatura, cantidad);
		this.id = id;
	}
	
	public Voto(Integer casilla, Integer candidatura, Integer cantidad) {
		this.casilla = casilla;
		this.candidatura = candidatura;
		this.cantidad = cantidad;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCasilla() {
		return casilla;
	}
	public void setCasilla(Integer casilla) {
		this.casilla = casilla;
	}
	public Integer getCandidatura() {
		return candidatura;
	}
	public void setCandidatura(Integer candidatura) {
		this.candidatura = candidatura;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "Voto [id=" + id + ", casilla=" + casilla + ", candidatura=" + candidatura + ", cantidad=" + cantidad
				+ "]";
	}

}
