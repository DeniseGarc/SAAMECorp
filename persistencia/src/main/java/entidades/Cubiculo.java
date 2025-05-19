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
     * Capacidad del cubiculo
     */
    private int capacidad;
    
    /**
     * Tipo de terapia para la que esta diseñada el cubiculo
     */
    private String tipoTerapia;
    
    /**
     * Notas adicionales sobre el cubiculo
     */
    private String notas; 

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
    
    /**
     * Constructor que inicializa todos sus parametros
     * @param id
     * @param nombre
     * @param estado
     * @param capacidad
     * @param tipoTerapia
     * @param notas 
     */
    public Cubiculo(ObjectId id, String nombre, boolean estado, int capacidad, String tipoTerapia, String notas) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.capacidad = capacidad;
        this.tipoTerapia = tipoTerapia;
        this.notas = notas;
    }
    
    /**
     * Devuelve el identificador en formato String (hexadecimal)
     * @return Representacion textual del ObjectId.
     */
    public String getObjectString(){
        return id != null ? id.toHexString(): null;
    }
    /**
     * Asigna el identificador MongoBD a partir de una cadena hexadecimal.
     * @param idStr Cadena con el valor de objectId. Si es null o vacio, no se asigna
     */
    public void setObjectString (String idStr){
        this.id = (idStr != null && !idStr.isBlank()) ? new ObjectId(idStr) : null;
    }
    
    /**
     * Obtieme la capacidad del cubiculo
     * @return capacidad del cubiculo
     */
    public int getCapacidad() {
        return capacidad;
    }
    
    /**
     * Establece la capacidad del cubiculo
     * @param capacidad capacidad del cubiculo 
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    /**
     * Obtiene el tipo de terapia
     * @return tipo de terapia
     */
    public String getTipoTerapia() {
        return tipoTerapia;
    }
    
    /**
     * Establece el tipo de terapia
     * @param tipoTerapia tipo de terapia
     */
    public void setTipoTerapia(String tipoTerapia) {
        this.tipoTerapia = tipoTerapia;
    }
    
    /**
     * Obtiene las notas del cubiculo
     * @return notas del cubiculo
     */
    public String getNotas() {
        return notas;
    }
    
    /**
     * Establece las notas del cubiculo
     * @param notas notas del cubiculo
     */
    public void setNotas(String notas) {
        this.notas = notas;
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
