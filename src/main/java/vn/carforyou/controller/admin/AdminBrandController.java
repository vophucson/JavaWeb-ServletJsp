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

import vn.carforyou.model.BrandModel;
import vn.carforyou.model.UserModel;
import vn.carforyou.service.BrandService;
import vn.carforyou.service.impl.BrandServiceImpl;

@WebServlet(urlPatterns = { "/admin-brand" })
public class AdminBrandController extends HttpServlet {
	private static final long serialVersionUID = -7286716036930831911L;
	BrandService bs = new BrandServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		if (user.getIsAdmin() == 1) {
			int endP = bs.countPageBrand();
			req.setAttribute("endP", endP);
			int index = Integer.parseInt(req.getParameter("index"));
			List<BrandModel> list = bs.listBrandAdmin(index);
			req.setAttribute("list", list);
			req.setAttribute("tag", index);
			String mess = req.getParameter("mess");
			if (mess != null && mess != "") {
				if (mess.equals("1")) {
					req.setAttribute("mess", "Không được để trống tên thương hiệu");
				}
				if (mess.equals("2")) {
					req.setAttribute("mess", "Không được để trống logo thương hiệu");
				}
				if (mess.equals("3")) {
					req.setAttribute("mess", "Thêm thương hiệu thành công");
				}
			}
			// req.setAttribute("mess", "Không được để trống");
			RequestDispatcher rq = req.getRequestDispatcher("/viewsadmin/brand.jsp");
			rq.forward(req, resp);
		} else {
			resp.sendRedirect("404");
		}
	}
}
