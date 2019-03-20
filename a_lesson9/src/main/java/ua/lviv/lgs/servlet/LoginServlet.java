package ua.lviv.lgs.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import ua.lviv.lgs.domain.Users;
import ua.lviv.lgs.dto.UserLogin;
import ua.lviv.lgs.service.UsersService;
import ua.lviv.lgs.service.impl.UsersServiceImpl;

@WebServlet(name = "loginServlet", description = "loginServlet", urlPatterns = { "/loginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		UsersService usersService = UsersServiceImpl.getUserServiceImpl();
		Users user = usersService.readByLogin(email);
		
		if (user == null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("message", "email not found");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		if (user.getPassword().equals(password)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("userId", user.getId());
			UserLogin userLogin = new UserLogin();
			userLogin.destinationURL="cabinet.jsp";
			userLogin.email=user.getEmail();
			String json = new Gson().toJson(userLogin);
			response.setContentType("application/json");
			response.getWriter().write(json);
		}
		
	}

}
