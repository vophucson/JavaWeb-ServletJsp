package vn.carforyou.controller.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/removec" })
public class RemoveCookiesController extends HttpServlet {
	private static final long serialVersionUID = -5746928455710845558L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/htm");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("pid");
		Cookie arr[] = req.getCookies();
		String txt = "";
		for (Cookie o : arr) {
			if (o.getName().equals("id")) {
				txt = txt + o.getValue();
				o.setMaxAge(0);
				resp.addCookie(o);
			}
		}
		String ids[] = txt.split("x");
		String txtOutPut = "";
		for (int i = 0; i < ids.length; i++) {
			if (!ids[i].equals(id)) {
				if (txtOutPut.isEmpty()) {
					txtOutPut = ids[i];
				} else {
					txtOutPut = txtOutPut + "x" + ids[i];
				}
			}
		}
		if (!txtOutPut.isEmpty()) {
			Cookie c = new Cookie("id", txtOutPut);
			c.setMaxAge(60 * 60 * 24 * 30);
			resp.addCookie(c);
		}
		resp.sendRedirect("save");
	}

}
