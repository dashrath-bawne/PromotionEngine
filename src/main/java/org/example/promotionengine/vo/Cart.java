package org.example.promotionengine.vo;

import java.util.LinkedList;
import java.util.List;

/**
 * Acts as a container to all the items of particular order
 */
public class Cart {

    private List<Character> items = new LinkedList<>();

    public void addItem(Character itemCode) {

        items.add(itemCode);
    }

    public List<Character> getItems() {

        return items;
    }
}
