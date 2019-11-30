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

import com.sena.webmotor.dao.PreguntaForoDAO;
import com.sena.webmotor.dto.NotaMantenimientoDTO;
import com.sena.webmotor.dto.PreguntaForoDTO;
import com.sena.webmotor.dto.RespuestaDTO;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/webmotor/")

public class ServicePreguntaForo {
	
	@Autowired
	private PreguntaForoDAO preguntaForo;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "consultarPreguntaForo", method = RequestMethod.GET)
	public ResponseEntity consultarPreguntaForo(@RequestParam int id) {
		System.out.println("id PreguntaForo: "+id);
	List<PreguntaForoDTO> lstPreguntaforo  = preguntaForo.consultarPreguntaForo(id);
	return new ResponseEntity(lstPreguntaforo, HttpStatus.OK);
	}
	@RequestMapping(value = "obtenerPreguntaForo", method = RequestMethod.POST)
	public ResponseEntity<List<PreguntaForoDTO>> obtenerPreguntaForo(@Valid @RequestBody PreguntaForoDTO ma) {
		System.out.println("placa moto: ");
		List<PreguntaForoDTO> lstPreguntas = preguntaForo.obtenerPreguntaForo(ma);
		
		return new ResponseEntity<List<PreguntaForoDTO>>(lstPreguntas, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value= "crearPreguntaForo", method = RequestMethod.POST)
	public ResponseEntity crearPreguntaForo (@Valid @RequestBody PreguntaForoDTO crear ) {
		RespuestaDTO respuesta = preguntaForo.crearPreguntaForo(crear);
		return new ResponseEntity(respuesta, HttpStatus.CREATED);
	}
	
	@SuppressWarnings( { "rawtypes", "unchecked"} )
	@RequestMapping(value = "actualizarPreguntaForo", method = RequestMethod.POST)
	public ResponseEntity actualizarPreguntaForo (@Valid @RequestBody PreguntaForoDTO actualizar) {
		RespuestaDTO respuesta = preguntaForo.actualizarPreguntaForo(actualizar);
		return new ResponseEntity (respuesta, HttpStatus.CREATED);
	}
	
	@SuppressWarnings ({"rawtypes", "unchecked"})
	@RequestMapping(value= "eliminarPreguntaForo", method = RequestMethod.POST)
	public ResponseEntity eliminarPreguntaForo (@Valid @RequestBody PreguntaForoDTO eliminar) {
		RespuestaDTO respuesta = preguntaForo.eliminarPreguntaForo(eliminar);
		return new ResponseEntity (respuesta, HttpStatus.CREATED);
	}
}
