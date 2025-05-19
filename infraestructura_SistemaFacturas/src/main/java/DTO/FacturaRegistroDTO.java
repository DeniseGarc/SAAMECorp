package DTO;

import java.time.LocalDateTime;

/**
 * Clase que representa un DTO de registro de factura, con los datos necesarios
 * para registrar una factura con la API Facturama. Esta clase se utiliza para
 * transferir datos a la capa de infraestructura.
 *
 * @author Alici
 */
public class FacturaRegistroDTO {

    /**
     * Identificador único de la factura en el sistema de Facturama.
     */
    private String id;
    /**
     * Número de folio de la factura.
     */
    private String folio;
    /*
     * Fecha de emisión de la factura.
     */
    private LocalDateTime fechaHoraEmision;
    /**
     * Moneda en la que se emite la factura. Por defecto es "MXN" (peso
     * mexicano).
     */
    private String currency;
    /**
     * Codigo postal del lugar de expedición de la factura.
     */
    private String expeditionPlace;
    /**
     * Condiciones del pago de la factura.
     */
    private String paymentConditions;
    /**
     * Tipo de comprobante fiscal digital por Internet (CFDI). Por defecto es
     * "I" (ingreso).
     */
    private String cfdiType;
    /**
     * Forma de pago de la factura.
     */
    private String paymentForm;
    /**
     * Método de pago de la factura.
     */
    private String paymentMethod;
    /**
     * RFC del receptor de la factura.
     */
    private String rfcReceiver;
    /**
     * Nombre del receptor de la factura.
     */
    private String nameReceiver;
    /**
     * Correo electrónico del receptor de la factura.
     */
    private String emailReceiver;
    /**
     * Uso del CFDI por parte del receptor.
     */
    private String cfdiUse;
    /**
     * Regimen fiscal del receptor de la factura.
     */
    private String fiscalRegime;
    /**
     * Codio postal del receptor de la factura.
     */
    private String taxZipCode;
    /**
     * Número de identificacion del tipo de producto o servicio según el
     * catalogo de SAT. Por defecto es "801231502" (Arrendamiento de
     * instalaciones comerciales o industriales).
     */
    private String productCode;
    /**
     * Descripción del producto o servicio que se está facturando. Por defecto
     * es "Renta por de cubiculo psicologico por hora".
     */
    private String description;
    /**
     * unidad de medida del producto o servicio que se está facturando.
     */
    private String unit;
    /**
     * Código de unidad de medida del producto o servicio según el catalogo de
     * SAT.
     */
    private String unitCode;
    /**
     * Valor unitario del producto o servicio que se está facturando.
     */
    private Double unitPrice;
    /**
     * Cantidad del producto o servicio que se está facturando.
     */
    private Double quantity;
    /**
     * subtotal de la factura.
     */
    private Double subtotal;
    /**
     * Precio total de la factura.
     */
    private Double total;
    /**
     * Impuesto trasladado de la factura. Por defecto es (01) no objeto de
     * impuesto.
     */
    private String taxObject;

    /**
     * Constructor por defecto de la clase FacturaRegistroDTO. Este constructor
     * inicializa los atributos de la clase con valores por defecto.
     */
    public FacturaRegistroDTO() {
    }

