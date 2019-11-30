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

import com.sena.webmotor.dto.CilindrajeDTO;
import com.sena.webmotor.dto.EstadoDTO;
import com.sena.webmotor.dto.IdPQRDTO;
import com.sena.webmotor.dto.NombreDTO;
import com.sena.webmotor.dto.PQRDTO;
import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.dto.VehiculoDTO;
import com.sena.webmotor.implement.PQRImp;

@Component
public class PQRDAO implements PQRImp {

	int validarResultado;

	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate jdbcTemplate;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public List<PQRDTO> obtenerPrueba() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PQRDTO> consultarPQR(int id) {
		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));

		List<PQRDTO> lstPrueba = new ArrayList<PQRDTO>();
		try {
			resultMap = jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_ConsultarPQR] (?)}");
					callableStatement.setInt(1, id);

					return callableStatement;
				}
			}, parameters);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(resultMap);
		List<Object> lstObjetos = (List<Object>) resultMap.get("#result-set-1");

		for (int i = 0; i < lstObjetos.size(); i++) {
			Map rowMap = (Map) lstObjetos.get(i);
			PQRDTO prue = new PQRDTO();
			prue.setId(Integer.parseInt(rowMap.get("id").toString()));
			prue.setNombre(rowMap.get("nombre").toString());
			prue.setApellido(rowMap.get("apellido").toString());
			prue.setCedula(rowMap.get("cedula").toString());
			prue.setDescripcion(rowMap.get("descripcion").toString());
			prue.setTipo_problema(Integer.parseInt(rowMap.get("tipo_problema").toString()));
			prue.setNombre_problema(rowMap.get("nombre_problema").toString());
			prue.setFecha(sdf.format(rowMap.get("fecha")));
			prue.setNombre_estado(rowMap.get("nombre_estado").toString());
			prue.setId_estado(Integer.parseInt(rowMap.get("estado").toString()));

			lstPrueba.add(prue);
		}
		return lstPrueba;
	}

	@Override
	public RespuestaDTO crearPQR(PQRDTO notas) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_CrearPQR](?,?,?)}");
					callableStatement.setString(1, notas.getCedula());
					callableStatement.setInt(2, notas.getTipo_problema());
					callableStatement.setString(3, notas.getDescripcion());
					return callableStatement;

				}

			}, parameters);
			respuesta = new RespuestaDTO("OK Se agrego la peticion correctamente" + notas.getCedula(), "EX");
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = new RespuestaDTO("ER", "99", "OTRO ERROR KAPA8 (Error guardando peticion)", "GU");
		}
		return respuesta;
	}

	@Override
	public RespuestaDTO actualizarPQR(PQRDTO notas) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			jdbcTemplate.call(new CallableStatementCreator() {
				
				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_ActualizarPQR](?,?)}");
					callableStatement.setInt(1, notas.getId());
					callableStatement.setInt(2, notas.getId_estado());
					return callableStatement;
				}
			}, parameters);
			respuesta = new RespuestaDTO("Se actualizo correctamente: ", "EX");
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = new RespuestaDTO("ER", "99", "ERROR AL ACTUALIZAR" + notas.getId(), "GU");
		}
		return respuesta;
	}

	@Override
	public RespuestaDTO eliminarTipoPeticionDTO(int id) {

		return null;
	}

	@Override
	public List<PQRDTO> consultarTipoPeticionDTO() {

		return jdbcTemplate.query("select id,nombre_problema from Tipo_Problema", new RowMapper<PQRDTO>() {
			public PQRDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new PQRDTO(rs.getInt(1), rs.getString(2));
			}
		});

	}

	@Override
	public List<EstadoDTO> consultarEstado(int id) {
		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<EstadoDTO> lstEstado = new ArrayList<EstadoDTO>();
		
		try {
			resultMap = jdbcTemplate.call(new CallableStatementCreator() {
				
				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_ObtenerEstado](?)}");
					callableStatement.setInt(1, id);
					
					return callableStatement;
				}
			},parameters);
		} catch (Exception e) {
			System.out.println("DAO ESTADO");
			e.printStackTrace();
		}
		System.out.println(resultMap);
		List<Object> lstObjects = (List<Object>) resultMap.get("#result-set-1");
		
		for (int i = 0; i < lstObjects.size(); i++) {
			Map rowMap = (Map) lstObjects.get(i);
			EstadoDTO est = new EstadoDTO();
			est.setId_estado(Integer.parseInt(rowMap.get("id").toString()));
			est.setNombre_estado(rowMap.get("nombre_estado").toString());
			
			lstEstado.add(est);
		}
		return lstEstado;
	
			}


	@Override
	public List<NombreDTO> obtenerNombre(NombreDTO nombre) {
		
		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<NombreDTO> lstNombre = new ArrayList<NombreDTO>();
		try {
			resultMap = jdbcTemplate.call(new CallableStatementCreator() {
				
				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement  callableStatement = con.prepareCall("{call [dbo].[sp_ObtenerNombre](?)}");
					callableStatement.setString(1, nombre.getCedula());
					
					return callableStatement;
				}
			},parameters);
		} catch (Exception e) {
			System.out.println("DAO NOMBRE");
			e.printStackTrace();
		}
		System.out.println(resultMap);
		List<Object> lstObjects = (List<Object>) resultMap.get("#result-set-1");
		
		for (int i = 0; i < lstObjects.size(); i++) {
			Map rowMap = (Map) lstObjects.get(i);
			NombreDTO asp = new NombreDTO();
			asp.setCedula(rowMap.get("cedula").toString());
			asp.setNombre(rowMap.get("nombre").toString());
			
			lstNombre.add(asp);
		}
		
		return lstNombre;
	}

	@Override
	public List<IdPQRDTO> obtenerIdPQR(IdPQRDTO id) {
		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<IdPQRDTO> lstId = new ArrayList<IdPQRDTO>();
		try {
			resultMap = jdbcTemplate.call(new CallableStatementCreator() {
				
				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement  callableStatement = con.prepareCall("{call [dbo].[sp_ObtenerIdPQR] (?)}");
					callableStatement.setInt(1, id.getId());
					
					return callableStatement;
				}
			},parameters);
		} catch (Exception e) {
			System.out.println("DAO ID PQR");
			e.printStackTrace();
		}
		System.out.println(resultMap);
		List<Object> lstObjects = (List<Object>) resultMap.get("#result-set-1");
		
		for (int i = 0; i < lstObjects.size(); i++) {
			Map rowMap = (Map) lstObjects.get(i);
			IdPQRDTO asp = new IdPQRDTO();
			asp.setId(Integer.parseInt(rowMap.get("id").toString()));
			asp.setDescripcion(rowMap.get("descripcion").toString());
			
			lstId.add(asp);
		}
		
		
		return lstId;
	}


	@Override
	public List<EstadoDTO> obtenerEstado(EstadoDTO estado) {

		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<EstadoDTO> lstEstado = new ArrayList<EstadoDTO>();
		
		try {
			resultMap = jdbcTemplate.call(new CallableStatementCreator() {
				
				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_ObtenerEstado](?)}");
					callableStatement.setInt(1, estado.getId_estado());
					
					return callableStatement;
				}
			},parameters);
		} catch (Exception e) {
			System.out.println("DAO ESTADO");
			e.printStackTrace();
		}
		System.out.println(resultMap);
		List<Object> lstObjects = (List<Object>) resultMap.get("#result-set-1");
		
		for (int i = 0; i < lstObjects.size(); i++) {
			Map rowMap = (Map) lstObjects.get(i);
			EstadoDTO est = new EstadoDTO();
			est.setId_estado(Integer.parseInt(rowMap.get("id").toString()));
			est.setNombre_estado(rowMap.get("nombre_estado").toString());
			
			lstEstado.add(est);
		}
		return lstEstado;

	}
}