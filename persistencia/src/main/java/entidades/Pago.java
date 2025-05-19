package entidades;

import java.time.LocalDateTime;

/**
 *
 * @author Alici
 */
public class Pago {

    private ObjectId id;
    private LocalDateTime fechaHora;
    private Double monto;
    private String metodoPago;
    private String formaPago;
    private String condicionesPago;

    public Pago() {
    }

    public Pago(ObjectId id, LocalDateTime fechaHora, Double monto, String metodoPago, String formaPago, String condicionesPago) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.formaPago = formaPago;
        this.condicionesPago = condicionesPago;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getCondicionesPago() {
        return condicionesPago;
    }

    public void setCondicionesPago(String condicionesPago) {
        this.condicionesPago = condicionesPago;
    }

    public String getObjectString() {
        return id != null ? id.toHexString() : null;
    }

    public void setObjectString(String idStr) {
        this.id = (idStr != null && !idStr.isBlank()) ? new ObjectId(idStr) : null;
    }
}
