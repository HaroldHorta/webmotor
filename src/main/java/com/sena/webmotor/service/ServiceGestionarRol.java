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

import com.sena.webmotor.dao.GestionarRolDAO;
import com.sena.webmotor.dto.GestionarRolDTO;
import com.sena.webmotor.dto.RespuestaDTO;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/webmotor/")
public class ServiceGestionarRol {
	
	@Autowired
	private GestionarRolDAO gestionarRolDAO;
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "listarRol", method = RequestMethod.GET)
	public ResponseEntity listarRol(@RequestParam int id) {
		List<GestionarRolDTO> lstRol  = gestionarRolDAO.listarRol(id);
		return new ResponseEntity(lstRol, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "crearRol", method = RequestMethod.POST)
	public ResponseEntity crearRol(@Valid @RequestBody GestionarRolDTO rol) {
		RespuestaDTO respuesta = gestionarRolDAO.crearRol(rol);	
		return new ResponseEntity(respuesta, HttpStatus.CREATED);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "editarRol", method = RequestMethod.POST)
	public ResponseEntity editarRol(@Valid @RequestBody GestionarRolDTO rol) {
		RespuestaDTO respuesta = gestionarRolDAO.editarRol(rol);
		return new ResponseEntity(respuesta, HttpStatus.CREATED);
		
	}	
}
