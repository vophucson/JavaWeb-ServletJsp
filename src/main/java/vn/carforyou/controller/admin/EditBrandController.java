package vn.carforyou.controller.admin;

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
import vn.carforyou.model.UserModel;
import vn.carforyou.service.BrandService;
import vn.carforyou.service.impl.BrandServiceImpl;

@WebServlet(urlPatterns = { "/admin-editbrand" })
public class EditBrandController extends HttpServlet {
	private static final long serialVersionUID = -7293087819593418436L;
	BrandService bs = new BrandServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		HttpSession session = req.getSession();
		UserModel user = (UserModel) session.getAttribute("user");
		String brandID = req.getParameter("bid");
		if (user.getIsAdmin() == 1) {
			BrandModel brand = bs.getBarndbyid(brandID);
			req.setAttribute("brand", brand);
			String mess = req.getParameter("mess");
			if (mess != null) {
				if (mess.equals("1")) {
					req.setAttribute("mess", "Không được để trống tên thương hiệu");
				}
				if (mess.equals("2")) {
					req.setAttribute("mess", "Cập nhật thương hiệu thành công");
				}
			}
			RequestDispatcher rq = req.getRequestDispatcher("/viewsadmin/editbrand.jsp");
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
		int brandId = 0;
		String oldIcon = "";
		BrandModel brand = new BrandModel();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// Configure a repository ( to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> items = upload.parseRequest(req);
			boolean New = false;
			// Process the uploaded items
			Iterator<FileItem> iter = items.iterator();
			while (iter.hasNext()) {
				FileItem item = iter.next();
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("UTF-8");
					if (name.equals("bid")) {
						brand.setBrandId(Integer.parseInt(value));
						brandId = Integer.parseInt(value);
					}
					if (name.equals("oldicon")) {
						oldIcon = value;
					}
					if (name.equals("icon")) {
						brand.setIcon(oldIcon);
						New = true;

					}
					if (name.equals("name")) {
						if (value.equals(null) || value.equals("")) {
							New = false;
							resp.sendRedirect("admin-editbrand?bid=" + brandId + "&&mess=1");
							break;
						} else {
							brand.setBrandName(value);
						}

					}

				} else {
					String filename = item.getName();
					if (filename.equals(null) || filename.equals("")) {
						brand.setIcon(oldIcon);
						New = true;

					} else {
						New = true;
						String storePath = servletContext.getRealPath("/uploads/brand");
						int index = filename.lastIndexOf(".");
						String ext = filename.substring(index + 1);
						String fname = filename.substring(0, index);
						String newName = System.currentTimeMillis() + "_" + fname + "." + ext;
						File file = new File(storePath + "/" + newName);
						item.write(file);
						brand.setIcon(newName);
					}
				}
			}
			if (New == true) {
				bs.editBrand(brand);
				resp.sendRedirect("admin-editbrand?bid=" + brandId + "&&mess=2");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
