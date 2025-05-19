package dto;

import java.time.LocalDateTime;

/**
 * Clase DTO que encapsula los datos de un pago realizado por un psicologo, para
 * llenar la informacion necesaria para la factura.
 * 
 * @author Alici
 */
public class PagoDTO {
    /** Fecha y hora del pago. */
    private LocalDateTime fechaHora;
    /** Forma de pago utilizada. */
    private String formaPago;
    /** Método de pago utilizado. */
    private String metodoPago;
    /** Condiciones de pago. */
    private String condicionesPago;
    /** Cantidad de productos o servicios pagados. */
    private int cantidad;
    /** Precio unitario del producto o servicio. */
    private double precioUnitario;
    /** Monto total del pago. */
    private double monto;
    /** Psicólogo asociado al pago. */
    private PsicologoDTO psicologo;

    /**
     * Constructor por defecto.
     */
    public PagoDTO() {
        // Constructor vacío
    }

    /**
     * Constructor que inicializa todos los atributos del pago.
     *
     * @param fechaHora       Fecha y hora del pago.
     * @param formaPago       Forma de pago utilizada.
     * @param metodoPago      Método de pago utilizado.
     * @param condicionesPago Condiciones de pago.
     * @param monto           Monto total del pago.
     * @param psicologo       Psicólogo asociado al pago.
     */
    public PagoDTO(LocalDateTime fechaHora, String formaPago, String metodoPago, String condicionesPago, double monto,
            PsicologoDTO psicologo) {
        this.fechaHora = fechaHora;
        this.formaPago = formaPago;
        this.metodoPago = metodoPago;
        this.condicionesPago = condicionesPago;
        this.monto = monto;
        this.psicologo = psicologo;
    }

    /**
     * Obtiene la fecha y hora del pago.
     * 
     * @return Fecha y hora del pago.
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Establece la fecha y hora del pago.
     *
     * @param fechaHora Fecha y hora del pago.
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Obtiene la forma de pago utilizada.
     *
     * @return Forma de pago utilizada.
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Establece la forma de pago utilizada.
     *
     * @param formaPago Forma de pago utilizada.
     */
    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    /**
     * Obtiene el método de pago utilizado.
     *
     * @return Método de pago utilizado.
     */
    public String getMetodoPago() {
        return metodoPago;
    }

    /**
     * Establece el método de pago utilizado.
     *
     * @param metodoPago Método de pago utilizado.
     */
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    /**
     * Obtiene las condiciones de pago.
     *
     * @return Condiciones de pago.
     */
    public String getCondicionesPago() {
        return condicionesPago;
    }

    /**
     * Establece las condiciones de pago.
     *
     * @param condicionesPago Condiciones de pago.
     */
    public void setCondicionesPago(String condicionesPago) {
        this.condicionesPago = condicionesPago;
    }

    /**
     * Obtiene el monto total del pago.
     *
     * @return Monto total del pago.
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Establece el monto total del pago.
     *
     * @param monto Monto total del pago.
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * Obtiene la cantidad de productos o servicios pagados.
     *
     * @return Cantidad de productos o servicios pagados.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de productos o servicios pagados.
     *
     * @param cantidad Cantidad de productos o servicios pagados.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el precio unitario del producto o servicio.
     *
     * @return Precio unitario del producto o servicio.
     */
    public double getPrecioUnitario() {
        return precioUnitario;
    }

    /**
     * Establece el precio unitario del producto o servicio.
     *
     * @param precioUnitario Precio unitario del producto o servicio.
     */
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    /**
     * Obtiene el psicólogo asociado al pago.
     *
     * @return Psicólogo asociado al pago.
     */
    public PsicologoDTO getPsicologo() {
        return psicologo;
    }

    /**
     * Establece el psicólogo asociado al pago.
     *
     * @param psicologo Psicólogo asociado al pago.
     */
    public void setPsicologo(PsicologoDTO psicologo) {
        this.psicologo = psicologo;
    }
}
