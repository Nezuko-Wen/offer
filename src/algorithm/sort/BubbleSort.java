package algorithm.sort;

/**
 * 冒泡排序
 * @param <T>
 */
public class BubbleSort<T extends Comparable<T>> extends Sort<T>{
    @Override
    public void sort(T[] nums) {
        boolean replaced = false;
        for (int i = 0; i < nums.length - 1; i ++){
            for (int j = 0; j < nums.length - i - 1; j ++){
                if (less(nums[j+1], nums[j])){
                    swap(nums, j, j+1);
                    replaced = true;
                }
            }
            if (replaced){
                replaced = false;
            }else {
                return;
            }
        }
    }
}
