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
import vn.carforyou.model.ProductModel;
import vn.carforyou.service.BrandService;
import vn.carforyou.service.InfoService;
import vn.carforyou.service.ProductService;
import vn.carforyou.service.impl.BrandServiceImpl;
import vn.carforyou.service.impl.InfoServiceImpl;
import vn.carforyou.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/productdetail" })
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 155964309014396934L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int productID = Integer.parseInt(req.getParameter("pid"));
		ProductService pd = new ProductServiceImpl();
		ProductModel detail = pd.getProductDetail(productID);
		req.setAttribute("detail", detail);
		BrandService bd = new BrandServiceImpl();
		List<BrandModel> brand = bd.getAllBrand();
		req.setAttribute("brand", brand);
		InfoService ind = new InfoServiceImpl();
		InfoModel info = ind.getInfo();
		req.setAttribute("info", info);
		List<ProductModel> top4 = pd.getTop4car(detail.getDealer().getDealerId());
		req.setAttribute("top4", top4);
		RequestDispatcher rq = req.getRequestDispatcher("/views/productdetail.jsp");
		rq.forward(req, resp);
	}
}
