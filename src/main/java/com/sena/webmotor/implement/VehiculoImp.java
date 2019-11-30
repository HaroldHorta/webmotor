package com.sena.webmotor.implement;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sena.webmotor.dto.CilindrajeDTO;
import com.sena.webmotor.dto.MarcaDTO;
import com.sena.webmotor.dto.ReferenciaDTO;
import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.dto.VehiculoDTO;
import com.sena.webmotor.utils.exceptions.DataNotFoundException;

public interface VehiculoImp {

	@Transactional(readOnly = true)
	public List<VehiculoDTO> consultarVehiculo(String placa) throws DataNotFoundException;

	
	public RespuestaDTO crearVehiculo(VehiculoDTO vehiculo);
	
	
	public RespuestaDTO actualizarVehiculo(VehiculoDTO vehiculo);
	
	public RespuestaDTO eliminarVehiculo(VehiculoDTO vehiculo);
	// nuevo
	
	public List<VehiculoDTO> obtenerVehiculo(VehiculoDTO vehiculo);
	
	public  List<CilindrajeDTO>  consultarCilindraje();
	public  List<MarcaDTO>  consultarMarca();
	public  List<ReferenciaDTO>  consultarReferencia();
	
	public List<CilindrajeDTO> obtenerCilindraje (CilindrajeDTO cilindraje);
	
	public List<MarcaDTO> obtenerMarca (MarcaDTO marca);
	
	public List<ReferenciaDTO> obtenerReferencia (ReferenciaDTO referencia);
}
