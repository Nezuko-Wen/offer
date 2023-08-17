/*
 * @lc app=leetcode.cn id=12 lang=javascript
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function (num) {
  const dic = { '1000:1': 'M', '100:1': 'C', '100:5': 'D', '10:1': 'X', '10:5': 'L', '1:1': 'I', '1:5': 'V' };
  let div = 1000,
    has,
    remain = num;
  let ret = "";
  while (remain != 0) {
    has = Math.floor(remain / div);
    remain = remain % div;
    if (has == 0) {
      //量级下调
      div /= 10;
      continue;
    }
    if (has < 4) {
      ret += dic[`${div}:1`].repeat(has)
    } else if (has == 4) {
      ret += (dic[`${div}:1`] + dic[`${div}:5`]);
    } else if (has < 9) {
      ret += dic[`${div}:5`];
      ret += dic[`${div}:1`].repeat(has - 5);
    } else {
      ret += (dic[`${div}:1`] + dic[`${div * 10}:1`]);
    }
    div /= 10;
  }
  return ret;
};
// console.log("a" + "c".repeat(3))
console.log(intToRoman(1994));
// @lc code=end
