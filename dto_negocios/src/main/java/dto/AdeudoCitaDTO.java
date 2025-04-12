package dto;

/**
 * DTO que se utiliza para generar el adeudo junto a la cita a registrar.
 *
 * @author Alici
 */
public class AdeudoCitaDTO {

    private double cantidad;
    private boolean estado;

    public AdeudoCitaDTO() {
    }

    public AdeudoCitaDTO(double cantidad, boolean estado) {
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
