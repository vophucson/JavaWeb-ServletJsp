package vn.carforyou.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.carforyou.model.BrandModel;
import vn.carforyou.model.InfoModel;
import vn.carforyou.service.BrandService;
import vn.carforyou.service.InfoService;
import vn.carforyou.service.impl.BrandServiceImpl;
import vn.carforyou.service.impl.InfoServiceImpl;

@WebServlet(urlPatterns = { "/404" })
public class ErrorController extends HttpServlet {
	private static final long serialVersionUID = -757323010638521997L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		BrandService bs = new BrandServiceImpl();
		List<BrandModel> brand = bs.getAllBrand();
		req.setAttribute("brand", brand);
		InfoService ind = new InfoServiceImpl();
		InfoModel info = ind.getInfo();
		req.setAttribute("info", info);
		RequestDispatcher rq = req.getRequestDispatcher("/views/404.jsp");
		rq.forward(req, resp);
	}

}
