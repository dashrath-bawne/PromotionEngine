package org.example.promotionengine.impl;

import java.util.Map;

import org.example.promotionengine.cache.ItemCache;
import org.example.promotionengine.interfaces.Promotion;

/**
 * This promotion is meant for two items (different itemId)
 */
public class CombinedPromotion implements Promotion {

    private Character firstItemId;
    private Character secondItemId;
    private int promotionalPrice;

    public CombinedPromotion(Character firstItemId, Character secondItemId, int promotionalPrice) {

        this.firstItemId = firstItemId;
        this.secondItemId = secondItemId;
        this.promotionalPrice = promotionalPrice;
    }

    @Override public int apply(Map<Character, Integer> cartItems) {

        // Number of items in cart which have same firstItemId as mentioned in this promotion
        int firstItemUnits = cartItems.getOrDefault(firstItemId, 0);
        // Number of items in cart which have same secondItemId as mentioned in this promotion
        int secondItemUnits = cartItems.getOrDefault(secondItemId, 0);
        // Removing items so that subsequent promotions won't be applied on same item
        cartItems.remove(firstItemId);
        cartItems.remove(secondItemId);
        // both items have same numbers of unit
        if (firstItemUnits == secondItemUnits) {
            return (firstItemUnits * promotionalPrice);
            // Only first item is available in cart. Apply actual price of first item directly
        } else if (secondItemUnits == 0) {
            return firstItemUnits * ItemCache.getItemCache().get(firstItemId);
            // Only second item is available in cart. Apply actual price of second item directly
        } else if (firstItemUnits == 0) {
            return secondItemUnits * ItemCache.getItemCache().get(secondItemId);
            // Both items are available in cart but there number of units aren't same
        } else {
            // Number of units for which actual price should be applied
            int promotionNotApplicableUnits = Math.abs(firstItemUnits - secondItemUnits);
            // Number of times promotion value should be applied
            int promotionApplicableUnits = Math.min(firstItemUnits, secondItemUnits);
            // Item ID which should be considered to get the actual price
            Character promotionNotApplicableItemId =
                    Math.max(firstItemUnits, secondItemUnits) == firstItemUnits ? firstItemId : secondItemId;
            // sum of promotional price and actual price
            return ((promotionNotApplicableUnits * ItemCache.getItemCache().get(promotionNotApplicableItemId)) + (
                    promotionApplicableUnits * promotionalPrice));
        }
    }
}
