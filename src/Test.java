import leecode.tree.No1530;
import leecode.tree.TreeNode;

public class Test {
    public static void main(String[] args) {
        Integer[] a = new Integer[]{1,2,3,4,5,6,7};
        TreeNode treeNode = TreeNode.parseTree(a);
        No1530 no1530 = new No1530();
        int i = no1530.countPairs(treeNode, 3);
        System.out.println(i);
    }
}
