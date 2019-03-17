package ua.lviv.lgs;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersMapper {
	public static Users map(ResultSet result) {
		try {
			int id = result.getInt("id");
			String first_name = result.getString("first_name");
			String last_name = result.getString("last_name");
			String email = result.getString("email");
			String password = result.getString("password");
			return new Users(id, first_name, last_name,email,password);
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		return null;
	}
}
