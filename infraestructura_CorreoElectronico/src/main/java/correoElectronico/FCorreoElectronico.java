package correoElectronico;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Clase fachada que implementa la interfaz ICorreoElectrónico para el envío de
 * correos,
 *
 * @author Alici
 */
public class FCorreoElectronico implements ICorreoElectronico {

    /**
     * Metodo que usa SMTP para mandar un correo
     *
     * @param correo el correo al cual se enviará la notificación
     * @param mensaje el contenido del correo
     * @return true si el correo se envió, false en caso de error
     */
    @Override
    public boolean mandarCorreo(String correo, String mensaje) {
        //correo remitente 
        final String user = "lolestutu@gmail.com";
        //contraseña de aplicacion que le da acceso a la cuenta
        final String password = "yiwa igto dpbu weku";

        // Configuración de propiedades SMTP
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Autenticación y creación de sesión
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });

        try {
            // Creación del mensaje
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(user));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo));
            message.setSubject("Cita en Alleri");
            message.setContent(mensaje, "text/html");

            // Envío del correo
            Transport.send(message);
        } catch (MessagingException e) {
            System.out.println("Error al enviar el correo: " + e.getMessage());
            return false;
        }
        return true;
    }

}
