package com.aaronvegu.prep.model;

public class Usuario {

	private Integer id;
	private String nombre;
	private String apellidos;
	private String correo;
	private String password;
	private String calle;
	private String colonia;
	private Integer numInt;
	private Integer numExt;
	private String municipio;
	private String estado;
	private Integer codigoPostal;
	private Boolean aprobado;
	private Boolean admin;
	
	public Usuario() {
		
	}	
	
	public Usuario(Integer id, String nombre, String apellidos, String correo, String password, String calle,
			String colonia, Integer numInt, Integer numExt, String municipio, String estado, Integer codigoPostal,
			Boolean aprobado, Boolean admin) {
		
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.password = password;
		this.calle = calle;
		this.colonia = colonia;
		this.numInt = numInt;
		this.numExt = numExt;
		this.municipio = municipio;
		this.estado = estado;
		this.codigoPostal = codigoPostal;
		this.aprobado = aprobado;
		this.admin = admin;
	}

	public Usuario(String nombre, String apellidos, String correo, String password, String calle,
			String colonia, Integer numInt, Integer numExt, String municipio, String estado, Integer codigoPostal,
			Boolean aprobado, Boolean admin) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.password = password;
		this.calle = calle;
		this.colonia = colonia;
		this.numInt = numInt;
		this.numExt = numExt;
		this.municipio = municipio;
		this.estado = estado;
		this.codigoPostal = codigoPostal;
		this.aprobado = aprobado;
		this.admin = admin;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public Integer getNumInt() {
		return numInt;
	}
	public void setNumInt(Integer numInt) {
		this.numInt = numInt;
	}
	public Integer getNumExt() {
		return numExt;
	}
	public void setNumExt(Integer numExt) {
		this.numExt = numExt;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public Boolean getAprobado() {
		return aprobado;
	}
	public void setAprobado(Boolean aprobado) {
		this.aprobado = aprobado;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo
				+ ", password=" + password + ", calle=" + calle + ", colonia=" + colonia + ", numInt=" + numInt
				+ ", numExt=" + numExt + ", municipio=" + municipio + ", estado=" + estado + ", codigoPostal="
				+ codigoPostal + ", aprobado=" + aprobado + ", admin=" + admin + "]";
	}
	
}
