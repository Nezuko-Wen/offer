package leecode;/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class No122 {
    //贪心算法
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        int res = 0;
        for (int i = 1; i < len; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                res += diff;
            }
        }
        return res;
    }
    //动态规划
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (len < 2) {
            return 0;
        }

        // 0：没有股票时的现金
        // 1：持有股票时的现金
        // 状态转移：0 → 1 → 0 → 1 → 0 → 1 → 0
        int[][] dp = new int[len][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < len; i++) {
            //今天未持有股票，昨天未持有或者昨天持有今天卖掉
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            //今天持有股票，持有的是昨天的股票或者今天买入的股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
//        int[][] dp = new int[prices.length + 1][prices.length + 1];
//        for (int i = 1; i <= prices.length; i++) {
//            dp[prices.length][i] = prices[prices.length - 1];
//        }
//        for (int i = prices.length - 1; i >= 1; i--) {
//            for (int j = 0; j < prices.length; j++) {
//                int nextSellNoBuy = 0, nextSellBuy = 0, nextBuy = 0;
//                //不交易
//                int nextNoTrade = dp[i + 1][j];
//                if (j == 0) {
//                    nextBuy = -prices[i] + dp[i + 1][i];
//                } else {
//                    //卖了不买
//                    nextSellNoBuy = prices[i] + dp[i + 1][0];
//                    //卖了买
//                    nextSellBuy = -prices[j] + dp[i + 1][i];
//                }
//                dp[i][j] = Math.max(Math.max(nextSellNoBuy, nextSellBuy), Math.max(nextBuy, nextNoTrade));
//            }
//        }
//        return dp[1][0];
//        return loop(prices, 0, -1);
    }

    //暴力递归
    private int dfs(int[] prices, int index, int cur) {
        if (index == prices.length - 1) {
            if (cur != -1) {
                //最后一天还持股，直接卖
                return prices[index];
            } else {
                return 0;
            }
        }
        int nextSellNoBuy = 0, nextSellBuy = 0, nextBuy = 0;
        //不交易
        int nextNoTrade = dfs(prices, index + 1, cur);
        if (cur == -1) {
            nextBuy = -prices[index] + dfs(prices, index + 1, index);
        } else {
            //卖了不买
            nextSellNoBuy = prices[index] + dfs(prices, index + 1, -1);
            //卖了买
            nextSellBuy = -prices[cur] + dfs(prices, index + 1, index);
        }
        return Math.max(Math.max(nextNoTrade, nextBuy), Math.max(nextSellNoBuy, nextSellBuy));
    }

    public static void main(String[] args) {
        int[] price = new int[]{1, 2, 3};
        No122 solution = new No122();
        System.out.println(solution.maxProfit(price));
    }

}
// @lc code=end

