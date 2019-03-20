package ua.lviv.lgs.DAOImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ua.lviv.lgs.CustomLoggerFile;
import ua.lviv.lgs.DAO.SubscriptionDAO;
import ua.lviv.lgs.domain.Subscriptions;
import ua.lviv.lgs.utils.ConnectionUtils;

public class SubscriptionDAOImpl implements SubscriptionDAO{
	
	static String READ_ALL = "select * from subscription";
	static String INSERT = "insert into subscription (user_id,jornal_id,start,end) values (?,?,?,?)";
	static String READ_BY_ID = "select * from subscription where id=?";
	static String UPDATE_BY_ID = "update subscription set user_id=?, jornal_id=?, start=?, end=? where id=?";
	static String DELETE_BY_ID = "delete from subscription where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;

	public SubscriptionDAOImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.connection = ConnectionUtils.openConnection();
	}

	@Override
	public Subscriptions create(Subscriptions subscription) {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setInt(1, subscription.getUser_id());
			preparedStatement.setInt(2, subscription.getJornal_id());
			preparedStatement.setDate(3, subscription.getStart());
			preparedStatement.setDate(4, subscription.getEnd());
			preparedStatement.executeUpdate();
			return subscription;
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return null;
	}

	@Override
	public Subscriptions read(Integer id) {
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			Integer subscriptionId = result.getInt("id");
			Integer user_id = result.getInt("user_id");
			Integer jornal_id = result.getInt("jornal_id");
			Date start = result.getDate("start");
			Date end = result.getDate("end");
			return new Subscriptions(subscriptionId, user_id, jornal_id, start, end);
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return null;
	}

	@Override
	public Subscriptions update(Subscriptions subscription) {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setInt(1, subscription.getUser_id());
			preparedStatement.setInt(2, subscription.getJornal_id());
			preparedStatement.setDate(3, subscription.getStart());
			preparedStatement.setDate(4, subscription.getEnd());
			preparedStatement.setInt(5, subscription.getId());
			preparedStatement.executeUpdate();
			return subscription;
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return null;
	}

	@Override
	public void delete(Subscriptions subscription) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, subscription.getId());
			preparedStatement.executeQuery();
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
	}

	@Override
	public List<Subscriptions> readAll() {
		List<Subscriptions> listOfSubscriptions = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				result.next();
				Integer subscriptionId = result.getInt("id");
				Integer user_id = result.getInt("user_id");
				Integer jornal_id = result.getInt("jornal_id");
				Date start = result.getDate("start");
				Date end = result.getDate("end");
				listOfSubscriptions.add(new Subscriptions(subscriptionId, user_id, jornal_id, start, end));
			}
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return listOfSubscriptions;
	}

}
