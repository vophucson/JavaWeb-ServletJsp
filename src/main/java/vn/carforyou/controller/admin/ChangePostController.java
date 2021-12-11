package vn.carforyou.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.carforyou.service.ProductService;
import vn.carforyou.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/admin-changepost" })
public class ChangePostController extends HttpServlet {
	private static final long serialVersionUID = -2141226453148696459L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int isPass = Integer.parseInt(req.getParameter("pass"));
		int productID = Integer.parseInt(req.getParameter("pid"));
		ProductService ps = new ProductServiceImpl();
		ps.changePass(isPass, productID);
		if (isPass == 1) {
			resp.sendRedirect("admin-postcarpass?index=1");
		} else {
			resp.sendRedirect("admin-postcarnopass?index=1");
		}
	}

}
