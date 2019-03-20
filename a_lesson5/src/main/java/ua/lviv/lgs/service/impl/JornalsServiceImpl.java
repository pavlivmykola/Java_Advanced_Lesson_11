package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.lgs.CustomLoggerFile;
import ua.lviv.lgs.DAO.AccountingDAO;
import ua.lviv.lgs.DAO.JornalsDAO;
import ua.lviv.lgs.DAOImpl.AccountingDAOImpl;
import ua.lviv.lgs.DAOImpl.JornalsDAOImpl;
import ua.lviv.lgs.domain.Jornals;
import ua.lviv.lgs.service.JornalsService;

public class JornalsServiceImpl implements JornalsService{

	private JornalsDAO jornalsDAO;

	public JornalsServiceImpl() {
		try {
			jornalsDAO = new JornalsDAOImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
	}

	@Override
	public Jornals create(Jornals t) {
		return jornalsDAO.create(t);
	}

	@Override
	public Jornals read(Integer i) {
		return jornalsDAO.read(i);
	}

	@Override
	public Jornals update(Jornals t) {
		return jornalsDAO.update(t);
	}

	@Override
	public void delete(Jornals t) {
		jornalsDAO.delete(t);
		
	}

	@Override
	public List<Jornals> readAll() {
		return jornalsDAO.readAll();
	}
}
