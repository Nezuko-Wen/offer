package leecode;

import java.util.Arrays;

/**
 * @author Wen
 * @date 2025/6/20 21:54
 */
public class No5 {
    public String longestPalindrome(String s) {
        int size = s.length();
        boolean[][] dp = new boolean[size][size];
        for (int i = 0; i < size; i ++) {
            Arrays.fill(dp[i], false);
        }
        int maxLen = 0;
        String res = "";
        // 如果dp[i+1][j-1]为回文串，那么字符串i位==字符串j位时，dp[i][j]也为回文串
        for (int i = size - 1; i >= 0; i--) {
            for (int j = i; j < size; j ++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    maxLen = Math.max(maxLen, j - i);
                    if(j - i >= maxLen) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }
}
