// src/dao/ClaimsDAO.java
package dao;

import db.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClaimsDAO {
    public void createClaim(int charityId, int itemId) throws SQLException {
        String query = "INSERT INTO claims (charity_id, inventory_id) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, charityId);
            stmt.setInt(2, itemId);
            stmt.executeUpdate();
        }
    }
}
