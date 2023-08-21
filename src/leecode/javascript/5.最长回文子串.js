/*
 * @lc app=leetcode.cn id=5 lang=javascript
 *
 * [5] 最长回文子串
 */

// @lc code=start
/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function (s) {
  const l = s.length;
  let ret = "";
  for (let i = 0; i < l; i++) {
    let sFront = i - 1,
      sTail = i + 1,
      dFront = i,
      dTail = i + 1;
    let sRet = s.charAt(i),
      dRet = "";
    while ((sFront >= 0 && sTail <= l - 1) || (dFront >= 0 && dTail <= l - 1)) {
      if (sFront >= 0 && sTail <= l - 1) {
        if (s.charAt(sFront) == s.charAt(sTail)) {
          sRet = s.charAt(sFront).concat(sRet).concat(s.charAt(sFront));
          sFront -= 1;
          sTail += 1;
        } else {
          sFront = -1;
        }
      }
      if (dFront >= 0 && dTail <= l - 1) {
        if (s.charAt(dFront) == s.charAt(dTail)) {
          dRet = s.charAt(dFront).concat(dRet).concat(s.charAt(dFront));
          dFront -= 1;
          dTail += 1;
        } else {
          dFront = -1;
        }
      }
    }
    if (sRet.length > ret.length) {
      ret = sRet;
    }
    if (dRet.length > ret.length) {
      ret = dRet;
    }
  }
  return ret;
};
// @lc code=end
