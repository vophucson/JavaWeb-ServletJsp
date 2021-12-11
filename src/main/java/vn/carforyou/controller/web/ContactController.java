package vn.carforyou.controller.web;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.carforyou.model.BrandModel;
import vn.carforyou.model.InfoModel;
import vn.carforyou.service.BrandService;
import vn.carforyou.service.InfoService;
import vn.carforyou.service.impl.BrandServiceImpl;
import vn.carforyou.service.impl.InfoServiceImpl;

@WebServlet(urlPatterns = { "/contact" })
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 6010569184557141903L;
	BrandService bs = new BrandServiceImpl();
	List<BrandModel> brand = bs.getAllBrand();
	InfoService ind = new InfoServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("brand", brand);
		InfoModel info = ind.getInfo();
		req.setAttribute("info", info);
		RequestDispatcher rq = req.getRequestDispatcher("/views/contact.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		InfoModel info = ind.getInfo();
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		final String username = "vophucson1@gmail.com";
		final String password = "anhson123";
		Properties prop = System.getProperties();
		 prop.put("mail.smtp.starttls.enable", "true");
         prop.put("mail.smtp.host", "smtp.gmail.com");
         prop.put("mail.smtp.port", "587");
         prop.put("mail.smtp.auth", "true");
		Session session = Session.getInstance(prop, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});	
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String content = req.getParameter("content");
		session.setDebug(true);
		if (name.equals("") || email.equals("") || phone.equals("") || content.equals("")) {
			req.setAttribute("mess", "Không được để trống");
		} else {
			try {
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(info.getEmail()));
				message.setSubject(MimeUtility.encodeText("Khách hàng gửi thông tin liên hệ", "utf-8", "B"));
				String emailContent = "Họ và tên: " + name + "\r\n" + "Email: " + email + "\r\n" + "SĐT: " + phone
						+ "\r\n" + "Nội dung :" + content;
				message.setContent(emailContent, "text/plain; charset=UTF-8");
				Transport.send(message);
				req.setAttribute("mess", "Cảm ơn bạn đã gửi thông tin.Chúng tôi sẽ hồi đáp sớm nhất");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		req.setAttribute("brand", brand);
		req.setAttribute("info", info);
		RequestDispatcher rq = req.getRequestDispatcher("/views/contact.jsp");
		rq.forward(req, resp);
	}
}
