package vn.caforyou.controller.dealer;

import java.io.File;
import java.io.IOException;
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
import vn.carforyou.model.UserModel;
import vn.carforyou.service.BrandService;
import vn.carforyou.service.DealerService;
import vn.carforyou.service.InfoService;
import vn.carforyou.service.impl.BrandServiceImpl;
import vn.carforyou.service.impl.DealerServiceImpl;
import vn.carforyou.service.impl.InfoServiceImpl;

@WebServlet(urlPatterns = { "/store-setting" })
public class StoreSettingController extends HttpServlet {
	private static final long serialVersionUID = -3488863957083761476L;
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
		req.setAttribute("tag", 2);
		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		req.setAttribute("user", user);
		req.setAttribute("brand", brand);
		req.setAttribute("info", info);
		if (user.getIsDealer() == 1) {
			DealerModel dInfo = ds.getDealerInfobyid(user.getUserId());
			req.setAttribute("dInfo", dInfo);
			String mess = req.getParameter("mess");
			if (mess != null) {
				if (mess.equals("1")) {
					req.setAttribute("mess", "Không được để trống tên cửa hàng");
				}
				if (mess.equals("2")) {
					req.setAttribute("mess", "Không được để trống email cửa hàng");
				}
				if (mess.equals("3")) {
					req.setAttribute("mess", "Không được để trống số điện thoại cửa hàng");
				}
				if (mess.equals("4")) {
					req.setAttribute("mess", "Không được để trống giới thiệu cửa hàng");
				}
				if (mess.equals("5")) {
					req.setAttribute("mess", "Không được để trống địa chỉ cửa hàng");
				}
				if (mess.equals("6")) {
					req.setAttribute("mess", "Không được để trống ảnh đại diện");
				}
				if (mess.equals("7")) {
					req.setAttribute("mess", "Tạo cửa hàng thành công");
				}
				if (mess.equals("8")) {
					req.setAttribute("mess", "Cập nhật cửa hàng thành công");
				}
			}
			RequestDispatcher rq = req.getRequestDispatcher("/views/storesetting.jsp");
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
		boolean pass = true;
		DealerModel dealer = new DealerModel();
		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		DealerModel dInfo = ds.getDealerInfobyid(user.getUserId());
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// Configure a repository ( to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(req);
			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					System.out.println(name);
					System.out.println(value);
					if (name.equals("dname")) {
						if (value.equals(null) || value.equals("")) {
							resp.sendRedirect("store-setting?mess=1");
							pass = false;
							break;
						} else {
							dealer.setdName(value);
						}
					}
					if (name.equals("demail")) {
						if (value.equals(null) || value.equals("")) {
							resp.sendRedirect("store-setting?mess=2");
							pass = false;
							break;
						} else {
							dealer.setdEmail(value);
						}
					}
					if (name.equals("dphone")) {
						if (value.equals(null) || value.equals("")) {
							resp.sendRedirect("store-setting?mess=3");
							pass = false;
							break;
						} else {
							dealer.setdPhone(value);
						}
					}
					if (name.equals("dinfo")) {
						if (value.equals(null) || value.equals("")) {
							resp.sendRedirect("store-setting?mess=4");
							pass = false;
							break;
						} else {
							dealer.setdInfo(value);
						}
					}
					if (name.equals("address")) {
						if (value.equals(null) || value.equals("")) {
							resp.sendRedirect("store-setting?mess=5");
							pass = false;
							break;
						} else {
							dealer.setdAddress(value);
						}
					}

				} else {
					String filename = item.getName();
					if (filename.equals(null) || filename.equals("")) {
						if (dInfo == null) {
							resp.sendRedirect("store-setting?mess=6");
							pass = false;
							break;
						} else {
							dealer.setdImage(dInfo.getdImage());
						}
					} else {
						String storePath = servletContext.getRealPath("/uploads/store");
						int index = filename.lastIndexOf(".");
						String ext = filename.substring(index + 1);
						String fname = filename.substring(0, index - 1);
						String newName = System.currentTimeMillis() + "_" + fname + "." + ext;
						File file = new File(storePath + "/" + newName);
						item.write(file);
						dealer.setdImage(newName);
						System.out.println(filename);
					}
				}
			}
			if (pass == true) {
				dealer.setDealerId(user.getUserId());
				if (dInfo == null) {
					ds.createStore(dealer);
					resp.sendRedirect("store-setting?mess=7");
				} else {
					ds.editStore(dealer);
					resp.sendRedirect("store-setting?mess=8");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
