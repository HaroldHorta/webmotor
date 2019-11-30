package com.sena.webmotor.dto;

public class UsuarioDTO {
	private String nombres;
	private String apellidos;
	private String mensaje;
	private String correo;

	public UsuarioDTO() {
		super();		
	}

	public UsuarioDTO(String nombres, String apellidos, String mensaje, String correo) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.mensaje = mensaje;
		this.correo = correo;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
}
