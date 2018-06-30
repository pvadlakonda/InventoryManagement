package com.inventory.manager;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import org.junit.Test;

public class InventoryManagerTest {
    InventoryManager testObj = new InventoryManager();

    @Test
    public void createShouldAddItemToInventory() {
        testObj.addItem("Book01", "10.5", "13.99");

        assertTrue(testObj.getInventory().keySet().contains("Book01"));
    }

    @Test
    public void deleteShouldRemoveItemFromInventory() {
        testObj.addItem("Book01", "10.5", "13.99");

        testObj.deleteItem("Book01");
        assertFalse(testObj.getInventory().keySet().contains("Book01"));

    }

    @Test
    public void updateItemBuyShouldIncreaseTheItemQuantity() {
        testObj.addItem("Book01", "10.5", "13.99");

        testObj.updateBuyItem("Book01", "10");

        assertEquals(10, testObj.getInventory().get("Book01").getQuantity());
    }

    @Test
    public void updateItemBuyTwiceShouldIncreaseTheItemQuantity() {
        testObj.addItem("Book01", "10.5", "13.99");

        testObj.updateBuyItem("Book01", "10");
        testObj.updateBuyItem("Book01", "5");

        assertEquals(15, testObj.getInventory().get("Book01").getQuantity());
    }

    @Test
    public void updateSellItemShouldDeductItemFromInventory() {
        testObj.addItem("Book01", "10.5", "13.99");

        testObj.updateBuyItem("Book01", "10");
        testObj.updateSellItem("Book01", "2");

        assertEquals(8, testObj.getInventory().get("Book01").getQuantity());
    }

    @Test
    public void shouldGenerateReportOfAllInventory() {
        testObj.addItem("Book01", "10.5", "13.99");

        testObj.updateBuyItem("Book01", "10");
        testObj.updateSellItem("Book01", "4");

        testObj.addItem("Food01", "8.5", "10.99");

        testObj.updateBuyItem("Food01", "5");
        testObj.updateSellItem("Food01", "2");

        testObj.generateReport();
    }

    @Test
    public void shouldUpdateSellPrice() {
        testObj.addItem("Book01", "10.5", "13.99");

        testObj.updateBuyItem("Book01", "10");
        testObj.updateSellPrice("Book01", "5.99");

        assertEquals(5.99, testObj.getInventory().get("Book01").getSellPrice());
    }
}