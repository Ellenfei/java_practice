package sort;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/11/13.
 * 堆排序的基本思想是：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根节点。将其与末尾元素进行交换，
 * 此时末尾就为最大值。然后将剩余n-1个元素重新构造成一个堆，这样会得到n个元素的次小值。如此反复执行，便能得到一个有序序列了
 *
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, -1, -2, -3 };

        System.out.println("Before heap:");
        System.out.println(Arrays.toString(array));

        heapSort(array);

        System.out.println("After heap sort:");
        System.out.println(Arrays.toString(array));
    }

    public static void heapSort(int[] arr) {
        int len = arr.length;
        buildMaxHeap(arr);
        while (len>1) {
            int temp = arr[len-1];
            arr[len-1] = arr[0];
            arr[0] = temp;
            len--;
            maxHeap(arr, len, 0);

        }
    }

    public static void buildMaxHeap(int[] arr) {
        int len = arr.length;
        for (int i=len/2; i>=0; i--) {
            maxHeap(arr, len, i);
        }
    }

    public static void maxHeap(int[] arr, int heapSize, int index) {

        int left = 2*index+1;
        int right = 2*index+2;

        int largest = index;
        if (left<heapSize && arr[largest]<arr[left]) {
            largest = left;
        }
        if (right<heapSize && arr[largest]<arr[right]) {
            largest = right;
        }

        if (largest!=index) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            maxHeap(arr, heapSize, largest);
        }

    }
}
