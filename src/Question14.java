/**
 * 剪绳子，绳子长度乘积最大
 */
public class Question14 {
    public static void main(String[] args) {
        int length = 8;
        int result = cutMaxRopeType(length);
        System.out.println(result);
    }

    private static int cutMaxRopeType(int length) {
        //当绳子长度小于4时，因为必须要剪一次（实际不剪断的值已经最大），返回固定计算值。
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        /**
         * 当绳子长度大于等于5时，可知3(n-3) > 2(n-2)
         * 所以要把绳子尽量剪成长度为3的段，不够3时剪成长度为2的段
         * 如果把绳子分为大于3的段，比如5=2*3，所以最终还是比较剪成2段和3段的大小
         */
        int cut3Frequency = length / 3;
        //此时分出一个3，剪成2*2
        if (length - cut3Frequency * 3 == 1){
            cut3Frequency --;
        }
        //剪成2段的次数
        int cut2Frequency = (length - cut3Frequency * 3) / 2;
        int result = (int) (Math.pow(3, cut3Frequency) * Math.pow(2, cut2Frequency));
        return result;
    }
}
