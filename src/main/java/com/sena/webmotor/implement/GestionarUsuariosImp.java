package com.sena.webmotor.implement;

import java.util.List;

import com.sena.webmotor.dto.GestionarUsuariosDTO;
import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.dto.VehiculoDTO;

public interface GestionarUsuariosImp {
		
    // listar por usuario
    public List<GestionarUsuariosDTO> listarUsuario(String cedula);
    // Agregar
    public RespuestaDTO crearUsuario(GestionarUsuariosDTO usuario);
    // Editar
    public RespuestaDTO editarUsuario(GestionarUsuariosDTO usuario);    
    //Validar
    public GestionarUsuariosDTO validarUsuarioLogin(String cedula, String contrasenia);
    
	public RespuestaDTO actualizarContraseniaUsuario(GestionarUsuariosDTO usuario);
	
	 public List<GestionarUsuariosDTO> obtenerUsuario(GestionarUsuariosDTO cedula); 
}
