
package com.payrollManagementSystem.service;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * <b>MailerService</b> is user defined class to send a one-time password for
 * the users in 'Login' module
 * 
 * @author mahad
 */
public class MailerService {
	/**
	 * @param to  The email address to which the OTP has to be sent
	 * @param OTP - A unique OTP, please use Random generator to pass a 4 digit OTP
	 *            to this parameter
	 * @return 1 - If the mail is sent successfully <br>
	 *         0 - If mail operation fails
	 */
	public static int generateOTP(String to, int OTP) {
		final String from = "mahadhirmohammed38@gmail.com";
		// FIXME REDACT password variable value
		final String password = "qnqovhtuhfmlaflu";

		String subject = "Forgot Password";
		String msg = "Your One Time Password is " + OTP;

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");

		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);
			}
		});

		try {
			MimeMessage message = new MimeMessage(session);
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(msg);
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		} catch (MessagingException e) {
			e.printStackTrace();
			return 0;
		}
		return 1;
	}
}
