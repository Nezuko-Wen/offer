/*
 * @lc app=leetcode.cn id=89 lang=javascript
 *
 * [89] 格雷编码
 */

// @lc code=start
/**
 * @param {number} n
 * @return {number[]}
 */
var grayCode = function (n) {
  const zeroSeq = [["0"]];
  const oneSeq = [["1"]];
  for (let index = 1; index < n; index++) {
    const zeroPush = [];
    const onePush = [];
    for (const str of zeroSeq[index-1]) {
      zeroPush.push("0" + str);
    }
    for (const str of oneSeq[index-1]) {
      zeroPush.push("0" + str);
    } 
    for (const str of oneSeq[index-1].slice().reverse()) {
      onePush.push("1" + str);
    }
    for (const str of zeroSeq[index-1].slice().reverse()) {
      onePush.push("1" + str);
    } 
    zeroSeq.push(zeroPush);
    oneSeq.push(onePush);
  }
  const ret = [];
  if (n === 0) {
    ret.push(0);
  } else {
    for (const str of zeroSeq[n-1]) {
      ret.push(parseInt(str, 2));
    }
    for (const str of oneSeq[n-1]) {
      ret.push(parseInt(str, 2));
    }
  }
  return ret;
};
console.log(grayCode(3));
// @lc code=end
