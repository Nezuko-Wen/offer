import java.util.Stack;

/**
 * 根据前序遍历和后序遍历重建二叉树
 */
public class Question_7 {

    public static void main(String[] args) {
        int[] preInt = new int[]{1,2,4,7,3,5,6,8};
        int[] inInt = new int[]{4,7,2,1,5,3,8,6};

        TreeNode result = reConstructTree(preInt, inInt);
        result.preorderTraversal();
        result.inorderTraversal();
    }

    private static TreeNode reConstructTree(int[] preInt, int[] inInt) {
        if ((preInt == null || preInt.length == 0) && (inInt == null || inInt.length == 0)){
            return null;
        }
        if (preInt.length == 1){
            return new TreeNode(preInt[0]);
        }
        if (inInt.length == 1){
            return new TreeNode(preInt[0]);
        }
        int head = preInt[0];
        int split = 0;
        for (int i = 0; i < inInt.length;i++){
            if (head == inInt[i]){
                split = i;
                break;
            }
        }
        TreeNode thisTree = new TreeNode(head);
        int[] splitLeftPreInt = new int[split];
        int[] splitLeftInInt = new int[split];
        int[] splitRightPreInt = new int[inInt.length-split-1];
        int[] splitRightInInt = new int[inInt.length-split-1];

        for (int i = 0;i < split;i ++){
            splitLeftPreInt[i] = preInt[i + 1];
            splitLeftInInt[i] = inInt[i];
        }

        for (int i = 0;i < inInt.length-split-1;i++){
            splitRightPreInt[i] = preInt[split + 1 + i];
            splitRightInInt[i] = inInt[split + 1 + i];
        }
        thisTree.left = reConstructTree(splitLeftPreInt, splitLeftInInt);
        thisTree.right = reConstructTree(splitRightPreInt, splitRightInInt);
        return thisTree;
    }

    static class TreeNode{
        private int var;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int var){
            this.var = var;
        }

        public void preorderTraversal(){
            if (this == null){
                return;
            }
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode head = this;
            while (!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    System.out.println(head.var);
                    head = head.left;
                }else {
                    head = stack.pop();
                    head = head.right;
                }
            }
        }

        public void inorderTraversal(){
            if (this == null){
                return;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode head = this;
            while (!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    head = head.left;
                }else {
                    head = stack.pop();
                    System.out.println(head.var);
                    head = head.right;
                }
            }
        }

        public void postorderTraversal(){
            Stack<TreeNode> stack = new Stack<>();
            Stack<Integer> outStack = new Stack<>();
            TreeNode head = this;
            while (!stack.isEmpty() || head != null){
                if (head != null){
                    stack.push(head);
                    outStack.push(head.var);
                    head = head.right;
                }else {
                    head = stack.pop();
                    head = head.left;
                }
            }
            while (!outStack.isEmpty()){
                System.out.println(outStack.pop());
            }
        }
    }
}
