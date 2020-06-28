/**
 * 寻找链表中环的入口节点
 */
public class Question23 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node3;
        System.out.println(enterNode(head).val);
    }

    static ListNode enterNode(ListNode head){
        if (isContainLoop(head) != null){
            return getEnterNode(head, getLoopLength(head, isContainLoop(head)));
        }
        return null;
    }
    //判断链表中是否有环,并返回环中的一个节点
    static ListNode isContainLoop(ListNode head){
        if (head == null || head.next == null){
            return null;
        }
        ListNode slowOne = head;
        ListNode fastOne = slowOne.next;

        while (slowOne.next != null && fastOne.next != null){
            //快指针每次走2步，慢指针每次走一步,当两个节点相遇则链表中含有环，且相遇节点为环中节点
            if (slowOne.val == fastOne.val){
                return fastOne;
            }
            fastOne = fastOne.next;
            if (fastOne.val == slowOne.val){
                return fastOne;
            }
            slowOne = slowOne.next;
            fastOne = fastOne.next;
        }

        return null;
    }
    //得到环的长度
    static int getLoopLength(ListNode head, ListNode meetNode){
        boolean firstMeet = false;
        int count = 0;
        //从相遇节点开始计数，若再次相遇可得出环中节点数
        while (head.next != null){
            if (head.val == meetNode.val){
                if (!firstMeet){
                    count ++;
                    firstMeet = true;
                }else {
                    break;
                }
            }else {
                if (firstMeet){
                    count ++;
                }
            }
            head = head.next;
        }
        return count;
    }
    //得到环的入口节点
    static ListNode getEnterNode(ListNode head, int loopLength){
        /**1->2->3->4->5
         *       |     |
         *       -------
         * **/
        //快指针先走环长度的步数，此时快指针到入口的距离=起点到入口的距离
        //假设起点到最远点长度为m,环长度为l,即m-l=m-(l+1)+1
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (loopLength > 0){
            fastNode = fastNode.next;
            loopLength --;
        }
        while (fastNode.val != slowNode.val){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return fastNode;
    }
    static class ListNode {
        ListNode next;
        int val;

        public ListNode(int val) {
            this.val = val;
        }
    }
}
