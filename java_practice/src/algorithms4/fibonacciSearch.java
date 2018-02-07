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

    //产生fabonacci数列
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

    //fabonacci搜索
    public static int fibSearch(int[] nums, int key) {
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length-1;
        int mid = 0;

        //生成fabonacci数列
        int[] fab = fibonacci();
        int fabIndex = 0;
        //int numsIndex = 0;
        while (nums.length > fab[fabIndex]-1)
            fabIndex++;

        //创建临时数组
        int[] temp = new int[fab[fabIndex]];
        for (int i=0; i<high+1; i++) {
            temp[i] = nums[i];
        }
        //补充数组nums至fab[fabIndex]个元素
        for (int i=high+1; i<fab[fabIndex]; i++) {
            temp[i] = nums[high];
        }

        System.out.println(Arrays.toString(temp));

        while (low<=high) {
            //low：起始位置，前半部分有fab[fabIndex-1]个元素
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
