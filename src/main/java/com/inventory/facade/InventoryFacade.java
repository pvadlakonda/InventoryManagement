package com.inventory.facade;

import java.util.Scanner;

import com.inventory.manager.InventoryManager;

public class InventoryFacade {
    InventoryManager manager = new InventoryManager();

    public static void main(String[] args) {
        InventoryFacade facade = new InventoryFacade();

        System.out.println("Please enter your command and enter # when done \n");

        Scanner input = new Scanner(System.in);
        String command;
        while ((command = input.nextLine()) != null && !command.equals("#")) {
            facade.executeCommand(command);
        }
    }

    private void executeCommand(String command) {

        String[] tokens = command.split(" ");
        if (tokens[0].startsWith("create")) {
            manager.addItem(tokens[1], tokens[2], tokens[3]);
        } else if (tokens[0].startsWith("delete")) {
            manager.deleteItem(tokens[1]);
        } else if (tokens[0].startsWith("updateBuy")) {
            manager.updateBuyItem(tokens[1], tokens[2]);
        } else if (tokens[0].startsWith("updateSell")) {
            manager.updateSellItem(tokens[1], tokens[2]);
        } else if (tokens[0].startsWith("report")) {
            String report = manager.generateReport();
            System.out.println(report);
        } else if (tokens[0].startsWith("updateSellPrice")) {
            manager.updateSellPrice(tokens[1], tokens[2]);
        } else {
            System.out.println("Invalid Command");
        }
    }
}
