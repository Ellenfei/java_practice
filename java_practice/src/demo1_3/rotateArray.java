package demo1_3;

import java.util.Arrays;

/**
 * Created by ye on 2017/1/18.
 */
public class rotateArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums,3);
        System.out.print(Arrays.toString(nums));
    }

    public static void rotate(int[] nums, int k) {
        /*for (int i=0; i<k; i++) {
            int temp;
            temp = nums[nums.length-1];

            for (int j=nums.length-2; j>-1; j--)
                nums[j+1] = nums[j];
            nums[0] = temp;
        }*/

         k = k%nums.length;
        reverse(nums,0,nums.length-k-1);
        reverse(nums,nums.length-k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }

    public static void reverse (int[] nums, int start, int end) {
        while (start<end) {
            int temp;
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
