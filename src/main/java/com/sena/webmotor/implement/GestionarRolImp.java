package com.sena.webmotor.implement;

import java.util.List;

import com.sena.webmotor.dto.GestionarRolDTO;
import com.sena.webmotor.dto.RespuestaDTO;

public interface GestionarRolImp {
	
	 // listar por usuario
    public List<GestionarRolDTO> listarRol(int id);
    // Agregar
    public RespuestaDTO crearRol(GestionarRolDTO rol);
    // Editar
    public RespuestaDTO editarRol(GestionarRolDTO rol);    
}
