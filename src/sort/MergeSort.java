package sort;

/**
 * 归并排序
 * @param <T>
 */
public class MergeSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int length = nums.length;
        T[] tempArr = (T[]) new Comparable[length];
        //合并的个体数组大小
        int mergeNum = 1;
        while (mergeNum <= length){
            int startSubscript = 0;
            for (int i = 0;i < length;i++){
                tempArr[i] = nums[i];
            }
            while ((startSubscript + 1) * mergeNum < length){
                //第一组初始下标
                int leftSub = startSubscript * mergeNum;
                //第二组初始下标
                int rightSub = (startSubscript + 1) * mergeNum;
                //左数组长度
                int leftArrLen = mergeNum;
                //右数据长度
                int rightArrLen = (length - rightSub) > mergeNum ? mergeNum : (length - rightSub);
                int leftEnd = leftSub + leftArrLen;
                int rightEnd = rightSub + rightArrLen;
                int count = leftSub;
                for (;rightSub < rightEnd || leftSub < leftEnd;){
                    if (leftSub == leftEnd){
                        nums[count++] = tempArr[rightSub++];
                    }else if (rightSub == rightEnd) {
                        nums[count++] = tempArr[leftSub++];
                    }else if (less(tempArr[leftSub], tempArr[rightSub])){
                        nums[count++] = tempArr[leftSub++];
                    }else{
                        nums[count++] = tempArr[rightSub++];
                    }
                }
                startSubscript = startSubscript + 2;
            }
            mergeNum = mergeNum * 2;
        }
    }
}
