package com.sena.webmotor.dto;

public class RespuestaForoDTO {

	private int id;
	private String descripcion_respuesta;
	private String fecha_publicacion;
	private int id_pregunta;
	private String cedula;
	
	
	
	/**
	 * 
	 */
	public RespuestaForoDTO() {
		super();
	}
	/**
	 * @param id
	 * @param descripcion_respuesta
	 * @param fecha_publicacion
	 * @param id_pregunta
	 * @param cedula
	 */
	public RespuestaForoDTO(int id, String descripcion_respuesta, String fecha_publicacion, int id_pregunta,
			String cedula) {
		super();
		this.id = id;
		this.descripcion_respuesta = descripcion_respuesta;
		this.fecha_publicacion = fecha_publicacion;
		this.id_pregunta = id_pregunta;
		this.cedula = cedula;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion_respuesta() {
		return descripcion_respuesta;
	}
	public void setDescripcion_respuesta(String descripcion_respuesta) {
		this.descripcion_respuesta = descripcion_respuesta;
	}
	public String getFecha_publicacion() {
		return fecha_publicacion;
	}
	public void setFecha_publicacion(String fecha_publicacion) {
		this.fecha_publicacion = fecha_publicacion;
	}
	public int getId_pregunta() {
		return id_pregunta;
	}
	public void setId_pregunta(int id_pregunta) {
		this.id_pregunta = id_pregunta;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	
}
