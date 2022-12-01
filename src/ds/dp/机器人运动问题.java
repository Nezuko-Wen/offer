package ds.dp;

/**
 * 机器人移动问题
 * n长度的数组上，机器人起始位置为s，目标位置为e，规定走k步，有多少种走法。
 * @author Wen
 * @date 2022/12/1 21:30
 */
class RobotMove {

    int dpf(int n, int s, int e, int k) {
        int[][] dp = new int[n + 1][k + 1];
        dp[e][0] = 1;
        for (int j = 1; j <=k; j ++) {
            for (int i = 1; i <= n; i ++) {
                if (i == 1) {
                    dp[i][j] = dp[2][j-1];
                    continue;
                }
                if (i == n) {
                    dp[i][j] = dp[n-1][j-1];
                    continue;
                }
                dp[i][j] = dp[i-1][j-1] + dp[i+1][j-1];
            }
        }
        return dp[s][k];
    }

    int f(int n, int s, int e, int k) {
        if (k == 0) {
            return s == e ? 1 : 0;
        }
        if (s == 1) {
            return f(n, 2, e, k - 1);
        }
        if (s == n) {
            return f(n, n - 1, e, k - 1);
        }
        return f(n, s - 1, e, k - 1) + f(n, s + 1, e, k - 1);
    }

    public static void main(String[] args) {
        RobotMove robotMove = new RobotMove();
        System.out.println(robotMove.dpf(4, 1, 3, 4));
    }
}
