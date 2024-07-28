// src/dao/InventoryDAO.java
package dao;

import db.DBConnection;
import model.FoodItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDAO {
    public List<FoodItem> getAvailableSurplusItems() throws SQLException {
        String query = "SELECT * FROM inventory WHERE is_surplus = TRUE AND status = 'available'";
        List<FoodItem> items = new ArrayList<>();

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                FoodItem item = new FoodItem(
                        rs.getInt("id"),
                        rs.getInt("retailer_id"),
                        rs.getString("item_name"),
                        rs.getInt("quantity"),
                        rs.getDate("expiration_date"),
                        rs.getBoolean("is_surplus"),
                        rs.getString("status")
                );
                items.add(item);
            }
        }
        return items;
    }

    public void updateItemStatus(int itemId, String status) throws SQLException {
        String query = "UPDATE inventory SET status = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, status);
            stmt.setInt(2, itemId);
            stmt.executeUpdate(); ////
        }
    }
}
