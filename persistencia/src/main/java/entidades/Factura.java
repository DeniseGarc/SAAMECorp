package entidades;

import java.time.LocalDateTime;

public class Factura {
    private String idFactura;
    private String folio;
    private LocalDateTime fechaHora;

    public Factura() {
    }

    public Factura(String idFactura, String folio, LocalDateTime fechaHora) {
        this.idFactura = idFactura;
        this.folio = folio;
        this.fechaHora = fechaHora;
    }
    
    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
    
    
}
