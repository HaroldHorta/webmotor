/**
 * 
 */
package com.sena.webmotor.implement;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sena.webmotor.dto.PreguntaForoDTO;
import com.sena.webmotor.dto.RespuestaDTO;

/**
 * @author ADMIN
 *
 */
public interface PreguntaForoImp {

	@Transactional(readOnly = true)
	public List<PreguntaForoDTO> consultarPreguntaForo(int id);
	
	public List <PreguntaForoDTO> obtenerPreguntaForo(PreguntaForoDTO PreguntaForo);
	
	public RespuestaDTO crearPreguntaForo(PreguntaForoDTO PreguntaForo);
	
	public RespuestaDTO actualizarPreguntaForo(PreguntaForoDTO PreguntaForo);
	
	public RespuestaDTO eliminarPreguntaForo(PreguntaForoDTO PreguntaForo);
}
