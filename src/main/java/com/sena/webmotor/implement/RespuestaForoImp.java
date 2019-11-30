package com.sena.webmotor.implement;

import java.util.List;

import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.dto.RespuestaForoDTO;

public interface RespuestaForoImp {
	
	public List<RespuestaForoDTO> consultarRespuestaForo (int id);
	
	public RespuestaDTO crearRespuestaForo(RespuestaForoDTO respuestaForo);
	
	public RespuestaDTO actualizarRespuestaForo(RespuestaForoDTO respuestaForo);
	
	public RespuestaDTO eliminarRespuestaForo(RespuestaForoDTO respuestaForo);
	
	
	

}
