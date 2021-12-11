package vn.carforyou.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.carforyou.service.DealerService;
import vn.carforyou.service.impl.DealerServiceImpl;

@WebServlet(urlPatterns = { "/admin-deletedealer" })
public class DeleteDealerController extends HttpServlet {
	private static final long serialVersionUID = 1567766104159983520L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int dealerID = Integer.parseInt(req.getParameter("did"));
		DealerService ds = new DealerServiceImpl();
		ds.deleteDealer(dealerID);
		resp.sendRedirect("admin-dealer?index=1");
	}
}
