package com.inventory.manager;

import java.util.HashMap;
import java.util.Map;

import com.inventory.domain.Item;

public class InventoryObjectMother {

    public static Map<String, Item> create() {
        Map<String, Item> inventory = new HashMap<>();
        Item book1 = new Item("Book01", 10.5, 13.5);
        Item book2 = new Item("Book02", 22.99, 27.99);

        Item food1 = new Item("Food01", 6, 7.99);
        Item food2 = new Item("Food02", 7.99, 9.99);

        book1.setQuantity(10);
        book2.setQuantity(55);
        food1.setQuantity(8);
        food2.setQuantity(6);

        book1.setNumberSold(2);
        food1.setNumberSold(3);

        inventory.put(book1.getItemName(), book1);
        inventory.put(book2.getItemName(), book2);
        inventory.put(food1.getItemName(), food1);
        inventory.put(food2.getItemName(), food2);



        return inventory;
    }
}
