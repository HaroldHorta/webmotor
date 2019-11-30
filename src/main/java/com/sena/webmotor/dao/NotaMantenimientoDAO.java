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

import com.sena.webmotor.dto.DuracionGarantiaDTO;
import com.sena.webmotor.dto.MarcaDTO;
import com.sena.webmotor.dto.NotaMantenimientoDTO;
import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.dto.TipoMantenimientoDTO;
import com.sena.webmotor.implement.NotaMantenimientoImp;

@Component
public class NotaMantenimientoDAO implements NotaMantenimientoImp {

	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate jdbcTemplate;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public RespuestaDTO crearNotaMantenimiento(NotaMantenimientoDTO nota) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_CrearNotaMantenimiento](?,?,?,?,?,?,?)}");

					callableStatement.setString(1, nota.getDescripcion());
					callableStatement.setInt(2, nota.getCosto());
					callableStatement.setInt(3, nota.getDescuento());
					callableStatement.setInt(4, nota.getId_taller());
					callableStatement.setInt(5, nota.getId_tipoMantenimiento());
					callableStatement.setString(6, nota.getPlaca());
					callableStatement.setInt(7, nota.getDuracion_garantia());
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
	public List<NotaMantenimientoDTO> consultarNotaMantenimiento(int id) {
		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<NotaMantenimientoDTO> lstPrueba = new ArrayList<NotaMantenimientoDTO>();
		try {
			resultMap = jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_ConsultarNotaMantenimiento](?)}");
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
			NotaMantenimientoDTO prue = new NotaMantenimientoDTO();

			prue.setId_mantenimiento(Integer.parseInt(rowMap.get("id").toString()));
			prue.setPlaca(rowMap.get("placa").toString());
			prue.setDescripcion(rowMap.get("observacion").toString());
			prue.setCosto(Integer.parseInt(rowMap.get("costo").toString()));
			prue.setDescuento(Integer.parseInt(rowMap.get("descuento").toString()));
			prue.setId_taller(Integer.parseInt(rowMap.get("idTaller").toString()));
			prue.setId_tipoMantenimiento(Integer.parseInt(rowMap.get("tipoMantenimiento").toString()));
			prue.setDuracion_garantia(Integer.parseInt(rowMap.get("duracion").toString()));
			prue.setTaller(rowMap.get("taller").toString());
			prue.setCosto_total(Integer.parseInt(rowMap.get("costo_total").toString()));
			prue.setTipo_mantenimiento(rowMap.get("tipo_mantenimiento").toString());
			prue.setFecha_compra(sdf.format(rowMap.get("fecha_compra")));
			prue.setFecha_vencimiento_mantenimiento(sdf.format(rowMap.get("fecha_vencimiento_mantenimiento")));
			prue.setEstado(rowMap.get("estado").toString());


			lstPrueba.add(prue);
		}
		return lstPrueba;
	}

	@Override
	public List<NotaMantenimientoDTO> obtenerPrueba() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RespuestaDTO actualizarNotaMantenimiento(NotaMantenimientoDTO nota) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		// System.out.println("Fecha " + nota.getFecha());
		try {

			jdbcTemplate.call(new CallableStatementCreator() {
				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_ActualizarNotaMantenimiento](?,?)}");
					callableStatement.setInt(1, nota.getId_mantenimiento());
					callableStatement.setString(2, nota.getDescripcion());
					

					return callableStatement;
				}
			}, parameters);
			respuesta = new RespuestaDTO("OK Se actualizo correctamente", "EX");
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = new RespuestaDTO("ER", "99", "Error actualizar nota", "GU");
		}
		return respuesta;

	}

	@Override
	public RespuestaDTO eliminarNotaMantenimiento(NotaMantenimientoDTO nota) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			jdbcTemplate.call(new CallableStatementCreator() {
				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_EliminarNotaMantenimiento](?)}");
					callableStatement.setInt(1, nota.getId_mantenimiento());
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
	public List<NotaMantenimientoDTO> consultarNotaMantenimientoCliente(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RespuestaDTO cambiarEtapa(NotaMantenimientoDTO nota) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			jdbcTemplate.call(new CallableStatementCreator() {
				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[CambioEtapa](?)}");
					callableStatement.setInt(1, nota.getId_mantenimiento());
					return callableStatement;
				}
			}, parameters);
			respuesta = new RespuestaDTO("OK Se cambio correctamente la etapa  ", "EX");
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = new RespuestaDTO("ER", "99", "Error al cambiar la etapa ", "GU");
		}
		return respuesta;
	}

	@Override
	public List<NotaMantenimientoDTO> obtenerMantenimiento(NotaMantenimientoDTO nota) {

		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<NotaMantenimientoDTO> lstPrueba = new ArrayList<NotaMantenimientoDTO>();
		try {
			resultMap = jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_ConsultarNotaMantenimiento](?)}");
					callableStatement.setInt(1, nota.getId_mantenimiento());

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
			NotaMantenimientoDTO prue = new NotaMantenimientoDTO();

			prue.setId_mantenimiento(Integer.parseInt(rowMap.get("id").toString()));
			prue.setPlaca(rowMap.get("placa").toString());
			prue.setDescripcion(rowMap.get("observacion").toString());
			prue.setCosto(Integer.parseInt(rowMap.get("costo").toString()));
			prue.setDescuento(Integer.parseInt(rowMap.get("descuento").toString()));
			prue.setId_taller(Integer.parseInt(rowMap.get("idTaller").toString()));
			prue.setId_tipoMantenimiento(Integer.parseInt(rowMap.get("tipoMantenimiento").toString()));
			prue.setDuracion_garantia(Integer.parseInt(rowMap.get("duracion").toString()));
			prue.setTaller(rowMap.get("taller").toString());
			prue.setCosto_total(Integer.parseInt(rowMap.get("costo_total").toString()));
			prue.setTipo_mantenimiento(rowMap.get("tipo_mantenimiento").toString());
			prue.setFecha_compra(sdf.format(rowMap.get("fecha_compra")));
			prue.setFecha_vencimiento_mantenimiento(sdf.format(rowMap.get("fecha_vencimiento_mantenimiento")));
			prue.setEstado(rowMap.get("estado").toString());
			prue.setEtapaActual(rowMap.get("etapa_actual").toString());
			prue.setEtapaAntigua(rowMap.get("etapa_anterior").toString());

			lstPrueba.add(prue);
		}
		return lstPrueba;

	}

	@Override
	public List<TipoMantenimientoDTO> obtenerTipoMantenimiento(TipoMantenimientoDTO tipoMante) {
		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<TipoMantenimientoDTO> lstTipoMantenimiento = new ArrayList<TipoMantenimientoDTO>();
		try {
			resultMap = jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_ConsultarTipoMantenimiento](?)}");
					callableStatement.setInt(1, tipoMante.getId_tipoMantenimiento());

					return callableStatement;
				}
			}, parameters);
		} catch (Exception e) {
			System.out.println("DAO PLACA");
			e.printStackTrace();
		}
		System.out.println(resultMap);
		List<Object> lstObjetos = (List<Object>) resultMap.get("#result-set-1");

		for (int i = 0; i < lstObjetos.size(); i++) {
			Map rowMap = (Map) lstObjetos.get(i);
			TipoMantenimientoDTO mar = new TipoMantenimientoDTO();
			mar.setId_tipoMantenimiento(Integer.parseInt(rowMap.get("id").toString()));
			mar.setTipo_mantenimiento(rowMap.get("tipo_mantenimiento").toString());

			lstTipoMantenimiento.add(mar);
		}

		return lstTipoMantenimiento;
	}

	@Override
	public List<DuracionGarantiaDTO> obtenerDuracionGarantia(DuracionGarantiaDTO duracion) {
		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<DuracionGarantiaDTO> lstDuracionGarantia = new ArrayList<DuracionGarantiaDTO>();
		try {
			resultMap = jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_ConsultarDuracionGarantia](?)}");
					callableStatement.setInt(1, duracion.getId_garantia());

					return callableStatement;
				}
			}, parameters);
		} catch (Exception e) {
			System.out.println("DAO PLACA");
			e.printStackTrace();
		}
		System.out.println(resultMap);
		List<Object> lstObjetos = (List<Object>) resultMap.get("#result-set-1");

		for (int i = 0; i < lstObjetos.size(); i++) {
			Map rowMap = (Map) lstObjetos.get(i);
			DuracionGarantiaDTO mar = new DuracionGarantiaDTO();
			mar.setId_garantia(Integer.parseInt(rowMap.get("id").toString()));
			mar.setDuracion(Integer.parseInt(rowMap.get("duracion").toString()));
			mar.setDescripcion(rowMap.get("descripcion").toString());

			lstDuracionGarantia.add(mar);
		}

		return lstDuracionGarantia;

	}

	@Override
	public List<TipoMantenimientoDTO> ConsultarTipoMantenimiento() {
		return jdbcTemplate.query("select id,tipo_mantenimiento from Tipo_Mantenimiento",
				new RowMapper<TipoMantenimientoDTO>() {
					public TipoMantenimientoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new TipoMantenimientoDTO(rs.getInt(1), rs.getString(2));
					}
				});
	}

	@Override
	public List<DuracionGarantiaDTO> ConsultarDuracionGarantia() {
		return jdbcTemplate.query("select id,duracion,descripcion from duracion_garantia",
				new RowMapper<DuracionGarantiaDTO>() {
					public DuracionGarantiaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new DuracionGarantiaDTO(rs.getInt(1), rs.getInt(2), rs.getString(3));
					}
				});
	}
}
