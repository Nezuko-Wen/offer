/*
 * @lc app=leetcode.cn id=17 lang=javascript
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
/**
 * @param {string} digits
 * @return {string[]}
 */
const keymap = [
  [],
  [],
  ['a', 'b', 'c'],
  ['d', 'e', 'f'],
  ['g', 'h', 'i'],
  ['j', 'k', 'l'],
  ['m', 'n', 'o'],
  ['p', 'q', 'r', 's'],
  ['t', 'u', 'v'],
  ['w', 'x', 'y', 'z'],
];
var letterCombinations = function (digits) {
  const result = [];
  if (digits.length === 0) {
    return result;
  }
  def('', 0, digits, result);
  return result;
};

const def = function (ret, index, digits, arr) {
  if (index >= digits.length) {
    arr.push(ret);
    return;
  }
  for (const letter of keymap[parseInt(digits[index])]) {
    ret += letter;
    def(ret, index + 1, digits, arr);
    ret = ret.slice(0, -1);
  }
};

// @lc code=end
