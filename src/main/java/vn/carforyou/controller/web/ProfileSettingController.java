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

@WebServlet(urlPatterns = { "/profile-setting" })
public class ProfileSettingController extends HttpServlet {
	private static final long serialVersionUID = 4614403887311698495L;
	InfoService ind = new InfoServiceImpl();
	InfoModel info = ind.getInfo();
	BrandService bs = new BrandServiceImpl();
	List<BrandModel> brand = bs.getAllBrand();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		req.setAttribute("user", user);
		req.setAttribute("brand", brand);
		req.setAttribute("info", info);
		req.setAttribute("tag", 1);
		if (user != null) {
			RequestDispatcher rq = req.getRequestDispatcher("/views/profilesetting.jsp");
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
		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		String oldpass = req.getParameter("oldpass");
		String newpass = req.getParameter("newpass");
		String confrim = req.getParameter("confrim");
		UserService us = new UserServiceImpl();
		if (newpass.equals(confrim)) {
			if (user.getPassword().equals(oldpass)) {
				us.oldPassword(newpass, user.getUserId());
				req.setAttribute("mess", "Thay đổi mật khẩu thành công");

			} else {
				req.setAttribute("mess", "Mật khẩu cũ không đúng");
			}
		} else {
			req.setAttribute("mess", "Mật khẩu xác nhận không đúng");
		}
		req.setAttribute("user", user);
		req.setAttribute("brand", brand);
		req.setAttribute("info", info);
		RequestDispatcher rq = req.getRequestDispatcher("/views/profilesetting.jsp");
		rq.forward(req, resp);
	}

}
