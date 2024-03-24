package Controller;

import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import javax.faces.view.ViewScoped;
import java.io.Serializable;

// Definición del bean gestionado por JSF con ámbito de solicitud
@Named(value = "emailJSFManagedBean")
@ViewScoped
public class emailJSFManagedBean implements Serializable {

    private String to;
    private String subject;
    private String message;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void sendEmail() {
        try {
            // Configuración para enviar correos electrónicos
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp-mail.outlook.com"); // Cambia esto con tu servidor SMTP
            props.put("mail.smtp.port", "587"); // Puerto SMTP (normalmente 587 para TLS)

            // Autenticación de usuario y contraseña
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("juliangjkl07@outlook.com", "pepinito44");
                }
            });

            // Crear un nuevo mensaje de correo electrónico
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress("juliangjkl07@outlook.com"));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            emailMessage.setSubject(subject);
            emailMessage.setText(message);

            // Enviar el mensaje
            Transport.send(emailMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
            // Mensaje de error
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al enviar el correo", null));
        }
    }
}