/*
 * @lc app=leetcode.cn id=69 lang=javascript
 *
 * [69] x 的平方根 
 */

// @lc code=start
/**
 * @param {number} x
 * @return {number}
 */
var mySqrt = function(x) {
  let ret = 1;
  while (ret * ret < x) {
    ret += 1;
  }
  if (ret * ret > x) ret -= 1;
  return ret;
};
// @lc code=end

