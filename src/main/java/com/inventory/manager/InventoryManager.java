package com.inventory.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.inventory.domain.Item;


public class InventoryManager {
    private Map<String, Item> inventory = new HashMap<>();
    private List<Item> deletedItems = new ArrayList<>();

    public void addItem(String itemName, String costPrice, String sellPrice) {
        Item item = new Item(itemName, Double.valueOf(costPrice), Double.valueOf(sellPrice));
        inventory.put(item.getItemName(), item);
    }

    public Map<String, Item> getInventory() {
        return inventory;
    }

    public void deleteItem(String itemName) {
        if (inventory.keySet().contains(itemName)) {
            deletedItems.add(inventory.get(itemName));
            inventory.remove(itemName);
        }
    }

    public void updateBuyItem(String itemName, String quantity) {
        Item itemToBeUpdated = inventory.get(itemName);
        itemToBeUpdated.setQuantity(itemToBeUpdated.getQuantity() + Integer.valueOf(quantity));
    }

    public void updateSellItem(String itemName, String quantity) {
        Item itemToBeSold = inventory.get(itemName);
        itemToBeSold.setNumberSold(Integer.valueOf(quantity));
        itemToBeSold.setQuantity(itemToBeSold.getQuantity() - Integer.valueOf(quantity));

    }

    public String generateReport() {
        return new InventoryReport(inventory, deletedItems).generateReport();
    }

    public void updateSellPrice(String itemName, String updatedSellPrice) {
        inventory.get(itemName).setSellPrice(Double.valueOf(updatedSellPrice));
    }
}
