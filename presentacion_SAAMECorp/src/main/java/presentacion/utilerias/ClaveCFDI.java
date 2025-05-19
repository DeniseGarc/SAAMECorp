package presentacion.utilerias;

/**
 *
 * @author Alici
 */
public enum ClaveCFDI {
    G01("Adquisición de mercancías"),
    G02("Devoluciones, descuentos o bonificaciones"),
    G03("Gastos en General"),
    I01("Construcciones"),
    I02("Mobiliario y Equipo de Oficina por construcciones"),
    I03("Equipo de transporte"),
    I04("Equipo de cómputo y accesorios"),
    I05("Dados, troqueles, moldes, matrices y herramientas"),
    I06("Comunicaciones telefónicas"),
    I07("Comunicaciones satelitales"),
    I08("Otras máquinas y equipo"),
    D01("Honorarios médicos, dentales y hospitalarios"),
    D02("Gastos médicos por incapacidad o discapacidad"),
    D03("Gastos funerales"),
    D04("Donativos"),
    D05("Intereses reales efectivamente pagados por créditos hipotecarios (Casa habitación)"),
    D06("Aportaciones voluntarias al SAR"),
    D07("Primas por seguros de gastos médicos"),
    D08("Gastos por transportación escolar obligatoria"),
    D09("Depósito en cuentas para ahorro, primas que tengan como base planes de pensiones"),
    D10("Pagos por servicios educativos (colegiaturas)"),
    P01("Por definir");

    private final String descripcion;

    ClaveCFDI(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getClave() {
        return this.name(); // El nombre del enum es la clave
    }

    @Override
    public String toString() {
        return descripcion; // Para que el ComboBox muestre la descripción
    }
}
