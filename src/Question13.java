/**
 *
 */
public class Question13 {
    static int maxRow = 3;
    static int maxCol = 3;
    public static void main(String[] args) {
        int limit = 2;
        int[][] markNum = new int[maxRow][maxCol];
        int result = maxRobotRoute(0, 0, limit, markNum);
        System.out.println(result);
    }

    private static int maxRobotRoute(int row, int col, int limit, int[][] markNum) {
        if (row > maxRow - 1 || col > maxCol - 1 || row < 0 || col < 0 || markNum[row][col] == 1){
            return 0;
        }
        markNum[row][col] = 1;
        if (getDigSum(row) + getDigSum(col) > limit){
            return 0;
        }
        return maxRobotRoute(row + 1, col, limit, markNum) + maxRobotRoute(row - 1, col, limit, markNum)
                 + maxRobotRoute(row, col + 1, limit, markNum) + maxRobotRoute(row, col - 1, limit, markNum) + 1;
    }

    /**
     * 求数位和
     * @param num
     * @return
     */
    private static int getDigSum(int num){
        int sum = 0;
        while (num > 0){
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}
