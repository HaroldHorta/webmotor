package com.sena.webmotor.dto;

import java.io.Serializable;

public class PreguntaForoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idPregunta;
	private String pregunta;
	private String cedulaPregunta;
	private String fechaPregunta;
	private String nombrePregunta;

	private int idrespuesta1;
	private String descripcionRespuesta1;
	private String cedulaRespuesta1;
	private String nombreRespuesta1;

	private int idrespuesta2;
	private String descripcionRespuesta2;
	private String cedulaRespuesta2;
	private String nombreRespuesta2;

	private int idrespuesta3;
	private String descripcionRespuesta3;
	private String cedulaRespuesta3;
	private String nombreRespuesta3;

	private int idrespuesta4;
	private String descripcionRespuesta4;
	private String cedulaRespuesta4;
	private String nombreRespuesta4;

	private int idrespuesta5;
	private String descripcionRespuesta5;
	private String cedulaRespuesta5;
	private String nombreRespuesta5;

	/**
	 * 
	 */
	public PreguntaForoDTO() {
		super();
	}

	/**
	 * @param idPregunta
	 * @param pregunta
	 * @param cedulaPregunta
	 * @param fechaPregunta
	 * @param nombrePregunta
	 * @param idrespuesta1
	 * @param descripcionRespuesta1
	 * @param cedulaRespuesta1
	 * @param nombreRespuesta1
	 * @param idrespuesta2
	 * @param descripcionRespuesta2
	 * @param cedulaRespuesta2
	 * @param nombreRespuesta2
	 * @param idrespuesta3
	 * @param descripcionRespuesta3
	 * @param cedulaRespuesta3
	 * @param nombreRespuesta3
	 * @param idrespuesta4
	 * @param descripcionRespuesta4
	 * @param cedulaRespuesta4
	 * @param nombreRespuesta4
	 * @param idrespuesta5
	 * @param descripcionRespuesta5
	 * @param cedulaRespuesta6
	 * @param nombreRespuesta7
	 */
	public PreguntaForoDTO(int idPregunta, String pregunta, String cedulaPregunta, String fechaPregunta,
			String nombrePregunta, int idrespuesta1, String descripcionRespuesta1, String cedulaRespuesta1,
			String nombreRespuesta1, int idrespuesta2, String descripcionRespuesta2, String cedulaRespuesta2,
			String nombreRespuesta2, int idrespuesta3, String descripcionRespuesta3, String cedulaRespuesta3,
			String nombreRespuesta3, int idrespuesta4, String descripcionRespuesta4, String cedulaRespuesta4,
			String nombreRespuesta4, int idrespuesta5, String descripcionRespuesta5, String cedulaRespuesta5,
			String nombreRespuesta5) {
		super();
		this.idPregunta = idPregunta;
		this.pregunta = pregunta;
		this.cedulaPregunta = cedulaPregunta;
		this.fechaPregunta = fechaPregunta;
		this.nombrePregunta = nombrePregunta;
		this.idrespuesta1 = idrespuesta1;
		this.descripcionRespuesta1 = descripcionRespuesta1;
		this.cedulaRespuesta1 = cedulaRespuesta1;
		this.nombreRespuesta1 = nombreRespuesta1;
		this.idrespuesta2 = idrespuesta2;
		this.descripcionRespuesta2 = descripcionRespuesta2;
		this.cedulaRespuesta2 = cedulaRespuesta2;
		this.nombreRespuesta2 = nombreRespuesta2;
		this.idrespuesta3 = idrespuesta3;
		this.descripcionRespuesta3 = descripcionRespuesta3;
		this.cedulaRespuesta3 = cedulaRespuesta3;
		this.nombreRespuesta3 = nombreRespuesta3;
		this.idrespuesta4 = idrespuesta4;
		this.descripcionRespuesta4 = descripcionRespuesta4;
		this.cedulaRespuesta4 = cedulaRespuesta4;
		this.nombreRespuesta4 = nombreRespuesta4;
		this.idrespuesta5 = idrespuesta5;
		this.descripcionRespuesta5 = descripcionRespuesta5;
		this.cedulaRespuesta5 = cedulaRespuesta5;
		this.nombreRespuesta5 = nombreRespuesta5;
	}

	public int getIdPregunta() {
		return idPregunta;
	}

	public void setIdPregunta(int idPregunta) {
		this.idPregunta = idPregunta;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public String getCedulaPregunta() {
		return cedulaPregunta;
	}

	public void setCedulaPregunta(String cedulaPregunta) {
		this.cedulaPregunta = cedulaPregunta;
	}

	public String getFechaPregunta() {
		return fechaPregunta;
	}

	public void setFechaPregunta(String fechaPregunta) {
		this.fechaPregunta = fechaPregunta;
	}

	public String getNombrePregunta() {
		return nombrePregunta;
	}

	public void setNombrePregunta(String nombrePregunta) {
		this.nombrePregunta = nombrePregunta;
	}

	public int getIdrespuesta1() {
		return idrespuesta1;
	}

	public void setIdrespuesta1(int idrespuesta1) {
		this.idrespuesta1 = idrespuesta1;
	}

	public String getDescripcionRespuesta1() {
		return descripcionRespuesta1;
	}

	public void setDescripcionRespuesta1(String descripcionRespuesta1) {
		this.descripcionRespuesta1 = descripcionRespuesta1;
	}

	public String getCedulaRespuesta1() {
		return cedulaRespuesta1;
	}

	public void setCedulaRespuesta1(String cedulaRespuesta1) {
		this.cedulaRespuesta1 = cedulaRespuesta1;
	}

	public String getNombreRespuesta1() {
		return nombreRespuesta1;
	}

	public void setNombreRespuesta1(String nombreRespuesta1) {
		this.nombreRespuesta1 = nombreRespuesta1;
	}

	public int getIdrespuesta2() {
		return idrespuesta2;
	}

	public void setIdrespuesta2(int idrespuesta2) {
		this.idrespuesta2 = idrespuesta2;
	}

	public String getDescripcionRespuesta2() {
		return descripcionRespuesta2;
	}

	public void setDescripcionRespuesta2(String descripcionRespuesta2) {
		this.descripcionRespuesta2 = descripcionRespuesta2;
	}

	public String getCedulaRespuesta2() {
		return cedulaRespuesta2;
	}

	public void setCedulaRespuesta2(String cedulaRespuesta2) {
		this.cedulaRespuesta2 = cedulaRespuesta2;
	}

	public String getNombreRespuesta2() {
		return nombreRespuesta2;
	}

	public void setNombreRespuesta2(String nombreRespuesta2) {
		this.nombreRespuesta2 = nombreRespuesta2;
	}

	public int getIdrespuesta3() {
		return idrespuesta3;
	}

	public void setIdrespuesta3(int idrespuesta3) {
		this.idrespuesta3 = idrespuesta3;
	}

	public String getDescripcionRespuesta3() {
		return descripcionRespuesta3;
	}

	public void setDescripcionRespuesta3(String descripcionRespuesta3) {
		this.descripcionRespuesta3 = descripcionRespuesta3;
	}

	public String getCedulaRespuesta3() {
		return cedulaRespuesta3;
	}

	public void setCedulaRespuesta3(String cedulaRespuesta3) {
		this.cedulaRespuesta3 = cedulaRespuesta3;
	}

	public String getNombreRespuesta3() {
		return nombreRespuesta3;
	}

	public void setNombreRespuesta3(String nombreRespuesta3) {
		this.nombreRespuesta3 = nombreRespuesta3;
	}

	public int getIdrespuesta4() {
		return idrespuesta4;
	}

	public void setIdrespuesta4(int idrespuesta4) {
		this.idrespuesta4 = idrespuesta4;
	}

	public String getDescripcionRespuesta4() {
		return descripcionRespuesta4;
	}

	public void setDescripcionRespuesta4(String descripcionRespuesta4) {
		this.descripcionRespuesta4 = descripcionRespuesta4;
	}

	public String getCedulaRespuesta4() {
		return cedulaRespuesta4;
	}

	public void setCedulaRespuesta4(String cedulaRespuesta4) {
		this.cedulaRespuesta4 = cedulaRespuesta4;
	}

	public String getNombreRespuesta4() {
		return nombreRespuesta4;
	}

	public void setNombreRespuesta4(String nombreRespuesta4) {
		this.nombreRespuesta4 = nombreRespuesta4;
	}

	public int getIdrespuesta5() {
		return idrespuesta5;
	}

	public void setIdrespuesta5(int idrespuesta5) {
		this.idrespuesta5 = idrespuesta5;
	}

	public String getDescripcionRespuesta5() {
		return descripcionRespuesta5;
	}

	public void setDescripcionRespuesta5(String descripcionRespuesta5) {
		this.descripcionRespuesta5 = descripcionRespuesta5;
	}

	public String getCedulaRespuesta5() {
		return cedulaRespuesta5;
	}

	public void setCedulaRespuesta5(String cedulaRespuesta6) {
		this.cedulaRespuesta5 = cedulaRespuesta6;
	}

	public String getNombreRespuesta5() {
		return nombreRespuesta5;
	}

	public void setNombreRespuesta5(String nombreRespuesta7) {
		this.nombreRespuesta5 = nombreRespuesta7;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
