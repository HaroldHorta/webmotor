package com.sena.webmotor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.webmotor.dao.GarantiaMantenimientoDAO;
import com.sena.webmotor.dto.GarantiaMantenimientoDTO;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/webmotor/")
public class ServiceGarantiaMantenimiento {

	@Autowired
	private GarantiaMantenimientoDAO gardao;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "consultarGarantiaMantenimiento", method = RequestMethod.GET)
	public ResponseEntity consultarGarantiaMantenimiento(@RequestParam String placa) {
		List<GarantiaMantenimientoDTO> lstPrueba  = gardao.consultarGarantiaMantenimiento(placa);
		return new ResponseEntity(lstPrueba, HttpStatus.OK);
	}

}
