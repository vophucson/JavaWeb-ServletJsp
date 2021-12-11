package vn.carforyou.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.carforyou.model.BrandModel;
import vn.carforyou.model.InfoModel;
import vn.carforyou.model.UserModel;
import vn.carforyou.service.BrandService;
import vn.carforyou.service.InfoService;
import vn.carforyou.service.UserService;
import vn.carforyou.service.impl.BrandServiceImpl;
import vn.carforyou.service.impl.InfoServiceImpl;
import vn.carforyou.service.impl.UserServiceImpl;

@WebServlet(urlPatterns = { "/register" })
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = -5695747727999039129L;
	UserService us = new UserServiceImpl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		String repass = req.getParameter("repass");
		BrandService bs = new BrandServiceImpl();
		List<BrandModel> brand = bs.getAllBrand();
		if (name.equals("") || email.equals("") || pass.equals("") || repass.equals("")) {

			req.setAttribute("brand", brand);
			req.setAttribute("mess", "Không được để trống");
			RequestDispatcher rq = req.getRequestDispatcher("/views/register.jsp");
			rq.forward(req, resp);
		} else {
			if (repass.equals(pass)) {
				UserModel user = us.chechExit(email);
				if (user == null) {

					req.setAttribute("brand", brand);
					req.setAttribute("mess", "Đăng ký thành công. Bạn có thể đăng nhập");
					us.register(name, email, pass);
					System.out.println(name);
					System.out.println(email);
					System.out.println(pass);
					RequestDispatcher rq = req.getRequestDispatcher("/views/register.jsp");
					rq.forward(req, resp);
				} else {

					req.setAttribute("brand", brand);
					req.setAttribute("mess", "Email đã có người sử dụng");
					RequestDispatcher rq = req.getRequestDispatcher("/views/register.jsp");
					rq.forward(req, resp);
				}
			} else {

				req.setAttribute("brand", brand);
				req.setAttribute("mess", "Nhập lại mật khẩu không đúng vùi lòng nhập lại");
				RequestDispatcher rq = req.getRequestDispatcher("/views/register.jsp");
				rq.forward(req, resp);
			}
		}

	}

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
		RequestDispatcher rq = req.getRequestDispatcher("/views/register.jsp");
		rq.forward(req, resp);
	}
}
