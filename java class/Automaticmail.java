
package ebogrs;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Automaticmail {
    
        public static void sendMail(String recepient,String sub,String text)
        {
            System.out.println("Preparing to send the mail");
               
		final String username = "sanjuckarthick@gmail.com";
		final String password = "kingspunjab11";
 
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
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
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(recepient));
			message.setSubject(sub);
			message.setText(text);
 
			Transport.send(message);
 
			
 
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
        }
}

