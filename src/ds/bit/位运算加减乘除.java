package ds.bit;

/**
 * @author Wen
 * @date 2022/12/1 20:36
 */
class Bit {
    //a+b
    int sum(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    //a-b
    int minus(int a, int b) {
        return sum(a, sum(~b, 1));
    }

    //a*b
    int multi(int a, int b) {
        // int sum = 0;
        // if (a == 0 || b == 0) return 0;
        // int time = b < 0 ? sum(~b, 1) : b;
        // for (int i = 0; i < time; i ++) {
        //     sum = sum(b < 0 ? sum(~a, 1) : a, sum);
        // }
        // return sum;
        int ret = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                ret = sum(ret, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return ret;
    }

    //a/b
    int divid(int a, int b) {
        int ret = 0;
        while (a >= b) {
            a = minus(a, b);
            ret = sum(ret, 1);
        }
        return ret;
    }

    public static void main(String[] args) {
        Bit bit = new Bit();
        System.out.println(bit.sum(1, 2));
        System.out.println(bit.minus(1, 2));
        System.out.println(bit.multi(1, -2));
        System.out.println(bit.divid(100,26));
    }
}
