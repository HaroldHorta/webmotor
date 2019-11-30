package com.sena.webmotor.dao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sena.webmotor.dto.UsuarioDTO;
import com.sena.webmotor.implement.EnviarCorreoDAO;

import com.sena.webmotor.utils.EnviarCorreo;
import com.sena.webmotor.utils.PropiedadesConfiguracion;

@Component
public class EnviarCorreoImp implements EnviarCorreoDAO {

	private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
	private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
	private static final Font tittle = FontFactory.getFont(FontFactory.HELVETICA, 12, BaseColor.WHITE);

	@Override
	public boolean generarCorreo(UsuarioDTO persona) {
		boolean blnArchivoGenerado = false;
		EnviarCorreo ec = new EnviarCorreo();
		try {
			PropiedadesConfiguracion pc = new PropiedadesConfiguracion();
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(pc.getProperties("archivo")));

			document.open();
			document.addTitle("Confirmacion de correo");
			document.addAuthor("allWebMotor");

			Chunk chunk = new Chunk("Carta de informacion de contacto", chapterFont);
			chunk.setBackground(BaseColor.GRAY);
			Chapter chapter = new Chapter(new Paragraph(chunk), 0);
			chapter.setNumberDepth(0);
			chapter.add(new Paragraph("\nNombres: " + persona.getNombres(), paragraphFont));
			chapter.add(new Paragraph("\nCorreo: " + persona.getCorreo(), paragraphFont));
			chapter.add(new Paragraph("\nMensaje: " + persona.getMensaje(), paragraphFont));
			chapter.add(new Paragraph("\nGracias por contactarnos.", paragraphFont));
			chapter.add(new Paragraph("\nATT: AllWebMotor.", paragraphFont));

			document.add(chapter);
			document.close();
			String[] lstDestinatarios = new String[2];
			lstDestinatarios[0] = persona.getCorreo();
			lstDestinatarios[1] = "allwebmotor@gmail.com";
			ec.enviarCorreo(lstDestinatarios, pc.getProperties("asunto"), pc.getProperties("contenido"));
			blnArchivoGenerado = true;
		} catch (DocumentException e) {
			System.out.println("Error generando el documento " + e.getMessage());
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Error archivo no encontrado " + e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error enviar correo " + e.getMessage());
			e.printStackTrace();
		}
		return blnArchivoGenerado;
	}

}
