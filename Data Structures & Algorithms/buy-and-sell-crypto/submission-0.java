class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return 0;
        }
        int maxProfit = Integer.MIN_VALUE;
        int minBuy = prices[0];

        for(int sell: prices) {
            maxProfit = Math.max(maxProfit, sell - minBuy);
            minBuy = Math.min(minBuy, sell);
        }

        return maxProfit;
    }
}
