package presentacion.utilerias;

/**
 * Enumeración que representa los métodos de pago para CFDI.
 * Define los métodos de pago usados en facturación electrónica.
 * 
 * @author Alici
 */
public enum MetodoPago {
    PUE("Pago en una sola exhibición"),
    PPD("Pago en parcialidades o diferido");

    private final String descripcion;

    /**
     * Constructor para asignar la descripción a cada método de pago.
     * 
     * @param descripcion descripción legible para mostrar.
     */
    MetodoPago(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Obtiene la descripción del método de pago.
     * 
     * @return descripción legible.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Obtiene la clave del método de pago (nombre del enum).
     * 
     * @return clave como String.
     */
    public String getClave() {
        return this.name();
    }

    /**
     * Devuelve la descripción para mostrar en interfaces, como ComboBox.
     * 
     * @return descripción del método de pago.
     */
    @Override
    public String toString() {
        return descripcion;
    }
}
