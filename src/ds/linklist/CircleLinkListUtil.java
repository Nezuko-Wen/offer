package ds.linklist;

/**
 * 环形链表
 *
 * @author Wen
 * @date 2022/8/31 23:27
 */

public class CircleLinkListUtil {

    /**
     * 链表是否有环
     *
     * @return 第一个入环节点
     */
    public Node hasCircle(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next, quick = head.next.next;
        while (slow != quick) {
            if (slow == null || quick.next == null) {
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

    public Node bothNoCircle(Node h1, Node h2, Node tail) {
        if (h1 == null || h2 == null) {
            return null;
        }
        int length1 = 1, length2 = 1;
        Node n1 = h1, n2 = h2;
        while (n1.next != tail) {
            length1++;
            n1 = n1.next;
        }
        while (n2.next != tail) {
            length2++;
            n2 = n2.next;
        }
        if (n1 == n2) {
            n1 = length1 <= length2 ? h1 : h2;
            n2 = n1 == h1 ? h2 : h1;
        }
        //长路径先走多出来的步数
        int i = 0;
        int remain = Math.abs(length1 - length2);
        while (i < remain) {
            n2 = n2.next;
            i++;
        }
        while (n1.next != null && n2.next != null) {
            if (n1 == n2) {
                return n1;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    public Node bothCircle(Node h1, Node h2) {
        Node c1 = hasCircle(h1);
        Node c2 = hasCircle(h2);
        Node l1 = c1.next;
        while (l1 != c1) {
            if (l1 == c2) {
                break;
            }
            l1 = l1.next;
        }
        //两个不相交的环
        if (l1 != c2) return null;
        //两个环相交
        //1.入环节点为同一节点
        if (c1 == c2) {
            return bothNoCircle(h1, h2, l1);
        } else {
            return c1;
        }
    }
}
