package ds.tree;

import leecode.tree.TreeNode;

import java.util.Stack;

/**
 * @author Wen
 * @date 2022/9/1 22:03
 */
public class TreeTraverse {

    //前序
    public void pre(TreeNode h) {
        if (h == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(h);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    //中序
    public void in(TreeNode h) {
        if (h == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || h != null) {
            if (h != null) {
                stack.push(h);
                h = h.left;
            } else {
                h = stack.pop();
                System.out.println(h.val);
                h = h.right;
            }
        }
    }

    //后序
    public void pos(TreeNode h) {
        if (h == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack.push(h);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            stack2.push(pop);
            if (pop.left != null) {
                stack.push(pop.left);
            }
            if (pop.right != null) {
                stack.push(pop.right);
            }
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop().val);
        }
    }

    /**
     * c标记树的处理路径，先处理左树。
     * 没有左树时开始弹出，弹出后h移动到c的位置记录上一次的弹出位置
     * c指向下一个将要弹出的节点，这时候将判断h与c的位置关系，
     * h如果既不是c的左子树也不是右子树，按后序遍历的顺序来看相当于c还未处理左右子树，此时优先处理左子树，然后处理右子树
     */
    public void posPro(TreeNode h) {
        if (h == null){
            return;
        }
        TreeNode c;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(h);
        while (!stack.isEmpty()) {
            //指向将要弹出的节点，但不弹出
            c = stack.peek();
            if (c.left != null && h != c.left && h != c.right) {
                //c还没处理左子树
                stack.push(c.left);
                c = c.left;
            } else if (c.right != null && h != c.right) {
                //c还没处理右子树
                stack.push(c.right);
                c = c.right;
            } else {
                //c可以弹出了
                c = stack.pop();
                System.out.println(c.val);
                h = c;
            }
        }
    }

    public static void main(String[] args) {
        TreeTraverse treeTraverse = new TreeTraverse();
        treeTraverse.posPro(TreeNode.parseTree(new Integer[]{1,2,3,4,5,6,7}));
    }
}
