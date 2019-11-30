package com.sena.webmotor.dto;

//import java.util.Date;

public class GestionarUsuariosDTO {
	
	private String cedula;
    private String nombre;
    private String apellido;
    private String contrasenia;
    private String correo;
    private String telefono;
    private int id_rol;
    private String nombreRol;
    private String fecha_inicio;
    private String estado;
    private String contraseniaActual;
    private String contraseniaNueva;
    
    public GestionarUsuariosDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public GestionarUsuariosDTO(String cedula, String nombre, String apellido, String contrasenia, String correo,
			String telefono, int id_rol, String nombreRol, String fecha_inicio, String fecha_nacimiento, String estado) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasenia = contrasenia;
		this.correo = correo;
		this.telefono = telefono;
		this.id_rol = id_rol;
		this.nombreRol = nombreRol;
		this.fecha_inicio = fecha_inicio;
		this.estado = estado;
	}

	

	/**
	 * @param cedula
	 * @param nombre
	 * @param apellido
	 * @param contrasenia
	 * @param correo
	 * @param telefono
	 * @param id_rol
	 * @param nombreRol
	 * @param fecha_inicio
	 * @param estado
	 * @param contraseniaActual
	 * @param contraseniaNueva
	 */
	public GestionarUsuariosDTO(String cedula, String nombre, String apellido, String contrasenia, String correo,
			String telefono, int id_rol, String nombreRol, String fecha_inicio, String estado, String contraseniaActual,
			String contraseniaNueva) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasenia = contrasenia;
		this.correo = correo;
		this.telefono = telefono;
		this.id_rol = id_rol;
		this.nombreRol = nombreRol;
		this.fecha_inicio = fecha_inicio;
		this.estado = estado;
		this.contraseniaActual = contraseniaActual;
		this.contraseniaNueva = contraseniaNueva;
	}


	public GestionarUsuariosDTO(String cedula, String nombre, String apellido, String contrasenia, String correo,
			String telefono, int id_rol, String fecha_inicio, String fecha_nacimiento, String estado) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contrasenia = contrasenia;
		this.correo = correo;
		this.telefono = telefono;
		this.id_rol = id_rol;
		this.fecha_inicio = fecha_inicio;
		this.estado = estado;
	}


	public String getCedula() {
		return cedula;
	}


	public void setCedula(String cedula) {
		this.cedula = cedula;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public int getId_rol() {
		return id_rol;
	}


	public void setId_rol(int id_rol) {
		this.id_rol = id_rol;
	}


	public String getNombreRol() {
		return nombreRol;
	}


	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}


	public String getFecha_inicio() {
		return fecha_inicio;
	}


	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}




	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public String getContraseniaActual() {
		return contraseniaActual;
	}


	public void setContraseniaActual(String contraseniaActual) {
		this.contraseniaActual = contraseniaActual;
	}


	public String getContraseniaNueva() {
		return contraseniaNueva;
	}


	public void setContraseniaNueva(String contraseniaNueva) {
		this.contraseniaNueva = contraseniaNueva;
	}
	
	
}
