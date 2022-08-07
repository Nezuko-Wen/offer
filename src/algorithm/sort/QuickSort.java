package algorithm.sort;

/**
 * 快速排序
 * @param <T>
 */
public class QuickSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int front = 0;
        int rear = nums.length - 1;
        divideSort(nums,front,rear);
    }

    private void divideSort(T[] nums, int front, int rear) {
        int key = front;
        int i = front;
        int j = rear + 1;
        if (front >= rear){
            return;
        }
        while (true){
            while (less(nums[++i], nums[key]) && i != rear);
            while (less(nums[key], nums[--j]) && j != front);
            if (i >= j){
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, key, j);
        divideSort(nums, front, j-1);
        divideSort(nums, j + 1, rear);
    }
}
