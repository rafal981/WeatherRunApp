import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
public class MailSender {

    public static void sendMail() {
        ScannerMail scannerMail = new ScannerMail();
        scannerMail.getUserInput();

        String yourMail = scannerMail.getYourMailAddress();
        String mailPassword = scannerMail.getYourMailPassword();
        String anotherMail = scannerMail.getAnotherMailAddress();

            String host = "smtp.wp.pl";
            String from = yourMail;
            String to = anotherMail;

            final String username = yourMail;
            final String password = mailPassword;

            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "465");

            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");

            Session session = Session.getInstance(props, new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

        BuilderMailText builderMailText = new BuilderMailText();
        String messageContent = builderMailText.buildMessageContent();

        try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(from));
                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
                message.setSubject("Warunki pogodowe");
                message.setText(messageContent);

                Transport.send(message);

                System.out.println("Wiadomość została wysłana.");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
        }
    }

