package org.example.promotionengine.impl;

import java.util.Map;

import org.example.promotionengine.cache.ItemCache;
import org.example.promotionengine.interfaces.Promotion;

/**
 * This promotion type is meant for individual item (specific itemId)
 */
public class IndividualPromotion implements Promotion {

    // Item ID for which this promotion applies
    private Character itemId;
    // Indicates number of units of specific item ID
    private int promotionalCount;
    // Indicates promotional price to apply
    private int promotionalPrice;

    public IndividualPromotion(Character itemId, int promotionalCount, int promotionalPrice) {

        this.itemId = itemId;
        this.promotionalCount = promotionalCount;
        this.promotionalPrice = promotionalPrice;
    }

    @Override public int apply(Map<Character, Integer> cartItems) {

        // Number of items in cart which have same itemId as mentioned in this promotion
        int numberOfItems = cartItems.get(itemId);
        // Number of times promotional price should be applied
        int matchedCount = numberOfItems / promotionalCount;
        // Number of items for which original item price should be applied
        int remainingCount = numberOfItems % promotionalCount;

        return ((matchedCount * promotionalPrice) + (remainingCount * ItemCache.getItemCache().get(itemId)));
    }
}
