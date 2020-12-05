package sort;

public abstract class Sort<T extends Comparable<T>> {

    public abstract void sort(T[] nums);

    protected boolean less(T front, T rear){
        return front.compareTo(rear) < 0;
    }

    protected void swap(T[] nums, int i, int j){
        T temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
