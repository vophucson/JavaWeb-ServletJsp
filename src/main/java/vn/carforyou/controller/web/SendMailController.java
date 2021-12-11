package vn.carforyou.controller.web;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/sendmail" })
public class SendMailController extends HttpServlet {
	private static final long serialVersionUID = 3130412598744135554L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		final String username = "vophucson1@gmail.com";
		final String password = "anhson123";
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		String emailTo = req.getParameter("to");
		String emailSubject = req.getParameter("subject");
		String emailContent = req.getParameter("content");
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
			message.setSubject(MimeUtility.encodeText("Khách hàng " + emailSubject, "utf-8", "B"));
			// message.setText(emailContent);
			message.setContent(emailContent, "text/plain; charset=UTF-8");
			Transport.send(message);
			System.out.println("Done");
			resp.sendRedirect("home");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
