package com.sena.webmotor.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropiedadesConfiguracion {
	Properties properties = new Properties();

	/**
	 * Se obtiene el archivo properties.
	 * 
	 * @param nomPropiedad
	 * @return Objeto String.
	 */

	public String getProperties(String nomPropiedad) {
		try {

			if (properties.isEmpty()) {
				properties.load(new FileReader("c:\\tmp\\DataConfigProperties.prop"));
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return properties.getProperty(nomPropiedad);
	}
}
