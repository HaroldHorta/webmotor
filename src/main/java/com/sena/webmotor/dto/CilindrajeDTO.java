/**
 * 
 */
package com.sena.webmotor.dto;

/**
 * @author ADMIN
 *
 */
public class CilindrajeDTO {
	   private int id_cilindraje;

	   private String cilindraje;
	
	/**
	 * 
	 */
	public CilindrajeDTO() {
		
	}

	/**
	 * @param cilindraje
	 * @param id_cilindraje
	 */
	public CilindrajeDTO(int id_cilindraje, String cilindraje) {
		super();
		this.cilindraje = cilindraje;
		this.id_cilindraje = id_cilindraje;
	}

	public String getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(String cilindraje) {
		this.cilindraje = cilindraje;
	}

	public int getId_cilindraje() {
		return id_cilindraje;
	}

	public void setId_cilindraje(int id_cilindraje) {
		this.id_cilindraje = id_cilindraje;
	}
	

}
