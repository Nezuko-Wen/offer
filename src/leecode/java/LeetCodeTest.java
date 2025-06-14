package leecode.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCodeTest {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            int[] ans = new int[2];
            for (int i = 0; i < nums.length - 1; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    if (nums[i] + nums[j] == target) {
                        ans[0] = i;
                        ans[1] = j;
                        break;
                    }
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println();
    }
}
