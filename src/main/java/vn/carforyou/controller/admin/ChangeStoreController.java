package vn.carforyou.controller.admin;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vn.carforyou.model.UserModel;
import vn.carforyou.service.DealerService;
import vn.carforyou.service.impl.DealerServiceImpl;

@WebServlet(urlPatterns = { "/admin-changestore" })
public class ChangeStoreController extends HttpServlet {
	private static final long serialVersionUID = -5699177218322525001L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		if (user.getIsAdmin() == 1) {
			String did = req.getParameter("did");
			req.setAttribute("deadlerid", did);
			RequestDispatcher rq = req.getRequestDispatcher("/viewsadmin/changestore.jsp");
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
		int pass = Integer.parseInt(req.getParameter("pass"));
		int dealerID = Integer.parseInt(req.getParameter("did"));
		System.out.println(pass);
		DealerService ds = new DealerServiceImpl();
		ds.changeStore(pass, dealerID);
		resp.sendRedirect("admin-dealer?index=1");

	}

}
