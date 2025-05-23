package presentacion.control;

import presentacion.utilerias.FormaPago;
import presentacion.utilerias.MetodoPago;
import presentacion.utilerias.Validadores;
import agendarCita.FAgendarCita;
import agendarCita.IAgendarCita;
import calendario.configuracion.ControlDiasCalendario;
import calendario.configuracion.PintorFechas;
import com.toedter.calendar.JCalendar;
import dto.CitaNuevaDTO;
import dto.CitaRegistradaDTO;
import dto.CubiculoDTO;
import dto.FacturaDTO;
import dto.PagoDTO;
import dto.PsicologoCitaDTO;
import dto.PsicologoDTO;
import dto.ReporteIngresosCubiculoDTO;
import dto.ReporteResumenCubiculoDTO;
import dto.ReporteUsoCubiculoDTO;
import dto.ResultadoAgendarCita;
import dto.ResultadoFacturarPago;
import dto.UsuarioDTO;
import excepciones.AgendarCitaException;
import excepciones.CoordinadorException;
import excepciones.GestorCalendarioException;
import generarFactura.FGenerarFactura;
import generarFactura.IGenerarFactura;
import excepciones.ModificarCitaException;
import excepciones.GestorCubiculosException;
import excepciones.IniciarSesionException;
import exception.GestorReportesException;
import gestorCalendario.FGestorCalendario;
import gestorCalendario.IGestorCalendario;
import gestorCubiculos.FGestorCubiculos;
import gestorCubiculos.IGestorCubiculos;
import gestorReportes.FGestorReportes;
import gestorReportes.IGestorReportes;
import iniciarSesion.FIniciarSesion;
import iniciarSesion.IIniciarSesion;
import java.awt.Color;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modificarCita.FModificarCita;
import modificarCita.IModificarCita;
import pagos.FPago;
import pagos.IPago;
import presentacion.sesion.GestorSesion;
import presentacion.sesion.TipoUsuario;

/**
 * Clase que aplica Singleton y se encarga de la comunicación entre presentación
 * y los subsistemas necesarios.
 *
 * @author Alici
 */
public class CoordinadorNegocio {

    /**
     * Instancia única del singleton
     */
    private static CoordinadorNegocio instancia;
    /**
     * Subsistema para agendar cita
     */
    private final IAgendarCita sistemaAgendarCita = new FAgendarCita();
    /**
     * Subsistema para gestionar el calendario de citas
     */
    private final IGestorCalendario sistemaGestorCalendario = new FGestorCalendario();

    private final IGenerarFactura sistemaGenerarFactura = new FGenerarFactura();

    private final IModificarCita sistemaModificarCita = new FModificarCita();
    private final IPago sistemaPagos = new FPago();
    private final IIniciarSesion sistemaInicioSesion = new FIniciarSesion();

    /**
     * Subsistema para gestionar cubiculos
     */
    private final IGestorCubiculos sistemaGestorCubiculoa = new FGestorCubiculos();

    private final IGestorReportes sistemaGestorReportes = new FGestorReportes();

    /**
     * Constructor privado para evitar la creación de múltiples instancias.
     */
    private CoordinadorNegocio() {
    }

    /**
     * Método para obtener la instancia única de CoordinadorNegocio.
     *
     * @return Instancia única del coordinador.
     */
    public static CoordinadorNegocio getInstance() {
        if (instancia == null) {
            instancia = new CoordinadorNegocio();
        }
        return instancia;
    }

