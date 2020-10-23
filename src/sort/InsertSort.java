package sort;

/**
 * 插入排序
 * @param <T>
 */
public class InsertSort<T extends Comparable<T>> extends Sort<T>{
    @Override
    public void sort(T[] nums) {
        for (int i = 0; i < nums.length - 1; i ++){
            //下一个要插入的元素为nums[i+1]，nums[0]-nums[i]为有序列
            for (int j = i + 1; j > 0;j--){
                //给当前元素找到合适位置
                if (less(nums[j],nums[j-1])){
                    swap(nums, j-1, j);
                }
                else {//找到后退出
                    break;
                }
            }
        }
    }
}
