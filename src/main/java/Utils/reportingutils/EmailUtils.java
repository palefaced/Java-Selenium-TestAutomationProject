package Utils.reportingutils;

import Utils.constants.Constants_EmailUtils;
import Utils.loggers.Logger;
import Utils.readers.ConfigReader;
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
    public static void sendEmail(String testName, String errorMessage, String screenshotPath) {
        Properties props = new Properties();
        //Values will be taken from external classes to avoid hard coding them here
        props.put(Constants_EmailUtils.SMTP_AUTH, ConfigReader.getConfig().getEmailConfig().getAuth());
        props.put(Constants_EmailUtils.SMTP_STARTTLS_ENABLE, ConfigReader.getConfig().getEmailConfig().getStarttlsEnable());
        props.put(Constants_EmailUtils.SMTP_HOST, ConfigReader.getConfig().getEmailConfig().getHost());
        props.put(Constants_EmailUtils.SMTP_PORT, ConfigReader.getConfig().getEmailConfig().getPort());

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Constants_EmailUtils.USERNAME, Constants_EmailUtils.APP_PASSWORD); // Use app password
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Constants_EmailUtils.USERNAME));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Constants_EmailUtils.RECIPIENT));
            message.setSubject(Constants_EmailUtils.EMAIL_HEADING_MSG + testName);

            // Email body
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText(String.format(Constants_EmailUtils.EMAIL_BODY_MSG, testName, errorMessage));

            // Attach Screenshot
            MimeBodyPart attachmentPart = new MimeBodyPart();
            attachmentPart.attachFile(screenshotPath);

            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            message.setContent(multipart);

            Transport.send(message);
            Logger.log.info(Constants_EmailUtils.EMAIL_SENT_MSG);

        } catch (Exception e) {
            Logger.log.error(Constants_EmailUtils.ERROR_MSG_UPON_MAIL_CREATION, e);
        }
    }
}
