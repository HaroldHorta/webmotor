/**
 * 
 */
package com.sena.webmotor.utils.exceptions;

/**
 * @author ADMIN
 * @version 0.0.1 24/11/2019
 */
public class DataNotFoundException extends Exception {

	private String message;

	/**
	 * @author ADMIN
	 * @version 0.0.1 24/11/2019
	 * @param message
	 */
	public DataNotFoundException(String message) {
		super(message);
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
