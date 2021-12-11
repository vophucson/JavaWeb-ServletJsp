package vn.carforyou.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.carforyou.model.UserModel;

@WebServlet(urlPatterns = { "/admin-changepass" })
public class ChangePassController extends HttpServlet {
	private static final long serialVersionUID = 8607626092918047426L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		if (user.getIsAdmin() == 1) {
			String pid = req.getParameter("pid");
			req.setAttribute("productid", pid);
			RequestDispatcher rq = req.getRequestDispatcher("/viewsadmin/changepass.jsp");
			rq.forward(req, resp);
		} else {
			resp.sendRedirect("404");
		}
	}
}
