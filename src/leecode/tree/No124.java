package leecode.tree;

/**
 * 二叉树的最大路径和
 */
public class No124 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.parseTree(new Integer[]{8,9,-6,null,null,5,9});
        TreeNode.preorderTraversalPrint(treeNode);
        System.out.println(maxPathSum(treeNode, true));
    }

    public static int maxPathSum(TreeNode root, boolean rootNode) {
        int rootVal = root.val;

        int max = rootVal;
        if (root.left == null && root.right == null) {
            return max;
        }
        if (rootVal < 0 && rootNode) {
            if (root.left != null) {
                max = Math.max(max, maxPathSum(root.left, true));
            }
            if (root.right != null) {
                max = Math.max(max, maxPathSum(root.right, true));
            }
            return max;
        }
        int leftMax = 0;
        int rightMax = 0;
        if (root.left != null) {
            leftMax = maxPathSum(root.left, false);
            if (root.left.val >= 0){
                max = Math.max(rootVal, rootVal + leftMax);
            }
            if (rootNode) {
                max = Math.max(max, leftMax);
            }
        }
        if (root.right != null) {
            rightMax = maxPathSum(root.right, false);
            if (root.right.val >= 0){
                max = Math.max(max, rootVal + rightMax);
            }
            if (rootNode) {
                max = Math.max(max, rightMax);
            }
        }
        if (root.left != null && root.right != null && rootNode) {
            max = Math.max(max, rightMax + rootVal + leftMax);
        }
        return max;
    }
}
