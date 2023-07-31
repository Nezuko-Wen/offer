/*
 * @lc app=leetcode.cn id=162 lang=javascript
 *
 * [162] 寻找峰值
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var findPeakElement = function (nums) {
  if (nums.length == 1 || nums.length == 0) return 0;
  return split(nums, 0, nums.length);
};

function split(nums, front, tail) {
  if (front == tail) {
    if (
      (front == 0 && nums[front] > nums[front + 1]) ||
      (front == nums.length - 1 && nums[front] > nums[front - 1]) ||
      (nums[front] > nums[front - 1] && nums[front] > nums[front + 1])
    ) {
      return front;
    } else {
      return -1;
    }
  }
  const mid = Math.floor((front + tail) / 2);
  if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
    return mid;
  }
  const left = split(nums, front, mid);
  if (left != -1) {
    return left;
  }
  return split(nums, mid + 1, tail);
}

console.log(findPeakElement([1, 2]));
// @lc code=end
