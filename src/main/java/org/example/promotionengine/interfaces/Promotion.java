package org.example.promotionengine.interfaces;

import java.util.Map;

/**
 * Super type for all types of promotions. Each promotion type should implement apply method
 */
public interface Promotion {

    /**
     * This method looks for specific item type in cartItems. Gets its corresponding unit count and perform logic as mentioned to calculate final order value.
     *
     * @param cartItems - holds mapping of cart item and its corresponding unit count
     * @return int - total order value for specific type of item
     */
    int apply(Map<Character, Integer> cartItems);
}
