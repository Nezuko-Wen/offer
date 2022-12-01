package leecode;/*
 * @lc app=leetcode.cn id=65 lang=java
 *
 * [65] 有效数字
 */

// @lc code=start
class Solution {

    public boolean isNumber(String s) {
        char[] chars = s.toCharArray();
        int index = chars.length - 1;
        return match(chars, index);
    }

    private boolean match(char[] chars, int index) {
        String flag = String.valueOf(chars[index]);
        String dMatch = "[0-9]*";
        String sMatch = "[eE+-.]*";
        if (index == 0) {
            return flag.matches("[+,-]") || flag.matches(dMatch);
        }
        if (!flag.matches(dMatch) && !flag.matches(sMatch)) {
            return false;
        }
        if (flag.matches(dMatch)) {

        }
        return false;
    }

    public static void main(String[] args) {

    }
}
// @lc code=end

