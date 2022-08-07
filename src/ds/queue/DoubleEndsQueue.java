package ds.queue;

import ds.linklist.DoubleNode;

/**
 * @author Wen
 * @date 2022/1/23 23:02
 */
public class DoubleEndsQueue {
    public DoubleNode head;
    public DoubleNode tail;

    public void leftAdd(int val) {
        DoubleNode node = new DoubleNode(val);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.last = node;
            head = node;
        }
    }
}
