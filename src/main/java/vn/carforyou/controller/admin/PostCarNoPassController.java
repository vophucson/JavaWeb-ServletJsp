package vn.carforyou.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.carforyou.model.ProductModel;
import vn.carforyou.model.UserModel;
import vn.carforyou.service.ProductService;
import vn.carforyou.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/admin-postcarnopass" })
public class PostCarNoPassController extends HttpServlet {
	private static final long serialVersionUID = 6615192291086614783L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		ProductService ps = new ProductServiceImpl();
		if (user.getIsAdmin() == 1) {
			int endP = ps.countPageNoPassCar();
			req.setAttribute("endP", endP);
			int index = Integer.parseInt(req.getParameter("index"));
			req.setAttribute("tag", index);
			List<ProductModel> list = ps.listPostCarNoPass(index);
			req.setAttribute("list", list);
			RequestDispatcher rq = req.getRequestDispatcher("/viewsadmin/postcarnopass.jsp");
			rq.forward(req, resp);
		} else {
			resp.sendRedirect("404");
		}
	}

}
