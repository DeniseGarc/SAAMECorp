/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package presentacion.utilerias;

/**
 *
 * @author Alici
 */
public enum MetodoPago {
    PUE("Pago en una sola exhibición");
    // parece que por el momento el sistema no admite este tipo de metodo de pago
    // PPD("Pago en parcialidades ó diferido");

    private final String descripcion;

    MetodoPago(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getClave() {
        return this.name();
    }

    @Override
    public String toString() {
        return descripcion;
    }
}
