/*
 * @lc app=leetcode.cn id=148 lang=javascript
 *
 * [148] 排序链表
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
 * @return {ListNode}
 */
var sortList = function (head) {
  if (!head || !head.next) {
    return head;
  }
  let slow = head,
    fast = head.next;
  while (fast && fast.next) {
    slow = slow.next;
    fast = fast.next.next;
  }
  const tmp = slow.next;
  slow.next = null;
  let left = sortList(head);
  let right = sortList(tmp);
  let h = new ListNode(0);
  const ret = h;
  while (left && right) {
    if (left.val < right.val) {
      h.next = left;
      left = left.next;
    } else {
      h.next = right;
      right = right.next;
    }
    h = h.next;
  }
  h.next = left == null ? right : left;
  return ret.next;
};
// @lc code=end
