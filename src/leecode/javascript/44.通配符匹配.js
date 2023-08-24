/*
 * @lc app=leetcode.cn id=44 lang=javascript
 *
 * [44] 通配符匹配
 */

// @lc code=start
/**
 * @param {string} s
 * @param {string} p
 * @return {boolean}
 */
var isMatch = function (s, p) {
  const cache = {};
  return dp(0, 0, s, p, cache);
};

var dp = (si, pi, s, p, cache) => {
  const key = `${si}:${pi}`;
  if (key in cache) {
    return cache[key];
  }
  if (si == s.length) {
    //空字符串匹配剩余全部是*的情况
    return pi >= p.length || (p.charAt(pi) == '*' && dp(si, pi + 1, s, p, cache));
  }
  if (pi >= p.length) {
    cache[key] = false;
    return false;
  }
  const sVal = s.charAt(si);
  const pVal = p.charAt(pi);
  let ret = false;
  if (pVal == '?' || pVal == sVal) {
    ret = dp(si + 1, pi + 1, s, p, cache);
  } else if (pVal == '*') {
    ret = dp(si + 1, pi + 1, s, p, cache) || dp(si + 1, pi, s, p, cache) || dp(si, pi + 1, s, p, cache);
  }
  cache[key] = ret;
  return ret;
};
// @lc code=end
