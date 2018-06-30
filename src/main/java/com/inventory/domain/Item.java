package com.inventory.domain;

public class Item {
    private String itemName;
    private double costPrice;
    private double sellPrice;
    private int quantity;
    private int numberSold;

    public Item(String itemName, double costPrice, double sellPrice) {
        this.itemName = itemName;
        this.costPrice = costPrice;
        this.sellPrice = sellPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getNumberSold() {
        return numberSold;
    }

    public void setNumberSold(int numberSold) {
        this.numberSold = numberSold;
    }

    public double getTotalValue() {
        return quantity * costPrice;
    }

    public double getItemProfit() {
        return numberSold * (sellPrice - costPrice);
    }
}
