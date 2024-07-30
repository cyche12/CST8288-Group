/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cst8288.group.project.model;

import java.util.Date;

/**
 * This class represents a food item in the retailer's inventory.
 * It includes properties such as name, quantity, cost, expiry date, and surplus status.
 * 
 * @version 1.0
 * @since 1.9
 * Course: CST8288
 * Assignment: Final Project
 * Date: 07/30/2024
 * Professor: Islam Gomaa
 */
public class FoodItem {
    private String foodId;
    private String foodName;
    private int foodQuantity;
    private double foodCost;
    private Date foodExpiry;
    private String retailerId;
    private boolean isSurplus;
    private String listingType;

    /**
     * Constructor to initialize FoodItem with necessary details.
     * 
     * @param foodId The ID of the food item
     * @param foodName The name of the food item
     * @param foodQuantity The quantity of the food item
     * @param foodCost The cost of the food item
     * @param foodExpiry The expiry date of the food item
     * @param retailerId The ID of the retailer who owns the food item
     */
    public FoodItem(String foodId, String foodName, int foodQuantity, double foodCost, Date foodExpiry, String retailerId) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodQuantity = foodQuantity;
        this.foodCost = foodCost;
        this.foodExpiry = foodExpiry;
        this.retailerId = retailerId;
        this.isSurplus = false;
        this.listingType = "available";
    }

    /**
     * Gets the ID of the food item.
     * 
     * @return The ID of the food item
     */
    public String getFoodId() {
        return foodId;
    }

    /**
     * Sets the ID of the food item.
     * 
     * @param foodId The ID to set
     */
    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    /**
     * Gets the name of the food item.
     * 
     * @return The name of the food item
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * Sets the name of the food item.
     * 
     * @param foodName The name to set
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * Gets the quantity of the food item.
     * 
     * @return The quantity of the food item
     */
    public int getFoodQuantity() {
        return foodQuantity;
    }

    /**
     * Sets the quantity of the food item.
     * 
     * @param foodQuantity The quantity to set
     */
    public void setFoodQuantity(int foodQuantity) {
        this.foodQuantity = foodQuantity;
    }

    /**
     * Gets the cost of the food item.
     * 
     * @return The cost of the food item
     */
    public double getFoodCost() {
        return foodCost;
    }

    /**
     * Sets the cost of the food item.
     * 
     * @param foodCost The cost to set
     */
    public void setFoodCost(double foodCost) {
        this.foodCost = foodCost;
    }

    /**
     * Gets the expiry date of the food item.
     * 
     * @return The expiry date of the food item
     */
    public Date getFoodExpiry() {
        return foodExpiry;
    }

    /**
     * Sets the expiry date of the food item.
     * 
     * @param foodExpiry The expiry date to set
     */
    public void setFoodExpiry(Date foodExpiry) {
        this.foodExpiry = foodExpiry;
    }

    /**
     * Gets the ID of the retailer who owns the food item.
     * 
     * @return The ID of the retailer
     */
    public String getRetailerId() {
        return retailerId;
    }

    /**
     * Sets the ID of the retailer who owns the food item.
     * 
     * @param retailerId The ID to set
     */
    public void setRetailerId(String retailerId) {
        this.retailerId = retailerId;
    }

    /**
     * Checks if the food item is surplus.
     * 
     * @return true if the food item is surplus, false otherwise
     */
    public boolean isSurplus() {
        return isSurplus;
    }

    /**
     * Sets the surplus status of the food item.
     * 
     * @param isSurplus The surplus status to set
     */
    public void setIsSurplus(boolean isSurplus) {
        this.isSurplus = isSurplus;
    }

    /**
     * Gets the listing type of the food item.
     * 
     * @return The listing type of the food item
     */
    public String getListingType() {
        return listingType;
    }

    /**
     * Sets the listing type of the food item.
     * 
     * @param listingType The listing type to set
     */
    public void setListingType(String listingType) {
        this.listingType = listingType;
    }
}
