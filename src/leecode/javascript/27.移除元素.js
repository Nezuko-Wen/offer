/*
 * @lc app=leetcode.cn id=27 lang=javascript
 *
 * [27] 移除元素
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} val
 * @return {number}
 */
var removeElement = function (nums, val) {
  if (!nums) {
    return 0;
  }
  let size = nums.length;
  for (let i = 0; i < size; i++) {
    if (nums[i] == val) {
      let t = nums[size - 1];
      nums[i] = nums[size - 1];
      nums[size - 1] = t;
      size--;
      i--;
    }
  }
  return size;
};
// @lc code=end
