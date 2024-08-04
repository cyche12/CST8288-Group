//Class: CST8288//
//Section: 033//
//Professor: Islam Gomaa//
//Assignment: Final Project//
//Date: 23/7/2024//
//Authors: Jake Elliott, Navjot Kaur, Heeseok Yang, Scott Valair//

package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

private static final String URL = "jdbc:mysql://localhost:3306/FWRP";
private static final String USER = "root";
private static final String PASSWORD = "password";
private static final Logger LOGGER = Logger.getLogger(DatabaseConnection.class.getName());

static {
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		}
	catch (ClassNotFoundException e) {
		LOGGER.log(Level.SEVERE, "MySQL JDBC Driver not found", e);
		}
	}

public static Connection getConnection() throws SQLException {
	Connection connection = null;
	try {
		connection = DriverManager.getConnection(URL, USER, PASSWORD);
		}
	catch (SQLException e) {
		LOGGER.log(Level.SEVERE, "Connection to database failed", e);
		throw e;
		}
	return connection;
	}

public static void closeConnection(Connection connection) {
	if (connection != null) {
		try {
			connection.close();
			}
		catch (SQLException e) {
			LOGGER.log(Level.SEVERE, "Failed to close the connection", e);
			}
		}
	}
}
