package com.sena.webmotor.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.sena.webmotor.dto.GestionarAlmacenesDTO;
import com.sena.webmotor.implement.GestionarAlmacenesImp;

@Component
public class GestionarAlmacenesDAO implements GestionarAlmacenesImp {

	@Autowired
	@Qualifier("jdbcMaster")
	private JdbcTemplate JdbcTemplate;	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	@Override
	public List<GestionarAlmacenesDTO> obtenerAlmacen() {
		return JdbcTemplate.query("select id,nombre, telefono, id_direccion from Almacen",
				new RowMapper<GestionarAlmacenesDTO>() {
					public GestionarAlmacenesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
						return new GestionarAlmacenesDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
					}
		});
	}
}
