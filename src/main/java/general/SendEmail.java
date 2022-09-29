package general;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {
	
	static String from = "maksymiliantest1@gmail.com";
	
	public static void sendEmails(String title, String text, String[] emailList) {
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = getSession(properties);
        session.setDebug(false);
        generateMessage(session, title, text, emailList);
    }
	
	private static void generateMessage(Session session, String title, String text, String[] emailList) {
		try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            for (int i = 0; i < emailList.length; i++) {
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailList[i]));
            }
            message.setSubject(title);
            //message.setText(text);
            message.setContent(text, "text/html; charset=utf-8");
            Transport.send(message);
            System.out.println("Sent message successfull("+title+")\n");
        } 
        catch (MessagingException mex) {
            mex.printStackTrace();
        }
	}
	
	private static Session getSession(Properties properties) {
		Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, "Rrr99659");
            }
        });
		return session;
	}
}