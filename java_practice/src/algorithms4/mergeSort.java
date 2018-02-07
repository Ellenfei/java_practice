package algorithms4;


import java.util.Arrays;

/**
 * Created by Ellen on 2017/7/12.
 * 归并排序：采用分治法
 */
public class mergeSort {
    private static Comparable[] aux;
    public static void main(String[] args) {
        Integer[] nums = {9,1,2,5,7,4,8,6,3,0,12,11,15,14,13};
        //System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(Comparable[] a) {
        aux = new Integer[a.length];
        sort(a,0,a.length-1);
    }

    public static void sort(Comparable[] a, int start, int end) {
        if (end<=start) return;
        int mid = start + (end-start)/2;
        sort(a,start,mid);
        sort(a,mid+1,end);
        merge(a,start,mid,end);
    }
    public static void merge(Comparable[] a, int low, int mid, int high) {
        int i = low;
        int j = mid+1;
        for (int k=low; k<=high; k++) {
            aux[k] = a[k];
        }
        for (int k=low; k<=high; k++) {
            if (i>mid) a[k] = aux[j++];
            else if (j>high) a[k] = aux[i++];
            else if ((aux[i].compareTo(aux[j]))>0) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }
}
