package org.example.promotionengine.cache;

import java.util.HashMap;
import java.util.Map;

/**
 * Acts as a cache for items where all the available items in system are stored during runtime.
 * Simply it holds itemId and its corresponding actual price
 */
public class ItemCache {

    private static Map<Character, Integer> itemsWithPrice;

    public static Map<Character, Integer> getItemCache() {

        if (itemsWithPrice == null) {
            itemsWithPrice = new HashMap<>();
            itemsWithPrice.put('A', 50);
            itemsWithPrice.put('B', 30);
            itemsWithPrice.put('C', 20);
            itemsWithPrice.put('D', 15);
        }
        return itemsWithPrice;
    }
}
