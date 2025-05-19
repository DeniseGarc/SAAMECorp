package entidades;

import java.time.LocalDateTime;
import java.util.List;
import org.bson.types.ObjectId;

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
    private ObjectId idPsicologo;
    private List<Cita> citasCubiertas;
    private Factura detallesFactura;

    public Pago() {
    }

    public Pago(ObjectId id, LocalDateTime fechaHora, Double monto, String metodoPago, String formaPago, String condicionesPago, ObjectId idPsicologo, List<Cita> citasCubiertas, Factura detallesFactura) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.monto = monto;
        this.metodoPago = metodoPago;
        this.formaPago = formaPago;
        this.condicionesPago = condicionesPago;
        this.idPsicologo = idPsicologo;
        this.citasCubiertas = citasCubiertas;
        this.detallesFactura = detallesFactura;
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

    public ObjectId getIdPsicologo() {
        return idPsicologo;
    }

    public void setIdPsicologo(ObjectId idPsicologo) {
        this.idPsicologo = idPsicologo;
    }

    public List<Cita> getCitasCubiertas() {
        return citasCubiertas;
    }

    public void setCitasCubiertas(List<Cita> citasCubiertas) {
        this.citasCubiertas = citasCubiertas;
    }

    public Factura getDetallesFactura() {
        return detallesFactura;
    }

    public void setDetallesFactura(Factura detallesFactura) {
        this.detallesFactura = detallesFactura;
    }

    public String getObjectString() {
        return id != null ? id.toHexString() : null;
    }

    public void setObjectString(String idStr) {
        this.id = (idStr != null && !idStr.isBlank()) ? new ObjectId(idStr) : null;
    }

    public String getObjectPsicologoString() {
        return idPsicologo != null ? idPsicologo.toHexString() : null;
    }

    public void setObjectPsicologoString(String idStr) {
        this.idPsicologo = (idStr != null && !idStr.isBlank()) ? new ObjectId(idStr) : null;
    }
}
