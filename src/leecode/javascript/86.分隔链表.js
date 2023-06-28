/*
 * @lc app=leetcode.cn id=86 lang=javascript
 *
 * [86] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @param {number} x
 * @return {ListNode}
 */
var partition = function(head, x) {
  const minHead = new ListNode(0);
  const maxHead = new ListNode(0);
  let cur = head;
  let minCur = minHead;
  let maxCur = maxHead;
  while (cur != null) {
    if (cur.val < x) {
      minCur.next = new ListNode(cur.val);
      minCur = minCur.next;
    } else {
      maxCur.next = new ListNode(cur.val)
      maxCur = maxCur.next;
    }
    cur = cur.next;
  }
  minCur.next = maxHead.next;
  return minHead.next;
};
// @lc code=end

