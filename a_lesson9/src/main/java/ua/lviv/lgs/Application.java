package ua.lviv.lgs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import ua.lviv.lgs.DAO.JornalsDAO;
import ua.lviv.lgs.DAO.Impl.JornalsDAOImpl;
import ua.lviv.lgs.service.impl.UsersServiceImpl;

public class Application {
	
	private static Logger LOGGER = Logger.getLogger(Application.class);


	public static void main(String[] args) {
		
		try {
			JornalsDAO jornalDAO = new JornalsDAOImpl();
			jornalDAO.readAll().forEach(System.out::println);			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException ex) {
			LOGGER.error(ex);
		} 
		
		
//		CustomLoggerFile.logError("");
		
	}

}
