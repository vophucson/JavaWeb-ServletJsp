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
import vn.carforyou.service.ProductService;
import vn.carforyou.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/admin-home" })
public class AdminHomeController extends HttpServlet {
	private static final long serialVersionUID = 9042142602470307219L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		ProductService ps = new ProductServiceImpl();
		UserModel user = (UserModel) session.getAttribute("user");
		if (user.getIsAdmin() == 1) {
			int totalCar = ps.totalCar();
			req.setAttribute("totalCar", totalCar);
			int totalpassCar = ps.totalpassCar();
			req.setAttribute("totalpassCar", totalpassCar);
			int totalnoPassCar = ps.totalnoPassCar();
			req.setAttribute("totalnoPassCar", totalnoPassCar);
			int totalUser = ps.totalUser();
			req.setAttribute("totalUser", totalUser);
			int totalStore = ps.totalStore();
			req.setAttribute("totalStore", totalStore);
			int totalBrand = ps.totalBrand();
			req.setAttribute("totalBrand", totalBrand);
			RequestDispatcher rq = req.getRequestDispatcher("/viewsadmin/home.jsp");
			rq.forward(req, resp);
		} else {
			resp.sendRedirect("404");
		}
	}
}
