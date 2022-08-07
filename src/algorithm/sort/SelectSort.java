package algorithm.sort;

/**
 * 选择排序
 * @param <T>
 */
public class SelectSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        for(int i = 0; i < nums.length; i ++){
            int min = i;
            for (int j = i + 1; j < nums.length; j++){
                if (less(nums[j], nums[min])){
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }
}
