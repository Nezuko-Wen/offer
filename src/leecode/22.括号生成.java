package leecode;/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// @lc code=start
class No22 {
    public List<String> generateParenthesis(int n) {
        Stack<String> stack = new Stack<>();
        List<String> result = new ArrayList<>();
        boolean selectLeft = true;
        StringBuilder create = new StringBuilder();
        select(stack, result, n-1, n, selectLeft, create.append("("));
        return result;
    }

    private void select(Stack<String> stack, List<String> result, int left, int right, boolean selectLeft, StringBuilder create) {
        if (left == 0 && right == 0) {
            if (stack.isEmpty() || !stack.pop().equals("(")) {
                return;
            }
            result.add(create.toString());
            return;
        }
        if (left < 0 || right < 0) {
            return;
        }
        if (selectLeft) {
            stack.push("(");
        } else {
            if (stack.isEmpty() || !stack.pop().equals("(")) {
                return;
            }
        }
        select((Stack<String>) stack.clone(), result, left - 1, right, true, create.append("("));
        create.delete(create.length() - 1, create.length());
        select((Stack<String>) stack.clone(), result, left, right-1, false, create.append(")"));
        create.delete(create.length() - 1, create.length());
    }

    public static void main(String[] args) {
        No22 solution = new No22();
        System.out.println(solution.generateParenthesis(2));
    }
}
// @lc code=end

