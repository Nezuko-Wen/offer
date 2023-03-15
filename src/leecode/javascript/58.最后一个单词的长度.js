/*
 * @lc app=leetcode.cn id=58 lang=javascript
 *
 * [58] 最后一个单词的长度
 */

// @lc code=start
/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function (s) {
  let index = s.length - 1;
  let result = 0;
  let first = false;
  while (index >= 0) {
    if (s[index] == " ") {
      if (first) {
        return result;
      }
    } else {
      first = true;
      result++;
    }
    index--;
  }
  return result;
};
// @lc code=end
