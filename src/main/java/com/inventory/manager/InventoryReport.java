package com.inventory.manager;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;

import com.inventory.domain.Item;

public class InventoryReport {
    public static final String DASHES_20 = "---------------     ";
    public static final String DASHES_100 = "----------------------------------------------------------------------------------------------------";
    DecimalFormat format = new DecimalFormat("#.##");

    private final Map<String, Item> inventory;
    private final List<Item> deletedItems;

    public InventoryReport(Map<String, Item> inventory, List<Item> deletedItems) {
        this.inventory = inventory;
        this.deletedItems = deletedItems;
    }

    public String generateReport() {
        StringBuilder reportBuilder = new StringBuilder("\n\t\t\t INVENTORY REPORT");
        reportBuilder.append("\n");
        reportBuilder.append(pad("Item Name")).append(pad("Bought At")).append(pad("Sold At ")).append(pad("Available Qty")).append(pad("Value"));
        reportBuilder.append("\n");
        reportBuilder.append(DASHES_20).append(DASHES_20).append(DASHES_20).append(DASHES_20).append(DASHES_20);
        reportBuilder.append("\n");
        for(Item item : inventory.values()) {
            reportBuilder.append(pad(item.getItemName() + ""));
            reportBuilder.append(pad(item.getCostPrice() + ""));
            reportBuilder.append(pad(item.getSellPrice() + ""));
            reportBuilder.append(pad(item.getQuantity() + ""));
            reportBuilder.append(pad(Double.valueOf(format.format(item.getTotalValue())) + ""));
            reportBuilder.append("\n");
        }
        reportBuilder.append(DASHES_100);
        reportBuilder.append("\n");

        reportBuilder.append("Total Value                                                       " + getInventoryTotal());
        reportBuilder.append("\nProfit since previous report                                      " + getProfitSince());

        resetSoldItems();
        return reportBuilder.toString();
    }

    private void resetSoldItems() {
        for (Item item : inventory.values()) {
            item.setNumberSold(0);
        }
    }

    private double getProfitSince() {
        double totalProfit = 0;
        for (Item item : inventory.values()) {
            totalProfit += item.getItemProfit();
        }
        return Double.valueOf(format.format(totalProfit - deletedItemCost()));
    }

    private double deletedItemCost() {

        double result = 0;
        for(Item deletedItem : deletedItems) {
            result += deletedItem.getQuantity() * deletedItem.getCostPrice();
        }
        return result;
    }

    private double getInventoryTotal() {
        double total = 0;
        for (Item item : inventory.values()) {
            total += item.getTotalValue();
        }
        return Double.valueOf(format.format(total));
    }

    private String pad(String value) {
        StringBuilder result = new StringBuilder();
        result.append(value);
        while(result.length() < 20) {
            result.append(" ");
        }

        return result.toString();
    }
}
