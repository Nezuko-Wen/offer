package leecode.java;


public class No206 {
    public ListNode reverseList(ListNode head) {
        ListNode result = new ListNode();
        while (head != null) {
            ListNode next = result.next;
            result.next = head;
            head = head.next;
            result.next.next = next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        No206 no206 = new No206();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        node1.next = node2;
        System.out.println(no206.reverseList(node1));
    }
}
