package vn.carforyou.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.carforyou.service.BrandService;
import vn.carforyou.service.impl.BrandServiceImpl;

@WebServlet(urlPatterns = { "/admin-deletebrand" })
public class DeleteBrandController extends HttpServlet {

	static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int brandID = Integer.parseInt(req.getParameter("bid"));
		BrandService bs = new BrandServiceImpl();
		bs.deleteBrand(brandID);
		resp.sendRedirect("admin-brand?index=1");
	}

}
