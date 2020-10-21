package leecode.tree;

/**
 * 二叉树的最大路径和
 */
public class No124 {
    private static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.parseTree(new Integer[]{-10,9,20,null,null,15,7});
        maxPathSum(treeNode);
        System.out.println(max);
    }

    public static int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxPathSum(root.left);
        int right = maxPathSum(root.right);
        //单独分支产生的最大值，这种情况不可递归，用全局变量去存储，看最后会不会是这个单独分支的值最大
        int allSum = root.val + Math.max(0, left) + Math.max(0, right);
        //单边的最大值，将继续和父层累加
        int sideMax = root.val + Math.max(0, Math.max(left, right));
        max = Math.max(max, Math.max(allSum, sideMax));
        //只把单边的最大值去做递归计算
        return sideMax;
    }
}
