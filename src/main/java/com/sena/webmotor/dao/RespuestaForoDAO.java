package com.sena.webmotor.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
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
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;

import com.sena.webmotor.dto.PreguntaForoDTO;
import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.dto.RespuestaForoDTO;
import com.sena.webmotor.implement.RespuestaForoImp;

@Component
public class RespuestaForoDAO implements RespuestaForoImp {
	
	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate jdbcTemplate;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public List<RespuestaForoDTO> consultarRespuestaForo (int id) {
		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<RespuestaForoDTO> lstPrueba = new ArrayList<RespuestaForoDTO>();
		try {
			resultMap = jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_ConsultarRespuesta_Foro](?)}");
					callableStatement.setInt(1, id);

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
			RespuestaForoDTO prue = new RespuestaForoDTO();
			
			prue.setId(Integer.parseInt(rowMap.get("id").toString()));
			prue.setDescripcion_respuesta(rowMap.get("descripcion_respuesta").toString());
			prue.setFecha_publicacion(sdf.format(rowMap.get("fecha_publicacion")));
			prue.setId_pregunta(Integer.parseInt(rowMap.get("id_pregunta").toString()));
			prue.setCedula(rowMap.get("cedula").toString());
			
			
			lstPrueba.add(prue);
		}
		return lstPrueba;
	
	}

	@Override
	public RespuestaDTO crearRespuestaForo(RespuestaForoDTO respuestaForo) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			
			jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_CrearRespuesta_Foro](?,?,?)}");

					callableStatement.setString(1, respuestaForo.getDescripcion_respuesta());
					
					callableStatement.setInt(2, respuestaForo.getId_pregunta());
					callableStatement.setString(3, respuestaForo.getCedula());
					return callableStatement;

				}
			}, parameters);
			respuesta = new RespuestaDTO("OK Se creo el correctamente la respuesta: ", "EX");
		} catch (Exception e) {
			respuesta = new RespuestaDTO("ER", "99", "Error guardando Pregunta: " + respuestaForo.getId(), "GU");

		}
		return respuesta;
	}

	@Override
	public RespuestaDTO actualizarRespuestaForo(RespuestaForoDTO respuestaForo) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			java.util.Date date = sdf.parse(respuestaForo.getFecha_publicacion());
			java.sql.Date fec = new java.sql.Date(date.getTime());
			jdbcTemplate.call(new CallableStatementCreator() {
				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_ActualizarRespuesta_Foro](?,?,?,?,?)}");
					callableStatement.setInt(1, respuestaForo.getId());
					callableStatement.setString(2, respuestaForo.getDescripcion_respuesta());
					callableStatement.setDate(3, fec);
					callableStatement.setInt(4, respuestaForo.getId_pregunta());
					callableStatement.setString(5, respuestaForo.getCedula());

					return callableStatement;
				}
			}, parameters);
			respuesta = new RespuestaDTO("OK Se actualizo correctamente Respuesta: ", "EX");
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = new RespuestaDTO("ER", "99", "Error actualizar Respuesta: " + respuestaForo.getId(), "GU");
		}
		return respuesta;
	}

	@Override
	public RespuestaDTO eliminarRespuestaForo(RespuestaForoDTO respuestaForo) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			jdbcTemplate.call(new CallableStatementCreator() {
				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_EliminarRespuesta_Foro](?,?,?)}");
					callableStatement.setInt(1, respuestaForo.getId());
					callableStatement.setString(2, respuestaForo.getCedula());
					callableStatement.setInt(3, respuestaForo.getId_pregunta());
					return callableStatement;
				}
			}, parameters);
			respuesta = new RespuestaDTO("OK Se elimino correctamente el Respuesta: cc  ", "EX");
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = new RespuestaDTO("ER", "99", "Error al eliminar el Respuesta: cc  ", "GU");
		}
		return respuesta;
	}

}
