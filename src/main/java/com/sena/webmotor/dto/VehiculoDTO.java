package com.sena.webmotor.dto;

import java.io.Serializable;


public class VehiculoDTO implements Serializable {

	private String placa;
	private String color;
	private String modelo;
	private int id_cilindraje;
	private int id_marca;
	private String foto_vehiculo;
	private int kilometraje;
    private String cedula;
    private int id_referencia;
    private String cilindraje;
    private String marca;
    private String referencia;
   
    
    
	public VehiculoDTO() {
		super();
	}

	


	/**
	 * @param placa
	 */
	public VehiculoDTO(String placa) {
		super();
		this.placa = placa;
	}




	/**
	 * @param placa
	 * @param color
	 */
	public VehiculoDTO(String placa, String color) {
		super();
		this.placa = placa;
		this.color = color;
	}




	public VehiculoDTO(String placa, String color, String modelo, int id_cilindraje, int id_marca, String foto_vehiculo,
			int kilometraje, String cedula, int id_referencia) {
		super();
		this.placa = placa;
		this.color = color;
		this.modelo = modelo;
		this.id_cilindraje = id_cilindraje;
		this.id_marca = id_marca;
		this.foto_vehiculo = foto_vehiculo;
		this.kilometraje = kilometraje;
		this.cedula = cedula;
		this.id_referencia = id_referencia;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public int getId_cilindraje() {
		return id_cilindraje;
	}


	public void setId_cilindraje(int id_cilindraje) {
		this.id_cilindraje = id_cilindraje;
	}


	public int getId_marca() {
		return id_marca;
	}


	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}


	public String getFoto_vehiculo() {
		return foto_vehiculo;
	}


	public void setFoto_vehiculo(String foto_vehiculo) {
		this.foto_vehiculo = foto_vehiculo;
	}


	public int getKilometraje() {
		return kilometraje;
	}


	public void setKilometraje(int kilometraje) {
		this.kilometraje = kilometraje;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public int getId_referencia() {
		return id_referencia;
	}


	public void setId_referencia(int id_referencia) {
		this.id_referencia = id_referencia;
	}


	public String getCilindraje() {
		return cilindraje;
	}


	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getReferencia() {
		return referencia;
	}


	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
    
    
}
