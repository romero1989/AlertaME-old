package alertame.utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {

    private static void sendEmail(String error) {

        final String username = "romero.ufrr@gmail.com";
        final String password = "2009ufrr";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("romero.ufrr@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse("romero.ufrr@gmail.com"));
            message.setSubject("Erro no Alert@ME!");
            message.setText(error);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void sendEmailError(String msg) {
        sendEmail(msg);
    }

    public static void sendEmailError(Exception ex) {
        StackTraceElement[] stackTrace = ex.getStackTrace();
        String msg = "";

        for (StackTraceElement stackTraceElement : stackTrace) {
            msg += stackTraceElement.toString() + "\n";
        }

        sendEmail(msg);
    }

    public static void sendEmailError(Throwable ex) {
        StackTraceElement[] stackTrace = ex.getStackTrace();
        String msg = "";

        for (StackTraceElement stackTraceElement : stackTrace) {
            msg += stackTraceElement.toString() + "\n";
        }

        sendEmail(msg);
    }
}