package org.example.promotionengine;

import static org.example.promotionengine.utility.PromotionEngine.calculateTotalOrderValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.List;

import org.example.promotionengine.impl.CombinedPromotion;
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

    /**
     * Unit price for SKU IDs
     * A 50
     * B 30
     * Active Promotions
     * 3 of A's for 130
     * 2 of B's for 45
     * Scenario A
     * 4 * A 50
     * 2 * B 30
     * Total value = 225
     */
    @Test
    void testCalculateTotalOrderValue_case3() {

        Cart cart = new Cart();
        cart.addItem('A');
        cart.addItem('A');
        cart.addItem('A');
        cart.addItem('A');
        cart.addItem('B');
        cart.addItem('B');
        List<Promotion> promotions = new ArrayList<>();
        promotions.add(new IndividualPromotion('A', 3, 130));
        promotions.add(new IndividualPromotion('B', 2, 45));
        assertThat("Total order value should be 225", calculateTotalOrderValue(cart, promotions), is(225));
    }

    /**
     * Unit price for SKU IDs
     * A 50
     * B 30
     * C 20
     * Active Promotions
     * 3 of A's for 130
     * 2 of B's for 45
     * C & D for 30
     * Scenario A
     * 1 * A 50
     * 1 * B 30
     * 1 * C 20
     * Total value = 100
     */
    @Test
    void testCalculateTotalOrderValue_case4() {

        Cart cart = new Cart();
        cart.addItem('A');
        cart.addItem('B');
        cart.addItem('C');
        List<Promotion> promotions = new ArrayList<>();
        promotions.add(new IndividualPromotion('A', 3, 130));
        promotions.add(new IndividualPromotion('B', 2, 45));
        promotions.add(new CombinedPromotion('C', 'D', 30));
        assertThat("Total order value should be 100", calculateTotalOrderValue(cart, promotions), is(100));
    }

    /**
     * Unit price for SKU IDs
     * A 50
     * B 30
     * C 20
     * D 15
     * Active Promotions
     * 3 of A's for 130
     * 2 of B's for 45
     * C & D for 30
     * Scenario A
     * 3 * A 50
     * 2 * B 30
     * 1 * C
     * 1 * D
     * Total value = 205
     */
    @Test
    void testCalculateTotalOrderValue_case5() {

        Cart cart = new Cart();
        cart.addItem('A');
        cart.addItem('A');
        cart.addItem('A');
        cart.addItem('B');
        cart.addItem('B');
        cart.addItem('C');
        cart.addItem('D');
        List<Promotion> promotions = new ArrayList<>();
        promotions.add(new IndividualPromotion('A', 3, 130));
        promotions.add(new IndividualPromotion('B', 2, 45));
        promotions.add(new CombinedPromotion('C', 'D', 30));
        assertThat("Total order value should be 205", calculateTotalOrderValue(cart, promotions), is(205));
    }

    /**
     * Unit price for SKU IDs
     * A 50
     * B 30
     * Active Promotions
     * 3 of A's for 130
     * 2 of A's for 70
     * 2 of B's for 45
     * Scenario A
     * 5 * A 50
     * 2 * B 30
     * Total value = (130 + (2*50) + 45 = 275
     *  2 of A's for 70 promotion won't be applied here
     */
    @Test
    void testCalculateTotalOrderValue_case6() {

        Cart cart = new Cart();
        cart.addItem('A');
        cart.addItem('A');
        cart.addItem('A');
        cart.addItem('A');
        cart.addItem('A');
        cart.addItem('B');
        cart.addItem('B');
        List<Promotion> promotions = new ArrayList<>();
        promotions.add(new IndividualPromotion('A', 3, 130));
        promotions.add(new IndividualPromotion('A', 2, 70));
        promotions.add(new IndividualPromotion('B', 2, 45));
        assertThat("Total order value should be 275", calculateTotalOrderValue(cart, promotions), is(275));
    }
}
