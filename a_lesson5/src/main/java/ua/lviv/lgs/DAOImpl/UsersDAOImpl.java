package ua.lviv.lgs.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ua.lviv.lgs.CustomLoggerFile;
import ua.lviv.lgs.DAO.UsersDAO;
import ua.lviv.lgs.domain.Users;
import ua.lviv.lgs.utils.ConnectionUtils;

public class UsersDAOImpl implements UsersDAO{

	static String READ_ALL = "select * from users";
	static String INSERT = "insert into users (first_name,last_name,email,password,role) values (?,?,?,?,?)";
	static String READ_BY_ID = "select * from Users where id=?";
	static String READ_BY_LOGIN = "select * from Users where email=?";
	static String UPDATE_BY_ID = "update users set first_name=?, last_name=?, email=?, password=?, role=? where id=?";
	static String DELETE_BY_ID = "delete from users where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public UsersDAOImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.connection = ConnectionUtils.openConnection();
	}
	
	@Override
	public Users create(Users user) {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, user.getFirst_name());
			preparedStatement.setString(2, user.getLast_name());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return null;
	}

	@Override
	public Users read(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			Integer userId = result.getInt("id");
			String first_name = result.getString("first_name");
			String last_name = result.getString("last_name");
			String email = result.getString("email");
			String password = result.getString("password");
			String role = result.getString("role");
			return new Users(userId, first_name, last_name,email,password,role);
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return null;
	}
	
	@Override
	public Users readByLogin(String login) {
		try {
			preparedStatement = connection.prepareStatement(READ_BY_LOGIN);
			preparedStatement.setString(1, login);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			Integer userId = result.getInt("id");
			String first_name = result.getString("first_name");
			String last_name = result.getString("last_name");
			String email = result.getString("email");
			String password = result.getString("password");
			String role = result.getString("role");
			return new Users(userId, first_name, last_name,email,password,role);
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return null;
	}

	@Override
	public Users update(Users user) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, user.getFirst_name());
			preparedStatement.setString(2, user.getLast_name());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.setInt(6, user.getId());
			preparedStatement.executeUpdate();
			return user;
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return null;
	}
	
	@Override
	public void delete(Users user) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.executeQuery();
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
	}

	@Override
	public List<Users> readAll() {
		List<Users> listOfUsers = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer userId = result.getInt("id");
				String first_name = result.getString("first_name");
				String last_name = result.getString("last_name");
				String email = result.getString("email");
				String password = result.getString("password");
				String role = result.getString("role");
				listOfUsers.add(new Users(userId, first_name, last_name,email,password,role));
			}
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return listOfUsers;
	}

}
