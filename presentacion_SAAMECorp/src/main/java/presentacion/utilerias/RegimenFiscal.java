package presentacion.utilerias;

/**
 * Enum que representa los diferentes regímenes fiscales permitidos,
 * cada uno con su clave y descripción para uso en facturación electrónica.
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

    /**
     * Clave del régimen fiscal, según catálogo oficial.
     */
    private final String clave;

    /**
     * Descripción del régimen fiscal.
     */
    private final String descripcion;

    /**
     * Constructor del enum RegimenFiscal.
     * 
     * @param clave clave oficial del régimen fiscal.
     * @param descripcion descripción del régimen fiscal.
     */
    RegimenFiscal(String clave, String descripcion) {
        this.clave = clave;
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la clave del régimen fiscal.
     * 
     * @return la clave oficial como String.
     */
    public String getClave() {
        return clave;
    }

    /**
     * Obtiene la descripción del régimen fiscal.
     * 
     * @return la descripción como String.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Devuelve la descripción para mostrar en interfaces, como JComboBox.
     * 
     * @return la descripción del régimen fiscal.
     */
    @Override
    public String toString() {
        return descripcion; // Para mostrar la descripción en el ComboBox
    }
}
