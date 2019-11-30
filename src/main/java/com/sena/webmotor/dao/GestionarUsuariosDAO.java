package com.sena.webmotor.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

import com.sena.webmotor.dto.GestionarUsuariosDTO;
import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.implement.GestionarUsuariosImp;

@Component
public class GestionarUsuariosDAO implements GestionarUsuariosImp {
	
	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate JdbcTemplate;	
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");	

	@Override
	public List<GestionarUsuariosDTO> listarUsuario(String cedula) {
		
		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<GestionarUsuariosDTO> lstUsuarios = new ArrayList<GestionarUsuariosDTO>();
				
		try {			
			 
			resultMap = JdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_ListarUsuario](?)}");
					callableStatement.setString(1, cedula);

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
			GestionarUsuariosDTO usuario = new GestionarUsuariosDTO();
			
			usuario.setCedula(rowMap.get("cedula").toString());
			usuario.setNombre(rowMap.get("nombre").toString());
			usuario.setApellido(rowMap.get("apellido").toString());			
			usuario.setCorreo(rowMap.get("correo").toString());
			usuario.setNombreRol(rowMap.get("nombre").toString());
			usuario.setTelefono(rowMap.get("telefono").toString());															
			usuario.setFecha_inicio(sdf.format(rowMap.get("fecha_inicio")));	
			usuario.setEstado(rowMap.get("estado").toString());
			lstUsuarios.add(usuario);
		}
		return lstUsuarios;
	}

	@Override
	public RespuestaDTO crearUsuario(GestionarUsuariosDTO usuario) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			//java.util.Date dateI = sdf.parse(usuario.getFecha_inicio());
			//java.sql.Date fecI = new java.sql.Date(dateI.getTime());
	
			
			JdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_CrearUsuario](?,?,?,?,?,?)}");
					
					callableStatement.setString(1, usuario.getCedula());
					callableStatement.setString(2, usuario.getNombre());
					callableStatement.setString(3, usuario.getApellido());
					callableStatement.setString(4, usuario.getContrasenia());
					callableStatement.setString(5, usuario.getCorreo());
					callableStatement.setString(6, usuario.getTelefono());
								
					
					return callableStatement;
					
				}
				
			}, parameters);
			respuesta = new RespuestaDTO("OK Se creo la el usuario correctamente", "EX");
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = new RespuestaDTO("ER", "99", "Error guardando usuario", "GU");
		}
		return respuesta;

	}

	@Override
	public RespuestaDTO editarUsuario(GestionarUsuariosDTO usuario) {
		
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));		
		
		try {
			
			java.util.Date dateI = sdf.parse(usuario.getFecha_inicio());
			java.sql.Date fecI = new java.sql.Date(dateI.getTime());
			
			JdbcTemplate.call(new CallableStatementCreator() {
				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_ActualizarUsuario](?,?,?,?,?,?,?,?,?,?)}");
					
					callableStatement.setString(1, usuario.getNombre());
					callableStatement.setString(2, usuario.getApellido());
					callableStatement.setString(3, usuario.getContrasenia());
					callableStatement.setString(4, usuario.getCorreo());
					callableStatement.setString(5, usuario.getTelefono());
					callableStatement.setInt(6, usuario.getId_rol());
					callableStatement.setDate(7, fecI);
			
					callableStatement.setString(9, usuario.getEstado());
					callableStatement.setString(10, usuario.getCedula());
					
					return callableStatement;
				}
			}, parameters);
			
			respuesta = new RespuestaDTO("OK Se actualizo el usuario correctamente", "EX");
			
		} catch (Exception e) {			
			e.printStackTrace();
			respuesta = new RespuestaDTO("ER", "99", "Error actualizar usuario", "GU");
		}
		
		return respuesta;		
	}

	@Override
	public GestionarUsuariosDTO validarUsuarioLogin(String cedula, String contrasenia) {
		
		RespuestaDTO respuesta;		 
		try { 
			String sql = "SELECT cedula, nombre, apellido, contrasenia, correo, telefono, id_rol, fecha_inicio, estado FROM Usuario WHERE cedula = " + cedula + " and contrasenia = " + "'" + contrasenia + "'";					
			GestionarUsuariosDTO usuarioLogin = JdbcTemplate.queryForObject(sql, new RowMapper<GestionarUsuariosDTO>() {
	            public GestionarUsuariosDTO mapRow(ResultSet rs, int rowNum) throws SQLException {	 
	            	GestionarUsuariosDTO usuario = new GestionarUsuariosDTO();
	            	usuario.setCedula(rs.getString(1));
	            	usuario.setNombre(rs.getString(2));
	            	usuario.setApellido(rs.getString(3));
	            	usuario.setContrasenia(rs.getString(4));
	            	usuario.setCorreo(rs.getString(5));
	            	usuario.setTelefono(rs.getString(6));
	            	usuario.setId_rol(rs.getInt(7));
	            	usuario.setFecha_inicio(rs.getDate(8).toString());
	            
	            	usuario.setEstado(rs.getString(9));
	                return usuario;                
	            }      	           
	        });		
			respuesta = new RespuestaDTO("OK Usuario Existente", "EX");
			return usuarioLogin;
			
		} catch (Exception e) {
			respuesta = new RespuestaDTO("OK Usuario NO Existente", "EX");
			//GestionarUsuariosDTO usuarioLogin = null;
			GestionarUsuariosDTO usuarioNull = new GestionarUsuariosDTO();
			return usuarioNull;
		}
		
		
		
	}

	@Override
	public RespuestaDTO actualizarContraseniaUsuario(GestionarUsuariosDTO usuario) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			JdbcTemplate.call(new CallableStatementCreator() {
				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[actualizarContraseniaUsuario](?,?,?)}");
					callableStatement.setString(1, usuario.getCedula());
					callableStatement.setString(2, usuario.getContraseniaActual());
					callableStatement.setString(3, usuario.getContraseniaNueva());
					
					return callableStatement;
				}
			}, parameters);
			respuesta = new RespuestaDTO("OK Se actualizo correctamente aspirante: ", "EX");
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = new RespuestaDTO("ER", "99", "Error actualizar aspirante: " + usuario.getCedula(), "GU");
		}
		return respuesta;
	}

	@Override
	public List<GestionarUsuariosDTO> obtenerUsuario(GestionarUsuariosDTO cedula) {
		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<GestionarUsuariosDTO> lstUsuarios = new ArrayList<GestionarUsuariosDTO>();
				
		try {			
			 
			resultMap = JdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_ListarUsuario](?)}");
					callableStatement.setString(1, cedula.getCedula());

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
			GestionarUsuariosDTO usuario = new GestionarUsuariosDTO();
			
			usuario.setCedula(rowMap.get("cedula").toString());
			usuario.setNombre(rowMap.get("nombre").toString());
			usuario.setApellido(rowMap.get("apellido").toString());		
			usuario.setContrasenia(rowMap.get("contrasenia").toString());
			usuario.setCorreo(rowMap.get("correo").toString());
			usuario.setNombreRol(rowMap.get("nombre").toString());
			usuario.setTelefono(rowMap.get("telefono").toString());															
			usuario.setFecha_inicio(sdf.format(rowMap.get("fecha_inicio")));	
			usuario.setEstado(rowMap.get("estado").toString());
			lstUsuarios.add(usuario);
		}
		return lstUsuarios;
	}
	
	
}
