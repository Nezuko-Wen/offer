package leecode;/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 0 || numRows == 1) return s;
        int structNum = numRows + numRows - 2;
        int wholeNum = s.length() / structNum;
        int lastNum = s.length() % structNum;
        int lastCell = lastNum / numRows + (lastNum / numRows == 0 ? 1 : lastNum % numRows);
        int cellRight = wholeNum * (numRows - 1) + lastCell;
        char[][] resultStruct = new char[numRows][cellRight];
        int cursor = 1;
        int structCount = 0;
        int row = 0, cell = 0;
        boolean back = false;
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if ((cursor - 1) / structNum > structCount) {
                row = 0;
                cell ++;
                structCount = (cursor - 1) / structNum;
                resultStruct[row][cell] = aChar;
                row ++;
                back = false;
            } else if (row < numRows && !back) {
                resultStruct[row][cell] = aChar;
                row ++;
            } else {
                if (row == numRows) row --;
                back = true;
                cell ++;
                row --;
                resultStruct[row][cell] = aChar;
            }
            cursor ++;
        }
        StringBuilder sb = new StringBuilder();
        for (char[] chars1 : resultStruct) {
            for (char c : chars1) {
                if (c == '\u0000') continue;
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
// @lc code=end

