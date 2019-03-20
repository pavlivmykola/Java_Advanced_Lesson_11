package ua.lviv.lgs.service.impl;

import java.sql.SQLException;
import java.util.List;

import ua.lviv.lgs.CustomLoggerFile;
import ua.lviv.lgs.DAO.UsersDAO;
import ua.lviv.lgs.DAOImpl.UsersDAOImpl;
import ua.lviv.lgs.domain.Users;
import ua.lviv.lgs.service.UsersService;

public class UsersServiceImpl implements UsersService{
	
	private UsersDAO usersDAO;

	public UsersServiceImpl() {
		try {
			usersDAO = new UsersDAOImpl();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
	}

	@Override
	public Users create(Users t) {
		return usersDAO.create(t);
	}

	@Override
	public Users read(Integer i) {
		return usersDAO.read(i);
	}
	
	@Override
	public Users readByLogin(String login) {
		return usersDAO.readByLogin(login);
	}

	@Override
	public Users update(Users t) {
		return usersDAO.update(t);
	}

	@Override
	public void delete(Users t) {
		usersDAO.delete(t);
		
	}

	@Override
	public List<Users> readAll() {
		return usersDAO.readAll();
	}
	
	
}
