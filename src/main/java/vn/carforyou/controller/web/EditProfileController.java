package vn.carforyou.controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.carforyou.model.UserModel;
import vn.carforyou.service.UserService;
import vn.carforyou.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/editprofile" })
public class EditProfileController extends HttpServlet {
	private static final long serialVersionUID = 5180905586063773295L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String userId = req.getParameter("userid");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		System.out.println(userId);
		System.out.println(name);
		System.out.println(phone);
		System.out.println(address);
		UserService us = new UserServiceImpl();
		us.edit(name, phone, address, userId);
		HttpSession session = req.getSession();
		UserModel user = us.getInfoUser(userId);
		session.setAttribute("user", user);
		resp.sendRedirect("profile-setting?id=" + userId);
	}
}
