package demo1_3;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ye on 2017/1/17.
 */
public class findNumber {
    public static void main(String[] args) {
       // int[] nums = {2,5,3,6,4,3,2,1};
        int[] nums = {2,1,1};
        System.out.print(findDisappearedNumbers(nums));
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<Integer>();
        for (int i=0;i<nums.length;i++) {
            int index = nums[i];
            if (nums[Math.abs(index)-1]>0) {
                nums[Math.abs(index)-1] = -nums[Math.abs(index)-1];
            }
        }

        for (int j=0; j<nums.length; j++) {
            if (nums[j]>0) {
                result.add(j+1);
            }
        }
        return  result;
    }
}
