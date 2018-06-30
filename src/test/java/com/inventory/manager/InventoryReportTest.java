package com.inventory.manager;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.inventory.domain.Item;

public class InventoryReportTest {
    InventoryReport testObj = new InventoryReport(InventoryObjectMother.create(), new ArrayList<Item>());

    @Test
    public void reportShouldContainHeading() {

        String report = testObj.generateReport();
        assertTrue(report.contains("INVENTORY REPORT"));
    }

    @Test
    public void reportShouldContainTableHeadings() {
        String report = testObj.generateReport();

        assertTrue(report.contains("Item Name"));
        assertTrue(report.contains("Bought At"));
        assertTrue(report.contains("Sold At"));
        assertTrue(report.contains("Available Qty"));
        assertTrue(report.contains("Value"));
    }

    @Test
    public void reportShouldContainItemNames() {
        String report = testObj.generateReport();

        assertTrue(report.contains("Book01"));
        assertTrue(report.contains("Book02"));
        assertTrue(report.contains("Food01"));
        assertTrue(report.contains("Food02"));
    }

    @Test
    public void reportShouldContainTotalValue() {

        String report = testObj.generateReport();
        assertTrue(report.contains("Total Value"));
        assertTrue(report.contains(String.valueOf(1465.39)));
    }

    @Test
    public void reportShouldContainProfit() {

        String report = testObj.generateReport();
        assertTrue(report.contains("Profit since previous report"));
        assertTrue(report.contains(String.valueOf(11.97)));
    }

    @Test
    public void reportShouldContainZeroProfitAfterFirstReport() {

        String report1 = testObj.generateReport();
        String report2 = testObj.generateReport();

        assertTrue(report2.contains("Profit since previous report"));
        assertTrue(report2.contains(String.valueOf(0.00)));
    }
}