    /**
     * Constructor de la clase FacturaRegistroDTO. Este constructor tiene todos
     * los atributos de la clase como parámetros. Menos el id y la fecha de
     * emisión de la factura.
     *
     * @param currency          Moneda en la que se emite la factura.
     * @param expeditionPlace   Código postal del lugar de expedición de la
     *                          factura.
     * @param paymentConditions Condiciones de pago de la factura.
     * @param cfdiType          Tipo de CFDI de la factura.
     * @param paymentForm       Forma de pago de la factura.
     * @param paymentMethod     Método de pago de la factura.
     * @param rfcReceiver       RFC del receptor de la factura.
     * @param nameReceiver      Nombre del receptor de la factura.
     * @param emailReceiver     Correo electrónico del receptor de la factura.
     * @param cfdiUse           Uso del CFDI por parte del receptor.
     * @param fiscalRegime      Régimen fiscal del receptor de la factura.
     * @param taxZipCode        Código postal del receptor de la factura.
     * @param productCode       Número de identificación del tipo de producto o
     *                          servicio según el catalogo de SAT.
     * @param description       Descripción del producto o servicio que se está
     *                          facturando.
     * @param unit              Unidad de medida del producto o servicio que se está
     *                          facturando.
     * @param unitCode          Código de unidad de medida del producto o servicio
     *                          según
     *                          el catalogo de SAT.
     * @param unitPrice         Valor unitario del producto o servicio que se está
     *                          facturando.
     * @param quantity          Cantidad del producto o servicio que se está
     *                          facturando.
     * @param subtotal          Subtotal de la factura.
     * @param total             Precio total de la factura.
     * @param taxObject         Impuesto trasladado de la factura.
     */
    public FacturaRegistroDTO(String currency, String expeditionPlace, String paymentConditions, String cfdiType,
            String paymentForm, String paymentMethod, String rfcReceiver, String nameReceiver, String emailReceiver,
            String cfdiUse, String fiscalRegime, String taxZipCode, String productCode, String description, String unit,
            String unitCode, Double unitPrice, Double quantity, Double subtotal, Double total, String taxObject) {
        this.currency = currency;
        this.expeditionPlace = expeditionPlace;
        this.paymentConditions = paymentConditions;
        this.cfdiType = cfdiType;
        this.paymentForm = paymentForm;
        this.paymentMethod = paymentMethod;
        this.rfcReceiver = rfcReceiver;
        this.nameReceiver = nameReceiver;
        this.emailReceiver = emailReceiver;
        this.cfdiUse = cfdiUse;
        this.fiscalRegime = fiscalRegime;
        this.taxZipCode = taxZipCode;
        this.productCode = productCode;
        this.description = description;
        this.unit = unit;
        this.unitCode = unitCode;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.total = total;
        this.taxObject = taxObject;
    }

    /**
     * Constructor de la clase FacturaRegistroDTO. Este constructor tiene todos
     * los atributos de la clase como parámetros.
     *
     * @param id                Identificador único de la factura en el sistema de
     *                          Facturama.
     * @param folio             Número de folio de la factura.
     * @param fechaHoraEmision  Fecha y hora de emisión de la factura.
     * @param currency          Moneda en la que se emite la factura.
     * @param expeditionPlace   Código postal del lugar de expedición de la
     *                          factura.
     * @param paymentConditions Condiciones de pago de la factura.
     * @param cfdiType          Tipo de CFDI de la factura.
     * @param paymentForm       Forma de pago de la factura.
     * @param paymentMethod     Método de pago de la factura.
     * @param rfcReceiver       RFC del receptor de la factura.
     * @param nameReceiver      Nombre del receptor de la factura.
     * @param emailReceiver     Correo electrónico del receptor de la factura.
     * @param cfdiUse           Uso del CFDI por parte del receptor.
     * @param fiscalRegime      Régimen fiscal del receptor de la factura.
     * @param taxZipCode        Código postal del receptor de la factura.
     * @param productCode       Número de identificación del tipo de producto o
     *                          servicio según el catalogo de SAT.
     * @param description       Descripción del producto o servicio que se está
     *                          facturando.
     * @param unit              Unidad de medida del producto o servicio que se está
     *                          facturando.
     * @param unitCode          Código de unidad de medida del producto o servicio
     *                          según
     *                          el catalogo de SAT.
     * @param unitPrice         Valor unitario del producto o servicio que se está
     *                          facturando.
     * @param quantity          Cantidad del producto o servicio que se está
     *                          facturando.
     * @param subtotal          Subtotal de la factura.
     * @param total             Precio total de la factura.
     * @param taxObject         Impuesto trasladado de la factura.
     */
    public FacturaRegistroDTO(String id, String folio, LocalDateTime fechaHoraEmision, String currency,
            String expeditionPlace, String paymentConditions, String cfdiType,
            String paymentForm, String paymentMethod, String rfcReceiver, String nameReceiver, String emailReceiver,
            String cfdiUse, String fiscalRegime, String taxZipCode, String productCode, String description, String unit,
            String unitCode, Double unitPrice, Double quantity, Double subtotal, Double total, String taxObject) {
        this.id = id;
        this.folio = folio;
        this.fechaHoraEmision = fechaHoraEmision;
        this.currency = currency;
        this.expeditionPlace = expeditionPlace;
        this.paymentConditions = paymentConditions;
        this.cfdiType = cfdiType;
        this.paymentForm = paymentForm;
        this.paymentMethod = paymentMethod;
        this.rfcReceiver = rfcReceiver;
        this.nameReceiver = nameReceiver;
        this.emailReceiver = emailReceiver;
        this.cfdiUse = cfdiUse;
        this.fiscalRegime = fiscalRegime;
        this.taxZipCode = taxZipCode;
        this.productCode = productCode;
        this.description = description;
        this.unit = unit;
        this.unitCode = unitCode;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.total = total;
        this.taxObject = taxObject;
    }

