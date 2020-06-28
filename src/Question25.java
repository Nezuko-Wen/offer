public class Question25 {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(6);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(12);
        ListNode node5 = new ListNode(55);
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode head2 = new ListNode(1);
        ListNode node6 = new ListNode(2);
        ListNode node7 = new ListNode(3);
        ListNode node8 = new ListNode(4);
        ListNode node9 = new ListNode(5);
        head2.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;

        ListNode result = mergeListNode(head1, head2);

        while (result.next != null){
            System.out.println(result.val);
            result = result.next;
        }
    }

    static ListNode mergeListNode(ListNode head1, ListNode head2){
        ListNode mergeHead = new ListNode(0);
        ListNode node = mergeHead;
        if (head1 == null && head2 == null){
            return null;
        }
        if (head1 == null){
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        for (;;){
            if (head1 == null && head2 == null){
                break;
            }
            if (head1 == null || (head2 != null && head1.val >= head2.val)){
                mergeHead.next = head2;
                mergeHead = mergeHead.next;
                head2 = head2.next;
            }else if(head2 == null || head1.val < head2.val){
                mergeHead.next = head1;
                mergeHead = mergeHead.next;
                head1 = head1.next;
            }
        }
        return node.next;
    }

    static class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
