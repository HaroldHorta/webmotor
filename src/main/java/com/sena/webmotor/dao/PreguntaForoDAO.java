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

import com.sena.webmotor.implement.PreguntaForoImp;

@Component
public class PreguntaForoDAO implements PreguntaForoImp {

	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate jdbcTemplate;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public List<PreguntaForoDTO> consultarPreguntaForo(int id) {
		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<PreguntaForoDTO> lstPrueba = new ArrayList<PreguntaForoDTO>();
		try {
			resultMap = jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_ConsultarPregunta_Foro](?)}");
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
			PreguntaForoDTO prue = new PreguntaForoDTO();
			
			prue.setIdPregunta(Integer.parseInt(rowMap.get("idPregunta").toString()));
			prue.setPregunta(rowMap.get("pregunta").toString());
			prue.setFechaPregunta(sdf.format(rowMap.get("fechaPregunta")));
			prue.setCedulaPregunta(rowMap.get("cedulaPregunta").toString());
			prue.setNombrePregunta(rowMap.get("nombrePregunta").toString());
			
			prue.setIdrespuesta1(Integer.parseInt(rowMap.get("idRespuesta1").toString()));
			prue.setDescripcionRespuesta1(rowMap.get("descripcionRespuesta1").toString());
			prue.setCedulaRespuesta1(rowMap.get("cedulaRespuesta1").toString());
			prue.setNombreRespuesta1(rowMap.get("nombreRespuesta1").toString());
			
			prue.setIdrespuesta2(Integer.parseInt(rowMap.get("idRespuesta2").toString()));
			prue.setDescripcionRespuesta2(rowMap.get("descripcionRespuesta2").toString());
			prue.setCedulaRespuesta2(rowMap.get("cedulaRespuesta2").toString());
			prue.setNombreRespuesta2(rowMap.get("nombreRespuesta2").toString());
			
			prue.setIdrespuesta3(Integer.parseInt(rowMap.get("idRespuesta3").toString()));
			prue.setDescripcionRespuesta3(rowMap.get("descripcionRespuesta3").toString());
			prue.setCedulaRespuesta3(rowMap.get("cedulaRespuesta3").toString());
			prue.setNombreRespuesta3(rowMap.get("nombreRespuesta3").toString());
			
			prue.setIdrespuesta4(Integer.parseInt(rowMap.get("idRespuesta4").toString()));
			prue.setDescripcionRespuesta4(rowMap.get("descripcionRespuesta4").toString());
			prue.setCedulaRespuesta4(rowMap.get("cedulaRespuesta4").toString());
			prue.setNombreRespuesta4(rowMap.get("nombreRespuesta4").toString());
			
