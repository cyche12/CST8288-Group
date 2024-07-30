/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cst8288.group.project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a retailer user and includes methods for managing their inventory.
 * It provides functionalities to add, update, and identify surplus food items.
 * 
 * @version 1.0
 * @since 1.9
 * Course: CST8288
 * Assignment: Final Project
 * Date: 07/30/2024
 * Professor: Islam Gomaa
 */
public class Retailer {
    private String userId;
    private String name;
    private List<FoodItem> inventory;

    /**
     * Constructor to initialize Retailer with userId and name.
     * 
     * @param userId The ID of the retailer
     * @param name The name of the retailer
     */
    public Retailer(String userId, String name) {
        this.userId = userId;
        this.name = name;
        this.inventory = new ArrayList<>();
    }

    /**
     * Gets the user ID of the retailer.
     * 
     * @return The user ID of the retailer
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the user ID of the retailer.
     * 
     * @param userId The user ID to set
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * Gets the name of the retailer.
     * 
     * @return The name of the retailer
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the retailer.
     * 
     * @param name The name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the inventory of the retailer.
     * 
     * @return The inventory of the retailer
     */
    public List<FoodItem> getInventory() {
        return inventory;
    }

    /**
     * Sets the inventory of the retailer.
     * 
     * @param inventory The inventory to set
     */
    public void setInventory(List<FoodItem> inventory) {
        this.inventory = inventory;
    }

    /**
     * Adds a food item to the retailer's inventory.
     * 
     * @param item The food item to be added
     */
    public void addItem(FoodItem item) {
        this.inventory.add(item);
    }

    /**
     * Updates an existing food item in the retailer's inventory.
     * 
     * @param item The food item with updated information
     */
    public void updateItem(FoodItem item) {
        for (FoodItem i : inventory) {
            if (i.getFoodId().equals(item.getFoodId())) {
                i.setFoodQuantity(item.getFoodQuantity());
                i.setFoodExpiry(item.getFoodExpiry());
                i.setIsSurplus(item.isSurplus());
                i.setListingType(item.getListingType());
            }
        }
    }

    /**
     * Identifies surplus food items in the retailer's inventory.
     * 
     * @return A list of surplus food items
     */
    public List<FoodItem> identifySurplusItems() {
        List<FoodItem> surplusItems = new ArrayList<>();
        for (FoodItem item : inventory) {
            if (item.isSurplus()) {
                surplusItems.add(item);
            }
        }
        return surplusItems;
    }
}

