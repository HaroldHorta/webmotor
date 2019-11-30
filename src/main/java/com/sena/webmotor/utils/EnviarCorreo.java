package com.sena.webmotor.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EnviarCorreo {

	/**
	 * Se realiza la conexion con el servidor correo indicado por un datos de un
	 * properties y se envia el correo.
	 * 
	 * @param destinatarios
	 * @param asunto
	 * @param contenido
	 * @throws Exception
	 */
	public void enviarCorreo(String[] destinatarios, String asunto, String contenido) throws Exception {
		Properties props = System.getProperties();
		PropiedadesConfiguracion pc = new PropiedadesConfiguracion();
		props.setProperty("mail.smtp.host", pc.getProperties("mail.smtp.host"));
		props.setProperty("mail.smtp.port", pc.getProperties("mail.smtp.port"));
		props.setProperty("mail.smtp.starttls.enable", pc.getProperties("mail.smtp.starttls.enable"));
		props.setProperty("mail.smtp.auth", pc.getProperties("mail.smtp.auth"));
		props.setProperty("mail.smtp.user", pc.getProperties("mail.smtp.user"));

		String plantilla = leerPlantilla("correo");
		plantilla = replaceVariables(plantilla, contenido);
		Session mailSession = Session.getDefaultInstance(props, null);
		// mailSession.setDebug(true);
		Transport transport = mailSession.getTransport("smtp");
		MimeMessage message = new MimeMessage(mailSession);

		message.setSubject(asunto);
		message.setFrom(new InternetAddress(pc.getProperties("mail.from")));
		
		BodyPart cuerpoMensaje = new MimeBodyPart();
		cuerpoMensaje.setContent(plantilla, "text/html");
		
		BodyPart adjunto = new MimeBodyPart();
		adjunto.setDataHandler(new DataHandler(new FileDataSource(pc.getProperties("archivo"))));
		adjunto.setFileName("CartaAprobacion.pdf");
		MimeMultipart multiParte = new MimeMultipart();

		multiParte.addBodyPart(cuerpoMensaje);
		multiParte.addBodyPart(adjunto);
		message.setContent(multiParte);
	   
 
		for (int i = 0; i < destinatarios.length; i++) {
			String correo = destinatarios[i];
			if (correo != null)
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(correo));
		}
 
		transport.connect(pc.getProperties("mail.smtp.user"), pc.getProperties("mail.smtp.password"));
		transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));

		transport.close();
	}

	/**
	 * Se obtiene la plantilla para el correo.
	 * 
	 * @param nombrePlantilla
	 * @return Objeto String.
	 * @throws Exception
	 */
	private static String leerPlantilla(String nombrePlantilla) throws Exception {
		String rutaPlantilla = "c:\\tmp\\correo.html";

		FileInputStream fis = new FileInputStream(rutaPlantilla);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];

		while (fis.read(buffer) != -1) {
			baos.write(buffer);
		}

		baos.flush();
		baos.close();
		fis.close();

		return baos.toString();
	}

	/**
	 * Se remplaza el cuerpo de la plantilla con los datos que se envian para el
	 * correo.
	 * 
	 * @param plantilla
	 * @param contenido
	 * @return Objeto String.
	 */
	private static String replaceVariables(String plantilla, String contenido) {

		plantilla = plantilla.replace("[CUERPO_MENSAJE]", contenido);

		return plantilla;
	}

}

