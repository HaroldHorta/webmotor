/**
 * 
 */
package com.sena.webmotor.dto;

/**
 * @author ADMIN
 *
 */
public class ReferenciaDTO {
	
	 private int id_referencia;
	 private String referencia;

	/**
	 * 
	 */
	public ReferenciaDTO() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id_referencia
	 * @param referencia
	 */
	public ReferenciaDTO(int id_referencia, String referencia) {
		super();
		this.id_referencia = id_referencia;
		this.referencia = referencia;
	}

	public int getId_referencia() {
		return id_referencia;
	}

	public void setId_referencia(int id_referencia) {
		this.id_referencia = id_referencia;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	

}
