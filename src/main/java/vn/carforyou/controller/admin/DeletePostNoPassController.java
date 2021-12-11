package vn.carforyou.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.carforyou.service.ProductService;
import vn.carforyou.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/admin-deletepostnopass" })
public class DeletePostNoPassController extends HttpServlet {
	private static final long serialVersionUID = -5096493479832667225L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int productID = Integer.parseInt(req.getParameter("pid"));
		ProductService ps = new ProductServiceImpl();
		ps.deleteProduct(productID);
		resp.sendRedirect("admin-postcarnopass?index=1");
	}

}
