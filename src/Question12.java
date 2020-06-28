/**
 * 矩阵中是否含有某字符串
 */
public class Question12 {
    public static void main(String[] args) {
        char[][] proNums = new char[][]{{'a','b','e'},{'c','d','f'},{'g','h','i'}};
        String targetStr = "ifdg";
        System.out.println(isContainStrRoute(proNums, targetStr));
    }

    private static boolean isContainStrRoute(char[][] proNums, String targetStr) {
        boolean result = false;
        int[][] markNums = new int[proNums.length][proNums[0].length];
        char[] splitChar = targetStr.toCharArray();
        int currentPosition = 0;
        for (int row = 0; row < proNums.length; row++){
            for (int col = 0; col < proNums[row].length; col++){
                if (splitChar[0] == proNums[row][col]){
                    if (!findCompleteArea(markNums, row, col, proNums, splitChar, currentPosition)){
                        continue;
                    }else {
                        result = true;
                        break;
                    }
                }
            }
        }
        return result;
    }
    /**
     *
     * @param markNums 标记当前位置是否走过
     * @param row 行号
     * @param col 列号
     * @param proNums 问题矩阵
     * @param splitChar 需要寻找的字符串
     * @param currentPosition 当前寻找位置
     * @return
     */
    private static boolean findCompleteArea(int[][] markNums, int row, int col, char[][] proNums,
                                            char[] splitChar, int currentPosition) {
        if (row >= proNums.length || row < 0 || col < 0 || col >= proNums[0].length || markNums[row][col] == 1){
            return false;
        }
        if (currentPosition == splitChar.length - 1 && proNums[row][col] == splitChar[currentPosition]){
            return true;
        }
        markNums[row][col] = 1;
        if (proNums[row][col] == splitChar[currentPosition]){
            if(findCompleteArea(markNums, row + 1, col, proNums, splitChar, currentPosition + 1)
                    || findCompleteArea(markNums, row, col + 1, proNums, splitChar, currentPosition + 1)
                    || findCompleteArea(markNums, row - 1, col, proNums, splitChar, currentPosition + 1)
                    || findCompleteArea(markNums, row, col - 1, proNums, splitChar, currentPosition + 1)){
                return true;
            }
        }
        markNums[row][col] = 0;
        return false;
    }
}
