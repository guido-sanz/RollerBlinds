package com.example.demo.generadorPdf;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.example.demo.entidades.Pedido;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;



@Component
public class GeneradorPdf {

	private List<Pedido> listaPedido;

	public GeneradorPdf(List<Pedido> listaPedido) {
		this.listaPedido = listaPedido;
	}
	
	private void estructuraTabla(PdfPTable table) {
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);
		
		PdfPCell cell = new PdfPCell();
		
		cell.setPhrase(new Phrase("TIPO", font));
		cell.setBackgroundColor(Color.BLUE);
		
		table.addCell(cell);
		cell.setPhrase(new Phrase("TELA"));
		cell.setBackgroundColor(Color.BLUE);
		table.addCell(cell);
		cell.setPhrase(new Phrase("COLOR", font));
		cell.setBackgroundColor(Color.BLUE);
		table.addCell(cell);
		cell.setPhrase(new Phrase("ANCHO", font));
		cell.setBackgroundColor(Color.BLUE);
		table.addCell(cell);
		cell.setPhrase(new Phrase("ALTO", font));
		cell.setBackgroundColor(Color.BLUE);
		table.addCell(cell);
		cell.setPhrase(new Phrase("CANT", font));
		cell.setBackgroundColor(Color.BLUE);
		table.addCell(cell);
		cell.setPhrase(new Phrase("ACC", font));
		cell.setBackgroundColor(Color.BLUE);
		table.addCell(cell);
		cell.setPhrase(new Phrase("LADO", font));
		cell.setBackgroundColor(Color.BLUE);
		table.addCell(cell);
		cell.setPhrase(new Phrase("ENVIO", font));
		cell.setBackgroundColor(Color.BLUE);
		table.addCell(cell);
		cell.setPhrase(new Phrase("TOTAL"));
		cell.setBackgroundColor(Color.BLUE);
		table.addCell(cell);
		
	}
	
	private void escribirTabla(PdfPTable table) {
		
		for (Pedido pedidos : listaPedido){
			table.addCell(pedidos.getTipo());
			table.addCell(pedidos.getTela());
			table.addCell(pedidos.getColor());
			table.addCell(String.valueOf(pedidos.getAncho()));
			table.addCell(String.valueOf(pedidos.getAlto()));
			table.addCell(String.valueOf(pedidos.getCantidad()));
			table.addCell(pedidos.getTipoCadena());
			table.addCell(pedidos.getLadoCadena());
			table.addCell(pedidos.getEnvio());
			table.addCell(String.valueOf(pedidos.getTotal()));
			
		}
		
	}
	
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		
		Document document = new Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		
//		document.add(new Paragraph("lista de operaciones"));
		
		PdfPTable table = new PdfPTable(10);
		table.setWidthPercentage(100);
		estructuraTabla(table);
		escribirTabla(table);
		
		document.add(table);
		
		document.close();
	}
}
