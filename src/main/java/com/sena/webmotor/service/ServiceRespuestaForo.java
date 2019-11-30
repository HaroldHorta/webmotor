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

import com.sena.webmotor.dao.RespuestaForoDAO;
import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.dto.RespuestaForoDTO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/webmotor/")

public class ServiceRespuestaForo {
	
	@Autowired
	private RespuestaForoDAO respuestaForo;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "consultarRespuestaForo", method = RequestMethod.GET)
	public ResponseEntity consultarRespuestaForo(@RequestParam int id) {
		System.out.println("id RespuestaForo: "+id);
	List<RespuestaForoDTO> lstPreguntaforo  = respuestaForo.consultarRespuestaForo(id);
	return new ResponseEntity(lstPreguntaforo, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value= "crearRespuestaForo", method = RequestMethod.POST)
	public ResponseEntity crearRespuestaForo (@Valid @RequestBody RespuestaForoDTO crear ) {
		RespuestaDTO respuesta = respuestaForo.crearRespuestaForo(crear);
		return new ResponseEntity(respuesta, HttpStatus.CREATED);
	}
	
	@SuppressWarnings( { "rawtypes", "unchecked"} )
	@RequestMapping(value = "actualizarRespuestaForo", method = RequestMethod.POST)
	public ResponseEntity actualizarRespuestaForo (@Valid @RequestBody RespuestaForoDTO actualizar) {
		RespuestaDTO respuesta = respuestaForo.actualizarRespuestaForo(actualizar);
		return new ResponseEntity (respuesta, HttpStatus.CREATED);
	}
	
	@SuppressWarnings ({"rawtypes", "unchecked"})
	@RequestMapping(value= "eliminarRespuestaForo", method = RequestMethod.POST)
	public ResponseEntity eliminarRespuestaForo (@Valid @RequestBody RespuestaForoDTO eliminar) {
		RespuestaDTO respuesta = respuestaForo.eliminarRespuestaForo(eliminar);
		return new ResponseEntity (respuesta, HttpStatus.CREATED);
	}
	
	

}
