package correoElectronico;

import dto.CorreoDTO;
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
 * Clase que implementa la interfaz ICorreoElectrónico para el envío de
 * correos,
 *
 * @author Alici
 */
public class FCorreoElectronico implements ICorreoElectronico {

    /**
     * Método que envía un correo electrónico a la dirección de correo dada.
     * Envia el mensaje ingresado.
     *
     * @param correo dto con los datos que se necesitan para el correo
     * @return true si el correo se envio exitosamente o false en caso contrario
     */
    @Override
    public boolean mandarCorreo(CorreoDTO correo) {
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
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correo.getCorreoDestino()));
            message.setSubject("Cita en Alleri");
            message.setContent(correo.getMensaje(), "text/html");

            // Envío del correo
            Transport.send(message);
        } catch (MessagingException e) {
            System.out.println("Error al enviar el correo: " + e.getMessage());
            return false;
        }
        return true;
    }

}
