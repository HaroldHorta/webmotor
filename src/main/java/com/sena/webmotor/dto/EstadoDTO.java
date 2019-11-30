package com.sena.webmotor.dto;

public class EstadoDTO {

	 private int id_estado ;
	 private String nombre_estado;
	 
	 
	/** Constructor para construir el combo box de a tabla estado para pqr
	 * @param id
	 * @param nombre_estado
	 */
	 public EstadoDTO() {
		 super();
	 }
	 
	public EstadoDTO(int id_estado, String nombre_estado) {
		super();
		this.id_estado = id_estado;
		this.nombre_estado = nombre_estado;
	}



	public int getId_estado() {
		return id_estado;
	}


	public void setId_estado(int id_estado) {
		this.id_estado = id_estado;
	}


	public String getNombre_estado() {
		return nombre_estado;
	}


	public void setNombre_estado(String nombre_estado) {
		this.nombre_estado = nombre_estado;
	}
	 
	 
	
}
