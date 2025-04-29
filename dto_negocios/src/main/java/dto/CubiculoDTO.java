package dto;

/**
 * Clase que representa la información de un cubículo dentro del sistema.
 *
 * <p>
 * Este DTO (Data Transfer Object) se utiliza para transferir datos sobre un
 * cubículo, como su nombre e indicador de disponibilidad. Puede ser usado al
 * registrar o consultar citas, así como para mostrar la disponibilidad de los
 * cubículos en la interfaz del sistema.</p>
 *
 * <p>
 * El atributo {@code estado} indica si el cubículo está disponible o no.</p>
 *
 * @author Alici
 */
public class CubiculoDTO {

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
    public CubiculoDTO() {
    }

    /**
     * Constructor que inicializa el cubículo con nombre y estado.
     *
     * @param nombre Nombre o identificador del cubículo.
     * @param estado {@code true} si el cubículo está disponible, {@code false}
     * si está ocupado.
     */
    public CubiculoDTO(String nombre, boolean estado) {
        this.nombre = nombre;
        this.estado = estado;
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
