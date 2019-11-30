package com.sena.webmotor.dto;

public class GestionarRolDTO {
	
	private int id;
    private String nombre;
	
    public GestionarRolDTO() {
		super();
	}

	public GestionarRolDTO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}       
    
}
