//Class: CST8288//
//Section: 033//
//Professor: Islam Gomaa//
//Assignment: Final Project//
//Date: 23/7/2024//
//Authors: Jake Elliott, Navjot Kaur, Heeseok Yang, Scott Valair//

package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsumerDAO {

public boolean addConsumer(ConsumerDTO consumer) {
	String sql = "INSERT INTO consumers (userId, firstName, lastName, userEmail) VALUES (?, ?, ?, ?)";
	try (Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
		pstmt.setString(1, consumer.getUserId());
		pstmt.setString(2, consumer.getFirstName());
		pstmt.setString(3, consumer.getLastName());
		pstmt.setString(4, consumer.getUserEmail());
		pstmt.executeUpdate();
		return true;
		}
	catch (SQLException e) {
		e.printStackTrace();
		}
	return false;
	}

public ConsumerDTO getConsumerById(String userId) {
	String sql = "SELECT * FROM consumers WHERE userId = ?";
	try (Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
		pstmt.setString(1, userId);
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			ConsumerDTO consumer = new ConsumerDTO();
			consumer.setUserId(rs.getString("userId"));
			consumer.setFirstName(rs.getString("firstName"));
			consumer.setLastName(rs.getString("lastName"));
			consumer.setUserEmail(rs.getString("userEmail"));
			return consumer;
			}
		}
	catch (SQLException e) {
		e.printStackTrace();
		}
	return null;
	}

public boolean updateConsumer(ConsumerDTO consumer) {
	String sql = "UPDATE consumers SET firstName = ?, lastName = ?, userEmail = ? WHERE userId = ?";
	try (Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
		pstmt.setString(1, consumer.getFirstName());
		pstmt.setString(2, consumer.getLastName());
		pstmt.setString(3, consumer.getUserEmail());
		pstmt.setString(4, consumer.getUserId());
		pstmt.executeUpdate();
		return true;
		}
	catch (SQLException e) {
		e.printStackTrace();
		}
	return false;
	}

public boolean deleteConsumer(String userId) {
	String sql = "DELETE FROM consumers WHERE userId = ?";
	try (Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql)) {
		pstmt.setString(1, userId);
		pstmt.executeUpdate();
		return true;
		}
	catch (SQLException e) {
		e.printStackTrace();
		}
	return false;
	}

public List<ConsumerDTO> getAllConsumers() {
	List<ConsumerDTO> consumers = new ArrayList<>();
	String sql = "SELECT * FROM consumers";
	try (Connection conn = DatabaseConnection.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery()) {
		while (rs.next()) {
			ConsumerDTO consumer = new ConsumerDTO();
			consumer.setUserId(rs.getString("userId"));
			consumer.setFirstName(rs.getString("firstName"));
			consumer.setLastName(rs.getString("lastName"));
			consumer.setUserEmail(rs.getString("userEmail"));
			consumers.add(consumer);
			}
		}
	catch (SQLException e) {
		e.printStackTrace();
		}
	return consumers;
	}
}
