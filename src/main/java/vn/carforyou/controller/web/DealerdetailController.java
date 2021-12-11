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
import vn.carforyou.model.DealerModel;
import vn.carforyou.model.InfoModel;
import vn.carforyou.model.ProductModel;
import vn.carforyou.service.BrandService;
import vn.carforyou.service.DealerService;
import vn.carforyou.service.InfoService;
import vn.carforyou.service.impl.BrandServiceImpl;
import vn.carforyou.service.impl.DealerServiceImpl;
import vn.carforyou.service.impl.InfoServiceImpl;

@WebServlet(urlPatterns = { "/dealerdetail" })
public class DealerdetailController extends HttpServlet {
	private static final long serialVersionUID = -5046993834222155133L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int dealerID = Integer.parseInt(req.getParameter("dealerid"));
		DealerService dd = new DealerServiceImpl();
		DealerModel dDetail = dd.getDealerDetail(dealerID);
		int endP = dd.CountPageDetail(dealerID);
		req.setAttribute("detail", dDetail);
		req.setAttribute("endP", endP);
		int index = Integer.parseInt(req.getParameter("index"));
		req.setAttribute("tag", index);
		List<ProductModel> listP = dd.getProductbyDealer(index, dealerID);
		req.setAttribute("listP", listP);
		InfoService ind = new InfoServiceImpl();
		InfoModel info = ind.getInfo();
		req.setAttribute("info", info);
		BrandService bs = new BrandServiceImpl();
		List<BrandModel> brand = bs.getAllBrand();
		req.setAttribute("brand", brand);
		RequestDispatcher rq = req.getRequestDispatcher("/views/dealerdetail.jsp");
		rq.forward(req, resp);
	}
}