    /**
     * Método para obtener el identificador único de la factura en el sistema de
     * Facturama.
     *
     * @return El identificador único de la factura registrado en el sistema de
     *         Facturama.
     */
    public String getId() {
        return id;
    }

    /*
     * Método para establecer el identificador único de la factura en el
     * sistema de Facturama.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Método para obtener el número de folio de la factura.
     *
     * @return El número de folio de la factura.
     */
    public String getFolio() {
        return folio;
    }

    /**
     * Método para establecer el número de folio de la factura.
     *
     * @param folio El número de folio de la factura.
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * Método para obtener la fecha y hora de emisión de la factura.
     *
     * @return La fecha y hora de emisión de la factura.
     */
    public LocalDateTime getFechaHoraEmision() {
        return fechaHoraEmision;
    }

    /**
     * Método para establecer la fecha y hora de emisión de la factura.
     *
     * @param fechaHoraEmision La fecha y hora de emisión de la factura.
     */
    public void setFechaHoraEmision(LocalDateTime fechaHoraEmision) {
        this.fechaHoraEmision = fechaHoraEmision;
    }

    /**
     * Método para obtener la moneda en la que se emite la factura.
     *
     * @return La moneda en la que se emite la factura.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Método para establecer la moneda en la que se emite la factura.
     *
     * @param currency La moneda en la que se emite la factura.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Método para obtener el código postal del lugar de expedición de la
     * factura.
     *
     * @return El código postal del lugar de expedición de la factura.
     */
    public String getExpeditionPlace() {
        return expeditionPlace;
    }

    /**
     * Método para establecer el código postal del lugar de expedición de la
     * factura.
     *
     * @param expeditionPlace El código postal del lugar de expedición de la
     *                        factura.
     */
    public void setExpeditionPlace(String expeditionPlace) {
        this.expeditionPlace = expeditionPlace;
    }

    /**
     * Método para obtener las condiciones de pago de la factura.
     *
     * @return Las condiciones de pago de la factura.
     */
    public String getPaymentConditions() {
        return paymentConditions;
    }

    /**
     * Método para establecer las condiciones de pago de la factura.
     *
     * @param paymentConditions Las condiciones de pago de la factura.
     */
    public void setPaymentConditions(String paymentConditions) {
        this.paymentConditions = paymentConditions;
    }

    /**
     * Método para obtener el tipo de CFDI de la factura.
     *
     * @return El tipo de CFDI de la factura.
     */
    public String getCfdiType() {
        return cfdiType;
    }

    /**
     * Método para establecer el tipo de CFDI de la factura.
     *
     * @param cfdiType El tipo de CFDI de la factura.
     */
    public void setCfdiType(String cfdiType) {
        this.cfdiType = cfdiType;
    }

    /**
     * Método para obtener la forma de pago de la factura.
     *
     * @return La forma de pago de la factura.
     */
    public String getPaymentForm() {
        return paymentForm;
    }

    /**
     * Método para establecer la forma de pago de la factura.
     *
     * @param paymentForm La forma de pago de la factura.
     */
    public void setPaymentForm(String paymentForm) {
        this.paymentForm = paymentForm;
    }

    /**
     * Método para obtener el método de pago de la factura.
     *
     * @return El método de pago de la factura.
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Método para establecer el método de pago de la factura.
     *
     * @param paymentMethod El método de pago de la factura.
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * Método para obtener el RFC del receptor de la factura.
     *
     * @return El RFC del receptor de la factura.
     */
    public String getRfcReceiver() {
        return rfcReceiver;
    }

    /**
     * Método para establecer el RFC del receptor de la factura.
     *
     * @param rfcReceiver El RFC del receptor de la factura.
     */
    public void setRfcReceiver(String rfcReceiver) {
        this.rfcReceiver = rfcReceiver;
    }

    /**
     * Método para obtener el nombre del receptor de la factura.
     *
     * @return El nombre del receptor de la factura.
     */
    public String getNameReceiver() {
        return nameReceiver;
    }

    /**
     * Método para establecer el nombre del receptor de la factura.
     *
     * @param nameReceiver El nombre del receptor de la factura.
     */
    public void setNameReceiver(String nameReceiver) {
        this.nameReceiver = nameReceiver;
    }

    /**
     * Método para obtener el correo electrónico del receptor de la factura.
     *
     * @return El correo electrónico del receptor de la factura.
     */
    public String getEmailReceiver() {
        return emailReceiver;
    }

    /**
     * Método para establecer el correo electrónico del receptor de la factura.
     *
     * @param emailReceiver El correo electrónico del receptor de la factura.
     */
    public void setEmailReceiver(String emailReceiver) {
        this.emailReceiver = emailReceiver;
    }

