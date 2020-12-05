package leecode.tree;

public class TreeNode {
      public int val;
      public TreeNode left;
      public TreeNode right;
      public TreeNode(int x) {
          val = x;
      }

      public static TreeNode parseTree(Integer[] treeArr) {
            TreeNode root = new TreeNode(treeArr[0]);
            preorderTraversalSet(root, 0, treeArr);
            return root;
      }

      static void preorderTraversalSet(TreeNode root, int i, Integer[] treeArr) {
            if (2 * i + 1 < treeArr.length && treeArr[2 * i + 1] != null){
                  root.left = new TreeNode(treeArr[2 * i + 1]);
                  preorderTraversalSet(root.left, 2 * i + 1, treeArr);
            }else {
                  root.left = null;
            }
            if (2 * i + 2 < treeArr.length && treeArr[2 * i + 2] != null){
                  root.right = new TreeNode(treeArr[2 * i + 2]);
                  preorderTraversalSet(root.right, 2 * i + 2, treeArr);
            }else {
                  root.right = null;
            }
      }

      public static void preorderTraversalPrint(TreeNode root) {
            if (root != null) {
                  System.out.println(root.val);
                  preorderTraversalPrint(root.left);
                  preorderTraversalPrint(root.right);
            }
      }
}
