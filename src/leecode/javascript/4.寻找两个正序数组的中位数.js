/*
 * @lc app=leetcode.cn id=4 lang=javascript
 *
 * [4] 寻找两个正序数组的中位数
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
//o(n) = m+n
var findMedianSortedArrays = function (nums1, nums2) {
  let index1 = 0;
  let index2 = 0;
  let cur = 0;
  const needTow = (nums1.length + nums2.length) % 2 === 0;
  const mid = needTow ? (nums1.length + nums2.length) / 2 : Math.ceil((nums1.length + nums2.length) / 2);
  let index = 0;
  while (index < mid) {
    if ((index1 < nums1.length && nums1[index1] <= nums2[index2]) || index2 >= nums2.length) {
      cur = nums1[index1];
      index1++;
    } else {
      cur = nums2[index2];
      index2++;
    }
    index++;
  }
  if (needTow) {
    if ((index1 < nums1.length && nums1[index1] <= nums2[index2]) || index2 >= nums2.length) {
      cur = (cur + nums1[index1]) / 2;
    } else {
      cur = (cur + nums2[index2]) / 2;
    }
  }
  return cur;
};

console.log(findMedianSortedArrays([3, 4], []));
// @lc code=end
