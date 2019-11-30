package com.sena.webmotor.implement;


import com.sena.webmotor.dto.UsuarioDTO;
public interface EnviarCorreoDAO{

	public boolean generarCorreo( UsuarioDTO persona);

}
