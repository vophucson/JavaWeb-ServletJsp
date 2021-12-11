package vn.caforyou.controller.dealer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.carforyou.service.ProductService;
import vn.carforyou.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/store-deletepost" })
public class DeletePostController extends HttpServlet {
	private static final long serialVersionUID = 209777063945294094L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int productID = Integer.parseInt(req.getParameter("pid"));
		ProductService ps = new ProductServiceImpl();
		ps.deleteProduct(productID);
		resp.sendRedirect("store-listcar?index=1");
	}

}
