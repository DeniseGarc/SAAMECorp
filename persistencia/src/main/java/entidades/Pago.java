package entidades;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * Clase que representa un pago en el sistema.
 * 
 * @author Alici
 */
public class Pago {

    /**
     * Identificador único del pago.
     */
    private ObjectId id;
    /**
     * Fecha y hora del pago.
     */
    private LocalDateTime fechaHora;
    /**
     * Monto del pago.
     */
    private Double monto;
    /**
     * Método de pago utilizado.
     */
    private String metodoPago;
    /**
     * Forma de pago utilizada.
     */
    private String formaPago;
    /**
     * Condiciones de pago acordadas.
     */
    private String condicionesPago;
    /**
     * Identificador del psicólogo asociado al pago.
     */
    private ObjectId idPsicologo;
    /**
     * Lista de citas cubiertas por el pago.
     */
    private List<ObjectId> citasCubiertas = new ArrayList<>();
    /**
     * Detalles de la factura asociada al pago. 
     */
    private Factura detallesFactura;

    /**
     * Constructor por defecto.
     */
    public Pago() {
    }

    /**
     * Constructor con parámetros.
     *
     * @param id              Identificador único del pago.
     * @param fechaHora       Fecha y hora del pago.
     * @param monto           Monto del pago.
     * @param metodoPago      Método de pago utilizado.
     * @param formaPago       Forma de pago utilizada.
     * @param condicionesPago Condiciones de pago acordadas.
     * @param idPsicologo     Identificador del psicólogo asociado al pago.
     * @param citasCubiertas  Lista de citas cubiertas por el pago.
     * @param detallesFactura Detalles de la factura asociada al pago.
     */
    public Pago(ObjectId id, LocalDateTime fechaHora, Double monto, String metodoPago, String formaPago,
            String condicionesPago, ObjectId idPsicologo, List<ObjectId> citasCubiertas, Factura detallesFactura) {
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

    /**
     * Método que devuelve el identificador único del pago.
     * 
     * @return Identificador único del pago.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Método que establece el identificador único del pago.
     * 
     * @param id Identificador único del pago.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Método que devuelve la fecha y hora del pago.
     * 
     * @return Fecha y hora del pago.
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Método que establece la fecha y hora del pago.
     * 
     * @param fechaHora Fecha y hora del pago.
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Método que devuelve el monto del pago.
     * 
     * @return Monto del pago.
     */
    public Double getMonto() {
        return monto;
    }

    /**
     * Método que establece el monto del pago.
     * 
     * @param monto Monto del pago.
     */
    public void setMonto(Double monto) {
        this.monto = monto;
    }

    /**
     * Método que devuelve el método de pago utilizado.
     * 
     * @return Método de pago utilizado.
     */
    public String getMetodoPago() {
        return metodoPago;
    }

    /**
     * Método que establece el método de pago utilizado.
     * 
     * @param metodoPago Método de pago utilizado.
     */
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    /**
     * Método que devuelve la forma de pago utilizada.
     * 
     * @return Forma de pago utilizada.
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Método que establece la forma de pago utilizada.
     * 
     * @param formaPago Forma de pago utilizada.
     */
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    /**
     * Método que devuelve las condiciones de pago acordadas.
     * 
     * @return Condiciones de pago acordadas.
     */
    public String getCondicionesPago() {
        return condicionesPago;
    }

    /**
     * Método que establece las condiciones de pago acordadas.
     * 
     * @param condicionesPago Condiciones de pago acordadas.
     */
    public void setCondicionesPago(String condicionesPago) {
        this.condicionesPago = condicionesPago;
    }

    /**
     * Método que devuelve el identificador del psicólogo asociado al pago.
     * 
     * @return Identificador del psicólogo asociado al pago.
     */
    public ObjectId getIdPsicologo() {
        return idPsicologo;
    }

    /**
     * Método que establece el identificador del psicólogo asociado al pago.
     * 
     * @param idPsicologo Identificador del psicólogo asociado al pago.
     */
    public void setIdPsicologo(ObjectId idPsicologo) {
        this.idPsicologo = idPsicologo;
    }

    /**
     * Método que devuelve la lista de citas cubiertas por el pago.
     * 
     * @return Lista de citas
     */
    public List<ObjectId> getCitasCubiertas() {
        return citasCubiertas;
    }


    public void setCitasCubiertas(List<ObjectId> citasCubiertas) {
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
