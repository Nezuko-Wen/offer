/*
 * @lc app=leetcode.cn id=149 lang=javascript
 *
 * [149] 直线上最多的点数
 */

// @lc code=start
/**
 * @param {number[][]} points
 * @return {number}
 */
var maxPoints = function (points) {
  if (points.length <= 2) return points.length;
  let ret = 0;
  for (let i = 0; i < points.length; i++) {
    const a = points[i];
    let same = 0;
    const map = new Map();
    for (let j = i + 1; j < points.length; j++) {
      const b = points[j];
      let x = a[0] - b[0];
      let y = a[1] - b[1];
      if (x == 0) {
        y = 1;
      } else if (y == 0) {
        x = 1;
      } else {
        if (y < 0) {
          x = -x;
          y = -y;
        }
      }
      const div = gcd(Math.abs(x), Math.abs(y));
      const xSlope = x / div;
      const ySlope = y / div;
      const key = `${xSlope}:${ySlope}`;
      map.set(key, (map.get(key) || 0)+ 1);
      ret = Math.max(ret, map.get(key))
    }
  }
  return ret + 1;
};
//最大公约数
var gcd = (x, y) => {
  return y == 0 ? x : gcd(y, x % y);
};
console.log(maxPoints([[2,3],[3,3],[-5,3]]));
// @lc code=end
