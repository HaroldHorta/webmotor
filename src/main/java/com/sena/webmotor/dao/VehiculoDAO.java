package com.sena.webmotor.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.CallableStatementCreator;

import com.sena.webmotor.dto.CilindrajeDTO;
import com.sena.webmotor.dto.MarcaDTO;
import com.sena.webmotor.dto.PQRDTO;
import com.sena.webmotor.dto.ReferenciaDTO;
import com.sena.webmotor.dto.RespuestaDTO;
import com.sena.webmotor.dto.VehiculoDTO;
import com.sena.webmotor.implement.VehiculoImp;
import com.sena.webmotor.utils.exceptions.DataNotFoundException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class VehiculoDAO implements VehiculoImp {

	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate jdbcTemplate;

	@Override
	public RespuestaDTO crearVehiculo(VehiculoDTO vehiculo) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_CrearVehiculo](?,?,?,?,?,?,?,?,?)}");

					callableStatement.setString(1, vehiculo.getPlaca());
					callableStatement.setString(2, vehiculo.getColor());
					callableStatement.setString(3, vehiculo.getModelo());
					callableStatement.setInt(4, vehiculo.getId_cilindraje());
					callableStatement.setInt(5, vehiculo.getId_marca());
					callableStatement.setString(6, vehiculo.getFoto_vehiculo());
					callableStatement.setInt(7, vehiculo.getKilometraje());
					callableStatement.setString(8, vehiculo.getCedula());
					callableStatement.setInt(9, vehiculo.getId_referencia());
					return callableStatement;

				}
			}, parameters);
			respuesta = new RespuestaDTO("OK Se creo el correctamente Aspirante: ", "EX");
		} catch (Exception e) {
			respuesta = new RespuestaDTO("ER", "99", "Error guardando Aspirante: " + vehiculo.getPlaca(), "GU");

		}
		return respuesta;
	}

	@Override
	public List<VehiculoDTO> consultarVehiculo(String placa) throws DataNotFoundException {
		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<VehiculoDTO> lstVehiculo = new ArrayList<VehiculoDTO>();
		try {
			resultMap = jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_ConsultarVehiculo](?)}");
					callableStatement.setString(1, placa);

					return callableStatement;
				}
			}, parameters);
		} catch (Exception e) {
			if (log.isDebugEnabled())
				log.error(MessageFormat.format(
						"Excepción en la capa DAO para el metodo consultarVehiculo con el parametro {0} y causa: {1}",
						placa, e.getCause()) + placa);
		}

		if (ObjectUtils.isEmpty(resultMap.get("#result-set-1")))
			throw new DataNotFoundException("El resultado del procedimientos almacenado no contiene información.");

		List<Object> lstObjetos = (List<Object>) resultMap.get("#result-set-1");

		for (int i = 0; i < lstObjetos.size(); i++) {
			Map rowMap = (Map) lstObjetos.get(i);
			VehiculoDTO asp = new VehiculoDTO();
			asp.setPlaca(rowMap.get("placa").toString());
			asp.setColor(rowMap.get("color").toString());
			asp.setModelo(rowMap.get("modelo").toString());
			asp.setCilindraje(rowMap.get("cilindraje").toString());
			asp.setId_cilindraje(Integer.parseInt(rowMap.get("id_cilindraje").toString()));
			asp.setId_marca(Integer.parseInt(rowMap.get("id_marca").toString()));
			asp.setMarca(rowMap.get("nombre").toString());
			asp.setFoto_vehiculo(rowMap.get("foto_vehiculo").toString());
			asp.setKilometraje(Integer.parseInt(rowMap.get("kilometraje").toString()));
			asp.setCedula(rowMap.get("cedula").toString());
			asp.setId_referencia(Integer.parseInt(rowMap.get("id_referencia").toString()));
			asp.setReferencia(rowMap.get("descripcion").toString());

			lstVehiculo.add(asp);
		}

		return lstVehiculo;
	}

	@Override
	public RespuestaDTO actualizarVehiculo(VehiculoDTO vehiculo) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			jdbcTemplate.call(new CallableStatementCreator() {
				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con
							.prepareCall("{call [dbo].[sp_ActualizarVehiculo](?,?,?,?,?,?,?,?,?)}");
					callableStatement.setString(1, vehiculo.getPlaca());
					callableStatement.setString(2, vehiculo.getColor());
					callableStatement.setString(3, vehiculo.getModelo());
					callableStatement.setInt(4, vehiculo.getId_cilindraje());
					callableStatement.setInt(5, vehiculo.getId_marca());
					callableStatement.setString(6, vehiculo.getFoto_vehiculo());
					callableStatement.setInt(7, vehiculo.getKilometraje());
					callableStatement.setString(8, vehiculo.getCedula());
					callableStatement.setInt(9, vehiculo.getId_cilindraje());
					return callableStatement;
				}
			}, parameters);
			respuesta = new RespuestaDTO("OK Se actualizo correctamente aspirante: ", "EX");
		} catch (Exception e) {
			e.printStackTrace();
			respuesta = new RespuestaDTO("ER", "99", "Error actualizar aspirante: " + vehiculo.getPlaca(), "GU");
		}
		return respuesta;
	}

	@Override
	public RespuestaDTO eliminarVehiculo(VehiculoDTO vehiculo) {
		RespuestaDTO respuesta;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		try {
			jdbcTemplate.call(new CallableStatementCreator() {
				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_EliminarVehiculo](?)}");
					callableStatement.setString(1, vehiculo.getPlaca());
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
	public List<VehiculoDTO> obtenerVehiculo(VehiculoDTO vehiculo) {

		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<VehiculoDTO> lstVehiculo = new ArrayList<VehiculoDTO>();
		try {
			resultMap = jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_ObtenerVehiculo](?)}");
					callableStatement.setString(1, vehiculo.getPlaca());

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
			VehiculoDTO asp = new VehiculoDTO();
			asp.setPlaca(rowMap.get("placa").toString());
			asp.setColor(rowMap.get("color").toString());
			asp.setModelo(rowMap.get("modelo").toString());
			asp.setId_cilindraje(Integer.parseInt(rowMap.get("id_cilindraje").toString()));
			asp.setId_marca(Integer.parseInt(rowMap.get("id_marca").toString()));
			asp.setCilindraje(rowMap.get("cilindraje").toString());
			asp.setMarca(rowMap.get("nombre").toString());
			asp.setFoto_vehiculo(rowMap.get("foto_vehiculo").toString());
			asp.setKilometraje(Integer.parseInt(rowMap.get("kilometraje").toString()));
			asp.setCedula(rowMap.get("cedula").toString());
			asp.setId_referencia(Integer.parseInt(rowMap.get("id_referencia").toString()));
			asp.setReferencia(rowMap.get("descripcion").toString());

			lstVehiculo.add(asp);
		}

		return lstVehiculo;

	}

	@Override
	public List<CilindrajeDTO> consultarCilindraje() {

		return jdbcTemplate.query("select id,cilindraje from Cilindraje", new RowMapper<CilindrajeDTO>() {
			public CilindrajeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new CilindrajeDTO(rs.getInt(1), rs.getString(2));
			}
		});

	}

	@Override
	public List<MarcaDTO> consultarMarca() {
		return jdbcTemplate.query("select id, nombre from Marca", new RowMapper<MarcaDTO>() {
			public MarcaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new MarcaDTO(rs.getInt(1), rs.getString(2));
			}
		});
	}

	@Override
	public List<ReferenciaDTO> consultarReferencia() {
		return jdbcTemplate.query("select id,descripcion from Referencia", new RowMapper<ReferenciaDTO>() {
			public ReferenciaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new ReferenciaDTO(rs.getInt(1), rs.getString(2));
			}
		});
	}

	@Override
	public List<CilindrajeDTO> obtenerCilindraje(CilindrajeDTO cilindraje) {

		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<CilindrajeDTO> lstCilindraje = new ArrayList<CilindrajeDTO>();
		try {
			resultMap = jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_ConsultarCilindraje](?)}");
					callableStatement.setInt(1, cilindraje.getId_cilindraje());

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
			CilindrajeDTO cil = new CilindrajeDTO();
			cil.setId_cilindraje(Integer.parseInt(rowMap.get("id").toString()));
			cil.setCilindraje(rowMap.get("cilindraje").toString());

			lstCilindraje.add(cil);
		}

		return lstCilindraje;

	}

	@Override
	public List<MarcaDTO> obtenerMarca(MarcaDTO marca) {

		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<MarcaDTO> lstMarca = new ArrayList<MarcaDTO>();
		try {
			resultMap = jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_ConsultarMarca](?)}");
					callableStatement.setInt(1, marca.getId_marca());

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
			MarcaDTO mar = new MarcaDTO();
			mar.setId_marca(Integer.parseInt(rowMap.get("id").toString()));
			mar.setMarca(rowMap.get("nombre").toString());

			lstMarca.add(mar);
		}

		return lstMarca;
	}

	@Override
	public List<ReferenciaDTO> obtenerReferencia(ReferenciaDTO referencia) {

		Map<String, Object> resultMap = null;
		List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.BIGINT));
		List<ReferenciaDTO> lstReferencia = new ArrayList<ReferenciaDTO>();
		try {
			resultMap = jdbcTemplate.call(new CallableStatementCreator() {

				@Override
				public CallableStatement createCallableStatement(Connection con) throws SQLException {
					CallableStatement callableStatement = con.prepareCall("{call [dbo].[sp_ConsultarReferencia](?)}");
					callableStatement.setInt(1, referencia.getId_referencia());

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
			ReferenciaDTO ref = new ReferenciaDTO();
			ref.setId_referencia(Integer.parseInt(rowMap.get("id").toString()));
			ref.setReferencia(rowMap.get("descripcion").toString());

			lstReferencia.add(ref);
		}

		return lstReferencia;
	}

}
