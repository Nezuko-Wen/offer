package leecode;/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
 */

// @lc code=start

//  Definition for singly-linked list.


import java.util.ArrayList;
import java.util.List;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> cache =new ArrayList<>();
        ListNode ret = head;
        while (head != null) {
            cache.add(head);
            head = head.next;
        }
        if (n == cache.size()) {
            return ret.next;
        }
        cache.get(cache.size() - n - 1).next = n == 1 ? null : cache.get(cache.size() - n + 1);
        return ret;
    }

//      private static class ListNode {
//          int val;
//          ListNode next;
//          ListNode() {}
//          ListNode(int val) { this.val = val; }
//          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//      }
}
// @lc code=end

