/*
 * @lc app=leetcode.cn id=78 lang=javascript
 *
 * [78] 子集
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function (nums) {
  const ret = [];
  dp(nums, 0, [], ret);
  return ret;
};

const dp = function (nums, index, cur, ret) {
  if (index === nums.length) {
    ret.push(cur);
    return;
  }
  dp(nums, index + 1, cur.slice(), ret);
  dp(nums, index + 1, cur.slice().concat(nums[index]), ret);
};
// @lc code=end
