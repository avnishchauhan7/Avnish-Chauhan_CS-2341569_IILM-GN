class Solution {
    public int maxProfit(int[] prices) {
         int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // Update minimum price
            minPrice = Math.min(minPrice, prices[i]);

            // Calculate profit
            int profit = prices[i] - minPrice;

            // Update maximum profit
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}