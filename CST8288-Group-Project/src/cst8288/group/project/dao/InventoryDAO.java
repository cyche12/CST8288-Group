/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cst8288.group.project.dao;

import cst8288.group.project.db.DBConnection;
import cst8288.group.project.model.FoodItem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class handles database operations related to the inventory.
 * It provides methods to add, update, and retrieve food items from the database.
 * 
 * @version 1.0
 * @since 1.9
 * Course: CST8288
 * Assignment: Final Project
 * Date: 07/30/2024
 * Professor: Islam Gomaa
 */
public class InventoryDAO {

    /**
     * Adds a food item to the inventory database.
     * 
     * @param item The food item to be added
     * @throws SQLException if a database access error occurs
     */
    public void addItem(FoodItem item) throws SQLException {
        String query = "INSERT INTO foodItem (foodId, foodName, foodQuantity, foodCost, foodExpiry, retailerId) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, item.getFoodId());
            stmt.setString(2, item.getFoodName());
            stmt.setInt(3, item.getFoodQuantity());
            stmt.setDouble(4, item.getFoodCost());
            stmt.setDate(5, new java.sql.Date(item.getFoodExpiry().getTime()));
            stmt.setString(6, item.getRetailerId());
            stmt.executeUpdate();
        }
    }

    /**
     * Updates a food item in the inventory database.
     * 
     * @param item The food item with updated information
     * @throws SQLException if a database access error occurs
     */
    public void updateItem(FoodItem item) throws SQLException {
        String query = "UPDATE foodItem SET foodName = ?, foodQuantity = ?, foodCost = ?, foodExpiry = ?, isSurplus = ?, listingType = ? WHERE foodId = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, item.getFoodName());
            stmt.setInt(2, item.getFoodQuantity());
            stmt.setDouble(3, item.getFoodCost());
            stmt.setDate(4, new java.sql.Date(item.getFoodExpiry().getTime()));
            stmt.setBoolean(5, item.isSurplus());
            stmt.setString(6, item.getListingType());
            stmt.setString(7, item.getFoodId());
            stmt.executeUpdate();
        }
    }

    /**
     * Retrieves all food items for a given retailer from the database.
     * 
     * @param retailerId The ID of the retailer
     * @return A list of food items for the retailer
     * @throws SQLException if a database access error occurs
     */
    public List<FoodItem> getAllItemsByRetailer(String retailerId) throws SQLException {
        String query = "SELECT * FROM foodItem WHERE retailerId = ?";
        List<FoodItem> items = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, retailerId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FoodItem item = new FoodItem(
                        rs.getString("foodId"),
                        rs.getString("foodName"),
                        rs.getInt("foodQuantity"),
                        rs.getDouble("foodCost"),
                        rs.getDate("foodExpiry"),
                        rs.getString("retailerId")
                );
                item.setIsSurplus(rs.getBoolean("isSurplus"));
                item.setListingType(rs.getString("listingType"));
                items.add(item);
            }
        }
        return items;
    }
}

