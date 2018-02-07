package algorithms4;

import java.util.Arrays;


/**
 * Created by Ellen on 2017/7/12.
 */
public class quickSort {
    public static void main(String[] args) {
        Integer[] nums = {9,1,2,5,12,11,15};
        System.out.println(nums.length);
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(Comparable[] a) {
        sort(a,0,a.length-1);
    }
    public static void sort(Comparable[] a, int low, int high) {
        if (low>=high) return;
        int partition = partition(a, low, high);
        sort(a,low,partition-1);
        sort(a,partition+1,high);
    }

    public static int partition(Comparable[] a, int low, int high) {
        int i=low, j=high+1;
        Comparable v = a[low];
        while (i<=j) {
            while (a[++i].compareTo(v) < 0) if (i==high) break;
            while (a[--j].compareTo(v) > 0) if (j==low) break;
            if (i>=j) break;
            Comparable temp;
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
        a[low] = a[j];
        a[j] = v;
        return j;
    }

}
