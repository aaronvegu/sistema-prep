package com.aaronvegu.prep.pdf;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaronvegu.prep.model.Resultado;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.UnitValue;

public class PDFView extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// List of users that will be displayed in the PDF
		List<Resultado> resultados = (List<Resultado>) model.get("listResultado");
		
		// Create table with 3 columns of similar length
		Table table = new Table(new float[] { 1, 1, 1, 1, 1, 1, 1 });
		table.setWidth(UnitValue.createPercentValue(100));
		PdfFont bold = PdfFontFactory.createFont("Times-Bold");
		
		// Create title and subtitle
		PdfFont titleFont = PdfFontFactory.createFont("Helvetica");
		Paragraph title = new Paragraph("PROGRAMA DE RESULTADOS ELECTORALES PRELIMINARES").setFont(titleFont);
		Paragraph subtitle = new Paragraph("Resultados por casillas").setFont(titleFont);
		Paragraph space = new Paragraph(" ");
		
		// adding header
		table.addHeaderCell(new Cell().add(new Paragraph("Candidatura").setFont(bold)));
		table.addHeaderCell(new Cell().add(new Paragraph("Partido").setFont(bold)));
		table.addHeaderCell(new Cell().add(new Paragraph("Tipo Casilla").setFont(bold)));
		table.addHeaderCell(new Cell().add(new Paragraph("Municipio").setFont(bold)));
		table.addHeaderCell(new Cell().add(new Paragraph("Seccion").setFont(bold)));
		table.addHeaderCell(new Cell().add(new Paragraph("Distrito").setFont(bold)));
		table.addHeaderCell(new Cell().add(new Paragraph("Votos").setFont(bold)));
		
		// adding rows
		for (Resultado r : resultados) {
			table.addCell(r.getCandidatura());
			table.addCell(r.getPartido());
			table.addCell(r.getTipo());
			table.addCell(r.getMunicipio());
			table.addCell(String.valueOf(r.getSeccion()));
			table.addCell(String.valueOf(r.getDistrito()));
			table.addCell(String.valueOf(r.getCantidad()));
		}

		// adding paragraph for footer
		Paragraph footer = new Paragraph("Ing. de Software | CUTonala | 05/07/21");
		
		document.add(title);
		document.add(subtitle);
		document.add(space);
		document.add(table);
		document.add(space);
		document.add(space);
		document.add(space);
		document.add(footer);
	}
}
