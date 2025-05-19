/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import org.bson.types.ObjectId;

/**
 *
 * @author erika
 */
public class Cubiculo {

    /**
     * Id del registro
     */
    private ObjectId id;

    /**
     * Nombre o identificador del cubículo.
     */
    private String nombre;

    /**
     * Estado del cubículo: {@code true} si está disponible, {@code false} si
     * está ocupado.
     */
    private boolean estado;

    /**
     * Constructor vacío. Crea un objeto {@code CubiculoDTO} sin valores
     * definidos.
     */
    public Cubiculo() {
    }

    /**
     * Constructor que inicializa el cubículo con nombre y estado.
     *
     * @param nombre Nombre o identificador del cubículo.
     * @param estado {@code true} si el cubículo está disponible, {@code false}
     * si está ocupado.
     */
    public Cubiculo(String nombre, boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del cubículo.
     *
     * @return Nombre del cubículo.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del cubículo.
     *
     * @param nombre Nuevo nombre del cubículo.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Verifica si el cubículo está disponible.
     *
     * @return {@code true} si el cubículo está disponible, {@code false} si
     * está ocupado.
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Establece el estado del cubículo.
     *
     * @param estado {@code true} para disponible, {@code false} para ocupado.
     */
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
