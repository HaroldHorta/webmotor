package com.sena.webmotor.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import com.sena.webmotor.dto.GestionarRolDTO;
import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.implement.GestionarRolImp;

@Component
public class GestionarRolDAO implements GestionarRolImp{

	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate JdbcTemplate;
	
	@Override
	public List<GestionarRolDTO> listarRol(int id) {
		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<GestionarRolDTO> lstRol = new ArrayList<GestionarRolDTO>();
				
		try {			
			 
			resultMap = JdbcTemplate.call(new CallableStatementCreator() {				

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_ListarRol](?)}");
					callableStatement.setInt(1, id);

					return callableStatement;					
				}
			}, parameters);			 
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		List<Object> lstObjetos = (List<Object>) resultMap.get("#result-set-1");
		
		for(int i = 0; i < lstObjetos.size(); i++) {
			Map rowMap = (Map) lstObjetos.get(i);
			GestionarRolDTO rol = new GestionarRolDTO();
			
			rol.setId(Integer.parseInt(rowMap.get("id").toString()));
			rol.setNombre(rowMap.get("nombre").toString());		
			lstRol.add(rol);
		}
		return lstRol;
	}

	@Override
	public RespuestaDTO crearRol(GestionarRolDTO rol) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {			
			JdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_CrearRol](?)}");
										
					callableStatement.setString(1, rol.getNombre());			
					return callableStatement;
					
				}
				
			}, parameters);
			respuesta = new RespuestaDTO("OK Se creo la el rol correctamente", "EX");
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = new RespuestaDTO("ER", "99", "Error guardando rol", "GU");
		}
		return respuesta;

	}

	@Override
	public RespuestaDTO editarRol(GestionarRolDTO rol) {
	
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));		
		
		try {			
			
			JdbcTemplate.call(new CallableStatementCreator() {
				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_ActualizarRol](?,?)}");
					
					callableStatement.setString(1, rol.getNombre());				
					callableStatement.setInt(2, rol.getId());
					
					return callableStatement;
				}
			}, parameters);
			
			respuesta = new RespuestaDTO("OK Se actualizo el ROL correctamente", "EX");
			
		} catch (Exception e) {			
			e.printStackTrace();
			respuesta = new RespuestaDTO("ER", "99", "Error actualizar ROL", "GU");
		}
		
		return respuesta;		
	}

}
