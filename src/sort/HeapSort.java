package sort;

/**
 * 堆排序
 * @param <T>
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T> {
    private int length;
    @Override
    public void sort(T[] nums) {
        length = nums.length;
        //构建大顶堆
        for (int i = length/2 - 1;i >= 0;i--){
            //从下至上，从左至右将非叶子节点构建成局部大顶堆
            constructionLargeHeap(nums, i, length);
        }

        for (int j = length - 1;j > 0;j--){
            //将大顶堆的根节点作为最大值和尾元素替换
            swap(nums, 0, j);
            //直接将替换后的根节点下沉，将剩余最大值替换上来
            constructionLargeHeap(nums, 0, j);
        }
    }

    private void constructionLargeHeap(T[] nums, int head, int len) {
        while (head * 2 + 1< len){
            int j = head * 2 + 1;
            //左子树比右子树小
            if (j + 1 < len && less(nums[j], nums[j + 1])){
                j ++;
            }
            //当前节点非最大节点
            if (less(nums[head], nums[j])){
                swap(nums, head, j);
            }
            else {
                //当前节点已调整完成
                break;
            }
            //以被替换的节点为根节点继续向下检查是否已构成大顶堆
            head = j;
        }
    }
}
