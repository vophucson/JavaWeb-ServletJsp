package vn.carforyou.controller.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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

@WebServlet(urlPatterns = { "/save" })
public class SaveController extends HttpServlet {
	private static final long serialVersionUID = 1697303804035804973L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		Cookie arr[] = req.getCookies();
		ProductService pd = new ProductServiceImpl();
		List<ProductModel> list = new ArrayList<ProductModel>();
		for (Cookie o : arr) {
			if (o.getName().equals("id")) {
				System.out.println(o.getValue());
				String txt[] = o.getValue().split("x");
				for (String s : txt) {
					list.add(pd.getProductbyID(s));
				}
			}
		}
		req.setAttribute("list", list);
		BrandService bd = new BrandServiceImpl();
		List<BrandModel> brand = bd.getAllBrand();
		req.setAttribute("brand", brand);
		InfoService ind = new InfoServiceImpl();
		InfoModel info = ind.getInfo();
		req.setAttribute("info", info);
		RequestDispatcher rq = req.getRequestDispatcher("/views/save.jsp");
		rq.forward(req, resp);
	}

}
