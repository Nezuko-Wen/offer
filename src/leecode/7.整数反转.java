package leecode;

/*
 * @lc app=leetcode.cn id=7 lang=java
 *
 * [7] 整数反转
 */

// @lc code=start
class No7 {
    public int reverse(int x) {
        int res = 0, y = Math.abs(x);
        while (y != 0) {
            if (res < Integer.MIN_VALUE / 10 || res > Integer.MAX_VALUE / 10) {
                return 0;
            }
            res = res * 10 + y % 10;
            y /= 10;
        }
        return x >= 0 ? res : - res;
    }
}
// @lc code=end

