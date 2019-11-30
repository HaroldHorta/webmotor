package com.sena.webmotor.implement; 

import java.util.List;

import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.dto.EstadoDTO;
import com.sena.webmotor.dto.IdPQRDTO;
import com.sena.webmotor.dto.NombreDTO;
import com.sena.webmotor.dto.PQRDTO;

public interface PQRImp {

	public List<PQRDTO> obtenerPrueba();

	public List<PQRDTO> consultarPQR(int id);

	public List<EstadoDTO> consultarEstado(int id);
	
	public List<EstadoDTO> obtenerEstado(EstadoDTO estado);

	public RespuestaDTO crearPQR(PQRDTO notas);

	public RespuestaDTO actualizarPQR(PQRDTO notas);

	public RespuestaDTO eliminarTipoPeticionDTO(int id);
	
	public  List<PQRDTO>  consultarTipoPeticionDTO();
	
	
	public List<NombreDTO> obtenerNombre(NombreDTO nombre);
	
	public List<IdPQRDTO> obtenerIdPQR(IdPQRDTO id);
}
