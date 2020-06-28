/**
 * 一个树是否包含另一个树
 */
public class Question26 {
    private static boolean findRoot = false;
    public static void main(String[] args) {
        TreeNode father = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node7 = new TreeNode(2);

        father.left = node1;
        father.right = node2;
        node1.left = node7;
        node7.left = node3;
        node7.right = node4;

        TreeNode child = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(5);
        child.left = node5;
        child.right = node6;

        System.out.println(containChildTree(father, child));
    }

    static boolean containChildTree(TreeNode father, TreeNode child){
        //规定null可以是任何树的子树
        if (child == null){
            return true;
        }
        //father树遍历到叶子节点也没找到和child根节点相同的节点，那该分支返回false
        if (father == null){
            return false;
        }
        //father树遍历过程中找到了节点和child根节点相同节点，从该节点开始和child树一起向下遍历看是否能包含child树。
        //同时不能忘了此时可能只是当前节点等于了child根节点，那要把该节点下面的子树的包含情况也带上
        if (father.value == child.value){
            return loopChild(father, child) || containChildTree(father.left, child) || containChildTree(father.right, child);
        }
        //一直向下遍历找到起始节点
        return containChildTree(father.left, child) || containChildTree(father.right, child);
    }

    static boolean loopChild(TreeNode father, TreeNode child){
        //child遍历到其中一个叶子过程中都与father树节点相同，该分支可以返回true了
        if (child == null){
            return true;
        }
        //当有节点值不等时返回false
        if (father == null || father.value != child.value){
            return false;
        }
        //遍历左右2个分支一直到child所有的叶子，将结果并起来为最终结果
        return loopChild(father.left, child.left) && loopChild(father.right, child.right);
    }

    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}
