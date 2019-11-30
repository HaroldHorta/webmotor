package com.sena.webmotor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.webmotor.dao.GestionarAlmacenesDAO;
import com.sena.webmotor.dto.GestionarAlmacenesDTO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/webmotor/")
public class ServiceGestionarAlmacenes {
	
	@Autowired
	private GestionarAlmacenesDAO gestionarAlmacendao;
	
	@RequestMapping("gestObtenerAlmacen")
	public ResponseEntity<List<GestionarAlmacenesDTO>> gestObtenerAlmacen() {
		return new ResponseEntity<List<GestionarAlmacenesDTO>>(gestionarAlmacendao.obtenerAlmacen(), HttpStatus.OK);
	}

}
