/*
 * @lc app=leetcode.cn id=24 lang=javascript
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start

// Definition for singly-linked list.
function ListNode(val, next) {
  this.val = val === undefined ? 0 : val;
  this.next = next === undefined ? null : next;
}

/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var swapPairs = function (head) {
  let ret = new ListNode(null, head);
  let cur = ret;
  while (cur.next != null && cur.next.next != null) {
    const front = cur;
    const next = cur.next.next;
    const temp = cur.next;
    const tail = next.next;
    temp.next = tail;
    next.next = temp;
    front.next = next;
    cur = temp;
  }
  return ret.next;
};

const head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));

swapPairs(head);
// @lc code=end
