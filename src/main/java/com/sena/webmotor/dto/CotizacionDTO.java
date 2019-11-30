package com.sena.webmotor.dto;

public class CotizacionDTO {

	private int id_cotizacion;
	private int productos;
	private int cantidad;
	private int id_mantenimiento;
	
	public CotizacionDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id_cotizacion
	 * @param productos
	 * @param cantidad
	 * @param id_mantenimiento
	 */
	public CotizacionDTO(int id_cotizacion, int productos, int cantidad, int id_mantenimiento) {
		super();
		this.id_cotizacion = id_cotizacion;
		this.productos = productos;
		this.cantidad = cantidad;
		this.id_mantenimiento = id_mantenimiento;
	}

	public int getId_cotizacion() {
		return id_cotizacion;
	}

	public void setId_cotizacion(int id_cotizacion) {
		this.id_cotizacion = id_cotizacion;
	}

	public int getProductos() {
		return productos;
	}

	public void setProductos(int productos) {
		this.productos = productos;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getId_mantenimiento() {
		return id_mantenimiento;
	}

	public void setId_mantenimiento(int id_mantenimiento) {
		this.id_mantenimiento = id_mantenimiento;
	}

	
}
