package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import ua.lviv.lgs.DAO.AccountingDAO;
import ua.lviv.lgs.DAO.UsersDAO;
import ua.lviv.lgs.DAO.Impl.AccountingDAOImpl;
import ua.lviv.lgs.DAO.Impl.UsersDAOImpl;
import ua.lviv.lgs.domain.Accounting;
import ua.lviv.lgs.service.AccountingService;
import ua.lviv.lgs.service.UsersService;

public class AccountingServiceImpl implements AccountingService{

	private AccountingDAO accountingDAO;
	private static Logger LOGGER = Logger.getLogger(AccountingServiceImpl.class);
	private static AccountingService accountingServiceImpl;
	
	private AccountingServiceImpl() {
		try {
			accountingDAO = new AccountingDAOImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
			LOGGER.error(ex);
		}
	}
	
	public static AccountingService getAccountingServiceImpl() {
		if (accountingServiceImpl==null) {
			accountingServiceImpl = new AccountingServiceImpl();
		}
		return accountingServiceImpl;
	}

	@Override
	public Accounting create(Accounting t) {
		return accountingDAO.create(t);
	}

	@Override
	public Accounting read(Integer i) {
		return accountingDAO.read(i);
	}

	@Override
	public Accounting update(Accounting t) {
		return accountingDAO.update(t);
	}

	@Override
	public void delete(Accounting t) {
		accountingDAO.delete(t);
		
	}

	@Override
	public List<Accounting> readAll() {
		return accountingDAO.readAll();
	}
}
