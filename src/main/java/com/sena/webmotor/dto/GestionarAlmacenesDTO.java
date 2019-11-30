package com.sena.webmotor.dto;

public class GestionarAlmacenesDTO {
	private int id;
    private String nombre;
    private String telefono;
    private int id_direccion;
	
    public GestionarAlmacenesDTO() {
		super();
	}
    
    

	public GestionarAlmacenesDTO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}



	public GestionarAlmacenesDTO(int id, String nombre, String telefono, int id_direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.id_direccion = id_direccion;
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getId_direccion() {
		return id_direccion;
	}

	public void setId_direccion(int id_direccion) {
		this.id_direccion = id_direccion;
	}
    
    
    
}
