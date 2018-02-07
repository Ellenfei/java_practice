package algorithms4;

import java.util.Arrays;

/**
 * Created by Ellen on 2017/7/10.
 */
public class fibonacciSearch {
    public static int maxSize = 20;
    public static void main(String[] args) {
        int[] nums = { 25, 31, 39,  1, 5, 15, 22,42, 47, 49, 59, 68, 88 };
        int key = 39;
        int position = fibSearch(nums, key);
        System.out.println(key +" is : "+position);
    }

    //����fabonacci����
    public static int[] fibonacci() {
        //int length = nums.length;
        int[] fab = new int[maxSize];
        fab[0] = 1;
        fab[1] = 1;
        for (int i=2; i<maxSize; i++) {
            fab[i] = fab[i-1]+fab[i-2];
        }
        return fab;
    }

    //fabonacci����
    public static int fibSearch(int[] nums, int key) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length-1;
        int mid = 0;

        //����fabonacci����
        int[] fab = fibonacci();
        int fabIndex = 0;
        //int numsIndex = 0;
        while (nums.length > fab[fabIndex]-1)
            fabIndex++;

        //������ʱ����
        int[] temp = new int[fab[fabIndex]];
        for (int i=0; i<high+1; i++) {
            temp[i] = nums[i];
        }
        //��������nums��fab[fabIndex]��Ԫ��
        for (int i=high+1; i<fab[fabIndex]; i++) {
            temp[i] = nums[high];
        }

        System.out.println(Arrays.toString(temp));

        while (low<=high) {
            //low����ʼλ�ã�ǰ�벿����fab[fabIndex-1]��Ԫ��
            mid = low + fab[fabIndex-1]-1;
            if (temp[mid]<key) {
                low = mid+1;
                fabIndex = fabIndex-2;
            } else if (temp[mid]>key) {
                high = mid-1;
                fabIndex = fabIndex-1;
            } else {
                if (mid < high) return mid;
                else return high;
            }
        }
        return -1;
    }
}
