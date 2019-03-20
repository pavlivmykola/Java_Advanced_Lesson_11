package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import ua.lviv.lgs.DAO.JornalsDAO;
import ua.lviv.lgs.DAOImpl.JornalsDAOImpl;

public class Application {


	public static void main(String[] args) {
		
		try {
			JornalsDAO jornalDAO = new JornalsDAOImpl();
			jornalDAO.readAll().forEach(System.out::println);			
		} catch (InstantiationException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		} catch (IllegalAccessException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			CustomLoggerFile.logError(ex.getMessage());			
		} catch (SQLException ex) {
			CustomLoggerFile.logError(ex.getMessage());
		}
		
		
//		CustomLoggerFile.logError("");
		
	}

}
