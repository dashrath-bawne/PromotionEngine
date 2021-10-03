package org.example.promotionengine.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.example.promotionengine.interfaces.Promotion;
import org.example.promotionengine.vo.Cart;

/**
 * Acts as a utility class. It takes cart items and promotions, applies those on each item and calculate final order value.
 */
public class PromotionEngine {

    /**
     * Accepts cart items and promotions, apply each promotion on cart items and calculate final order value
     *
     * @param cart       - holds all the order items
     * @param promotions - all the promotions available in system
     * @return int - total order value
     */
    public static int calculateTotalOrderValue(Cart cart, List<Promotion> promotions) {

        List<Character> items = cart.getItems();
        if (items != null && !items.isEmpty()) {
            Map<Character, Integer> itemsWithUnits = mapCartItemWithNumberOfUnits(cart);
            
        }
        return 0;
    }

    /**
     * Generates a map which holds itemId and number of units of that item in given cart
     *
     * @param cart - items in cart
     * @return Map - mapping of itemId and its number of units
     */
    private static Map<Character, Integer> mapCartItemWithNumberOfUnits(Cart cart) {

        Map<Character, Integer> itemsWithNumberOfUnits = new HashMap<>();
        for (Character itemId : cart.getItems()) {
            Integer count = itemsWithNumberOfUnits.getOrDefault(itemId, new Integer(0));
            itemsWithNumberOfUnits.put(itemId, count.intValue() + 1);
        }
        return itemsWithNumberOfUnits;
    }
}
