/*
 * @lc app=leetcode.cn id=79 lang=javascript
 *
 * [79] 单词搜索
 */

// @lc code=start
/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function (board, word) {
  const hasVisit = new Array(board.length);
  for (let i = 0; i < hasVisit.length; ++i) {
    hasVisit[i] = new Array(board[0].length).fill(false);
  }
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[i].length; j++) {
      //找到单词头可能的位置
      if (board[i][j] == word[0]) {
        if (dp(i, j, board, 0, word, -1, hasVisit)) {
          return true
        };
      }
    }
  }
  return false;
};

//direct上下左右 0，1，2，3
const dp = function (i, j, board, index, word, direct, hasVisit) {
  //看最后一个字母是否匹配了
  if (hasVisit[i][j]) {
    return false;
  }
  if (index == word.length - 1) {
    return board[i][j] == word[index];
  }
  if (board[i][j] != word[index]) {
    return false;
  }
  hasVisit[i][j] = true;
  let ret = false;
  //向上
  if (i - 1 >= 0 && direct != 3) {
    ret |= dp(i - 1, j, board, index + 1, word, 2, hasVisit);
    if (ret) return true;
  }
  //向下
  if (i + 1 < board.length && direct != 2) {
    ret |= dp(i + 1, j, board, index + 1, word, 3, hasVisit);
    if (ret) return true;
  }
  //向左
  if (j - 1 >= 0 && direct != 1) {
    ret |= dp(i, j - 1, board, index + 1, word, 0, hasVisit);
    if (ret) return true;
  }
  //向右
  if (j + 1 < board[i].length && direct != 0) {
    ret |= dp(i, j + 1, board, index + 1, word, 1, hasVisit);
    if (ret) return true;
  }
  hasVisit[i][j] = false;
  return false;
};
// @lc code=end
