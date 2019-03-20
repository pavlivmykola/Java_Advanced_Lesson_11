package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import ua.lviv.lgs.domain.Jornals;
import ua.lviv.lgs.service.JornalsService;
import ua.lviv.lgs.service.impl.JornalsServiceImpl;

@WebServlet(name = "productsServlet", description = "productsServlet", urlPatterns = { "/productsServlet" })
public class ProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private JornalsService jornalsService = JornalsServiceImpl.getJornalsServiceImpl();  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Jornals> jornals = jornalsService.readAll();
		String json = new Gson().toJson(jornals);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
	}


}
