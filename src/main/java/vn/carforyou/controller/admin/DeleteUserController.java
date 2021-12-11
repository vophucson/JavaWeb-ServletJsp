package vn.carforyou.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.carforyou.service.UserService;
import vn.carforyou.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin-deleteuser" })
public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 2021286071973419635L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userID = Integer.parseInt(req.getParameter("uid"));
		UserService us = new UserServiceImpl();
		us.deleteUser(userID);
		resp.sendRedirect("admin-user?index=1");
	}

}
