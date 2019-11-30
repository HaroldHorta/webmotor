package com.sena.webmotor.dto;

public class DuracionGarantiaDTO {
	
	private int id_garantia;
	private int duracion;
	private String descripcion;

	public DuracionGarantiaDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id_garantia
	 * @param duracion
	 * @param descripcion
	 */
	public DuracionGarantiaDTO(int id_garantia, int duracion, String descripcion) {
		super();
		this.id_garantia = id_garantia;
		this.duracion = duracion;
		this.descripcion = descripcion;
	}

	public int getId_garantia() {
		return id_garantia;
	}

	public void setId_garantia(int id_garantia) {
		this.id_garantia = id_garantia;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
