package ua.lviv.lgs;

import java.sql.SQLException;

public class UserService {
	private UsersDAO usersDAO;

	public UserService() {
		super();
		try {this.usersDAO = new UsersDAO(ConnectionUtils.openConnection());			
		} catch (InstantiationException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		} catch (IllegalAccessException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			CustomLoggerFile.logError(ex.getMessage());			
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
	}

	public UsersDAO getUsersDAO() {
		return usersDAO;
	}

	public void setUsersDAO(UsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}
	
	public Users getUser(String login) {
		return usersDAO.readByLogin(login);
	}
	
	public void addUser(Users user) {
		usersDAO.insert(user);
	}
	
}
