package vn.caforyou.controller.dealer;

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
import vn.carforyou.model.ProductModel;
import vn.carforyou.model.UserModel;
import vn.carforyou.service.BrandService;
import vn.carforyou.service.InfoService;
import vn.carforyou.service.ProductService;
import vn.carforyou.service.impl.BrandServiceImpl;
import vn.carforyou.service.impl.InfoServiceImpl;
import vn.carforyou.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/store-listcar" })
public class ListCarController extends HttpServlet {
	private static final long serialVersionUID = -898283173876749071L;
	InfoService ind = new InfoServiceImpl();
	InfoModel info = ind.getInfo();
	BrandService bs = new BrandServiceImpl();
	List<BrandModel> brand = bs.getAllBrand();
	ProductService ps = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("tag", 3);
		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		req.setAttribute("user", user);
		req.setAttribute("brand", brand);
		req.setAttribute("info", info);
		if (user != null) {

			int count = ps.countPost(user.getUserId());
			req.setAttribute("count", count);
			int endP = 0;
			endP = count / 6;
			if (count % 6 != 0 && count > 6) {
				endP++;
			}
			if (count < 6) {
				endP = 1;
			}
			req.setAttribute("endP", endP);
			int index = Integer.parseInt(req.getParameter("index"));
			req.setAttribute("tagindex", index);
			List<ProductModel> list = ps.getPostbyDealer(index, user.getUserId());
			req.setAttribute("list", list);
			RequestDispatcher rq = req.getRequestDispatcher("/views/storelistcar.jsp");
			rq.forward(req, resp);
		} else {
			resp.sendRedirect("404");
		}

	}

}