    /**
     * Método para obtener el uso del CFDI por parte del receptor.
     *
     * @return El uso del CFDI por parte del receptor.
     */
    public String getCfdiUse() {
        return cfdiUse;
    }

    /**
     * Método para establecer el uso del CFDI por parte del receptor.
     *
     * @param cfdiUse El uso del CFDI por parte del receptor.
     */
    public void setCfdiUse(String cfdiUse) {
        this.cfdiUse = cfdiUse;
    }

    /**
     * Método para obtener el régimen fiscal del receptor de la factura.
     *
     * @return El régimen fiscal del receptor de la factura.
     */
    public String getFiscalRegime() {
        return fiscalRegime;
    }

    /**
     * Método para establecer el régimen fiscal del receptor de la factura.
     *
     * @param fiscalRegime El régimen fiscal del receptor de la factura.
     */
    public void setFiscalRegime(String fiscalRegime) {
        this.fiscalRegime = fiscalRegime;
    }

    /**
     * Método para obtener el código postal del receptor de la factura.
     *
     * @return El código postal del receptor de la factura.
     */
    public String getTaxZipCode() {
        return taxZipCode;
    }

    /**
     * Método para establecer el código postal del receptor de la factura.
     *
     * @param taxZipCode El código postal del receptor de la factura.
     */
    public void setTaxZipCode(String taxZipCode) {
        this.taxZipCode = taxZipCode;
    }

    /**
     * Método para obtener el código del producto o servicio que se está
     * facturando.
     *
     * @return El código del producto o servicio que se está facturando.
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Método para establecer el código del producto o servicio que se está
     * facturando.
     *
     * @param productCode El código del producto o servicio que se está
     *                    facturando.
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * Método para obtener la descripción del producto o servicio que se está
     * facturando.
     *
     * @return La descripción del producto o servicio que se está facturando.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Método para establecer la descripción del producto o servicio que se está
     * facturando.
     *
     * @param description La descripción del producto o servicio que se está
     *                    facturando.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Método para obtener la unidad de medida del producto o servicio que se
     * está facturando.
     *
     * @return La unidad de medida del producto o servicio que se está
     *         facturando.
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Método para establecer la unidad de medida del producto o servicio que se
     * está facturando.
     *
     * @param unit La unidad de medida del producto o servicio que se está
     *             facturando.
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * Método para obtener el código de unidad de medida del producto o servicio
     * según el catálogo de SAT.
     *
     * @return El código de unidad de medida del producto o servicio según el
     *         catálogo de SAT.
     */
    public String getUnitCode() {
        return unitCode;
    }

    /**
     * Método para establecer el código de unidad de medida del producto o
     * servicio según el catálogo de SAT.
     *
     * @param unitCode El código de unidad de medida del producto o servicio
     *                 según el catálogo de SAT.
     */
    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    /**
     * Método para obtener el valor unitario del producto o servicio que se está
     * facturando.
     *
     * @return El valor unitario del producto o servicio que se está facturando.
     */
    public Double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Método para establecer el valor unitario del producto o servicio que se
     * está facturando.
     *
     * @param unitPrice El valor unitario del producto o servicio que se está
     *                  facturando.
     */
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Método para obtener la cantidad del producto o servicio que se está
     * facturando.
     *
     * @return La cantidad del producto o servicio que se está facturando.
     */
    public Double getQuantity() {
        return quantity;
    }

    /**
     * Método para establecer la cantidad del producto o servicio que se está
     * facturando.
     *
     * @param quantity La cantidad del producto o servicio que se está
     *                 facturando.
     */
    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    /**
     * Método para obtener el subtotal de la factura.
     *
     * @return El subtotal de la factura.
     */
    public Double getSubtotal() {
        return subtotal;
    }

    /**
     * Método para establecer el subtotal de la factura.
     *
     * @param subtotal El subtotal de la factura.
     */
    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * Método para obtener el precio total de la factura.
     *
     * @return El precio total de la factura.
     */
    public Double getTotal() {
        return total;
    }

    /**
     * Método para establecer el precio total de la factura.
     *
     * @param total El precio total de la factura.
     */
    public void setTotal(Double total) {
        this.total = total;
    }

    /**
     * Método para obtener el impuesto trasladado de la factura.
     *
     * @return El impuesto trasladado de la factura.
     */
    public String getTaxObject() {
        return taxObject;
    }

    /**
     * Método para establecer el impuesto trasladado de la factura.
     *
     * @param taxObject El impuesto trasladado de la factura.
     */
    public void setTaxObject(String taxObject) {
        this.taxObject = taxObject;
    }

}
