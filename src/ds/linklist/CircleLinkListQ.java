package ds.linklist;

/**
 * 有两个可能有环可能无环的单向链表，找出两个链表是否有相交节点
 * 由于单链表只有一个next，所以两个链表相交后之后的路径都是一样的
 * 一、两个无环,最后的终点一致则相交,记录到终点的路径,长路径先走去比短路径多的部分，然后两个链表一起走遇到第一个相等的节点即第一个想交接点
 * 二、一个有环一个无环不可能相交
 * 三、两个有环，先找到两个链表的入环节点，
 *      1.如果两个入环节点是同一个，可看做两个无环链表的终点为入环节点的问题
 *      2.如果两个入环节点不是同一个
 *          (1)如果从一个入环节点一直走碰不到另一个入环节点，则两个链表不相交
 *          (2)如果从一个入环节点一直可以走到另一个入环节点，则任一入环节点可作为第一个相交节点
 * @author Wen
 * @date 2022/8/31 23:45
 */
public class CircleLinkListQ {
    private final CircleLinkListUtil util = new CircleLinkListUtil();

    public Node findFirstIntersectNode(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        if (util.hasCircle(head1) == null && util.hasCircle(head2) == null) {
            return util.bothNoCircle(head1, head2, null);
        } else if (util.hasCircle(head1) != null && util.hasCircle(head2) != null) {
            return util.bothCircle(head1, head2);
        }
        return null;
    }

    public static void main(String[] args) {
        CircleLinkListQ circleLinkListQ = new CircleLinkListQ();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;
        node6.next = node7;
        node7.next = node5;
        System.out.println(circleLinkListQ.findFirstIntersectNode(node1, node6).val);
    }
}
