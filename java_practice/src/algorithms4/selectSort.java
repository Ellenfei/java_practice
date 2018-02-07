package algorithms4;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Ellen on 2017/7/13.
 * 选择排序：首先在nums[0]-nums[n-1]选出最小的元素，与nums[0]交换；然后在nums[1]-nums[n-1]选出最小的元素，与nums[1]交换
 * .....依次类推，最终得到升序排列的数组
 * 时间复杂度：n^2；空间复杂度：1
 * 稳定性：否
 */
public class selectSort {
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
        select(nums);
        long endTime = System.currentTimeMillis();
        System.out.println(Arrays.toString(nums));
        System.out.println(endTime-startTime+"ms");
    }

    public static void select(int[] nums) {
        for (int i=0; i<nums.length; i++) {
            int min = nums[i];
            for (int j=i+1; j<nums.length; j++) {
                if (min > nums[j]) {
                    nums[i] = nums[j];
                    nums[j] = min;
                    min = nums[i];
                }
            }
        }
    }
}
