package ds.linklist;

/**
 * 环形链表
 * @author Wen
 * @date 2022/8/31 23:27
 */

public class CircleLinkList {

    /**
     * 链表是否有环
     * @return 第一个入环节点
     */
    public Node hasCircle(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head, quick = head.next;
        while (slow != quick) {
            if (slow == null || quick == null) {
                return null;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        quick = head;
        while (slow != quick) {
            slow = slow.next;
            quick = quick.next;
        }
        return slow;
    }
}
