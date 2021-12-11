package vn.carforyou.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.carforyou.service.UserService;
import vn.carforyou.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin-changedealer" })
public class ChangeDealerController extends HttpServlet {
	private static final long serialVersionUID = -6871353836390028199L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int userID = Integer.parseInt(req.getParameter("uid"));
		int role = Integer.parseInt(req.getParameter("role"));
		UserService us = new UserServiceImpl();
		us.changeDealer(userID, role);
		resp.sendRedirect("admin-user?index=1");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("uid", req.getParameter("uid"));
		RequestDispatcher rq = req.getRequestDispatcher("/viewsadmin/changedealer.jsp");
		rq.forward(req, resp);
	}
}
