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

import com.sena.webmotor.dao.NotaMantenimientoDAO;
import com.sena.webmotor.dto.DuracionGarantiaDTO;
import com.sena.webmotor.dto.MarcaDTO;
import com.sena.webmotor.dto.NotaMantenimientoDTO;
import com.sena.webmotor.dto.ReferenciaDTO;
import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.dto.TipoMantenimientoDTO;
import com.sena.webmotor.dto.VehiculoDTO;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/webmotor/")
public class ServiceNotaMantenimiento {

	@Autowired
	private NotaMantenimientoDAO notadao;
	
	@RequestMapping(value = "obtenerTipoMantenimiento", method = RequestMethod.POST)
	public ResponseEntity<List<TipoMantenimientoDTO>> obtenerTipoMantenimiento(@Valid @RequestBody TipoMantenimientoDTO ve) {
		
		List<TipoMantenimientoDTO> lstTipo = notadao.obtenerTipoMantenimiento(ve);
		System.out.println("LISTA placa moto: " + lstTipo);
		return new ResponseEntity<List<TipoMantenimientoDTO>>(lstTipo, HttpStatus.OK);
	}
	@RequestMapping(value = "obtenerDuracionGarantia", method = RequestMethod.POST)
	public ResponseEntity<List<DuracionGarantiaDTO>> obtenerDuracionGarantia(@Valid @RequestBody DuracionGarantiaDTO ve) {
		
		List<DuracionGarantiaDTO> lstDuracion = notadao.obtenerDuracionGarantia(ve);
		System.out.println("LISTA placa moto: " + lstDuracion);
		return new ResponseEntity<List<DuracionGarantiaDTO>>(lstDuracion, HttpStatus.OK);
	}
	
	@RequestMapping("consultarTipoMantenimiento")
	public ResponseEntity<List<TipoMantenimientoDTO>> getReferencia() {
		return new ResponseEntity<List<TipoMantenimientoDTO>>(notadao.ConsultarTipoMantenimiento(), HttpStatus.OK);
	}
	@RequestMapping("consultarDuracionGarantia")
	public ResponseEntity<List<DuracionGarantiaDTO>> getduracionGarantia() {
		return new ResponseEntity<List<DuracionGarantiaDTO>>(notadao.ConsultarDuracionGarantia(), HttpStatus.OK);
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "actualizarNotaMantenimiento", method = RequestMethod.POST)
	public ResponseEntity actualizaactualizarNotaMantenimiento(@Valid @RequestBody NotaMantenimientoDTO actualizar) {
		RespuestaDTO respuesta = notadao.actualizarNotaMantenimiento(actualizar);
		return new ResponseEntity(respuesta, HttpStatus.CREATED);
		
	}	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "consultarNotaMantenimiento", method = RequestMethod.GET)
	public ResponseEntity consultarNotaMantenimiento(@RequestParam int id) {
		List<NotaMantenimientoDTO> lstPrueba  = notadao.consultarNotaMantenimiento(id);
		return new ResponseEntity(lstPrueba, HttpStatus.OK);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping(value = "crearNotaMantenimiento", method = RequestMethod.POST)
	public ResponseEntity crearNotaMantenimiento(@Valid @RequestBody NotaMantenimientoDTO notas) {
		RespuestaDTO respuesta = notadao.crearNotaMantenimiento(notas);
	System.out.println( "dats"+notas);
		return new ResponseEntity(respuesta, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "cambioEtapa", method = RequestMethod.POST)
	public ResponseEntity<RespuestaDTO> cambioEtapa(@Valid @RequestBody NotaMantenimientoDTO cambiar) {
		RespuestaDTO respuesta = notadao.cambiarEtapa(cambiar);
		return new ResponseEntity<RespuestaDTO>(respuesta, HttpStatus.CREATED);

	}
	
	@RequestMapping(value = "obtenerMantenimiento", method = RequestMethod.POST)
	public ResponseEntity<List<NotaMantenimientoDTO>> obtenerMatenimiento(@Valid @RequestBody NotaMantenimientoDTO ma) {
		System.out.println("placa moto: ");
		List<NotaMantenimientoDTO> lstMantenimiento = notadao.obtenerMantenimiento(ma);
		System.out.println("LISTA placa moto: " + lstMantenimiento);
		return new ResponseEntity<List<NotaMantenimientoDTO>>(lstMantenimiento, HttpStatus.OK);
	}
	@RequestMapping(value = "eliminarMantenimiento", method = RequestMethod.POST)
	public ResponseEntity<RespuestaDTO> eliminarMantenimiento(@Valid @RequestBody NotaMantenimientoDTO eliminar) {
		RespuestaDTO respuesta = notadao.eliminarNotaMantenimiento(eliminar);
		return new ResponseEntity<RespuestaDTO>(respuesta, HttpStatus.CREATED);

	}
}
