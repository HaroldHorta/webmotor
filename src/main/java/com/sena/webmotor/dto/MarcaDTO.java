package com.sena.webmotor.dto;

public class MarcaDTO {
	
	private int id_marca;
	private String marca;

	public MarcaDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id_marca
	 * @param marca
	 */
	public MarcaDTO(int id_marca, String marca) {
		super();
		this.id_marca = id_marca;
		this.marca = marca;
	}

	public int getId_marca() {
		return id_marca;
	}

	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	
}
