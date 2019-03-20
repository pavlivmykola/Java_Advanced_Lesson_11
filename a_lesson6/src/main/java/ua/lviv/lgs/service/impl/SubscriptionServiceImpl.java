package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import ua.lviv.lgs.DAO.AccountingDAO;
import ua.lviv.lgs.DAO.SubscriptionDAO;
import ua.lviv.lgs.DAOImpl.AccountingDAOImpl;
import ua.lviv.lgs.DAOImpl.SubscriptionDAOImpl;
import ua.lviv.lgs.domain.Subscriptions;
import ua.lviv.lgs.service.SubscriptionService;
import ua.lviv.lgs.service.UsersService;

public class SubscriptionServiceImpl implements SubscriptionService{

	private SubscriptionDAO subscriptionDAO;
	private static Logger LOGGER = Logger.getLogger(SubscriptionServiceImpl.class);
	private static SubscriptionService subscriptionServiceImpl;
	

	private SubscriptionServiceImpl() {
		try {
			subscriptionDAO = new SubscriptionDAOImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
			LOGGER.error(ex);
		}
	}
	
	public static SubscriptionService getSubscriptionServiceImpl() {
		if (subscriptionServiceImpl==null) {
			subscriptionServiceImpl = new SubscriptionServiceImpl();
		}
		return subscriptionServiceImpl;
	}

	@Override
	public Subscriptions create(Subscriptions t) {
		return subscriptionDAO.create(t);
	}

	@Override
	public Subscriptions read(Integer i) {
		return subscriptionDAO.read(i);
	}

	@Override
	public Subscriptions update(Subscriptions t) {
		return subscriptionDAO.update(t);
	}

	@Override
	public void delete(Subscriptions t) {
		subscriptionDAO.delete(t);
		
	}

	@Override
	public List<Subscriptions> readAll() {
		return subscriptionDAO.readAll();
	}
	
}
