package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.Logger;
import ua.lviv.lgs.DAO.AccountingDAO;
import ua.lviv.lgs.DAO.JornalsDAO;
import ua.lviv.lgs.DAOImpl.AccountingDAOImpl;
import ua.lviv.lgs.DAOImpl.JornalsDAOImpl;
import ua.lviv.lgs.domain.Jornals;
import ua.lviv.lgs.service.JornalsService;
import ua.lviv.lgs.service.UsersService;

public class JornalsServiceImpl implements JornalsService{

	private JornalsDAO jornalsDAO;
	private static Logger LOGGER = Logger.getLogger(JornalsServiceImpl.class);
	private static JornalsService jornalsServiceImpl;
	
	private JornalsServiceImpl() {
		try {
			jornalsDAO = new JornalsDAOImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
			LOGGER.error(ex);
		}
	}
	
	public static JornalsService getJornalsServiceImpl() {
		if (jornalsServiceImpl==null) {
			jornalsServiceImpl = new JornalsServiceImpl();
		}
		return jornalsServiceImpl;
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
