package ua.lviv.lgs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "loginServlet", description = "loginServlet", urlPatterns = { "/loginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		UserService userService = new UserService();
		Users user = userService.getUser(email);
		HttpSession session = request.getSession(true);
		if (user == null) {
			session.setAttribute("message", "email not found");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		if (user.getPassword().equals(password)) {
			session.setAttribute("name", user.getFirst_name()+" "+user.getLast_name());
			request.getRequestDispatcher("cabinet.jsp").forward(request, response);
		} else {
			session.setAttribute("message", "Wrong password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
		
	}

}
