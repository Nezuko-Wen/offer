package ds.tree;

/**
 * @author Wen
 * @date 2022/8/22 22:26
 */
public class PrefixTree {
    private Node head;

    public PrefixTree() {
        head = new Node();
    }

    //将字符串插入前缀树中
    public void insert(String str) {
        if (str == null) {
            return;
        }
        Node node = head;
        node.pass++;
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            int index = aChar - 'a';//在哪个节点上
            if (node.next[index] == null) {
                node.next[index] = new Node();
            }
            node.next[index].pass++;
            node = node.next[index];
        }
        node.end++;
    }

    //str出现过几次
    public Integer search(String str) {
        if (str == null) {
            return 0;
        }
        Node node = head;
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            int index = aChar - 'a';//在哪个节点上
            if (node.next[index] == null) {
                return 0;
            }
            node = node.next[index];
        }
        return node.end;
    }

    public void delete(String str) {
        if (search(str) > 0) {
            Node node = head;
            node.pass--;
            char[] chars = str.toCharArray();
            for (char aChar : chars) {
                int index = aChar - 'a';//在哪个节点上
                if (--node.next[index].pass == 0) {//pass为0后，后面节点直接丢弃
                    node.next[index] = null;
                    return;
                }
                node = node.next[index];
            }
            node.end--;
        }
    }

    //以prefix为前缀的字符串个数
    public Integer prefixNumber(String prefix) {
        if (prefix == null) {
            return 0;
        }
        Node node = head;
        char[] chars = prefix.toCharArray();
        for (char aChar : chars) {
            int index = aChar - 'a';//在哪个节点上
            if (node.next[index] == null) {
                return 0;
            }
            node = node.next[index];
        }
        return node.pass;
    }

    class Node {
        int pass;
        int end;
        Node[] next;

        public Node() {
            this.pass = 0;
            this.end = 0;
            next = new Node[26];//假设字符串都是26个小写字母
        }
    }

    public static void main(String[] args) {
        PrefixTree prefixTree = new PrefixTree();
        prefixTree.insert("abc");
        prefixTree.insert("abc");
        prefixTree.insert("eewd");
        prefixTree.insert("adb");
        prefixTree.insert("eewd");
        prefixTree.insert("abs");
        prefixTree.insert("eewd");
        System.out.println(prefixTree.search("abc"));
        System.out.println(prefixTree.search("eewd"));
        System.out.println(prefixTree.prefixNumber("ab"));
    }
}
