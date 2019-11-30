package com.sena.webmotor.dto;


public class PQRDTO {

	private int id;
	private String nombre;
	private String apellido;
	private String cedula;
	private String descripcion;
	private int tipo_problema;
	private String nombre_problema;
	private String fecha;
	private String nombre_estado;
	private int id_estado;

	public PQRDTO() {
		super();
	}

	/**
	 * @param id
	 * @param nombre
	 * @param apellido
	 * @param cedula
	 * @param descripcion
	 * @param tipo_problema
	 * @param nombre_problema
	 * @param fecha
	 * @param nombre_estado
	 * @param estado
	 */
	public PQRDTO(int id, String nombre, String apellido, String cedula, String descripcion, int tipo_problema,
			String nombre_problema, String fecha, String nombre_estado, int id_estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cedula = cedula;
		this.descripcion = descripcion;
		this.tipo_problema = tipo_problema;
		this.nombre_problema = nombre_problema;
		this.fecha = fecha;
		this.nombre_estado = nombre_estado;
		this.id_estado = id_estado;
	}

	public PQRDTO(int tipo_problema, String nombre_problema) {
		super();
		this.tipo_problema = tipo_problema;
		this.nombre_problema = nombre_problema;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getTipo_problema() {
		return tipo_problema;
	}

	public void setTipo_problema(int tipo_problema) {
		this.tipo_problema = tipo_problema;
	}

	public String getNombre_problema() {
		return nombre_problema;
	}

	public void setNombre_problema(String nombre_problema) {
		this.nombre_problema = nombre_problema;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNombre_estado() {
		return nombre_estado;
	}

	public void setNombre_estado(String nombre_estado) {
		this.nombre_estado = nombre_estado;
	}

	public int getId_estado() {
		return id_estado;
	}

	public void setId_estado(int id_estado) {
		this.id_estado = id_estado;
	}

	
	

}
