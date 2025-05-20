/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package presentacion.utilerias;

/**
 *
 * @author Alici
 */
public enum FormaPago {
    EFECTIVO("01", "Efectivo"),
    CHEQUE_NOMINATIVO("02", "Cheque nominativo"),
    TRANSFERENCIA_ELECTRONICA_DE_FONDOS("03", "Transferencia electrónica de fondos"),
    TARJETA_DE_CREDITO("04", "Tarjeta de crédito"),
    MONEDERO_ELECTRONICO("05", "Monedero electrónico"),
    DINERO_ELECTRONICO("06", "Dinero electrónico"),
    VALES_DE_DESPENSA("08", "Vales de despensa"),
    DACION_EN_PAGO("12", "Dación en pago"),
    PAGO_POR_SUBROGACION("13", "Pago por subrogación"),
    PAGO_POR_CONSIGNACION("14", "Pago por consignación"),
    CONDONACION("15", "Condonación"),
    COMPENSACION("17", "Compensación"),
    NOVACION("23", "Novación"),
    CONFUSION("24", "Confusión"),
    REMISION_DE_DEUDA("25", "Remisión de deuda"),
    PRESCRIPCION_O_CADUCIDAD("26", "Prescripción o caducidad"),
    A_SATISFACCION_DEL_ACREEDOR("27", "A satisfacción del acreedor"),
    TARJETA_DE_DEBITO("28", "Tarjeta de débito"),
    TARJETA_DE_SERVICIOS("29", "Tarjeta de servicios"),
    APLICACION_DE_ANTICIPOS("30", "Aplicación de anticipos"),
    INTERMEDIARIOS("31", "Intermediarios"),
    POR_DEFINIR("99", "Por definir");

    private final String clave;
    private final String descripcion;

    FormaPago(String clave, String descripcion) {
        this.clave = clave;
        this.descripcion = descripcion;
    }

    public String getClave() {
        return clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return descripcion; // Para mostrar la descripción en el ComboBox
    }
}
