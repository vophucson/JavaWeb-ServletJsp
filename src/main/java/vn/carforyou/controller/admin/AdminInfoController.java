package vn.carforyou.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.carforyou.model.InfoModel;
import vn.carforyou.model.UserModel;
import vn.carforyou.service.InfoService;
import vn.carforyou.service.impl.InfoServiceImpl;

@WebServlet(urlPatterns = { "/admin-info" })
public class AdminInfoController extends HttpServlet {
	private static final long serialVersionUID = -4451212118960598864L;
	InfoService is = new InfoServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		if (user.getIsAdmin() == 1) {
			InfoModel info = is.getInfo();
			req.setAttribute("info", info);
			RequestDispatcher rq = req.getRequestDispatcher("/viewsadmin/editinfo.jsp");
			rq.forward(req, resp);
		} else {
			resp.sendRedirect("404");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		System.out.println(address);
		is.editInfo(email, phone, address);
		InfoModel info = is.getInfo();
		req.setAttribute("info", info);
		req.setAttribute("mess", "Cập nhật thông tin website thành công");
		RequestDispatcher rq = req.getRequestDispatcher("/viewsadmin/editinfo.jsp");
		rq.forward(req, resp);
	}

}
