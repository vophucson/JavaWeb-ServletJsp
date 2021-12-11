package vn.carforyou.controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/add" })
public class AddCookiesController extends HttpServlet {
	private static final long serialVersionUID = -3114027433208475377L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("pid");
		System.out.println(id);
		Cookie arr[] = req.getCookies();
		String txt = "";
		for (Cookie o : arr) {
			if (o.getName().equals("id")) {
				txt = txt + o.getValue();
				o.setMaxAge(0);
				resp.addCookie(o);
			}
		}
		if (txt.isEmpty()) {
			txt = id;
		} else {
			String ids[] = txt.split("x");
			boolean check = true;
			for (int i = 0; i < ids.length; i++) {
				if (ids[i].equals(id)) {
					check = false;
				}
			}
			if(check == true)
			{
				txt = txt + "x" + id;
			}
		}
		Cookie c = new Cookie("id", txt);
		c.setMaxAge(60 * 60 * 24 * 30);
		resp.addCookie(c);
		resp.sendRedirect("save");
	}

}
