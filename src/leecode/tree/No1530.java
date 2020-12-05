package leecode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数 distance 。
 *
 * 如果二叉树中两个 叶 节点之间的 最短路径长度 小于或者等于 distance ，那它们就可以构成一组 好叶子节点对 。
 *
 * 返回树中 好叶子节点对的数量
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-good-leaf-nodes-pairs
 */
public class No1530 {
    private int ret = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return ret;
    }

    private List<Integer> dfs(TreeNode root, int distance) {
        if (root == null) return null;
        if (root.left == null && root.right == null) return Collections.singletonList(0);
        List<Integer> dfsOnce = new ArrayList<>();
        List<Integer> leftArr = dfs(root.left, distance);
        List<Integer> rightArr = dfs(root.right, distance);
        if (root.left != null) {
            for (int l : leftArr) {
                if (++l > distance) continue;
                dfsOnce.add(l);
            }
        }
        if (root.right != null) {
            for (int r : rightArr) {
                if (++r > distance) continue;
                dfsOnce.add(r);
            }
        }
        if (root.left != null && root.right != null) {
            for (int l : leftArr) {
                for (int r : rightArr) {
                    if (l + r + 2 <= distance) ret++;
                }
            }
        }
        return dfsOnce;
    }
}
