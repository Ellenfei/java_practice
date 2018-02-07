package demo1_3;

import java.util.Arrays;

/**
 * Created by ye on 2017/1/17.
 */
public class moveZ {
    public static void main(String[] args) {
        int[] nums = {1,2,0,0,4,6};
        moveZeroes(nums);
        System.out.print(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        /*int j=0;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] != 0) {
                int temp;
                temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }*/
        int j=0;
        for (int i = 0;i<nums.length;i++) {
            if (nums[i]!=0){
                nums[j++]=nums[i];
            }
        }
        while (j<nums.length){
            nums[j] = 0;
        }
    }
}
