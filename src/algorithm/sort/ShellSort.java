package algorithm.sort;

/**
 * 希尔排序
 * @param <T>
 */
public class ShellSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int interval = nums.length/3;
        int length = nums.length;
        while (interval >= 1){
            for(int i = 0;i < interval;i++){
                for (int j = i;j<length - interval;j += interval){
                    for (int k = j + interval;k > i;k -= interval){
                        if (less(nums[k], nums[k-interval])){
                            swap(nums, k, k-interval);
                        }
                        else {
                            break;
                        }
                    }
                }
            }
            interval = interval / 3;
        }
    }
}
