package org.example.promotionengine.impl;

import java.util.Map;

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

        return 0;
    }
}
