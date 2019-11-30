package com.sena.webmotor.implement;

import java.util.List;

import com.sena.webmotor.dto.GarantiaMantenimientoDTO;
import com.sena.webmotor.dto.RespuestaDTO;

public interface GarantiaMantenimientoImp {

	//public List<GarantiaMantenimientoDTO> consultarGarantiaMantenimientoDTO(int id);

		public List<GarantiaMantenimientoDTO> obtenerPrueba();

		public List<GarantiaMantenimientoDTO> consultarGarantiaMantenimiento(String placa);

		//public RespuestaDTO crearGarantiaMantenimiento(GarantiaMantenimientoDTO notas);

		public RespuestaDTO actualizarGarantiaMantenimientoDTO(GarantiaMantenimientoDTO notas);

		public RespuestaDTO eliminarGarantiaMantenimientoDTO(int id);
}
