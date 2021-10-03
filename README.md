# PromotionEngine
This repository contains a logic to apply different types of promotion on order items during checkout and calculate final order value
# How Promotion Engine Works
1. Accepts cart items and all available promotions to apply
2. Process cart items and create a map which stores item Id and number of units of that item in cart
3. Each promotion is applied on items available in map.
  * If promotion is applicable for any available item ID in map, promotion logic gets executed against itemId and total value for those items get calculated
  * Successfully applied promotion deletes itemsId from map so that same itemId won't be used in subsequent promotions
  * Update total order value
4. Returns total order/cart value
