/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import org.bson.types.ObjectId;

/**
 * Mock para la entidad de audedo
 *
 * @author erika
 */
public class Adeudo {

    /**
     * Id del registro
     */
    private ObjectId id;

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
    public Adeudo() {
    }

    /**
     * Constructor que inicializa el adeudo con una cantidad y un estado
     * especificados.
     *
     * @param cantidad Monto del adeudo.
     * @param estado Estado del adeudo: {@code true} si está pagado,
     * {@code false} si está pendiente.
     */
    public Adeudo(double cantidad, boolean estado) {
        this.cantidad = cantidad;
        this.estado = estado;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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
