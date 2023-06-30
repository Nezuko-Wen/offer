/*
 * @lc app=leetcode.cn id=1094 lang=javascript
 *
 * [1094] 拼车
 */

// @lc code=start
/**
 * @param {number[][]} trips
 * @param {number} capacity
 * @return {boolean}
 */
var carPooling = function (trips, capacity) {
  //下车队列
  trips.sort((o1, o2) => o1[1] - o2[1]);
  const getout = [];
  let cur = 0;
  for (let i = 0; i < trips.length; i++) {
    //当前到达的位置
    const distance = trips[i][1];
    //上车人数
    const getOnNums = trips[i][0];
    //目标位置
    const targetDistance = trips[i][2];
    for (let j = 0; j < getout.length; j++) {
      if (getout[j][0] <= distance) {
        cur -= getout[j][1];
        getout.splice(j, 1);
        j--;
      } else {
        continue;
      }
    }
    cur += getOnNums;
    if (cur > capacity) {
      return false;
    }
    getout.push([targetDistance, getOnNums]);
  }
  return true;
};
// @lc code=end
