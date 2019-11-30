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

import com.sena.webmotor.dao.PQRDAO;
import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.dto.VehiculoDTO;
import com.sena.webmotor.dto.CilindrajeDTO;
import com.sena.webmotor.dto.EstadoDTO;
import com.sena.webmotor.dto.IdPQRDTO;
import com.sena.webmotor.dto.NombreDTO;
import com.sena.webmotor.dto.NotaMantenimientoDTO;
import com.sena.webmotor.dto.PQRDTO;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/WebMotor/")
public class ServicePQR {

	@Autowired
	private PQRDAO tipdao;
	
	@RequestMapping("obtenerTipoPeticion")
	public ResponseEntity<List<PQRDTO>> getUsuarios() {
		return new ResponseEntity<List<PQRDTO>>(tipdao.consultarTipoPeticionDTO(), HttpStatus.OK);
	}
	@RequestMapping(value = "obtenerEstado", method = RequestMethod.POST)
	public ResponseEntity<List<EstadoDTO>> obtenerEstado(@Valid @RequestBody EstadoDTO estado) {
		
		List<EstadoDTO> lstEstado = tipdao.obtenerEstado(estado);
		System.out.println("obtener estado: "+ lstEstado);
		return new ResponseEntity<List<EstadoDTO>>(lstEstado, HttpStatus.OK);	
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "consultarEstado", method = RequestMethod.GET)
	public ResponseEntity consultarEstado(@RequestParam int id) {
		List<EstadoDTO> lstPrueba  = tipdao.consultarEstado(id);
		return new ResponseEntity(lstPrueba, HttpStatus.OK);
	}
	
	@RequestMapping(value = "obtenerNombre", method = RequestMethod.POST)
	public ResponseEntity<List<NombreDTO>> obtenerNombre(@Valid @RequestBody NombreDTO no) {
		System.out.println("Nombre usuario: ");
		List<NombreDTO> lstAspirantes = tipdao.obtenerNombre(no);
		System.out.println("LISTA nombre usuario: " + lstAspirantes);
		return new ResponseEntity<List<NombreDTO>>(lstAspirantes, HttpStatus.OK);
	}
	
	@RequestMapping(value = "obtenerIdPQR", method = RequestMethod.POST)
	public ResponseEntity<List<IdPQRDTO>> obtenerIdPQR(@Valid @RequestBody IdPQRDTO id) {
		System.out.println("Id PQR: ");
		List<IdPQRDTO> lstAspirantes = tipdao.obtenerIdPQR(id);
		System.out.println("LISTA nombre usuario: " + lstAspirantes);
		return new ResponseEntity<List<IdPQRDTO>>(lstAspirantes, HttpStatus.OK);
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "consultarPQR", method = RequestMethod.GET)
	public ResponseEntity consultarTipoPeticion(@RequestParam int id) {
		List<PQRDTO> lstPrueba  = tipdao.consultarPQR(id);
		return new ResponseEntity(lstPrueba, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "crearPQR", method = RequestMethod.POST)
	public ResponseEntity crearTipoPeticion(@Valid @RequestBody PQRDTO notas) {
		RespuestaDTO respuesta = tipdao.crearPQR(notas);
		return new ResponseEntity(respuesta, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "actualizarPQR", method = RequestMethod.POST)
	public ResponseEntity <RespuestaDTO> actualizarPQR(@Valid @RequestBody PQRDTO actualizar) {
		RespuestaDTO respuesta = tipdao.actualizarPQR(actualizar);
		return new ResponseEntity<RespuestaDTO>(respuesta, HttpStatus.ACCEPTED);
	}
	
}
