package leecode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的前序遍历
 */
public class No589 {
    private List<Integer> ret = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        traverse(root);
        return ret;
    }

    public void traverse(Node root) {
        if (root == null) return;
        if (root != null) {
            ret.add(root.val);
        }
        if (root.children != null) {
            for (Node c : root.children) {
                preorder(c);
            }
        }
    }

    public class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int val, List<Node> children) {
            val = val;
            children = children;
        }
    }
}

