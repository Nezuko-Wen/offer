/*
 * @lc app=leetcode.cn id=35 lang=javascript
 *
 * [35] 搜索插入位置
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function (nums, target) {
  let front = 0,
    rear = nums.length - 1;
  while (front < rear) {
    let index = Math.floor((rear + front) / 2);
    if (nums[index] == target) {
      return index;
    } else if (nums[index] < target) {
      front = index + 1;
    } else {
      rear = index - 1;
    }
  }
  return nums[front] < target ? front + 1 : front;
};
searchInsert([1,3,5,6], 2);
// @lc code=end
