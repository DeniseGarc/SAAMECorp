package dto;

/**
 * Clase que representa un adeudo relacionado con una cita.
 *
 * <p>
 * Este DTO (Data Transfer Object) se utiliza para transferir la información
 * relacionada con el monto adeudado por una cita y su estado (si está pagado o
 * no).</p>
 *
 * <p>
 * Puede ser utilizado, por ejemplo, al registrar una nueva cita que ya incluya
 * un monto pendiente de pago.</p>
 *
 * @author Alici
 */
public class AdeudoCitaDTO {

    /**
     * Monto del adeudo asociado a la cita.
     */
    private double cantidad;

    /**
     * Estado del adeudo: {@code true} si está pagado, {@code false} si está
     * pendiente.
     */
    private boolean estado;

    /**
     * Constructor vacío. Inicializa un objeto {@code AdeudoCitaDTO} sin valores
     * definidos.
     */
    public AdeudoCitaDTO() {
    }

    /**
     * Constructor que inicializa el adeudo con una cantidad y un estado
     * especificados.
     *
     * @param cantidad Monto del adeudo.
     * @param estado Estado del adeudo: {@code true} si está pagado,
     * {@code false} si está pendiente.
     */
    public AdeudoCitaDTO(double cantidad, boolean estado) {
        this.cantidad = cantidad;
        this.estado = estado;
    }

    /**
     * Obtiene el monto del adeudo.
     *
     * @return Cantidad del adeudo.
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Establece el monto del adeudo.
     *
     * @param cantidad Nueva cantidad del adeudo.
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Indica si el adeudo está pagado.
     *
     * @return {@code true} si el adeudo está pagado, {@code false} si está
     * pendiente.
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Establece el estado del adeudo.
     *
     * @param estado {@code true} si el adeudo está pagado, {@code false} si
     * está pendiente.
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
