package demo1_3;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by ye on 2017/1/18.
 */
public class removeDuplicateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1,4};
        System.out.print(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        /*HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i=0; i<nums.length; i++) {
            if (!map.containsKey(nums[i]))
                map.put(nums[i],1);
        }
        System.out.println(map.keySet());

        return map.size();*/

        int i=0;
        for (int n : nums) {
            if (i==0 || n>nums[i-1]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}
