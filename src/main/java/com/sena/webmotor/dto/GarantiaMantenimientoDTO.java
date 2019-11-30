package com.sena.webmotor.dto;



public class GarantiaMantenimientoDTO {

	private String nombre;
	private String apellido;
	private String observaciones;
	private String placa;
    private String fecha_mantenimiento;
    private String fecha_vencimiento_mantenimiento;
    private int id;
    
    public GarantiaMantenimientoDTO() {
		super();
	}

	public GarantiaMantenimientoDTO(String nombre, String apellido, String observaciones, String placa,
			String fecha_mantenimiento, String fecha_vencimiento_mantenimiento, int id) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.observaciones = observaciones;
		this.placa = placa;
		this.fecha_mantenimiento = fecha_mantenimiento;
		this.fecha_vencimiento_mantenimiento = fecha_vencimiento_mantenimiento;
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getFecha_mantenimiento() {
		return fecha_mantenimiento;
	}

	public void setFecha_mantenimiento(String fecha_mantenimiento) {
		this.fecha_mantenimiento = fecha_mantenimiento;
	}

	public String getFecha_vencimiento_mantenimiento() {
		return fecha_vencimiento_mantenimiento;
	}

	public void setFecha_vencimiento_mantenimiento(String fecha_vencimiento_mantenimiento) {
		this.fecha_vencimiento_mantenimiento = fecha_vencimiento_mantenimiento;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    
	}
