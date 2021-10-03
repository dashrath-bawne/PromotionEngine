package org.example.promotionengine;

import static org.example.promotionengine.utility.PromotionEngine.calculateTotalOrderValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

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
        List<Promotion> promotions = new ArrayList<>();
        assertThat("Total order value should be 130", calculateTotalOrderValue(cart, promotions), is(130));
    }
}
