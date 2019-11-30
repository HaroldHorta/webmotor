package com.sena.webmotor.dto;

public class NombreDTO {
	
	private String cedula;
	private String nombre;
	/**
	 * 
	 */
	public NombreDTO() {
		super();
	}
	/**
	 * @param cedula
	 * @param nombre
	 */
	public NombreDTO(String cedula, String nombre) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
