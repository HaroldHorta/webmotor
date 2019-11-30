package com.sena.webmotor.dto;

import java.io.Serializable;
import java.sql.Date;

public class NotaMantenimientoDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private int id_mantenimiento;


    private String descripcion;
    private int costo;
    private int descuento;
    private int id_taller;
    private int id_tipoMantenimiento;
	private String placa;
    private int duracion_garantia;
    
    private String taller;
    private int costo_total;
    private String tipo_mantenimiento;
    private String fecha_compra;
    private String fecha_vencimiento_mantenimiento;
    private String estado;
    private String etapaActual;
    private String etapaAntigua;
    


    
	public NotaMantenimientoDTO() {
		super();
	}





	/**
	 * @return the id
	 */
	public int getId_mantenimiento() {
		return id_mantenimiento;
	}




	/**
	 * @param id_mantenimiento
	 * @param descripcion
	 * @param costo
	 * @param descuento
	 * @param id_taller
	 * @param id_tipoMantenimiento
	 * @param placa
	 * @param duracion_garantia
	 * @param taller
	 * @param costo_total
	 * @param tipo_mantenimiento
	 * @param fecha_compra
	 * @param fecha_vencimiento_mantenimiento
	 * @param estado
	 * @param etapaActual
	 * @param etapaAntigua
	 */
	public NotaMantenimientoDTO(int id_mantenimiento, String descripcion, int costo, int descuento, int id_taller,
			int id_tipoMantenimiento, String placa, int duracion_garantia, String taller, int costo_total,
			String tipo_mantenimiento, String fecha_compra, String fecha_vencimiento_mantenimiento, String estado,
			String etapaActual, String etapaAntigua) {
		super();
		this.id_mantenimiento = id_mantenimiento;
		this.descripcion = descripcion;
		this.costo = costo;
		this.descuento = descuento;
		this.id_taller = id_taller;
		this.id_tipoMantenimiento = id_tipoMantenimiento;
		this.placa = placa;
		this.duracion_garantia = duracion_garantia;
		this.taller = taller;
		this.costo_total = costo_total;
		this.tipo_mantenimiento = tipo_mantenimiento;
		this.fecha_compra = fecha_compra;
		this.fecha_vencimiento_mantenimiento = fecha_vencimiento_mantenimiento;
		this.estado = estado;
		this.etapaActual = etapaActual;
		this.etapaAntigua = etapaAntigua;
	}




	/**
	 * @param id the id to set
	 */
	public void setId_mantenimiento(int id_mantenimiento) {
		this.id_mantenimiento = id_mantenimiento;
	}




	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}




	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	/**
	 * @return the costo
	 */
	public int getCosto() {
		return costo;
	}




	/**
	 * @param costo the costo to set
	 */
	public void setCosto(int costo) {
		this.costo = costo;
	}




	/**
	 * @return the descuento
	 */
	public int getDescuento() {
		return descuento;
	}




	/**
	 * @param descuento the descuento to set
	 */
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}




	/**
	 * @return the id_taller
	 */
	public int getId_taller() {
		return id_taller;
	}




	/**
	 * @param id_taller the id_taller to set
	 */
	public void setId_taller(int id_taller) {
		this.id_taller = id_taller;
	}




	/**
	 * @return the id_tipoMantenimiento
	 */
	public int getId_tipoMantenimiento() {
		return id_tipoMantenimiento;
	}




	/**
	 * @param id_tipoMantenimiento the id_tipoMantenimiento to set
	 */
	public void setId_tipoMantenimiento(int id_tipoMantenimiento) {
		this.id_tipoMantenimiento = id_tipoMantenimiento;
	}




	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}




	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}




	/**
	 * @return the duracion_garantia
	 */
	public int getDuracion_garantia() {
		return duracion_garantia;
	}




	/**
	 * @param duracion_garantia the duracion_garantia to set
	 */
	public void setDuracion_garantia(int duracion_garantia) {
		this.duracion_garantia = duracion_garantia;
	}




	/**
	 * @return the taller
	 */
	public String getTaller() {
		return taller;
	}




	/**
	 * @param taller the taller to set
	 */
	public void setTaller(String taller) {
		this.taller = taller;
	}




	/**
	 * @return the costo_total
	 */
	public int getCosto_total() {
		return costo_total;
	}




	/**
	 * @param costo_total the costo_total to set
	 */
	public void setCosto_total(int costo_total) {
		this.costo_total = costo_total;
	}




	/**
	 * @return the tipo_mantenimiento
	 */
	public String getTipo_mantenimiento() {
		return tipo_mantenimiento;
	}




	/**
	 * @param tipo_mantenimiento the tipo_mantenimiento to set
	 */
	public void setTipo_mantenimiento(String tipo_mantenimiento) {
		this.tipo_mantenimiento = tipo_mantenimiento;
	}




	/**
	 * @return the fecha_compra
	 */
	public String getFecha_compra() {
		return fecha_compra;
	}




	/**
	 * @param fecha_compra the fecha_compra to set
	 */
	public void setFecha_compra(String fecha_compra) {
		this.fecha_compra = fecha_compra;
	}




	/**
	 * @return the fecha_vencimiento_mantenimiento
	 */
	public String getFecha_vencimiento_mantenimiento() {
		return fecha_vencimiento_mantenimiento;
	}




	/**
	 * @param fecha_vencimiento_mantenimiento the fecha_vencimiento_mantenimiento to set
	 */
	public void setFecha_vencimiento_mantenimiento(String fecha_vencimiento_mantenimiento) {
		this.fecha_vencimiento_mantenimiento = fecha_vencimiento_mantenimiento;
	}




	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}




	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}





	public String getEtapaActual() {
		return etapaActual;
	}





	public void setEtapaActual(String etapaActual) {
		this.etapaActual = etapaActual;
	}





	public String getEtapaAntigua() {
		return etapaAntigua;
	}





	public void setEtapaAntigua(String etapaAntigua) {
		this.etapaAntigua = etapaAntigua;
	}
	


}
