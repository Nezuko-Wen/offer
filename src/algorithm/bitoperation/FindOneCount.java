package algorithm.bitoperation;

/**
 * 二进制中1的个数
 * @author Wen
 * @date 2021/12/29 22:53
 */
public class FindOneCount {

    public static void main(String[] args) {
        System.out.println(findOneCount(7));
    }

    private static int findOneCount(int N) {
        int i;
        int result = 0;
        while ((i = (N & ((~N) + 1))) != 0) {
            result ++;
            N ^= i;
        }
        return result;
    }
}


