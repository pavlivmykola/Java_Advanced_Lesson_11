package ua.lviv.lgs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.xml.DOMConfigurator;

import ua.lviv.lgs.service.UsersService;

public class ConnectionUtils {

	private static String USER_NAME = "root";
	private static String USER_PASSWORD = "gfhfdjp";
	private static String URL = "jdbc:mysql://localhost:3306/project1?useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	public static Connection openConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		java.net.URL u = UsersService.class.getClassLoader().getResource("ua/lviv/lgs/logger/loggerConfig.xml");
		DOMConfigurator.configure("loggerConfig.xml");
		Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		return DriverManager.getConnection(URL, USER_NAME, USER_PASSWORD);
	}
	
}
