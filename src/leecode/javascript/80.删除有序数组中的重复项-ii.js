/*
 * @lc app=leetcode.cn id=80 lang=javascript
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
  //重复次数
  let repeat = 1;
  //当前判定数
  let cur = nums[0];
  //当前移动到的位置
  let index = 1;
  //有效尾部
  let tail = nums.length - 1;
  for (; index < nums.length; index++) {
    if (nums[index] < cur) {
      index--;
      break;
    }
    if (nums[index] == cur) {
      repeat++;
    } else {
      repeat = 1;
      cur = nums[index];
    }
    if (repeat >= 3) {
      if (nums[tail] == cur) {
        return index--;
      }
      let cursor = index + 1;
      while (cursor <= tail) {
        [nums[cursor - 1], nums[cursor]] = [nums[cursor], nums[cursor - 1]];
        cursor++;
      }
      tail--;
      index--;
    }
  }
  return index + 1;
};

console.log(removeDuplicates([0, 0, 1, 1, 1, 1, 2, 3, 3]));

// @lc code=end
