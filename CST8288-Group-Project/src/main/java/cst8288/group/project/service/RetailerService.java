/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.cst8288.group.project.service;

import main.java.cst8288.group.project.dao.InventoryDAO;
import main.java.cst8288.group.project.model.FoodItem;

import java.sql.SQLException;
import java.util.List;

/**
 * This class contains the business logic for managing the retailer's inventory.
 * It provides methods to add, update, and identify surplus food items.
 * 
 * @version 1.0
 * @since 1.9
 * Course: CST8288
 * Assignment: Final Project
 * Date: 07/30/2024
 * Professor: Islam Gomaa
 */
public class RetailerService {
    private InventoryDAO inventoryDAO;

    /**
     * Constructor to initialize RetailerService with an InventoryDAO instance.
     */
    public RetailerService() {
        this.inventoryDAO = new InventoryDAO();
    }

    /**
     * Adds a food item to the inventory.
     * 
     * @param item The food item to be added
     * @throws SQLException if a database access error occurs
     */
    public void addItem(FoodItem item) throws SQLException {
        inventoryDAO.addItem(item);
    }

    /**
     * Updates a food item in the inventory.
     * 
     * @param item The food item with updated information
     * @throws SQLException if a database access error occurs
     */
    public void updateItem(FoodItem item) throws SQLException {
        inventoryDAO.updateItem(item);
    }

    /**
     * Retrieves all food items for a given retailer.
     * 
     * @param retailerId The ID of the retailer
     * @return A list of food items for the retailer
     * @throws SQLException if a database access error occurs
     */
    public List<FoodItem> getAllItemsByRetailer(String retailerId) throws SQLException {
        return inventoryDAO.getAllItemsByRetailer(retailerId);
    }

    /**
     * Identifies and flags surplus food items for a given retailer.
     * 
     * @param retailerId The ID of the retailer
     * @throws SQLException if a database access error occurs
     */
    public void identifyAndFlagSurplusItems(String retailerId) throws SQLException {
        List<FoodItem> items = inventoryDAO.getAllItemsByRetailer(retailerId);
        for (FoodItem item : items) {
            if (item.getFoodExpiry().before(new java.util.Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000))) {
                item.setIsSurplus(true);
                inventoryDAO.updateItem(item);
            }
        }
    }
}
