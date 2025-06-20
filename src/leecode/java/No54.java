package leecode.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wen
 * @date 2025/6/19 13:18
 */
public class No54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        String a = "";
        String.valueOf(a.charAt(1));
        List<Integer> result = new ArrayList<>();
        dfs(result, matrix, 0, 0, matrix.length, matrix[0].length);
        return result;
    }


    public void dfs(List<Integer> result, int[][] matrix, int x, int y, int height, int width) {
        if (height <= 0 || width <= 0) {
            return;
        }
        // 单横边情况处理
        if (height == 1) {
            for (int i = x; i < x + width; i++) {
                result.add(matrix[y][i]);
            }
            return;
        }
        // 单竖边情况处理
        if (width == 1) {
            for (int i = y; i < y + height; i++) {
                result.add(matrix[i][x]);
            }
            return;
        }
        for (int i = x; i < x + width - 1; i++) {
            result.add(matrix[y][i]);
        }
        for (int i = y; i < y + height - 1; i++) {
            result.add(matrix[i][x + width - 1]);
        }
        for (int i = x + width - 1; i > x; i--) {
            result.add(matrix[y + height - 1][i]);
        }
        for (int i = y + height - 1; i > y; i--) {
            result.add(matrix[i][x]);
        }
        dfs(result, matrix, x + 1, y + 1, height - 2, width - 2);
    }

    public static void main(String[] args) {
        No54 no54 = new No54();
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(no54.spiralOrder(matrix));
    }

}