    /**
     * Método que devuelve el psicólogo al cual pertenece el identificador junto
     * a los horas disponibles para cita que tiene en el día seleccionado.
     *
     * @param identificadorPsicologo Identificador único del psicólogo.
     * @param fechaCita Fecha seleccionada para la cita
     * @return datos del psicólogo junto a sus horas disponible
     * @throws CoordinadorException Si ocurre un error al obtener los datos
     */
    public PsicologoCitaDTO mostrarPsicologoCita(String identificadorPsicologo, Calendar fechaCita)
            throws CoordinadorException {
        if (identificadorPsicologo == null || identificadorPsicologo.trim().isEmpty()) {
            throw new CoordinadorException("El identificador del psicólogo es inválido.");
        }
        if (fechaCita == null) {
            throw new CoordinadorException("La fecha seleccionada es inválida.");
        }
        try {
            return sistemaAgendarCita.obtenerPsicologo(identificadorPsicologo, fechaCita);
        } catch (AgendarCitaException ex) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("El psicólogo no se encuentra", ex);
        }
    }

    /**
     * Método para validar si el psicólogo presenta una cantidad aceptable de
     * adeudo al momento de seleccionar un psicólogo.
     *
     * @param psicologo datos del psicólogo a validar su cantidad total de
     * adeudo.
     * @return true si el psicólogo presenta una cantidad de adeudo que aun le
     * premite agendar´más citas, false en caso contrario.
     * @throws excepciones.CoordinadorException
     */
    public boolean validarAdeudoPsicologoSeleccionado(PsicologoCitaDTO psicologo) throws CoordinadorException {
        if (psicologo == null) {
            throw new CoordinadorException("El psicólogo proporcionado es nulo.");
        }
        try {
            return sistemaAgendarCita.validarAdeudoPsicologo(psicologo);
        } catch (Exception ex) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Error al validar el adeudo del psicólogo.", ex);
        }
    }

    /**
     * Método para obtener los datos de los psicólogos registrados en el sistema
     * y los horarios disponibles de cada uno de ellos.
     *
     * @param fecha Fecha seleccionada de la cita.
     * @return lista de psicólogos junto a sus horas disponibles.
     * @throws excepciones.CoordinadorException
     */
    public List<PsicologoCitaDTO> mostrarPsicologosCita(Calendar fecha) throws CoordinadorException {
        if (fecha == null) {
            throw new CoordinadorException("La fecha proporcionada es inválida.");
        }
        try {
            return sistemaAgendarCita.mandarPsicologos(fecha);
        } catch (Exception ex) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Error al obtener la lista de psicólogos.", ex);
        }
    }

    /**
     * Método obtener las horas disponibles del psicólogo seleccionado.
     *
     * @param psicologo Psicólogo que ha sido seleccionado.
     * @return lista de horas en las que el psicólogo esta disponible para
     * agendar una cita.
     * @throws excepciones.CoordinadorException
     */
    public List<LocalTime> mostrarHorarios(PsicologoCitaDTO psicologo) throws CoordinadorException {
        if (psicologo == null) {
            throw new CoordinadorException("El psicólogo seleccionado es inválido.");
        }
        return psicologo.getHorarioDia();
    }

    /**
     * Método para mostrar los cubiculos que se encuentran disponibles para la
     * fecha y hora seleccionadas para agendar cita.
     *
     * @param fechaHoraCita fecha y hora que han sido seleccionados para la
     * cita.
     * @return Lista de los cubiculos disponibles a la fecha y hora indicados.
     * @throws excepciones.CoordinadorException
     */
    public List<CubiculoDTO> mostrarCubiculos(Calendar fechaHoraCita) throws CoordinadorException {
        if (fechaHoraCita == null) {
            throw new CoordinadorException("La fecha y hora seleccionadas son inválidas.");
        }
        try {
            List<CubiculoDTO> nombresCubiculos = sistemaAgendarCita.mandarCubiculos(fechaHoraCita);
            return nombresCubiculos;
        } catch (Exception ex) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Error al obtener los cubículos disponibles.", ex);
        }
    }

    /**
     * Método para obtener el texto con el resumen de la cita.
     *
     * @param cita Datos de la cita a agendar
     * @param cubiculo nombre del cubiculo
     * @param psicologo nombre del psicologo
     * @return regresa el texto con el resumen de la cita.
     * @throws CoordinadorException Si ocurre un problema al obtener el resumen
     */
    public String obtenerResumenCita(CitaNuevaDTO cita, String cubiculo, String psicologo) throws CoordinadorException {
        if (cita == null) {
            throw new CoordinadorException("Los datos de la cita son nulos.");
        }
        String error = Validadores.validarCita(cita);
        if (error != null) {
            return error;
        }
        try {
            return sistemaAgendarCita.resumenCita(cita, cubiculo, psicologo);
        } catch (AgendarCitaException ex) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Error al generar resumen de la cita.", ex);
        }
    }

    /**
     * Método para mandar a agendar la cita al sistema.
     *
     * @param cita Datos de la cita a agendar.
     * @return regresa una cadena de texto con el resultado de la operación
     * @throws CoordinadorException Si sucede un error al intentar registrar la
     * cita.
     */
    public String agendarCita(CitaNuevaDTO cita) throws CoordinadorException {
        if (cita == null) {
            throw new CoordinadorException("Los datos de la cita son inválidos.");
        }
        try {
            ResultadoAgendarCita resultadoOperacion = sistemaAgendarCita.agendarCita(cita);
            if (!resultadoOperacion.isCitaAgendada()) {
                throw new CoordinadorException("No fue posible agendar la cita");
            }
            if (!resultadoOperacion.isCorreoEnviado()) {
                return resultadoOperacion.getMensajeAdvertencia();
            }
            return "El correo de confirmación ha sido enviado al correo asociado al psicólogo";
        } catch (AgendarCitaException ex) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException(ex.getMessage());
        }
    }

    /**
     * Método que define la cantidad de días que estan disponibles para su
     * selección en el calendario dado. Aqui se define que el limite para
     * agendar cita es de dos meses en adelato.
     *
     * @param calendario Calendario de la interfaz gráfica donde se va a aplicar
     * el bloqueo de dias
     */
    public void bloquearDiasNoDisponibles(JCalendar calendario) {
        Calendar fechaActual = Calendar.getInstance();
        Calendar fechaTope = Calendar.getInstance();
        fechaTope.add(Calendar.MONTH, 2);
        ControlDiasCalendario desactivarDias = new ControlDiasCalendario(fechaActual, fechaTope);
        calendario.getDayChooser().addDateEvaluator(desactivarDias);
        calendario.getDayChooser().updateUI();
    }

    /**
     * Método que le define al calendario los días que debe pintar y el color de
     * los días.
     *
     * @param calendario Calendario de la intefaz gráfica donde se selecciona la
     * fecha para la cita.
     */
    public void pintarDiasCalendario(JCalendar calendario) {
        try {
            List<Calendar> diasConReservas = sistemaGestorCalendario.diasConReservas();
            List<Calendar> diasAgendaLlena = sistemaGestorCalendario.diasAgendaLlena();
            PintorFechas diasConCita = new PintorFechas(diasConReservas, Color.white, new Color(233, 69, 191), false,
                    "Hay citas agendadas este día");
            PintorFechas diasSinDisponibilidad = new PintorFechas(diasAgendaLlena, Color.white, new Color(138, 34, 111),
                    true, "La agenda del consultorio esta llena para este día");

            calendario.getDayChooser().addDateEvaluator(diasConCita);
            calendario.getDayChooser().addDateEvaluator(diasSinDisponibilidad);
            calendario.getDayChooser().updateUI();
            // Cada que se seleccione una nueva fecha se vuelve a pintar el calendario
            calendario.getDayChooser().addPropertyChangeListener("day", evt -> {
                calendario.getDayChooser().updateUI();
            });
        } catch (GestorCalendarioException ex) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Método para validar, cuando el usuario es un psicólogo, si el día
     * seleccionado el psicólogo usuario tiene disponibilidad de horario para
     * agendar un cita.
     *
     * @param diaSeleccionado Dia seleccionado del calendario.
     * @return true si el psicólogo aun tiene horas de atencion para la fecha
     * seleccionada, false en caso contrario
     */
    public boolean validarDiaSeleccionado(Calendar diaSeleccionado) {
        if (diaSeleccionado == null) {
            return false;
        }
        if (GestorSesion.getTipoUsuario().equals(TipoUsuario.PSICOLOGO)) {
            try {
                if (!sistemaGestorCalendario.diaDisponiblePsicologo(GestorSesion.getIdentificadorUsuario(),
                        diaSeleccionado)) {
                    return false;
                }
            } catch (GestorCalendarioException ex) {
                Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
    }

    /**
     * Método para generar la factura.
     *
     * @param factura Datos de la factura a generar.
     * @return Regresa el objeto de la factura generada.
     * @throws CoordinadorException Si ocurre un error al generar la factura.
     */
    public ResultadoFacturarPago generarFactura(PagoDTO pagoDTO, FacturaDTO factura) throws CoordinadorException {
        String error = Validadores.validarDatosFactura(factura);
        if (error != null) {
            throw new CoordinadorException(error);
        }
        try {
            /// return sistemaAgendarCita.generarFactura(factura);
            ResultadoFacturarPago resultadoFacturarPago = sistemaGenerarFactura.facturarPago(pagoDTO, factura);
            if (resultadoFacturarPago.getFactura() == null) {
                throw new CoordinadorException("No fue posible generar la factura del pago");
            }
            return resultadoFacturarPago;
        } catch (Exception ex) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Error al generar la factura.", ex);
        }
    }

    /**
     * Metodo para descargar el PDF de la factura.
     *
     * @param factura factura a descargar
     * @param filePath ruta donde se guardara el PDF
     * @return true si se descarga correctamente, false si se cancela la
     * factura.
     * @throws CoordinadorException si ocurre un error al descargar el PDF.
     */
    public boolean descargarPDF(FacturaDTO factura, String filePath) throws CoordinadorException {
        if (factura == null || factura.getId() == null) {
            throw new CoordinadorException("La factura es inválida.");
        }
        if (filePath == null || filePath.isEmpty()) {
            throw new CoordinadorException("La ruta del archivo es inválida.");
        }
        try {
            return sistemaGenerarFactura.descargarFacturaPDF(factura, filePath);
        } catch (Exception ex) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Error al descargar el PDF.", ex);
        }
    }

    /**
     * Método para descargar el XML de la factura.
     *
     * @param factura factura a descargar
     * @param filePath ruta donde se guardara el XML
     * @return true si se descarga correctamente, false si se cancela la
     * factura.
     * @throws CoordinadorException si ocurre un error al descargar el XML.
     */
    public boolean descargarXML(FacturaDTO factura, String filePath) throws CoordinadorException {
        if (factura == null || factura.getId() == null) {
            throw new CoordinadorException("La factura es inválida.");
        }
        if (filePath == null || filePath.isEmpty()) {
            throw new CoordinadorException("La ruta del archivo es inválida.");
        }
        try {
            return sistemaGenerarFactura.descargarFacturaXML(factura, filePath);
        } catch (Exception ex) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Error al descargar el XML.", ex);
        }
    }

    /**
     * Metodo para filtrar las citas por el dia
     *
     * @param fecha de la cual se quieren mostrar las citas
     * @return la lista con las citas filtradas
     * @throws excepciones.CoordinadorException
     */
    public List<CitaRegistradaDTO> obtenerCitasDia(Calendar fecha) throws CoordinadorException {
        try {
            return sistemaModificarCita.obtenerCitasDia(fecha);
        } catch (ModificarCitaException ex) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException(ex.getMessage());
        }
    }
    /**
     * Metodo para mandar los cubiculos disponibles
     * @param cita 
     * @return Lista de cubiculos
     * @throws CoordinadorException 
     */
    public List<CubiculoDTO> mandarCubiculos(CitaRegistradaDTO cita) throws CoordinadorException {
        if (cita == null) {
            throw new CoordinadorException("Cita invalida..");
        }
        try {
            List<CubiculoDTO> cubiculos = new ArrayList<>();
            for (CubiculoDTO cubiculo : sistemaModificarCita.mandarCubiculos(cita)) {
                cubiculos.add(cubiculo);
            }
            return cubiculos;
        } catch (ModificarCitaException ex) {
            throw new CoordinadorException("Error al obtener los cubículos disponibles.", ex);
        }
    }

    /**
     * Metodo para agregar un nuevo cubiculo
     *
     * @param cubiculo
     * @return
     * @throws CoordinadorException
     */
    public String AgregarCubiculo(CubiculoDTO cubiculo) throws CoordinadorException {
        if (cubiculo == null) {
            throw new CoordinadorException("Los datos del cubiculo son inválidos.");
        }
        try {
            boolean resultadoOperacion = sistemaGestorCubiculoa.agregarCubiculo(cubiculo);
            if (resultadoOperacion == false) {
                throw new CoordinadorException("No fue posible agregar el cubiculo");
            }
        } catch (GestorCubiculosException ex) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException(ex.getMessage());
        }
        return "Se agrego el cubiculo con exito";
    }

    /**
     * Metodo para modificar la informacion de un cubiculo
     *
     * @param cubiculo cubiculo con la informacion a modificar
     * @return
     * @throws CoordinadorException
     */
    public String modificarCubiculo(CubiculoDTO cubiculo) throws CoordinadorException {
        if (cubiculo == null) {
            throw new CoordinadorException("Los datos del cubiculo son inválidos.");
        }
        try {
            boolean resultadoOperacion = sistemaGestorCubiculoa.modificarCubiculo(cubiculo);
            if (resultadoOperacion == false) {
                throw new CoordinadorException("No fue posible modificar el cubiculo");
            }
        } catch (GestorCubiculosException ex) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException(ex.getMessage());
        }
        return "Se modifico el cubiculo con exito";
    }

    /**
     * Metodo para modificar el estado de un cubiculo
     *
     * @param cubiculo cubiculo a modificar
     * @return True si se modifico exitosamente, false si no
     * @throws CoordinadorException
     */
    public String modificarEstadoCubiculo(CubiculoDTO cubiculo) throws CoordinadorException {
        if (cubiculo == null) {
            throw new CoordinadorException("El estado es invalido.");
        }
        try {
            boolean resultadoOperacion = sistemaGestorCubiculoa.actualizarEstadoCubiculo(cubiculo);
            if (resultadoOperacion == false) {
                throw new CoordinadorException("No fue posible modificar el estado del cubiculo");
            }
        } catch (GestorCubiculosException ex) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException(ex.getMessage());
        }
        return "Se modifico el estado del cubiculo con exito";
    }

    /*
     * Método para obtener los psicologos registrados en el sistema.
     * 
     * @return Un objeto PsicologoDTO que contiene los datos del psicologo.
     * 
     * @throws CoordinadorException si ocurre un error al obtener los psicologos
     */
    public List<PsicologoDTO> obtenerPsicologos() throws CoordinadorException {
        try {
            return sistemaPagos.obtenerPsicologos();
        } catch (Exception ex) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Error al obtener los psicólogos.", ex);
        }
    }

    /**
     * Metodo para obtener todos lo cubiculos registrados
     *
     * @return Lista de cubiculos
     * @throws CoordinadorException
     */
    public List<CubiculoDTO> obtenerCubiculos() throws CoordinadorException {
        try {
            return sistemaGestorCubiculoa.obtenerCubiculos();
        } catch (GestorCubiculosException ex) {

            throw new CoordinadorException(ex.getMessage());
        }
    }

    /**
     * Método para obtener los pagos de un psicólogo en los ultimos 30 dias.
     *
     * @param psicologoDTO El objeto PsicologoDTO que representa el psicólogo
     * para el cual se desean obtener los pagos.
     * @return Una lista de objetos PagoDTO que representan los pagos realizados
     * al psicólogo en los últimos 30 días.
     * @throws CoordinadorException Si ocurre un error al obtener los pagos.
     */
    public List<PagoDTO> obtenerPagosUltimos30Dias(PsicologoDTO psicologoDTO) throws CoordinadorException {
        if (psicologoDTO == null) {
            throw new CoordinadorException("El psicólogo proporcionado es nulo.");
        }
        try {
            // Flujo esperado si no se estuviera mockeando
            // return sistemaPagos.obtenerPagosMesAnterior(psicologoDTO);
            return java.util.Arrays.asList(
                    new PagoDTO(LocalDateTime.of(2025, Month.MAY, 03, 12, 23), FormaPago.EFECTIVO.getClave(),
                            MetodoPago.PUE.getClave(), "Ninguna", 300.0, null),
                    new PagoDTO(LocalDateTime.of(2025, Month.MAY, 10, 8, 00), FormaPago.TARJETA_DE_CREDITO.getClave(),
                            MetodoPago.PUE.getClave(), "Ninguna", 200.0, null),
                    new PagoDTO(LocalDateTime.of(2025, Month.MAY, 12, 15, 20), FormaPago.TARJETA_DE_CREDITO.getClave(),
                            MetodoPago.PUE.getClave(), "Ninguna", 500.0, null),
                    new PagoDTO(LocalDateTime.of(2025, Month.MAY, 14, 11, 30), FormaPago.EFECTIVO.getClave(),
                            MetodoPago.PUE.getClave(), "Ninguna", 300.0, null),
                    new PagoDTO(LocalDateTime.of(2025, Month.MAY, 20, 12, 40), FormaPago.EFECTIVO.getClave(),
                            MetodoPago.PUE.getClave(), "Ninguna", 100.0, null));
        } catch (Exception ex) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Error al obtener los pagos anteriores.", ex);
        }
    }

    /**
     * Método para obtener el total de cantidad de adeudo que tiene un psicologo
     *
     * @param psicologoDTO El objeto PsicologoDTO que representa el psicólogo
     * para el cual se desean obtener los pagos.
     * @return Un objeto PagoDTO que contiene los datos del pago.
     * @throws CoordinadorException Si ocurre un error al obtener los pagos.
     *
     */
    public double obtenerCantidadAdeudoPsicologo(PsicologoDTO psicologoDTO) throws CoordinadorException {
        return 200.0;
    }

    /**
     * Metodo que se encarga de registrar el pago en el sistema de pagos. TODO
     * LO RELACIONADO A PAGOS SE ENCUENTRA MOCK POR EL MOMENTO.
     *
     * @param pagoDTO DTO con los datos del pago a registrar.
     * @return DTO con los datos del pago registrado.
     * @throws CoordinadorException Si ocurre un error al registrar el pago.
     */
    public PagoDTO confirmarPago(PagoDTO pagoDTO) throws CoordinadorException {
        return pagoDTO;
    }

    /**
     * Metodo para obtener las horas disponibles que coinciden de un cubiculo y
     * un psicologo
     *
     * @param psicologo psicologo del cual se requieren las horas
     * @param idCubiculo cubiculo del cual se requieren las horas
     * @param fecha fecha en la cual sera la cita
     * @return lista de la horas disponibles coincidentes
     * @throws excepciones.ModificarCitaException
     */
    public List<LocalTime> mandarHorario(PsicologoCitaDTO psicologo, String idCubiculo, Calendar fecha) throws ModificarCitaException {
        try {
            return sistemaModificarCita.mandarHorario(psicologo, idCubiculo, fecha);
        } catch (ModificarCitaException e) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, e);
            throw new ModificarCitaException("Error al mandar horario: ", e);
        }
    }

    /**
     * Metodo que accede al subsistema de gestor de reportes para generar el
     * reporte de ingresos por cubiculo
     *
     * @param cubiculo cubiculo al que se le va a realizar el reporte
     * @return ReporteIngresosCubiculoDTO
     * @throws CoordinadorException
     */
    public ReporteIngresosCubiculoDTO generarReporteIngresosPorCubiculo(CubiculoDTO cubiculo)
            throws CoordinadorException {
        try {
            return sistemaGestorReportes.generarReporteIngresosPorCubiculo(cubiculo.getNombre());
        } catch (GestorReportesException ex) {

            throw new CoordinadorException(ex.getMessage());
        }

    }

    /**
     * Metodo par generar un reporte de uso de cubiculo
     *
     * @param cubiculo cubiculo al que se le va a realizar el reporte
     * @return ReporteUsoCubiculoDTO
     * @throws CoordinadorException
     */
    public ReporteUsoCubiculoDTO generaraReporteUsoCubiculo(String cubiculo) throws CoordinadorException {
        try {
            return sistemaGestorReportes.generarReporteUsoCubiculo(cubiculo);
        } catch (GestorReportesException ex) {

            throw new CoordinadorException(ex.getMessage());
        }
    }

    /**
     * Método para actualizar una cita existente
     *
     * @param citaActualizada La cita con los nuevos datos
     * @return true si la actualización fue exitosa, false en caso contrario
     * @throws excepciones.CoordinadorException
     */
    public boolean actualizarCita(CitaRegistradaDTO citaActualizada) throws CoordinadorException {
        try {
            return sistemaModificarCita.actualizarCita(citaActualizada);
        } catch (ModificarCitaException e) {
            throw new CoordinadorException("Error al intentar actualizar la cita: ", e);
        }
    }

    /**
     * Método que se conecta con el servicio externo para mandar un correo
     * electrónico al correo ingresado.
     *
     * @param cita de la cual se enviará confirmación
     * @return true si la operación fue exitosa, false en caso contrario.
     * @throws excepciones.CoordinadorException
     */
    public boolean mandarCorreo(CitaRegistradaDTO cita) throws CoordinadorException {
        try {
            return sistemaModificarCita.mandarCorreo(cita);
        } catch (ModificarCitaException e) {
            throw new CoordinadorException("Error al enviar correo: ", e);
        }
    }

    /**
     * Metodo para generar un reporte de resumen estadistico
     *
     * @return List ReporteResumenCubiculoDTO
     * @throws CoordinadorException
     */
    public List<ReporteResumenCubiculoDTO> generaReporteResumenCubiculo() throws CoordinadorException {
        try {
            return sistemaGestorReportes.generarReporteEstadisticoResumen();
        } catch (GestorReportesException ex) {

            throw new CoordinadorException(ex.getMessage());
        }

    }
    /**
     * Metodo para iniciar sesion 
     * @param usuario usuario que inicia sesion
     * @return UsuarioDTO
     * @throws CoordinadorException 
     */
    public UsuarioDTO iniciarSesion(UsuarioDTO usuario) throws CoordinadorException {
        if (usuario == null || usuario.getTipoUsuario() == null || usuario.getContrasena() == null || usuario.getUsuario() == null) {
            throw new CoordinadorException("El usuario ni contraseña no pueden ser nulos");
        }
        try {
            return sistemaInicioSesion.iniciarSesion(usuario);
        } catch (IniciarSesionException ex) {
            Logger.getLogger(CoordinadorNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new CoordinadorException("Credenciales Incorrectas");
        }
    }

}
