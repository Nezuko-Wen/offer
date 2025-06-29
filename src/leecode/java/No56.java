package leecode.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author Wen
 * @date 2025/6/25 23:17
 */
public class No56 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        // 将原子数组按左边界进行排序，这样重叠区间只要断开，后续的子数组不可能和前面的子数组有重叠
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        // 起始左右边界，当右边界与下一个子数组没重叠时，前一个子数组确定，切换左右边界
        int left = intervals[0][0];
        int right = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] compareArr = intervals[i];
            if (compareArr[0] <= right) {
                // 与前一个右边界有重叠，切换右边界
                right = Math.max(right, compareArr[1]);
            } else {
                result.add(new int[] { left, right });
                left = compareArr[0];
                right = compareArr[1];
            }
        }
        // 最后一个无论是否重叠都要加到结果中
        result.add(new int[] { left, right });
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        No56 no56 = new No56();
        System.out.println(no56.merge(new int[][] {
                { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 }
        }));
    }
}
