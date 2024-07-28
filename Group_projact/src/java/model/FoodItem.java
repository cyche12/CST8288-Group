// src/model/FoodItem.java
package model;

import java.util.Date;

public class FoodItem {
    private int id;
    private int retailerId;
    private String itemName;
    private int quantity;
    private Date expirationDate;
    private boolean isSurplus;
    private String status;

    public FoodItem(int id, int retailerId, String itemName, int quantity, Date expirationDate, boolean isSurplus, String status) {
        this.id = id;
        this.retailerId = retailerId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.isSurplus = isSurplus;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRetailerId() {
        return retailerId;
    }

    public void setRetailerId(int retailerId) {
        this.retailerId = retailerId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public boolean isSurplus() {
        return isSurplus;
    }

    public void setSurplus(boolean isSurplus) {
        this.isSurplus = isSurplus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
