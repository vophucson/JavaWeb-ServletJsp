package vn.carforyou.controller.web;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet(urlPatterns = { "/product" })
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = -7595053087941290489L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		BrandService bd = new BrandServiceImpl();
		List<BrandModel> brand = bd.getAllBrand();
		req.setAttribute("brand", brand);
		InfoService ind = new InfoServiceImpl();
		InfoModel info = ind.getInfo();
		req.setAttribute("info", info);
		String type = req.getParameter("type");
		String sort = req.getParameter("sort");
		int index = Integer.parseInt(req.getParameter("index"));
		String pName = req.getParameter("pname");
		int bID = 0;
		if (req.getParameter("bid") != null) {
			bID = Integer.parseInt(req.getParameter("bid"));
		}
		ProductService pd = new ProductServiceImpl();
		int endP = 0;
		List<ProductModel> listP = new ArrayList<ProductModel>();
		endP = pd.CountPage(type, pName, bID);
		listP = pd.getListProduct(type, index, sort, pName, bID);
		req.setAttribute("endP", endP);
		req.setAttribute("listP", listP);
		req.setAttribute("tag", index);
		req.setAttribute("type", type);
		req.setAttribute("sort", sort);
		req.setAttribute("pname", pName);
		req.setAttribute("bid", bID);
		List<ProductModel> special = pd.getSpecial();
		req.setAttribute("special", special);
		RequestDispatcher rq = req.getRequestDispatcher("/views/product.jsp");
		rq.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
