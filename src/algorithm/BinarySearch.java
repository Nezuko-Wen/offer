package algorithm;

public class BinarySearch {
    public static int search(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            if (key > a[mid]) lo = mid + 1;
            if (key == a[mid]) return mid;
        }
        return -1;
    }
}
