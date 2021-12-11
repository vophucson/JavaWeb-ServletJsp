package vn.caforyou.controller.dealer;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.carforyou.model.BrandModel;
import vn.carforyou.model.DealerModel;
import vn.carforyou.model.InfoModel;
import vn.carforyou.model.ProductModel;
import vn.carforyou.model.UserModel;
import vn.carforyou.service.BrandService;
import vn.carforyou.service.DealerService;
import vn.carforyou.service.InfoService;
import vn.carforyou.service.ProductService;
import vn.carforyou.service.impl.BrandServiceImpl;
import vn.carforyou.service.impl.DealerServiceImpl;
import vn.carforyou.service.impl.InfoServiceImpl;
import vn.carforyou.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/store-postcar" })
public class PostCarController extends HttpServlet {
	private static final long serialVersionUID = 5095457158124884890L;
	InfoService ind = new InfoServiceImpl();
	InfoModel info = ind.getInfo();
	BrandService bs = new BrandServiceImpl();
	List<BrandModel> brand = bs.getAllBrand();
	DealerService ds = new DealerServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		req.setAttribute("tag", 4);
		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		req.setAttribute("user", user);
		req.setAttribute("brand", brand);
		req.setAttribute("info", info);
		if (user != null) {
			DealerModel dInfo = ds.getDealerInfobyid(user.getUserId());
			req.setAttribute("dinfo", dInfo);
			String mess = req.getParameter("mess");
			if (mess != null) {
				if(mess.equals("1"))
				{
					req.setAttribute("mess", "không được để trống tên xe");
				}
				if(mess.equals("2"))
				{
					req.setAttribute("mess", "không được để trống giá xe");
				}
				if(mess.equals("3"))
				{
					req.setAttribute("mess", "không được để trống thương hiệu");
				}
				if(mess.equals("4"))
				{
					req.setAttribute("mess", "không được để trống tổng Km đã đi");
				}
				if(mess.equals("5"))
				{
					req.setAttribute("mess", "không được để trống động cơ");
				}
				if(mess.equals("6"))
				{
					req.setAttribute("mess", "không được để trống năm sản xuất");
				}
				if(mess.equals("7"))
				{
					req.setAttribute("mess", "không được để trống loại nhiên liệu");
				}
				if(mess.equals("8"))
				{
					req.setAttribute("mess", "không được để trống Hộp số");
				}
				if(mess.equals("9"))
				{
					req.setAttribute("mess", "không được để trống chỗ ngồi");
				}
				if(mess.equals("10"))
				{
					req.setAttribute("mess", "không được để trống khu vực");
				}
				if(mess.equals("11"))
				{
					req.setAttribute("mess", "không được để trống chi tiết về xe");
				}
				if(mess.equals("12"))
				{
					req.setAttribute("mess", "không được để trống Hình ảnh");
				}
				if(mess.equals("13"))
				{
					req.setAttribute("mess", "không được để trống loại xe");
				}
				if(mess.equals("14"))
				{
					req.setAttribute("mess", "Đăng bài thành công.Vui lòng đợi người quản trị duyệt bài");
				}
				
			}
			RequestDispatcher rq = req.getRequestDispatcher("/views/storepostcar.jsp");
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
		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// Configure a repository ( to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);
		ProductModel product = new ProductModel();
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(req);
			 boolean New = true;
			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					System.out.println(name);
					System.out.println(value);
					if (name.equals("productname")) {
						if (value.equals("") || value.equals(null)) {
							resp.sendRedirect("store-postcar?mess=1");
							New = false;
							break;
						} else {
							product.setpName(value);
						}
					}
					if (name.equals("price")) {
						if (value.equals("") || value.equals(null)) {
							resp.sendRedirect("store-postcar?mess=2");
							New = false;
							break;
						}
						else
						{
							product.setPrice(new BigDecimal(value));
						}
					}
					if (name.equals("brandid")) {
						if (value.equals("0")) {
							resp.sendRedirect("store-postcar?mess=3");
							New = false;
							break;
						}
						else
						{
							BrandModel brand = new BrandModel();
							brand.setBrandId(Integer.parseInt(value));
							product.setBrand(brand);
						}
					}
					if (name.equals("totalkm")) {
						if (value.equals("") || value.equals(null)) {
							resp.sendRedirect("store-postcar?mess=4");
							New = false;
							break;
						}
						else
						{
							product.setTotalKm(Integer.parseInt(value));
						}
					}
					if (name.equals("engine")) {
						if (value.equals("") || value.equals(null)) {
							resp.sendRedirect("store-postcar?mess=5");
							New = false;
							break;

						}
						else
						{
							product.setEngine(Integer.parseInt(value));
						}
					}
					if (name.equals("yearmodel")) {
						if (value.equals("") || value.equals(null)) {
							resp.sendRedirect("store-postcar?mess=6");
							New = false;
							break;

						}
						else
						{
							product.setYearModel(Integer.parseInt(value));
						}
					}
					if (name.equals("fueltype")) {
						if (value.equals("0")) {
							resp.sendRedirect("store-postcar?mess=7");
							New = false;
							break;
						}
						else
						{
							product.setFuelType(value);
						}
					}
					if (name.equals("transmission")) {
						if (value.equals("0")) {
							resp.sendRedirect("store-postcar?mess=8");
							New = false;
							break;
						}
						else
						{
							product.setTransmission(value);;
						}
					}
					if (name.equals("seats")) {
						if (value.equals("") || value.equals(null)) {
							resp.sendRedirect("store-postcar?mess=9");
							New = false;
							break;
						}
						else
						{
							product.setSeats(Integer.parseInt(value));
						}
					}
					if (name.equals("localtion")) {
						if (value.equals("0")) {
							resp.sendRedirect("store-postcar?mess=10");
							New = false;
							break;
						}
						else
						{
							product.setLocaltion(value);
						}
					}
					if (name.equals("description")) {
						if (value.equals("") || value.equals(null)) {
							resp.sendRedirect("store-postcar?mess=11");
							New = false;
							break;
						}
						else
						{
							product.setDes(value);
						}
						
					}
					if(name.equals("typecar"))
					{
						product.setTypeCar(value);
					}
				} else {
					String filename = item.getName();
					if (filename.equals(null) || filename.equals("")) {
						resp.sendRedirect("store-postcar?mess=12");
						New = false;
						break;
					} else {
						System.out.println(filename);
						String storePath = servletContext.getRealPath("/uploads/product");
						int index = filename.lastIndexOf(".");
						String ext = filename.substring(index + 1);
						String fname = filename.substring(0,index -1); 
						String newName = System.currentTimeMillis() + "_" + fname + "." + ext;
						File file = new File(storePath + "/" + newName);
						item.write(file);
						System.out.println(storePath);
						product.setImage(newName);
					}
				}
			}
			if(New == true)
			{
				if(product.getTypeCar() == null)
				{
					resp.sendRedirect("store-postcar?mess=13");
				}
				else
				{
					DealerModel dealer = new DealerModel();
					dealer.setDealerId(user.getUserId());
					product.setDealer(dealer);
					ProductService ps = new ProductServiceImpl();
					ps.insertProduct(product);
					resp.sendRedirect("store-postcar?mess=14");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
