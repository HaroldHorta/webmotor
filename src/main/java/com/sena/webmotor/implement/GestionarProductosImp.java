package com.sena.webmotor.implement;

import java.util.List;

import com.sena.webmotor.dto.GestionarAlmacenesDTO;
import com.sena.webmotor.dto.GestionarCategoriasDTO;
import com.sena.webmotor.dto.GestionarProductosDTO;
import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.dto.VehiculoDTO;


public interface GestionarProductosImp {

	// listar por producto
    public List<GestionarProductosDTO> listarProductos(String codigo);
    // Agregar
    public RespuestaDTO crearProductos(GestionarProductosDTO producto);
    //obtener almacen
    public List<GestionarAlmacenesDTO> obtenerAlmacen ();
    //obtener categoria
    public List<GestionarCategoriasDTO> obtenerCategoria ();
    // Editar
    public RespuestaDTO actualizarProducto(GestionarProductosDTO producto);    
    // Consultar por id producto
    public List<GestionarProductosDTO> obtenerProducto(GestionarProductosDTO producto);
    // Consultar un almacen especifico
    public List<GestionarAlmacenesDTO> obtenerAlmacenes(GestionarAlmacenesDTO almacen);
    // Consulta una categoria en especifico
    public List<GestionarCategoriasDTO> obtenerCategorias(GestionarCategoriasDTO categorias);    
    // Eliminar un producto en especifico
    public RespuestaDTO eliminarProductos(GestionarProductosDTO producto);
    //public RespuestaDTO actualizarProducto(GestionarProductosDTO usuario);    
    //Validar
    //public GestionarProductosDTO validarUsuarioLogin(String cedula, String contrasenia);
}
