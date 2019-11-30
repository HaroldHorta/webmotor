package com.sena.webmotor.dto;

public class IdPQRDTO {
	
	private int id;
	private String descripcion;
	/**
	 * 
	 */
	public IdPQRDTO() {
		super();
	}
	/**
	 * @param id
	 * @param descripcion
	 */
	public IdPQRDTO(int id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
