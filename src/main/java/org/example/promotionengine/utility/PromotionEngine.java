package org.example.promotionengine.utility;

import java.util.List;

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
            
        }
        return 0;
    }
}
