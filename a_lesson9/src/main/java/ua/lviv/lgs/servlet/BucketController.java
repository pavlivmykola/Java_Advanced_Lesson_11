package ua.lviv.lgs.servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.lviv.lgs.domain.Subscriptions;
import ua.lviv.lgs.service.SubscriptionService;
import ua.lviv.lgs.service.impl.SubscriptionServiceImpl;

@WebServlet(name = "bucket", description = "bucket", urlPatterns = { "/bucket" })
public class BucketController extends HttpServlet {
	private SubscriptionService subscriptionService = SubscriptionServiceImpl.getSubscriptionServiceImpl();
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jornalId = request.getParameter("jornalId");
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		long millis=System.currentTimeMillis();
		Subscriptions subscription = new Subscriptions(7, Integer.parseInt(jornalId), new Date(millis), new Date(millis));
		subscriptionService.create(subscription);
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write("Success");
	}

}
