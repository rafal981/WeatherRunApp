import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class MailSender {

        public static void sendMail() {

            // Dane do połączenia z serwerem pocztowym
            String host = "smtp.wp.pl";
            String from = "koraf9@wp.pl";
            String to = "adamkaliszeski1@wp.pl";

            // Ustawienia autoryzacji
            final String username = "koraf9@wp.pl";
            final String password = "6439968";

            // Ustawienia właściwości
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "465");

            //Protokół SSL/TLS
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");

            // Tworzenie sesji
            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

            try {
                //String weatherEvaluationResult = AssessmentOfConditions.evaluateWeatherConditions();
                // Tworzenie wiadomości
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                message.setSubject("Warunki pogodowe");
                message.setText("weatherEvaluationResult");

                // Wysyłanie wiadomości
                Transport.send(message);

                System.out.println("Wiadomość została wysłana.");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }
    }

