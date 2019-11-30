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

import com.sena.webmotor.dao.VehiculoDAO;
import com.sena.webmotor.dto.CilindrajeDTO;
import com.sena.webmotor.dto.MarcaDTO;
import com.sena.webmotor.dto.ReferenciaDTO;
import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.dto.VehiculoDTO;
import com.sena.webmotor.utils.exceptions.DataNotFoundException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/webmotor/")
public class ServiceVehiculoApi {

	@Autowired
	private VehiculoDAO vehiculo;
	
	
	@RequestMapping("obtenerReferencia")
	public ResponseEntity<List<ReferenciaDTO>> getReferencia() {
		return new ResponseEntity<List<ReferenciaDTO>>(vehiculo.consultarReferencia(), HttpStatus.OK);
	}
	@RequestMapping("obtenerMarca")
	public ResponseEntity<List<MarcaDTO>> getMarca() {
		return new ResponseEntity<List<MarcaDTO>>(vehiculo.consultarMarca(), HttpStatus.OK);
	}
	@RequestMapping("obtenerCilindraje")
	public ResponseEntity<List<CilindrajeDTO>> getCilindraje() {
		return new ResponseEntity<List<CilindrajeDTO>>(vehiculo.consultarCilindraje(), HttpStatus.OK);
	}

	@RequestMapping(value = "crearVehiculo", method = RequestMethod.POST)
	public ResponseEntity<RespuestaDTO> crearVehiculo(@Valid @RequestBody VehiculoDTO vehiculos) {
		RespuestaDTO respuesta = vehiculo.crearVehiculo(vehiculos);
		return new ResponseEntity<RespuestaDTO>(respuesta, HttpStatus.CREATED);
	}

	@RequestMapping(value = "actualizarVehiculo", method = RequestMethod.POST)
	public ResponseEntity<RespuestaDTO> actualizarVehiculo(@Valid @RequestBody VehiculoDTO actualizar) {
		RespuestaDTO respuesta = vehiculo.actualizarVehiculo(actualizar);
		return new ResponseEntity<RespuestaDTO>(respuesta, HttpStatus.ACCEPTED);

	}

	@RequestMapping(value = "eliminarVehiculo", method = RequestMethod.POST)
	public ResponseEntity<RespuestaDTO> eliminarVehiculo(@Valid @RequestBody VehiculoDTO eliminar) {
		RespuestaDTO respuesta = vehiculo.eliminarVehiculo(eliminar);
		return new ResponseEntity<RespuestaDTO>(respuesta, HttpStatus.CREATED);

	}

	@RequestMapping(value = "consultarVehiculo", method = RequestMethod.GET)
	public ResponseEntity<List<VehiculoDTO>> consultarVehiculo(@RequestParam String placa) throws DataNotFoundException {
		System.out.println("placa moto: " + placa);
		List<VehiculoDTO> lstAspirantes = vehiculo.consultarVehiculo(placa);
		System.out.println("LISTA placa moto: " + lstAspirantes);
		return new ResponseEntity<List<VehiculoDTO>>(lstAspirantes, HttpStatus.OK);
	}
	
	@RequestMapping(value = "obtenerVehiculo", method = RequestMethod.POST)
	public ResponseEntity<List<VehiculoDTO>> obtenerVehiculo(@Valid @RequestBody VehiculoDTO ve) {
		System.out.println("placa moto: ");
		List<VehiculoDTO> lstAspirantes = vehiculo.obtenerVehiculo(ve);
		System.out.println("LISTA placa moto: " + lstAspirantes);
		return new ResponseEntity<List<VehiculoDTO>>(lstAspirantes, HttpStatus.OK);
	}
	@RequestMapping(value = "consultarCilindraje", method = RequestMethod.POST)
	public ResponseEntity<List<CilindrajeDTO>> consultarCilindraje(@Valid @RequestBody CilindrajeDTO ve) {
		System.out.println("placa moto: ");
		List<CilindrajeDTO> lstAspirantes = vehiculo.obtenerCilindraje(ve);
		System.out.println("LISTA placa moto: " + lstAspirantes);
		return new ResponseEntity<List<CilindrajeDTO>>(lstAspirantes, HttpStatus.OK);
	}
	
	@RequestMapping(value = "consultarMarca", method = RequestMethod.POST)
	public ResponseEntity<List<MarcaDTO>> consultarMarca(@Valid @RequestBody MarcaDTO ve) {
		System.out.println("placa moto: ");
		List<MarcaDTO> lstAspirantes = vehiculo.obtenerMarca(ve);
		System.out.println("LISTA placa moto: " + lstAspirantes);
		return new ResponseEntity<List<MarcaDTO>>(lstAspirantes, HttpStatus.OK);
	}

	@RequestMapping(value = "consultarReferencia", method = RequestMethod.POST)
	public ResponseEntity<List<ReferenciaDTO>> consultarReferencia(@Valid @RequestBody ReferenciaDTO ve) {
		System.out.println("placa moto: ");
		List<ReferenciaDTO> lstAspirantes = vehiculo.obtenerReferencia(ve);
		System.out.println("LISTA placa moto: " + lstAspirantes);
		return new ResponseEntity<List<ReferenciaDTO>>(lstAspirantes, HttpStatus.OK);
	}
}
