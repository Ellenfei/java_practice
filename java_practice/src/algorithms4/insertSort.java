package algorithms4;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Ellen on 2017/7/13.
 * 插入排序：将元素分为有序和无序两部分，每次处理就是将无序数列的
 * 第一个元素与有序数列的元素从后往前逐个进行比较，找出插入位置，
 * 将该元素插入到有序数列的合适位置中。需要移动元素
 * nums[0]      nums[1] nums[2] ..... nums[n-1]
 * ...........
 * 时间复杂度：介于n-n^2 ；空间复杂度：1
 * 稳定性：是
 */
public class insertSort {
    public static void main(String[] args) {
        Random random = new Random();
        int length = random.nextInt(1000);
        System.out.println(length);
        int[] nums = new int[length];
        for (int i=0; i<length; i++) {
            nums[i] = random.nextInt(1000);
        }
        System.out.println(Arrays.toString(nums));
        long startTime = System.currentTimeMillis();
        insert(nums);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(nums));
        System.out.println(endTime-startTime+"ms");
    }
    public static void insert(int[] nums) {
        for (int i=1; i<nums.length; i++) {
            int temp = nums[i];
            for (int j=i-1; j>=0; j--) {
                if (temp<nums[j]) {
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
