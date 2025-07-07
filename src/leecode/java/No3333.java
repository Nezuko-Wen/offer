package leecode.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wen
 * @date 2025/7/2 13:29
 */
public class No3333 {
    //
    public int possibleStringCount(String word, int k) {
        // 将原字符串转为数组，单字母连续出现的次数为数组中的元素，遇到一个新字母结算一个数组元素[]{a:3,b:3,a:4} {3,3,4}
        // k的最小值即为数组长度，记为m，即至少每个出现连续块的字母取一次
        // k向上增加时，即k-m个数需要被分配，此为递归
        List<Integer> wordArr = new ArrayList<>();
        int i = 0;
        int sum = 0;
        char c = word.charAt(i);
        while (i < word.length()) {
            if (word.charAt(i) != c) {
                wordArr.add(sum);
                c = word.charAt(i);
                sum = 0;
            }
            sum++;
            i++;
        }
        // 最多再分配k - wordArr.size()
        int result = 0;
        for (int remain = 0; remain < word.length(); remain++) {
            result += dfs(wordArr, 0, word.length() - wordArr.size());
        }
        return result;
    }

    private int dfs(List<Integer> wordArr, int index, int remain) {
        // 字母分配完毕
        if (remain == 0) {
            return 1;
        }
        // 不可再分配
        if (index >= wordArr.size()) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i <= wordArr.get(index); i++) {
            sum += dfs(wordArr, index + 1, remain - i);
        }
        return sum;
    }

    public static void main(String[] args) throws InterruptedException {
//        No3333 no = new No3333();
//        System.out.println(no.possibleStringCount("aaabbb", 3));
        while (true) {
            Thread.sleep(1000);
        }
    }
}
