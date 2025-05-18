/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package presentacion.utilerias;

/**
 *
 * @author Alici
 */
public enum RegimenFiscal {
    SUELDOS_Y_SALARIOS("605", "Sueldos y Salarios"),
    ARRENDAMIENTO("606", "Arrendamiento"),
    ENAJENACION_O_ADQUISICION_DE_BIENES("607", "Enajenación o Adquisición de Bienes"),
    DEMAS_INGRESOS("608", "Demás ingresos"),
    INGRESOS_POR_DIVIDENDOS("611", "Ingresos por Dividendos"),
    ACTIVIDADES_EMPRESARIALES_Y_PROFESIONALES("612", "Actividades Empresariales y Profesionales"),
    INGRESOS_POR_INTERESES("614", "Ingresos por intereses"),
    INGRESOS_POR_OBTENCION_DE_PREMIOS("615", "Ingresos por obtención de premios"),
    INCORPORACION_FISCAL("621", "Incorporación Fiscal"),
    PLATAFORMAS_TECNOLOGICAS("625", "Plataformas Tecnológicas"),
    SIMPLIFICADO_DE_CONFIANZA("626", "Simplificado de Confianza"),
    ENAJENACION_DE_ACCIONES_EN_BOLSA_DE_VALORES("630", "Enajenación de acciones en bolsa de valores");

    private final String clave;
    private final String descripcion;

    RegimenFiscal(String clave, String descripcion) {
        this.clave = clave;
        this.descripcion = descripcion;
    }

    public String getClave() {
        return clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion; // Para mostrar la descripción en el ComboBox
    }
}
