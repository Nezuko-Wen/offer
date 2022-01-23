package linklist;

/**
 * @author Wen
 * @date 2022/1/23 22:15
 */
public class ReverseLinkList {

    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node4 = new Node(2);
        Node node3 = new Node(3);
        node4.next = node3;
        node2.next = node4;
        head.next = node2;
        print(head);
        print(delete(head, 2));
    }

    public static Node reverse(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static Node delete(Node head, int val) {
        while (head != null) {
            if (head.val != val) {
                break;
            }
            head = head.next;
        }
        //头一个值不为val的头部
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
