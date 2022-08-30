package algorithm;

/**
 * 荷兰国旗问题的划分
 * arr[L....R] 以arr[R]作为划分值
 * <arr[R]的在左侧 =arr[R]的在中间 >arr[R]的在右侧
 *
 * @author Wen
 * @date 2022/8/8 22:05
 */
public class NetherlandsFlag {

    //返回划分过后=arr[R]的数的左边界和右边界
    public int[] cal(int[] arr, int L, int R) {
        if (L > R) {
            return new int[]{-1, -1};
        }
        if (L == R) {
            return new int[]{L, R};
        }
        int index = 0;
        int less = 0;
        int large = R;
        int num = arr[R];
        while (index <= large) {
            if (arr[index] == num) {
                index++;
                continue;
            }
            if (arr[index] < num) {
                int temp = arr[less];
                arr[less] = arr[index];
                arr[index] = temp;
                less++;
                index++;
                continue;
            }
            if (arr[index] > num) {
                int temp = arr[large];
                arr[large] = arr[index];
                arr[index] = temp;
                large--;
            }
        }
        return new int[]{less , large};
    }

    public static void main(String[] args) {
        NetherlandsFlag netherlandsFlag = new NetherlandsFlag();
        int[] source = new int[]{1, 3, 5, 6, 3, 4, 3, 4, 8, 3};
        netherlandsFlag.cal(source, 0, 9);
        for (int i : source) {
            System.out.println(i);
        }
    }

}
