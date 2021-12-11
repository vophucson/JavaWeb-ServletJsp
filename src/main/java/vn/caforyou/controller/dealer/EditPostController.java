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
import vn.carforyou.model.InfoModel;
import vn.carforyou.model.ProductModel;
import vn.carforyou.model.UserModel;
import vn.carforyou.service.BrandService;
import vn.carforyou.service.InfoService;
import vn.carforyou.service.ProductService;
import vn.carforyou.service.impl.BrandServiceImpl;
import vn.carforyou.service.impl.InfoServiceImpl;
import vn.carforyou.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/store-editpost" })
public class EditPostController extends HttpServlet {
	private static final long serialVersionUID = 2492281738295213417L;
	InfoService ind = new InfoServiceImpl();
	InfoModel info = ind.getInfo();
	BrandService bs = new BrandServiceImpl();
	List<BrandModel> brand = bs.getAllBrand();
	ProductService ps = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		int productID = Integer.parseInt(req.getParameter("pid"));
		ProductModel detail = ps.getProductDetail(productID);
		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		if (user.getUserId() == detail.getDealer().getDealerId()) {
			req.setAttribute("detail", detail);
			req.setAttribute("fprice", detail.getPrice().toBigInteger());
			req.setAttribute("brand", brand);
			req.setAttribute("info", info);
			req.setAttribute("pid", productID);
			String mess = req.getParameter("mess");
			if (mess != null) {
				if (mess.equals("1")) {
					req.setAttribute("mess", "không được để trống tên xe");
				}
				if (mess.equals("2")) {
					req.setAttribute("mess", "không được để trống giá xe");
				}
				if (mess.equals("3")) {
					req.setAttribute("mess", "không được để trống tổng Km đã đi");
				}
				if (mess.equals("4")) {
					req.setAttribute("mess", "không được để trống động cơ");
				}
				if (mess.equals("5")) {
					req.setAttribute("mess", "không được để trống năm sản xuất");
				}
				if (mess.equals("6")) {
					req.setAttribute("mess", "không được để trống chi tiết về xe");
				}
				if (mess.equals("7")) {
					req.setAttribute("mess", "Cập nhật thông tin bài đăng thành công");
				}
				if (mess.equals("8")) {
					req.setAttribute("mess", "Không được để trống chỗ ngồi");
				}
			}
			RequestDispatcher rq = req.getRequestDispatcher("/views/editpostcar.jsp");
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
		String pid = "";
		String oldImage = "";
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
					if (name.equals("pid")) {
						pid = value;
					}
					if (name.equals("productname")) {
						if (value.equals("") || value.equals(null)) {
							resp.sendRedirect("store-editpost?mess=1" + "&&pid=" + pid);
							New = false;
							break;
						} else {
							product.setpName(value);
						}
					}
					if (name.equals("price")) {
						if (value.equals("") || value.equals(null)) {
							resp.sendRedirect("store-editpost?mess=2" + "&&pid=" + pid);
							New = false;
							break;
						} else {
							product.setPrice(new BigDecimal(value));
						}
					}
					if (name.equals("brandid")) {
						BrandModel brand = new BrandModel();
						brand.setBrandId(Integer.parseInt(value));
						product.setBrand(brand);
					}
					if (name.equals("totalkm")) {
						if (value.equals("") || value.equals(null)) {
							resp.sendRedirect("store-editpost?mess=3" + "&&pid=" + pid);
							New = false;
							break;
						} else {
							product.setTotalKm(Integer.parseInt(value));
						}
					}
					if (name.equals("engine")) {
						if (value.equals("") || value.equals(null)) {
							resp.sendRedirect("store-editpost?mess=4" + "&&pid=" + pid);
							New = false;
							break;

						} else {
							product.setEngine(Integer.parseInt(value));
						}
					}
					if (name.equals("yearmodel")) {
						if (value.equals("") || value.equals(null)) {
							resp.sendRedirect("store-editpost?mess=5" + "&&pid=" + pid);
							New = false;
							break;

						} else {
							product.setYearModel(Integer.parseInt(value));
						}
					}
					if (name.equals("fueltype")) {
						product.setFuelType(value);
						;
					}
					if (name.equals("transmission")) {
						product.setTransmission(value);
					}
					if (name.equals("seats")) {
						if (value.equals("") || value.equals(null)) {
							resp.sendRedirect("store-editpost?mess=8" + "&&pid=" + pid);
							New = false;
							break;
						} else {
							product.setSeats(Integer.parseInt(value));
						}
					}
					if (name.equals("localtion")) {
						product.setLocaltion(value);
					}
					if (name.equals("description")) {
						if (value.equals("") || value.equals(null)) {
							resp.sendRedirect("store-editpost?mess=6" + "&&pid=" + pid);
							New = false;
							break;
						} else {
							product.setDes(value);
						}

					}
					if (name.equals("typecar")) {
						product.setTypeCar(value);
					}
					if (name.equals("oldimage")) {
						oldImage = value;
					}
				} else {
					String filename = item.getName();
					if (filename.equals(null) || filename.equals("")) {
						product.setImage(oldImage);
					} else {
						System.out.println(filename);
						String storePath = servletContext.getRealPath("/uploads/product");
						int index = filename.lastIndexOf(".");
						String ext = filename.substring(index + 1);
						String fname = filename.substring(0, index - 1);
						String newName = System.currentTimeMillis() + "_" + fname + "." + ext;
						File file = new File(storePath + "/" + newName);
						item.write(file);
						product.setImage(newName);
					}
				}
			}
			if (New == true) {
				product.setProductId(Integer.parseInt(pid));
				ps.editPost(product);
				resp.sendRedirect("store-editpost?mess=7" + "&&pid=" + pid);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
