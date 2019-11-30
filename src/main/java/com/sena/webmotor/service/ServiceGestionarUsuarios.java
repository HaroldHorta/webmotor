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

import com.sena.webmotor.dao.GestionarUsuariosDAO;
import com.sena.webmotor.dto.GestionarUsuariosDTO;
import com.sena.webmotor.dto.RespuestaDTO;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/webmotor/")
public class ServiceGestionarUsuarios {

	@Autowired
	private GestionarUsuariosDAO gestionarUsuariodao;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "listarUsuarios", method = RequestMethod.GET)
	public ResponseEntity listarUsuarios(@RequestParam String cedula) {
		List<GestionarUsuariosDTO> lstUsuarios  = gestionarUsuariodao.listarUsuario(cedula);
		return new ResponseEntity(lstUsuarios, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "crearUsuario", method = RequestMethod.POST)
	public ResponseEntity crearUsuario(@Valid @RequestBody GestionarUsuariosDTO usuario) {
		RespuestaDTO respuesta = gestionarUsuariodao.crearUsuario(usuario);	
		return new ResponseEntity(respuesta, HttpStatus.CREATED);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "validarLoginUsuario", method = RequestMethod.POST)
	public GestionarUsuariosDTO validarLoginUsuario(@Valid @RequestBody GestionarUsuariosDTO usuario) {
		return gestionarUsuariodao.validarUsuarioLogin(usuario.getCedula(), usuario.getContrasenia());
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "editarUsuario", method = RequestMethod.POST)
	public ResponseEntity editarUsuario(@Valid @RequestBody GestionarUsuariosDTO actualizar) {
		RespuestaDTO respuesta = gestionarUsuariodao.editarUsuario(actualizar);
		return new ResponseEntity(respuesta, HttpStatus.CREATED);
		
	}	
	@RequestMapping(value = "actualizarContraseniaUsuario", method = RequestMethod.POST)
	public ResponseEntity<RespuestaDTO> actualizarContraseniaUsuario(@Valid @RequestBody GestionarUsuariosDTO actualizar) {
		RespuestaDTO respuesta = gestionarUsuariodao.actualizarContraseniaUsuario(actualizar);
		return new ResponseEntity<RespuestaDTO>(respuesta, HttpStatus.ACCEPTED);

	}
	@RequestMapping(value = "obtenerUsuario", method = RequestMethod.POST)
	public ResponseEntity<List<GestionarUsuariosDTO>> obtenerUsuario(@Valid @RequestBody GestionarUsuariosDTO ve) {
		
		List<GestionarUsuariosDTO> lstTipo = gestionarUsuariodao.obtenerUsuario(ve);
		System.out.println("LISTA placa moto: " + lstTipo);
		return new ResponseEntity<List<GestionarUsuariosDTO>>(lstTipo, HttpStatus.OK);
	}
}
