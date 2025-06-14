package leecode.java;

import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 *
 * @author Wen
 * @date 2025/6/12 13:12
 */
public class No3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int result = 0;
        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                int lastPosition = map.get(s.charAt(right));
                result = Math.max(result, right - left);
                map.put(s.charAt(right), right);
                left = Math.max(left, lastPosition + 1);
            } else {
                map.put(s.charAt(right), right);
            }
            right ++;
        }
        return Math.max(result, right - left);
    }

    public static void main(String[] args) {
        No3 no3 = new No3();
        no3.lengthOfLongestSubstring("abba");
    }
}
