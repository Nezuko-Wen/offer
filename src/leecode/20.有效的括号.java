package leecode;/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

import java.util.*;

// @lc code=start
class No20 {
    public boolean isValid(String s) {
        Map<Character, Character> cache = new HashMap<>();
        cache.put('(', ')');
        cache.put('{', '}');
        cache.put('[', ']');
        Set<Character> left = new HashSet<>();
        Set<Character> right = new HashSet<>();
        left.add('(');
        left.add('[');
        left.add('{');
        right.add(')');
        right.add(']');
        right.add('}');
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index <= s.length() - 1) {
            if (left.contains(s.charAt(index))) {
                stack.push(s.charAt(index));
            }
            if (right.contains(s.charAt(index))) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character peek = stack.peek();
                if (s.charAt(index) != cache.get(peek)) {
                    return false;
                }
                stack.pop();
            }
            index ++;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        No20 solution = new No20();
        System.out.println(solution.isValid("{{}}()"));
    }
}
// @lc code=end

