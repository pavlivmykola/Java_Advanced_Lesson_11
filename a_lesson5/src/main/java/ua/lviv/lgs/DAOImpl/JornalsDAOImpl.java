package ua.lviv.lgs.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ua.lviv.lgs.CustomLoggerFile;
import ua.lviv.lgs.DAO.JornalsDAO;
import ua.lviv.lgs.domain.Jornals;
import ua.lviv.lgs.utils.ConnectionUtils;

public class JornalsDAOImpl implements JornalsDAO{
	
	static String READ_ALL = "select * from jornals";
	static String INSERT = "insert into jornals (name,reit,price,description) values (?,?,?,?)";
	static String READ_BY_ID = "select * from jornals where id=?";
	static String UPDATE_BY_ID = "update jornals set name=?, reit=?,price=?,description=? where id=?";
	static String DELETE_BY_ID = "delete from jornals where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public JornalsDAOImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.connection = ConnectionUtils.openConnection();
	}
	@Override
	public Jornals create(Jornals jornal) {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setString(1, jornal.getName());
			preparedStatement.setInt(2, jornal.getReit());
			preparedStatement.setDouble(3, jornal.getPrice());
			preparedStatement.setString(4, jornal.getDescription());
			preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return null;
	}

	@Override
	public Jornals read(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			Integer jornalId = result.getInt("id");
			String name = result.getString("name");
			Integer reit = result.getInt("reit");
			String description = result.getString("description");
			double price = result.getDouble("price");
			return new Jornals(jornalId, name, reit, price, description);			
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return null;
	}

	@Override
	public Jornals update(Jornals jornal) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setString(1, jornal.getName());
			preparedStatement.setInt(2, jornal.getReit());
			preparedStatement.setDouble(3, jornal.getPrice());
			preparedStatement.setString(4, jornal.getDescription());
			preparedStatement.setInt(5, jornal.getId());
			preparedStatement.executeUpdate();
			return jornal;
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return null;
	}

	@Override
	public void delete(Jornals jornal) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, jornal.getId());
			preparedStatement.executeQuery();
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}

	}

	@Override
	public List<Jornals> readAll() {
		List<Jornals> listOfJornals = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer jornalId = result.getInt("id");
				String name = result.getString("name");
				Integer reit = result.getInt("reit");
				String description = result.getString("description");
				double price = result.getDouble("price");
				listOfJornals.add(new Jornals(jornalId, name, reit, price, description));
			}
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return listOfJornals;
	}

}
