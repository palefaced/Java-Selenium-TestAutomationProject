package Utils.testutils;

import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import jakarta.mail.Authenticator;  // Import from jakarta.mail
import jakarta.mail.PasswordAuthentication;  // Import from jakarta.mail
import java.util.Properties;

public class EmailUtils {
    private static final String USERNAME = "skytomationproject@gmail.com"; //my email
    private static final String APP_PASSWORD = "vziz nylk dwut nxoq"; //pass
    private static final String RECIPIENT = "nikolov87@yahoo.com"; //recipient email address



    public static void sendEmail(String testName, String errorMessage, String screenshotPath) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, APP_PASSWORD); // Use app password
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(RECIPIENT));
            message.setSubject("Test Failed: " + testName);

            // Email body
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("Test '" + testName + "' failed.\n\nError: " + errorMessage);

            // Attach Screenshot
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(screenshotPath);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);
            System.out.println("Failure email sent!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
