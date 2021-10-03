package org.example.promotionengine;

import static org.example.promotionengine.utility.PromotionEngine.calculateTotalOrderValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.example.promotionengine.impl.IndividualPromotion;
import org.example.promotionengine.interfaces.Promotion;
import org.example.promotionengine.vo.Cart;
import org.junit.jupiter.api.Test;

class PromotionEngineTest {

    /**
     * Unit price for SKU IDs
     * A 50
     * Active Promotions
     * 3 of A's for 130
     * Scenario A
     * 3 * A 50
     * Total value = 130
     */
    @Test
    void testCalculateTotalOrderValue_case1() {

        Cart cart = new Cart();
        cart.addItem('A');
        cart.addItem('A');
        cart.addItem('A');
        List<Promotion> promotions = new ArrayList<>();
        promotions.add(new IndividualPromotion('A', 3, 130));
        assertThat("Total order value should be 130", calculateTotalOrderValue(cart, promotions), is(130));
    }

    /**
     * Unit price for SKU IDs
     * A 50
     * Active Promotions
     * 3 of A's for 130
     * Scenario A
     * 2 * A 50
     * Total value = 100
     */
    @Test
    void testCalculateTotalOrderValue_case2() {

        Cart cart = new Cart();
        cart.addItem('A');
        cart.addItem('A');
        List<Promotion> promotions = new ArrayList<>();
        promotions.add(new IndividualPromotion('A', 3, 130));
        assertThat("Total order value should be 100", calculateTotalOrderValue(cart, promotions), is(100));
    }
}
