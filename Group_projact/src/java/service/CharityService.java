// src/service/CharityService.java
package service;

import dao.ClaimsDAO;
import dao.InventoryDAO;
import model.FoodItem;
import java.sql.SQLException;
import java.util.List;

public class CharityService {
    private InventoryDAO inventoryDAO;
    private ClaimsDAO claimsDAO;

    public CharityService() {
        this.inventoryDAO = new InventoryDAO();
        this.claimsDAO = new ClaimsDAO();
    }

    public List<FoodItem> getAvailableSurplusItems() throws SQLException {
        return inventoryDAO.getAvailableSurplusItems();
    }

    public void claimItem(int charityId, int itemId) throws SQLException {
        // Create a new claim
        claimsDAO.createClaim(charityId, itemId);
        // Update the inventory status to 'claimed'
        inventoryDAO.updateItemStatus(itemId, "claimed");
    }
}
