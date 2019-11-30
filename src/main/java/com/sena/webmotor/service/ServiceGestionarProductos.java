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

import com.sena.webmotor.dao.GestionarProductosDAO;
import com.sena.webmotor.dto.CilindrajeDTO;
import com.sena.webmotor.dto.GestionarAlmacenesDTO;
import com.sena.webmotor.dto.GestionarCategoriasDTO;
import com.sena.webmotor.dto.GestionarProductosDTO;
import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.dto.VehiculoDTO;



@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/webmotor/")
public class ServiceGestionarProductos {

	@Autowired
	private GestionarProductosDAO gestionarProductosdao;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "listarProductos", method = RequestMethod.GET)
	public ResponseEntity listarProductos(@RequestParam String codigo) {
		List<GestionarProductosDTO> lstProductos  = gestionarProductosdao.listarProductos(codigo);
		return new ResponseEntity(lstProductos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "crearProducto", method = RequestMethod.POST)
	public ResponseEntity<RespuestaDTO> crearProducto(@Valid @RequestBody GestionarProductosDTO producto) {
		RespuestaDTO respuesta = gestionarProductosdao.crearProductos(producto);
		return new ResponseEntity<RespuestaDTO>(respuesta, HttpStatus.CREATED);
	}
	
	@RequestMapping("obtenerAlmacen")
	public ResponseEntity<List<GestionarAlmacenesDTO>> getAlmacen() {
		return new ResponseEntity<List<GestionarAlmacenesDTO>>(gestionarProductosdao.obtenerAlmacen(), HttpStatus.OK);
	}
	
	@RequestMapping("obtenerCategoria")
	public ResponseEntity<List<GestionarCategoriasDTO>> getCategoria() {
		return new ResponseEntity<List<GestionarCategoriasDTO>>(gestionarProductosdao.obtenerCategoria(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "obtenerProducto", method = RequestMethod.POST)
	public ResponseEntity<List<GestionarProductosDTO>> obtenerProducto(@Valid @RequestBody GestionarProductosDTO producto) {
		System.out.println("placa moto: ");
		List<GestionarProductosDTO> lstProducto = gestionarProductosdao.obtenerProducto(producto);
		System.out.println("LISTA placa moto: " + lstProducto);
		return new ResponseEntity<List<GestionarProductosDTO>>(lstProducto, HttpStatus.OK);
	}
	
	@RequestMapping(value = "obtenerAlmacene", method = RequestMethod.POST)
	public ResponseEntity<List<GestionarAlmacenesDTO>> obtenerAlmacene(@Valid @RequestBody GestionarAlmacenesDTO al) {		
		List<GestionarAlmacenesDTO> lstAlmacen = gestionarProductosdao.obtenerAlmacenes(al);
		System.out.println("LISTA placa moto: " + lstAlmacen);
		return new ResponseEntity<List<GestionarAlmacenesDTO>>(lstAlmacen, HttpStatus.OK);
	}
	
	@RequestMapping(value = "obtenerCategorias", method = RequestMethod.POST)
	public ResponseEntity<List<GestionarCategoriasDTO>> obtenerCategorias(@Valid @RequestBody GestionarCategoriasDTO cat) {		
		List<GestionarCategoriasDTO> lstCategoria = gestionarProductosdao.obtenerCategorias(cat);
		System.out.println("LISTA placa moto: " + lstCategoria);
		return new ResponseEntity<List<GestionarCategoriasDTO>>(lstCategoria, HttpStatus.OK);
	}
	
	@RequestMapping(value = "actualizarProducto", method = RequestMethod.POST)
	public ResponseEntity<RespuestaDTO> actualizarProducto(@Valid @RequestBody GestionarProductosDTO actualizar) {
		RespuestaDTO respuesta = gestionarProductosdao.actualizarProducto(actualizar);
		return new ResponseEntity<RespuestaDTO>(respuesta, HttpStatus.ACCEPTED);

	}
	
	@RequestMapping(value = "eliminarProducto", method = RequestMethod.POST)
	public ResponseEntity<RespuestaDTO> eliminarProducto(@Valid @RequestBody GestionarProductosDTO eliminar) {
		RespuestaDTO respuesta = gestionarProductosdao.eliminarProductos(eliminar);
		return new ResponseEntity<RespuestaDTO>(respuesta, HttpStatus.CREATED);

	}
}
	