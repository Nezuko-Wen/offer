package leecode.tree;

import java.util.Stack;

/**
 * 二叉搜索树迭代器
 */
public class No173 {

    public static void main(String[] args) {
        Integer[] treeArr = new Integer[]{7,3,15,null,null,9,20};
        TreeNode root = TreeNode.parseTree(treeArr);
        BSTIterator iterator = new BSTIterator(root);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static class BSTIterator {
        private Stack<TreeNode> stack = new Stack();
        private TreeNode now;
        public BSTIterator(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }
        /** @return the next smallest number */
        public int next() {
            now = stack.pop();
            int result = now.val;
            if (now.right != null){
                TreeNode right = now.right;
                if (right.left != null) {
                    stack.push(right);
                    while (right.left != null) {
                        stack.push(right.left);
                        right = right.left;
                    }
                    return result;
                }
                stack.push(now.right);
            }
            return result;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return (now != null && now.right != null) || !stack.isEmpty();
        }
    }


}
