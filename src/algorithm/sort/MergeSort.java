package algorithm.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 归并排序
 *
 * @param <T>
 */
public class MergeSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int l = 0, r = nums.length - 1;
        mergeSplit(nums, l, r);
    }

    private void mergeSplit(T[] nums, int l, int r) {
        if (l == r) {
            return;
        }
        int mid = l + ((r - l) >> 1);
        mergeSplit(nums, l, mid);
        mergeSplit(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    private void merge(T[] nums, int l, int mid, int r) {
        int left = l;
        int right = mid + 1;
        List<T> temp = new ArrayList<>(r - l + 1);
        while (left <= mid && right <= r) {
            if (less(nums[left], nums[right])) {
                temp.add(nums[left++]);
            } else {
                temp.add(nums[right++]);
            }
        }
        while (left <= mid) {
            temp.add(nums[left++]);
        }
        while (right <= r) {
            temp.add(nums[right++]);
        }
        for (int i = 0; i < temp.size(); i++) {
            nums[l + i] = temp.get(i);
        }
    }
    // @Override
    // public void sort(T[] nums) {
    //     int length = nums.length;
    //     T[] tempArr = (T[]) new Comparable[length];
    //     //合并的个体数组大小
    //     int mergeNum = 1;
    //     while (mergeNum <= length){
    //         int startSubscript = 0;
    //         for (int i = 0;i < length;i++){
    //             tempArr[i] = nums[i];
    //         }
    //         while ((startSubscript + 1) * mergeNum < length){
    //             //第一组初始下标
    //             int leftSub = startSubscript * mergeNum;
    //             //第二组初始下标
    //             int rightSub = (startSubscript + 1) * mergeNum;
    //             //左数组长度
    //             int leftArrLen = mergeNum;
    //             //右数据长度
    //             int rightArrLen = (length - rightSub) > mergeNum ? mergeNum : (length - rightSub);
    //             int leftEnd = leftSub + leftArrLen;
    //             int rightEnd = rightSub + rightArrLen;
    //             int count = leftSub;
    //             for (;rightSub < rightEnd || leftSub < leftEnd;){
    //                 if (leftSub == leftEnd){
    //                     nums[count++] = tempArr[rightSub++];
    //                 }else if (rightSub == rightEnd) {
    //                     nums[count++] = tempArr[leftSub++];
    //                 }else if (less(tempArr[leftSub], tempArr[rightSub])){
    //                     nums[count++] = tempArr[leftSub++];
    //                 }else{
    //                     nums[count++] = tempArr[rightSub++];
    //                 }
    //             }
    //             startSubscript = startSubscript + 2;
    //         }
    //         mergeNum = mergeNum * 2;
    //     }
    // }
}
