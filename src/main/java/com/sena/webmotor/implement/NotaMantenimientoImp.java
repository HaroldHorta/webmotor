package com.sena.webmotor.implement;

import java.util.List;

import com.sena.webmotor.dto.DuracionGarantiaDTO;
import com.sena.webmotor.dto.NotaMantenimientoDTO;
import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.dto.TipoMantenimientoDTO;
import com.sena.webmotor.dto.VehiculoDTO;

public interface NotaMantenimientoImp {

	//public List<NotaMantenimientoDTO> consultarNotaMantenimiento(int id);

	public List<NotaMantenimientoDTO> obtenerPrueba();

	public List<NotaMantenimientoDTO> consultarNotaMantenimiento(int id);

	public List<NotaMantenimientoDTO> consultarNotaMantenimientoCliente(int id);

	public RespuestaDTO crearNotaMantenimiento(NotaMantenimientoDTO nota);

	public RespuestaDTO actualizarNotaMantenimiento(NotaMantenimientoDTO nota);

	public RespuestaDTO eliminarNotaMantenimiento(NotaMantenimientoDTO nota);
	
	public RespuestaDTO cambiarEtapa(NotaMantenimientoDTO nota);
	
	public List<NotaMantenimientoDTO> obtenerMantenimiento(NotaMantenimientoDTO nota);
	
	public List<TipoMantenimientoDTO> obtenerTipoMantenimiento(TipoMantenimientoDTO tipoMante);
	
	public List <DuracionGarantiaDTO> obtenerDuracionGarantia(DuracionGarantiaDTO duracion);
	
	public List<TipoMantenimientoDTO> ConsultarTipoMantenimiento();
	
	public List <DuracionGarantiaDTO> ConsultarDuracionGarantia();
	

}
