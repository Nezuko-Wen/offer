/*
 * @lc app=leetcode.cn id=67 lang=javascript
 *
 * [67] 二进制求和
 */

// @lc code=start
/**
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var addBinary = function (a, b) {
  let carry = 0,
    index = 1,
    ret = '';
  while (a[a.length-index] || b[b.length-index]) {
    const aval = parseInt(a[a.length-index] || 0);
    const bval = parseInt(b[b.length-index] || 0);
    ret = ((aval ^ bval) ^ carry) + ret;
    carry = (aval & bval) | (aval & carry) | (bval & carry);
    index ++;
  }
  if (carry) ret = carry + ret;
  return ret;
};
console.log(addBinary('1', '11'));
// @lc cod   e=end
