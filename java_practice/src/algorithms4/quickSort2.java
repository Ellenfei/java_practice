package algorithms4;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Ellen on 2017/7/13.
 * 快速排序：
 * 一趟快速排序算法：
 * 1.设置两个变量i=0, j=n-1;
 * 2.以第一个元素为基准 key=nums[0];
 * 3.从j开始向前搜索，即由后开始向前搜索(j--)，找到第一个小于key的值A[j]，将A[j]和A[i]互换；
 * 4.从i开始向后搜索，即由前开始向后搜索(i++)，找到第一个大于key的A[i]，将A[i]和A[j]互换；
 * 5.直到key左边的都不大于key，key右边的都不小于key，且i==j时终止循环
 * 时间复杂度：nlogn-n^2 空间复杂度：lgn-n（递归栈占用空间）
 * 稳定性：否
 */
public class quickSort2 {
    public static void main(String[] args) {
        Random random = new Random();
        int length = random.nextInt(100000);
        System.out.println(length);
        int[] nums = new int[length];
        for (int i=0; i<length; i++) {
            nums[i] = random.nextInt(10000);
        }
        System.out.println(Arrays.toString(nums));
        long startTime = System.currentTimeMillis();
        quick(nums);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(nums));
        System.out.println(endTime-startTime+"ms");
    }

    public static void quick(int[] nums) {
        quick(nums, 0, nums.length-1);
    }
    public static void quick(int[] nums, int start, int end) {
        int i=start, j=end;
        int key = nums[start];
        while (i<j) {
            //j--直到nums[j]小于key为止
            while (i<j && nums[j]>=key)
                j--;
            if (i<j) {
                nums[i] = nums[j];
                i++;
            }
            //i++直到nums[i]大于key为止
            while (i<j && nums[i]<=key)
                i++;
            if (i<j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = key;
        if (i>start) quick(nums, start, i-1);
        if (j<end) quick(nums, j+1, end);
    }

    /*public static void quick(int[] nums, int start, int end) {
        int i=start, j=end;
        int partition = nums[start];
        while (i<j ){
            while (i<j && partition<=nums[j]) j--;
            if (i<j) {
                int temp;
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }

            while (i<j && partition>=nums[i]) i++;
            if (i<j) {
                int temp;
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
        }
        if (i>start) quick(nums,start,i-1);
        if (j<end) quick(nums,j+1,end);
    }*/


}
