package vn.carforyou.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import vn.carforyou.service.BrandService;
import vn.carforyou.service.impl.BrandServiceImpl;

@WebServlet(urlPatterns = { "/admin-createbrand" })
public class CreateBrandController extends HttpServlet {
	private static final long serialVersionUID = -2682758450846140223L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String brandName = "";
		String icon = "";
		// Create a factory for disk-based file items
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Parse the request
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
					if (name.equals("name")) {
						if (value.equals(null) || value.equals("")) {
							resp.sendRedirect("admin-brand?index=1&&mess=1");
							break;

						} else {
							brandName = value;
						}
					}
					if (name.equals("icon")) {
						resp.sendRedirect("admin-brand?index=1&&mess=2");
						break;
					}
				} else {
					String filename = item.getName();

					if (filename.equals(null) || filename.equals("")) {
						resp.sendRedirect("admin-brand?index=1&&mess=2");
						break;
					} else {
						String storePath = servletContext.getRealPath("/uploads/brand");
						int index = filename.lastIndexOf(".");
						String ext = filename.substring(index + 1);
						String fname = filename.substring(0, index);
						String newName = System.currentTimeMillis() + "_" + fname + "." + ext;
						File file = new File(storePath + "/" + newName);
						item.write(file);
						icon = newName;

					}

				}
			}
			if ((brandName != null || brandName != "") && (icon != null && icon != "")) {
				System.out.println(brandName);
				BrandService bs = new BrandServiceImpl();
				bs.createBrand(brandName, icon);
				resp.sendRedirect("admin-brand?index=1&&mess=3");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
