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
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author erika
 */
public class DocumentoPDFUtil {
    public static File generarPDFIngresosCubiculo(ReporteIngresosCubiculoDTO dto) throws Exception {
        String nombreArchivo = "reporte_ingresos_cubiculo.pdf";
        File archivo = new File(nombreArchivo);

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(archivo));
        document.open();
        document.add(new Paragraph("Reporte de Ingresos del Cubículo: " + dto.getNombreCubiculo()));
        document.add(new Paragraph("Total ingresos: $" + dto.getTotalIngresos()));
        document.add(new Paragraph("Citas pagadas: " + dto.getCitasConPago()));
        document.add(new Paragraph("Citas pendientes: " + dto.getCitasPendientes()));
        document.close();

        return archivo;
    }
}
