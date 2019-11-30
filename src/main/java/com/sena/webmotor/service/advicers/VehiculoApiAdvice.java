/**
 * 
 */
package com.sena.webmotor.service.advicers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sena.webmotor.service.ServiceVehiculoApi;
import com.sena.webmotor.utils.exceptions.DataNotFoundException;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ADMIN
 * @version 0.0.1 24/11/2019
 */
@Slf4j
@ControllerAdvice(assignableTypes = ServiceVehiculoApi.class)
public class VehiculoApiAdvice extends ResponseEntityExceptionHandler {

	/**
	 * Método con implementación de handlerVehiculoNoEncontrado
	 * @author ADMIN
	 * @version 0.0.1 24/11/2019
	 * @return ResponseEntity<Void>
	 * @param VehiculoApiAdvice		
	 * @param dataNotFoundException
	 * @return
	 */
	@ExceptionHandler({ DataNotFoundException.class })
	public ResponseEntity<Void> handlerVehiculoNoEncontrado(final DataNotFoundException dataNotFoundException) {
		log.error("Error en la API Vehiculo. Error ", dataNotFoundException.getMessage());
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
