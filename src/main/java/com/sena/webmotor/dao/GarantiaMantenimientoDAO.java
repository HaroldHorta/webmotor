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

import com.sena.webmotor.dto.GarantiaMantenimientoDTO;
import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.implement.GarantiaMantenimientoImp;

import lombok.extern.log4j.Log4j2;


@Log4j2
@Component
public class GarantiaMantenimientoDAO implements GarantiaMantenimientoImp {

	int validarResultado;

	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate jdbcTemplate;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	
	/**
	 * Método para crear garantías de mantenimiento
	 *@return
	 *@param
	 *@author ADMIN
	 *@since
	 *@throws
	 */
	/*
	@Override
	public RespuestaDTO crearGarantiaMantenimiento(GarantiaMantenimientoDTO notas) {
		log.info( "GarantiaMantenimientoDAO - crearGarantiaMantenimiento", notas.toString());
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			return new RespuestaDTO();
		} catch (Exception e) {
			log.error("Error Crear Garanía Mantenimiento: ", e);
			return null;
		}
	}*/
	

	@Override
	public List<GarantiaMantenimientoDTO> consultarGarantiaMantenimiento(String placa) {
		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		
		List<GarantiaMantenimientoDTO> lstPrueba = new ArrayList<GarantiaMantenimientoDTO>();
		try {
			resultMap = jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_ConsultarGarantiaMantenimiento](?)}");
					callableStatement.setString(1, placa);

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
			GarantiaMantenimientoDTO prue = new GarantiaMantenimientoDTO();
			prue.setNombre(rowMap.get("nombre").toString());
			prue.setApellido(rowMap.get("apellido").toString());
			prue.setObservaciones(rowMap.get("observaciones").toString());
			prue.setPlaca(rowMap.get("placa").toString());
			prue.setFecha_mantenimiento(sdf.format(rowMap.get("fecha_mantenimiento")));
			prue.setFecha_vencimiento_mantenimiento(sdf.format(rowMap.get("fecha_vencimiento_mantenimiento")));
			prue.setId(Integer.parseInt(rowMap.get("id").toString()));

			lstPrueba.add(prue);
		}
		return lstPrueba;
	}

	@Override
	public List<GarantiaMantenimientoDTO> obtenerPrueba() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RespuestaDTO actualizarGarantiaMantenimientoDTO(GarantiaMantenimientoDTO notas) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RespuestaDTO eliminarGarantiaMantenimientoDTO(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
