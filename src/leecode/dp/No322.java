package leecode.dp;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * @author Wen
 * @date 2025/6/20 23:09
 */
public class No322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        // 如果能匹配到对应的硬币组合，硬币数一定小于amount+1个
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i ++) {
            for (int j = 0; j < coins.length; j ++) {
                // 遍历当前每个硬币值，认为当前取该枚硬币，然后找(i-当前硬币值)后的子解最小值
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }
        // 如果dp[amount]为初始值，说明子问题中没有找到解
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
