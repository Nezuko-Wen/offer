package offer;

/**
 * 一个数的二进制含有多少个1
 */
public class Question15 {
    public static void main(String[] args) {
        int a = 5;
        int result = superOneCurrents(8);
        System.out.println(result);
    }

    /**
     * 解法1：判断最右边是否为1，再右移
     * @param a
     * @return
     */
    private static int oneCurrents(int a) {
        int result = 0;
        while (a != 0){
            if ((a & 1) != 0){
                result ++;
            }
            a = a >> 1;
        }
        return result;
    }

    /**
     * 解法2：把一个数减去1从二进制来看就是把最右边的1变成0，再把1右边为0的数变为1
     *       此时将原数与减1后的数字做位与运算，会把1右边的数再变回0
     *       举例：1100 - 1 得 1011
     *            1100 & 1011 得 1000
     *       这样就把二进制的1从右往左去掉了
     * @param a
     * @return
     */
    private static int superOneCurrents(int a) {
        int result = 0;
        while (a != 0){
            a = a & a - 1;
            result ++;
        }
        return result;
    }
}
