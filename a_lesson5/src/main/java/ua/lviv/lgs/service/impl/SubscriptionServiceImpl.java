package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.lgs.CustomLoggerFile;
import ua.lviv.lgs.DAO.AccountingDAO;
import ua.lviv.lgs.DAO.SubscriptionDAO;
import ua.lviv.lgs.DAOImpl.AccountingDAOImpl;
import ua.lviv.lgs.DAOImpl.SubscriptionDAOImpl;
import ua.lviv.lgs.domain.Subscriptions;
import ua.lviv.lgs.service.SubscriptionServise;

public class SubscriptionServiceImpl implements SubscriptionServise{

	private SubscriptionDAO subscriptionDAO;

	public SubscriptionServiceImpl() {
		try {
			subscriptionDAO = new SubscriptionDAOImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
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
