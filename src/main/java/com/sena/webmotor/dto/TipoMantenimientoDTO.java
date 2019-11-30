package com.sena.webmotor.dto;

public class TipoMantenimientoDTO {

	private int id_tipoMantenimiento;
	private String tipo_mantenimiento;
	
	
	public TipoMantenimientoDTO() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param id_tipoMantenimiento
	 * @param tipo_mantenimiento
	 */
	public TipoMantenimientoDTO(int id_tipoMantenimiento, String tipo_mantenimiento) {
		super();
		this.id_tipoMantenimiento = id_tipoMantenimiento;
		this.tipo_mantenimiento = tipo_mantenimiento;
	}


	public int getId_tipoMantenimiento() {
		return id_tipoMantenimiento;
	}


	public void setId_tipoMantenimiento(int id_tipoMantenimiento) {
		this.id_tipoMantenimiento = id_tipoMantenimiento;
	}


	public String getTipo_mantenimiento() {
		return tipo_mantenimiento;
	}


	public void setTipo_mantenimiento(String tipo_mantenimiento) {
		this.tipo_mantenimiento = tipo_mantenimiento;
	}
	
	

}
