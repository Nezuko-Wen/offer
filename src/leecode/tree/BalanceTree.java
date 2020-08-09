package leecode.tree;

/**
 * 检查二叉树平衡性
 */
public class BalanceTree {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1,2,2,3,3,null,null,4,4};
        TreeNode root = TreeNode.parseTree(integers);
        System.out.println(isBalanced(root));
    }
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) >= 2) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getDepth(TreeNode node){
        if (node == null) {
            return 0;
        }
        return Math.max(1 + getDepth(node.left),1 + getDepth(node.right));
    }

}
