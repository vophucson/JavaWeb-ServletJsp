package vn.carforyou.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.carforyou.model.UserModel;
import vn.carforyou.service.UserService;
import vn.carforyou.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/admin-user" })
public class AdminUserController extends HttpServlet {
	private static final long serialVersionUID = 8815725822137402946L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		UserService us = new UserServiceImpl();
		if (user.getIsAdmin() == 1) {
			int endP = us.countPageUser();
			req.setAttribute("endP", endP);
			int index = Integer.parseInt(req.getParameter("index"));
			req.setAttribute("tag", index);
			List<UserModel> list = us.listUserAdmin(index);
			req.setAttribute("list", list);
			RequestDispatcher rq = req.getRequestDispatcher("/viewsadmin/user.jsp");
			rq.forward(req, resp);
		} else {
			resp.sendRedirect("404");
		}
	}

}
