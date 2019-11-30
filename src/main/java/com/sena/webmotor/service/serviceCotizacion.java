package com.sena.webmotor.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.webmotor.dao.CotizacionDAO;
import com.sena.webmotor.dto.CotizacionDTO;
import com.sena.webmotor.dto.ReferenciaDTO;
import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.dto.VehiculoDTO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/webmotor/")
public class serviceCotizacion {

	@Autowired
	private CotizacionDAO cotizacion;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "crearCotizacion", method = RequestMethod.POST)
	public ResponseEntity crearCotizacion(@Valid @RequestBody CotizacionDTO coti) {
		RespuestaDTO respuesta = cotizacion.crearCotizacion(coti);
	System.out.println( "dats"+coti);
		return new ResponseEntity(respuesta, HttpStatus.CREATED);
	}
	@RequestMapping(value = "obtenerCotizacion", method = RequestMethod.POST)
	public ResponseEntity<List<CotizacionDTO>> obtenerCotizacion(@Valid @RequestBody CotizacionDTO ve) {
		List<CotizacionDTO> lstAspirantes = cotizacion.obtenerCotizacion(ve);
		System.out.println("LISTA placa moto: " + lstAspirantes);
		return new ResponseEntity<List<CotizacionDTO>>(lstAspirantes, HttpStatus.OK);
	}
}
