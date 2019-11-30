package com.sena.webmotor.dto;

public class GestionarProductosDTO {
	private int id;
    private String nombre;
    private String descripcion;
    private int costo;
    private String Url_imagen;
    private int id_almacen;
    private String codigo;
    private int id_categoria;
    private int existencias;
	
    
    
    public GestionarProductosDTO() {
		super();
	}
    
    
    
	public GestionarProductosDTO(int id, String nombre, String descripcion, int costo, String url_imagen,
			int id_almacen, String codigo, int id_categoria, int existencias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.costo = costo;
		Url_imagen = url_imagen;
		this.id_almacen = id_almacen;
		this.codigo = codigo;
		this.id_categoria = id_categoria;
		this.existencias = existencias;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo = costo;
	}
	public String getUrl_imagen() {
		return Url_imagen;
	}
	public void setUrl_imagen(String url_imagen) {
		Url_imagen = url_imagen;
	}
	public int getId_almacen() {
		return id_almacen;
	}
	public void setId_almacen(int id_almacen) {
		this.id_almacen = id_almacen;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public int getExistencias() {
		return existencias;
	}
	public void setExistencias(int existencias) {
		this.existencias = existencias;
	} 
    
    
}
