package leecode.java;

/**
 * @author Wen
 * @date 2025/6/14 14:13
 */
public class No200 {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int x = 0; x < grid[0].length; x++) {
            for (int y = 0; y < grid.length; y++) {
                if (grid[y][x] == '1') {
                    result ++;
                    dfs(grid, x, y);
                }
            }
        }
        return result;
    }

    public void dfs(char[][] grid, int x, int y) {
        if (!isValid(grid, x, y)) {
            // 越界返回
            return;
        }
        if (grid[y][x] == '0') {
            // 非陆地返回
            return;
        }
        if (grid[y][x] == '2') {
            // 已被标记过
            return;
        }
        grid[y][x] = '2';
        // 遍历上下左右
        dfs(grid, x, y - 1);
        dfs(grid, x, y + 1);
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
    }

    public boolean isValid(char[][] grid, int x, int y) {
        return x >= 0 && x < grid[0].length && y >=0 && y < grid.length;
    }

    public static void main(String[] args) {
        No200 no200 = new No200();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        System.out.println(no200.numIslands(grid)); // 输出 3
    }
}
