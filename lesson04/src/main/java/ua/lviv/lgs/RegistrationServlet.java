package ua.lviv.lgs;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "registrationServlet", description = "registrationServlet", urlPatterns = { "/registrationServlet" })
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String button = request.getParameter("button");
		HttpSession session = request.getSession(true);
		if (button.equals("submit")) {
			UserService userService = new UserService();
			if (userService.getUser(email) == null) {
				Users user = new Users(firstName, lastName, email, password);
				userService.addUser(user);				
				session.setAttribute("name", firstName + " " + lastName);
				request.getRequestDispatcher("cabinet.jsp").forward(request, response);
			} else {
				session.setAttribute("message", "email already exists");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else {
			session.setAttribute("message", " ");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
