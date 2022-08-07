package algorithm.sort;

/**
 * @author Wen
 * @date 2022/8/7 15:39
 */
public class SortTest {
    public static void main(String[] args) {
        Integer[] source = new Integer[]{2,1,3,64,7,3,1,3,24,5,3,6,7,9,3,24};
        MergeSort<Integer> mergeSort = new MergeSort<>();
        mergeSort.sort(source);
        for (int i : source) {
            System.out.println(i + ",");
        }
    }
}
