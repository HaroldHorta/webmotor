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

import com.sena.webmotor.dto.CotizacionDTO;
import com.sena.webmotor.dto.NotaMantenimientoDTO;
import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.implement.CotizacionImp;


@Component
public class CotizacionDAO implements CotizacionImp{

	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate jdbcTemplate;

	@Override
	public RespuestaDTO crearCotizacion(CotizacionDTO cotizacion) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_CrearCotizacion](?,?,?)}");

					callableStatement.setInt(1, cotizacion.getId_mantenimiento());
					callableStatement.setInt(2, cotizacion.getProductos());
					callableStatement.setInt(3, cotizacion.getCantidad());
				
					
					return callableStatement;

				}

			}, parameters);
			respuesta = new RespuestaDTO("OK Se creo la nota mantenimiento correctamente", "EX");
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = new RespuestaDTO("ER", "99", "Error guardando nota mantenimiento", "GU");
		}
		return respuesta;
	}

	@Override
	public List<CotizacionDTO> obtenerCotizacion(CotizacionDTO cotizacion) {
		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<CotizacionDTO> lstPrueba = new ArrayList<CotizacionDTO>();
		try {
			resultMap = jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_ConsultarCotizacion](?)}");
					callableStatement.setInt(1, cotizacion.getId_mantenimiento());

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
			CotizacionDTO prue = new CotizacionDTO();

			prue.setId_mantenimiento(Integer.parseInt(rowMap.get("id").toString()));
		
			lstPrueba.add(prue);
		}
		return lstPrueba;
	}

}
