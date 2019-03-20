package ua.lviv.lgs.DAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import ua.lviv.lgs.DAO.AccountingDAO;
import ua.lviv.lgs.domain.Accounting;
import ua.lviv.lgs.service.AccountingService;
import ua.lviv.lgs.service.impl.AccountingServiceImpl;
import ua.lviv.lgs.utils.ConnectionUtils;

public class AccountingDAOImpl implements AccountingDAO{

	private static String READ_ALL = "select * from accounting";
	private static String INSERT = "insert into accounting (user_id,operation_id,sum) values (?,?,?)";
	private static String READ_BY_ID = "select * from accounting where id=?";
	private static String UPDATE_BY_ID = "update accounting set user_id=?, operation_id=?, sum=? where id=?";
	private static String DELETE_BY_ID = "delete from accounting where id=?";

	private Connection connection;
	private PreparedStatement preparedStatement;
	private static Logger LOGGER = Logger.getLogger(AccountingDAOImpl.class);

	public AccountingDAOImpl() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		this.connection = ConnectionUtils.openConnection();
	}
	
	@Override
	public Accounting create(Accounting accounting) {
		try {
			preparedStatement = connection.prepareStatement(INSERT);
			preparedStatement.setInt(1, accounting.getUser_id());
			preparedStatement.setInt(2, accounting.getOperation_id());
			preparedStatement.setDouble(3, accounting.getSum());
			preparedStatement.executeUpdate();
			return accounting;
		} catch (SQLException ex) {
			LOGGER.error(ex);
		}
		return null;
	}
	
	@Override
	public Accounting read(Integer id) {
		Accounting accounting=null;
		try {
			preparedStatement = connection.prepareStatement(READ_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet result = preparedStatement.executeQuery();
			result.next();
			Integer accountingId = result.getInt("id");
			Integer user_id = result.getInt("user_id");
			Integer operation_id = result.getInt("operation_id");
			double sum = result.getDouble("sum");
			accounting = new Accounting(accountingId, user_id, operation_id, sum);
		} catch (SQLException ex) {
			LOGGER.error(ex);
		}
		return accounting;
	}

	@Override
	public Accounting update(Accounting accounting) {
		try {
			preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
			preparedStatement.setInt(1, accounting.getUser_id());
			preparedStatement.setInt(2, accounting.getOperation_id());
			preparedStatement.setDouble(3, accounting.getSum());
			preparedStatement.setInt(4, accounting.getId());
			preparedStatement.executeUpdate();
			return accounting;
		} catch (SQLException ex) {
			LOGGER.error(ex);
		}
		return null;
	}

	@Override
	public void delete(Accounting accounting) {
		try {
			preparedStatement = connection.prepareStatement(DELETE_BY_ID);
			preparedStatement.setInt(1, accounting.getId());
			preparedStatement.executeQuery();
		} catch (SQLException ex) {
			LOGGER.error(ex);
		}
	}


	@Override
	public List<Accounting> readAll() {
		List<Accounting> listOfAccounting = new ArrayList<>();
		try {
			preparedStatement = connection.prepareStatement(READ_ALL);
			ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Integer accountingId = result.getInt("id");
				Integer user_id = result.getInt("user_id");
				Integer operation_id = result.getInt("operation_id");
				double sum = result.getDouble("sum");
				listOfAccounting.add(new Accounting(accountingId, user_id, operation_id, sum));
			}
		} catch (SQLException ex) {
			LOGGER.error(ex);
		}
		return listOfAccounting;
	}

}
