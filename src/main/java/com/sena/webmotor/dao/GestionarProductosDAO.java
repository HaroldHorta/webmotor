package com.sena.webmotor.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import com.sena.webmotor.dto.CilindrajeDTO;
import com.sena.webmotor.dto.GestionarAlmacenesDTO;
import com.sena.webmotor.dto.GestionarCategoriasDTO;
import com.sena.webmotor.dto.GestionarProductosDTO;
import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.dto.VehiculoDTO;
import com.sena.webmotor.implement.GestionarProductosImp;

@Component
public class GestionarProductosDAO implements GestionarProductosImp{
	
	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate JdbcTemplate;	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	
	
	@Override
	public List<GestionarProductosDTO> listarProductos(String codigo) {
		
		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<GestionarProductosDTO> lstProductos = new ArrayList<GestionarProductosDTO>();
				
		try {			
			 
			resultMap = JdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_ListarProducto](?)}");
					callableStatement.setString(1, codigo);

					return callableStatement;
				}
			}, parameters);			 
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(resultMap);
		List<Object> lstObjetos = (List<Object>) resultMap.get("#result-set-1");
		
		for(int i = 0; i < lstObjetos.size(); i++) {
			Map rowMap = (Map) lstObjetos.get(i);
			GestionarProductosDTO producto = new GestionarProductosDTO();
			
			producto.setId((int) rowMap.get("id"));
			producto.setNombre(rowMap.get("nombre").toString());
			producto.setDescripcion(rowMap.get("descripcion").toString());			
			producto.setCosto((int) rowMap.get("costo"));
			producto.setUrl_imagen(rowMap.get("Url_imagen").toString());
			producto.setId_almacen((int) rowMap.get("id_almacen"));															
			producto.setCodigo(rowMap.get("codigo").toString());
			producto.setId_categoria((int) rowMap.get("id_categoria"));			
			producto.setExistencias((int) rowMap.get("existencias"));
			lstProductos.add(producto);
		}
		return lstProductos;
	}

	@Override
	public RespuestaDTO crearProductos(GestionarProductosDTO producto) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			JdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_CrearProducto](?,?,?,?,?,?,?,?)}");

					callableStatement.setString(1, producto.getCodigo());
					callableStatement.setString(2, producto.getNombre());
					callableStatement.setString(3, producto.getDescripcion());
					callableStatement.setInt(4, producto.getCosto());
					callableStatement.setString(5, producto.getUrl_imagen());
					callableStatement.setInt(6, producto.getId_almacen());
					callableStatement.setInt(7, producto.getId_categoria());
					callableStatement.setInt(8, producto.getExistencias());					
					return callableStatement;

				}
			}, parameters);
			respuesta = new RespuestaDTO("OK Se creo el correctamente Aspirante: ", "EX");
		} catch (Exception e) {
			respuesta = new RespuestaDTO("ER", "99", "Error guardando Aspirante: " + producto.getCodigo(), "GU");

		}
		return respuesta;		
	}

	@Override
	public List<GestionarAlmacenesDTO> obtenerAlmacen() {
		return JdbcTemplate.query("select id,nombre from Almacen",
				new RowMapper<GestionarAlmacenesDTO>() {
					public GestionarAlmacenesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new GestionarAlmacenesDTO(rs.getInt(1), rs.getString(2));
					}
		});
	}

	@Override
	public List<GestionarCategoriasDTO> obtenerCategoria() {
		return JdbcTemplate.query("select id,categoria from Categorias",
				new RowMapper<GestionarCategoriasDTO>() {
					public GestionarCategoriasDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new GestionarCategoriasDTO(rs.getInt(1), rs.getString(2));
					}
		});
	}
	
	@Override
	public List<GestionarAlmacenesDTO> obtenerAlmacenes(GestionarAlmacenesDTO almacen) {

		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<GestionarAlmacenesDTO> lstAlmacen = new ArrayList<GestionarAlmacenesDTO>();
		try {
			resultMap = JdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_ObtenerAlmacen](?)}");
					callableStatement.setInt(1, almacen.getId());

					return callableStatement;
				}
			}, parameters);
		} catch (Exception e) {
			System.out.println("DAO ALMACEN PRODUCTO");
			e.printStackTrace();
		}
		System.out.println(resultMap);
		List<Object> lstObjetos = (List<Object>) resultMap.get("#result-set-1");

		for (int i = 0; i < lstObjetos.size(); i++) {
			Map rowMap = (Map) lstObjetos.get(i);
			GestionarAlmacenesDTO alm = new GestionarAlmacenesDTO();
			alm.setId(Integer.parseInt(rowMap.get("id").toString()));
			alm.setNombre(rowMap.get("nombre").toString());
			
			

			lstAlmacen.add(alm);
		}

		return lstAlmacen;
	
	}
	
	@Override
	public List<GestionarCategoriasDTO> obtenerCategorias(GestionarCategoriasDTO categorias) {

		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<GestionarCategoriasDTO> lstCategorias = new ArrayList<GestionarCategoriasDTO>();
		try {
			resultMap = JdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_ObtenerCategoria](?)}");
					callableStatement.setInt(1, categorias.getId());

					return callableStatement;
				}
			}, parameters);
		} catch (Exception e) {
			System.out.println("DAO CATEGORIA PRODUCTO");
			e.printStackTrace();
		}
		System.out.println(resultMap);
		List<Object> lstObjetos = (List<Object>) resultMap.get("#result-set-1");

		for (int i = 0; i < lstObjetos.size(); i++) {
			Map rowMap = (Map) lstObjetos.get(i);
			GestionarCategoriasDTO cat = new GestionarCategoriasDTO();
			cat.setId(Integer.parseInt(rowMap.get("id").toString()));
			cat.setCategoria(rowMap.get("categoria").toString());
			
			

			lstCategorias.add(cat);
		}

		return lstCategorias;
	
	}	

	
	@Override
	public RespuestaDTO actualizarProducto(GestionarProductosDTO producto) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			JdbcTemplate.call(new CallableStatementCreator() {
				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_ActualizarProducto](?,?,?,?,?,?,?,?,?)}");
					callableStatement.setInt(1, producto.getId());					
					callableStatement.setString(2, producto.getNombre());
					callableStatement.setString(3, producto.getDescripcion());
					callableStatement.setInt(4, producto.getCosto());
					if (producto.getUrl_imagen() == null) {
						producto.setUrl_imagen("../../../../assets/images/combo2.png");
						callableStatement.setString(5, producto.getUrl_imagen());
					}else {
						callableStatement.setString(5, producto.getUrl_imagen());
					}					
					callableStatement.setInt(6, producto.getId_almacen());					
					callableStatement.setString(7, producto.getCodigo());
					callableStatement.setInt(8, producto.getId_categoria());
					callableStatement.setInt(9, producto.getExistencias());							
					return callableStatement;
				}
			}, parameters);
			respuesta = new RespuestaDTO("OK", "EX" + producto.getUrl_imagen());
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = new RespuestaDTO("ER", "99", "Error actualizar producto: " + producto.getUrl_imagen(), "GU");
		}
		return respuesta;
	}
	
	@Override
	public RespuestaDTO eliminarProductos(GestionarProductosDTO producto) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			JdbcTemplate.call(new CallableStatementCreator() {
				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_EliminarProducto](?)}");
					callableStatement.setInt(1, producto.getId());
					return callableStatement;
				}
			}, parameters);
			respuesta = new RespuestaDTO("OK", "EX");
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = new RespuestaDTO("ER", "99", "Error al eliminar el producto ", "GU");
		}
		return respuesta;
	}

	@Override
	public List<GestionarProductosDTO> obtenerProducto(GestionarProductosDTO productos) {
		
		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<GestionarProductosDTO> lstProductos = new ArrayList<GestionarProductosDTO>();
				
		try {			
			 
			resultMap = JdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_ObtenerProducto](?)}");
					callableStatement.setInt(1, productos.getId());

					return callableStatement;
				}
			}, parameters);			 
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(resultMap);
		List<Object> lstObjetos = (List<Object>) resultMap.get("#result-set-1");
		
		for(int i = 0; i < lstObjetos.size(); i++) {
			Map rowMap = (Map) lstObjetos.get(i);
			GestionarProductosDTO producto = new GestionarProductosDTO();
			
			producto.setId((int) rowMap.get("id"));
			producto.setNombre(rowMap.get("nombre").toString());
			producto.setDescripcion(rowMap.get("descripcion").toString());			
			producto.setCosto((int) rowMap.get("costo"));
			producto.setUrl_imagen(rowMap.get("Url_imagen").toString());
			producto.setId_almacen((int) rowMap.get("id_almacen"));															
			producto.setCodigo(rowMap.get("codigo").toString());
			producto.setId_categoria((int) rowMap.get("id_categoria"));			
			producto.setExistencias((int) rowMap.get("existencias"));
			lstProductos.add(producto);
		}
		return lstProductos;
	}	
	
}
