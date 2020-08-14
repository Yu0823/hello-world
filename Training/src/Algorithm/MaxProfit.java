package Algorithm;

public class MaxProfit {
    public int maxProfit(int[] prices, int fee) {
        int days = prices.length;
        int[][] dp = new int[days][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        for(int i = 1; i < days; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i] - fee, dp[i - 1][1]);
        }
        return dp[days - 1][0];
    }

    public static void main(String[] args) {
        int[] a = {1};
        System.out.println(new MaxProfit().maxProfit(a, 2));
    }
}
