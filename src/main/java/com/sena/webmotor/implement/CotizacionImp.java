package com.sena.webmotor.implement;

import java.util.List;

import com.sena.webmotor.dto.CotizacionDTO;
import com.sena.webmotor.dto.RespuestaDTO;

public interface CotizacionImp {

	public RespuestaDTO crearCotizacion(CotizacionDTO cotizacion);
	
	public List<CotizacionDTO> obtenerCotizacion (CotizacionDTO cotizacion);
}
