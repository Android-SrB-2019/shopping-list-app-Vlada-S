package ca.nbcc.shoppinglist;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    public class Item {

        public Item(String name) {
            this.name = name;
            this.count = 1;
        }

        public String name;
        public Integer count;
    }

    private List<Item> items = new ArrayList<>();

    public void addItem(String itemName) {
        boolean isFound = false;
        for (Item i : items) {
            if (i.name.equals(itemName)) {
                isFound = true;
                i.count++;
                break;
            }
        }
        if (!isFound) {
            items.add(new Item(itemName));
        }
    }

    public List<Item> getList() {
        return items;
    }

}