			prue.setIdrespuesta5(Integer.parseInt(rowMap.get("idRespuesta5").toString()));
			prue.setDescripcionRespuesta5(rowMap.get("descripcionRespuesta5").toString());
			prue.setCedulaRespuesta5(rowMap.get("cedulaRespuesta5").toString());
			prue.setNombreRespuesta5(rowMap.get("nombreRespuesta5").toString());
			lstPrueba.add(prue);
		}
		return lstPrueba;
	}

	@Override
	public RespuestaDTO crearPreguntaForo(PreguntaForoDTO PreguntaForo) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			//java.util.Date date = sdf.parse(PreguntaForo.getFecha());
			//java.sql.Date fec = new java.sql.Date(date.getTime());
			jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_CrearPregunta_Foro](?,?)}");

					callableStatement.setString(1, PreguntaForo.getPregunta());
					
					callableStatement.setString(2, PreguntaForo.getCedulaPregunta());
					return callableStatement;

				}
			}, parameters);
			respuesta = new RespuestaDTO("OK Se creo el correctamente la pregunta: ", "EX");
		} catch (Exception e) {
			respuesta = new RespuestaDTO("ER", "99", "Error guardando Pregunta: " + PreguntaForo.getIdPregunta(), "GU");

		}
		return respuesta;
	}

	@Override
	public RespuestaDTO actualizarPreguntaForo(PreguntaForoDTO PreguntaForo) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			//java.util.Date date = sdf.parse(PreguntaForo.getFecha());
			//java.sql.Date fec = new java.sql.Date(date.getTime());
			jdbcTemplate.call(new CallableStatementCreator() {
				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_ActualizarPregunta_Foro](?,?)}");
					callableStatement.setInt(1, PreguntaForo.getIdPregunta());
					callableStatement.setString(2, PreguntaForo.getPregunta());
				
					
					return callableStatement;
				}
			}, parameters);
			respuesta = new RespuestaDTO("OK Se actualizo correctamente aspirante: ", "EX");
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = new RespuestaDTO("ER", "99", "Error actualizar aspirante: " + PreguntaForo.getIdPregunta(), "GU");
		}
		return respuesta;
	}

	@Override
	public RespuestaDTO eliminarPreguntaForo(PreguntaForoDTO PreguntaForo) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			jdbcTemplate.call(new CallableStatementCreator() {
				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_EliminarPregunta_Foro](?,?)}");
					callableStatement.setInt(1, PreguntaForo.getIdPregunta());
					callableStatement.setString(2, PreguntaForo.getCedulaPregunta());
					return callableStatement;
				}
			}, parameters);
			respuesta = new RespuestaDTO("OK Se elimino correctamente el aspirante: cc  ", "EX");
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = new RespuestaDTO("ER", "99", "Error al eliminar el Aspirante: cc  ", "GU");
		}
		return respuesta;
	}

	@Override
	public List<PreguntaForoDTO> obtenerPreguntaForo(PreguntaForoDTO PreguntaForo) {
		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<PreguntaForoDTO> lstPrueba = new ArrayList<PreguntaForoDTO>();
		try {
			resultMap = jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_ConsultarPregunta_Foro](?)}");
					callableStatement.setInt(1, PreguntaForo.getIdPregunta());

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
			PreguntaForoDTO prue = new PreguntaForoDTO();
			
			prue.setIdPregunta(Integer.parseInt(rowMap.get("idPregunta").toString()));
			prue.setPregunta(rowMap.get("pregunta").toString());
			prue.setFechaPregunta(sdf.format(rowMap.get("fechaPregunta")));
			prue.setCedulaPregunta(rowMap.get("cedulaPregunta").toString());
			prue.setNombrePregunta(rowMap.get("nombrePregunta").toString());
			
			prue.setIdrespuesta1(Integer.parseInt(rowMap.get("idRespuesta1").toString()));
			prue.setDescripcionRespuesta1(rowMap.get("descripcionRespuesta1").toString());
			prue.setCedulaRespuesta1(rowMap.get("cedulaRespuesta1").toString());
			prue.setNombreRespuesta1(rowMap.get("nombreRespuesta1").toString());
			
			prue.setIdrespuesta2(Integer.parseInt(rowMap.get("idRespuesta2").toString()));
			prue.setDescripcionRespuesta2(rowMap.get("descripcionRespuesta2").toString());
			prue.setCedulaRespuesta2(rowMap.get("cedulaRespuesta2").toString());
			prue.setNombreRespuesta2(rowMap.get("nombreRespuesta2").toString());
			
			prue.setIdrespuesta3(Integer.parseInt(rowMap.get("idRespuesta3").toString()));
			prue.setDescripcionRespuesta3(rowMap.get("descripcionRespuesta3").toString());
			prue.setCedulaRespuesta3(rowMap.get("cedulaRespuesta3").toString());
			prue.setNombreRespuesta3(rowMap.get("nombreRespuesta3").toString());
			
			prue.setIdrespuesta4(Integer.parseInt(rowMap.get("idRespuesta4").toString()));
			prue.setDescripcionRespuesta4(rowMap.get("descripcionRespuesta4").toString());
			prue.setCedulaRespuesta4(rowMap.get("cedulaRespuesta4").toString());
			prue.setNombreRespuesta4(rowMap.get("nombreRespuesta4").toString());
			
			prue.setIdrespuesta5(Integer.parseInt(rowMap.get("idRespuesta5").toString()));
			prue.setDescripcionRespuesta5(rowMap.get("descripcionRespuesta5").toString());
			prue.setCedulaRespuesta5(rowMap.get("cedulaRespuesta5").toString());
			prue.setNombreRespuesta5(rowMap.get("nombreRespuesta5").toString());
			lstPrueba.add(prue);
		}
		return lstPrueba;
	}

}
