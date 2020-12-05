package offer;

import leecode.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * 对称的二叉树
 */
public class Question28 {
    public boolean isSymmetry(TreeNode node) {
        TreeNode lHead = new TreeNode(0);
        lHead.left = node;
        TreeNode rHead = new TreeNode(0);
        rHead.left = node;
        return dfs(lHead.left, rHead.left);
    }

    private boolean dfs(TreeNode lHead, TreeNode rHead) {
        if (lHead == null && rHead == null) {
            return true;
        }
        if (lHead == null || rHead == null) {
            return false;
        }
        if (!Objects.equals(lHead.val, rHead.val)) {
            return false;
        }
        return dfs(lHead.left, rHead.right) && dfs(lHead.right, rHead.left);
    }
}
