package leecode;/*
 * @lc app=leetcode.cn id=91 lang=java
 *
 * [91] 解码方法
 */

import java.util.Arrays;

// @lc code=start test
class No91 {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);
        char[] chars = s.toCharArray();
        dp[s.length()] = 1;
        dp[s.length() - 1] = 1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '0') {
                dp[i] = 0;
            }
        }
        for (int i = s.length() - 2; i >= 0; i--) {
            if ((Integer.parseInt(String.valueOf(s.charAt(i)) + Integer.parseInt(String.valueOf(s.charAt(i + 1)))) > 26)) {
                if (dp[i] == -1) {
                    dp[i] = dp[i + 1];
                }
            } else {
                if (dp[i] == -1) {
                    dp[i] = dp[i + 1] + dp[i + 2];
                }
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        No91 solution = new No91();
        System.out.println(solution.numDecodings("0"));
    }
}
// @lc code=end

