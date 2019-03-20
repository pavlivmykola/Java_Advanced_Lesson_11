package ua.lviv.lgs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.lgs.domain.Jornals;
import ua.lviv.lgs.service.JornalsService;
import ua.lviv.lgs.service.impl.JornalsServiceImpl;

@WebServlet("/Periodical")
public class JornalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JornalsService jornalService = JornalsServiceImpl.getJornalsServiceImpl();
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String price = request.getParameter("price");
		jornalService.create(new Jornals(name, 0, getValidatedPrice(price), description));
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success200");
	}
	
	private double getValidatedPrice(String price) {
		if (price==null && price.isEmpty()) return 0;
		return Double.parseDouble(price);
	}
	
	@Override      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jornalId = request.getParameter("id");
		Jornals jornal = jornalService.read(Integer.parseInt(jornalId));
		request.setAttribute("jornal", jornal);
		request.getRequestDispatcher("jornal.jsp").forward(request, response);;
	}
	

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}

}
