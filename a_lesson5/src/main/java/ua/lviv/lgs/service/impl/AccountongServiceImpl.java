package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.lgs.CustomLoggerFile;
import ua.lviv.lgs.DAO.AccountingDAO;
import ua.lviv.lgs.DAO.UsersDAO;
import ua.lviv.lgs.DAOImpl.AccountingDAOImpl;
import ua.lviv.lgs.DAOImpl.UsersDAOImpl;
import ua.lviv.lgs.domain.Accounting;
import ua.lviv.lgs.service.AccountingService;

public class AccountongServiceImpl implements AccountingService{

	private AccountingDAO accountingDAO;

	public AccountongServiceImpl() {
		try {
			accountingDAO = new AccountingDAOImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
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
