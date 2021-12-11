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
import vn.carforyou.model.ListDealerModel;
import vn.carforyou.service.BrandService;
import vn.carforyou.service.DealerService;
import vn.carforyou.service.InfoService;
import vn.carforyou.service.impl.BrandServiceImpl;
import vn.carforyou.service.impl.DealerServiceImpl;
import vn.carforyou.service.impl.InfoServiceImpl;

@WebServlet(urlPatterns = { "/dealer" })
public class DealerController extends HttpServlet {
	private static final long serialVersionUID = -5023414484441846597L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String sort = req.getParameter("sort");
		int index = Integer.parseInt(req.getParameter("index"));
		DealerService dd = new DealerServiceImpl();
		List<ListDealerModel> listD = dd.geListDealerModels(index, sort);
		int endP = dd.CountPage();
		req.setAttribute("endP", endP);
		req.setAttribute("listD", listD);
		req.setAttribute("tag", index);
		req.setAttribute("sort", sort);
		BrandService bd = new BrandServiceImpl();
		List<BrandModel> brand = bd.getAllBrand();
		req.setAttribute("brand", brand);
		InfoService ind = new InfoServiceImpl();
		InfoModel info = ind.getInfo();
		req.setAttribute("info", info);
		RequestDispatcher rq = req.getRequestDispatcher("/views/dealer.jsp");
		rq.forward(req, resp);
	}

}
