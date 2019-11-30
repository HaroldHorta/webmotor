package com.sena.webmotor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sena.webmotor.dto.UsuarioDTO;
import com.sena.webmotor.dao.EnviarCorreoImp;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/WebMotor/")
@Component
public class ServiceEnviarCorreo {

	@Autowired
	private EnviarCorreoImp documento;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "generarCorreo", method = RequestMethod.POST)
	public ResponseEntity generarCorreo(@RequestBody UsuarioDTO persona) {
		System.out.println("persona nombres" + persona.getNombres());
		boolean respuesta = documento.generarCorreo(persona);
		return new ResponseEntity(respuesta, HttpStatus.CREATED);
	}

}
