/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.utilerias;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dto.ReporteIngresosCubiculoDTO;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author erika
 */
public class DocumentoPDFUtil {
    public static void generarPDFIngresosCubiculo(ReporteIngresosCubiculoDTO dto) throws DocumentException, IOException {
        // Ruta donde se guardará el PDF
        String nombreArchivo = "ReporteIngresos_" + dto.getNombreCubiculo().replaceAll("\\s+", "_") + ".pdf";

        Document documento = new Document() {};
        PdfWriter.getInstance(documento, new FileOutputStream(nombreArchivo));
        documento.open();

        // Título
        documento.add(new Paragraph("REPORTE DE INGRESOS POR CUBÍCULO\n\n"));

        // Contenido del reporte
        documento.add(new Paragraph("Cubículo: " + dto.getNombreCubiculo()));
        documento.add(new Paragraph("Total ingresos: $" + dto.getTotalIngresos()));
        documento.add(new Paragraph("Citas pagadas: " + dto.getCitasConPago()));
        documento.add(new Paragraph("Citas con pago pendiente: " + dto.getCitasPendientes()));

        documento.close();
    }
}
