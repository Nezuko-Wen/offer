package leecode.java;

import leecode.tree.TreeNode;

/**
 * @author Wen
 * @date 2025/6/19 20:48
 */
public class No236 {

    private TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return result;
    }

    public boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        // 自己是公共祖先
        if (root.val == p.val || root.val == q.val) {
            if (lson || rson) {
                result = root;
            }
            return true;
        }
        // 一般情况下的公共祖先，分别在该节点的左右子树
        if (lson && rson) {
            result = root;
            return true;
        }
        return lson || rson;
    }
}
