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

import vn.carforyou.model.DealerAdminModel;
import vn.carforyou.model.UserModel;
import vn.carforyou.service.DealerService;
import vn.carforyou.service.impl.DealerServiceImpl;

@WebServlet(urlPatterns = { "/admin-dealer" })
public class AdminDealerController extends HttpServlet {
	private static final long serialVersionUID = -1706409687282844754L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		DealerService ds = new DealerServiceImpl();
		if (user.getIsAdmin() == 1) {
			int endP = ds.CountPageAdmin();
			req.setAttribute("endP", endP);
			int index = Integer.parseInt(req.getParameter("index"));
			req.setAttribute("tag", index);
			List<DealerAdminModel> list = ds.listDealerAdmin(index);
			req.setAttribute("list", list);
			RequestDispatcher rq = req.getRequestDispatcher("/viewsadmin/dealer.jsp");
			rq.forward(req, resp);
		} else {
			resp.sendRedirect("404");
		}
	}

}
