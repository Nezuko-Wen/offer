package leecode;

import java.util.List;

/**
 * 二叉树中的链表
 */
public class No1367 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode next = new ListNode(2);
        ListNode next2 = new ListNode(8);
        head.next=next;
        next.next=next2;
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(1);
        TreeNode node9 = new TreeNode(3);
        root.left=node1;
        root.right=node2;
        node1.right=node3;
        node3.left=node5;
        node2.left=node4;
        node4.left=node6;
        node4.right=node7;
        node7.left=node8;
        node7.right=node9;
        System.out.println(isSubPath(head, root));
    }
    public static boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        }
        if (root.val == head.val){
            if (findSubPath(root, head)){
                return true;
            }
        }
        return isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private static boolean findSubPath(TreeNode root, ListNode head) {
        if (head == null){
            return true;
        }
        if (root == null) {
            return false;
        }
        if (root.val != head.val){
            return false;
        }
        return findSubPath(root.left, head.next) || findSubPath(root.right, head.next);
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
