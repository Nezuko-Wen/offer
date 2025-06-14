package leecode.java;

import leecode.tree.TreeNode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


class No49 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i =0;i<k;i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        int[] result = new int[nums.length - k + 1];
        result[0] = nums[deque.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            while(deque.peekFirst() < i - k +1) {
                deque.pollFirst();
            }
            result[i - k +1] = nums[deque.pollFirst()];
        }
        return result;
    }


    public static void main(String[] args) {
        No49 no49 = new No49();
        no49.maxSlidingWindow(new int[]{-1,3,-1,-3,5,3}, 3);
    }
}