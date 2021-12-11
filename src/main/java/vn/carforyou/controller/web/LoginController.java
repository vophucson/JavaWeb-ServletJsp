package vn.carforyou.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.carforyou.model.BrandModel;
import vn.carforyou.model.InfoModel;
import vn.carforyou.model.UserModel;
import vn.carforyou.service.BrandService;
import vn.carforyou.service.InfoService;
import vn.carforyou.service.UserService;
import vn.carforyou.service.impl.BrandServiceImpl;
import vn.carforyou.service.impl.InfoServiceImpl;
import vn.carforyou.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 7553683779016932144L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		BrandService bs = new BrandServiceImpl();
		List<BrandModel> brand = bs.getAllBrand();
		req.setAttribute("brand", brand);
		InfoService ind = new InfoServiceImpl();
		InfoModel info = ind.getInfo();
		req.setAttribute("info", info);
		RequestDispatcher rq = req.getRequestDispatcher("/views/login.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		BrandService bs = new BrandServiceImpl();
		List<BrandModel> brand = bs.getAllBrand();
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		UserService us = new UserServiceImpl();
		InfoService ind = new InfoServiceImpl();
		InfoModel info = ind.getInfo();
		if (email.equals("") || pass.equals("")) {
			req.setAttribute("brand", brand);
			req.setAttribute("info", info);
			req.setAttribute("mess", "Không được để trống");
			RequestDispatcher rq = req.getRequestDispatcher("/views/login.jsp");
			rq.forward(req, resp);
		} else {
			UserModel user = us.login(email, pass);
			if (user == null) {
				resp.setContentType("text/htm");
				resp.setCharacterEncoding("UTF-8");
				req.setCharacterEncoding("UTF-8");
				req.setAttribute("brand", brand);
				req.setAttribute("info", info);
				req.setAttribute("mess", "Sai địa chỉ email hoặc mật khẩu");
				RequestDispatcher rq = req.getRequestDispatcher("/views/login.jsp");
				rq.forward(req, resp);
			} else {
				HttpSession session = req.getSession();
				session.setAttribute("user", user);
				if (user.getIsAdmin() == 1) {
					resp.sendRedirect("admin-home");

				} else {
					resp.sendRedirect("home");
				}

			}
		}

	}
}
