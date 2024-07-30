//Class: CST8288//
//Section: 033//
//Professor: Islam Gomaa//
//Assignment: Final Project//
//Date: 23/7/2024//
//Authors: Jake Elliott, Navjot Kaur, Heeseok Yang, Scott Valair//

package interfaces;

import inventory.inventoryItemDTO;

public interface InventoryDao {
	
	boolean addInventoryItem(inventoryItemDTO item);
    inventoryItemDTO getInventoryItemById(int itemId);
    boolean updateInventoryItem(inventoryItemDTO item);
    boolean deleteInventoryItem(int itemId);

}
