package practice;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by ye on 2017/2/27.
 */
public class nextGreaterEleStack {
    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.print(Arrays.toString(nextGreaterElements(nums)));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<nums.length*2; i++) {
            //i = i%nums.length;
            int num = nums[i%nums.length];
            while (!stack.isEmpty() && nums[stack.peek()]<num) {
                res[stack.pop()] = num;
               // stack.pop();
            }
            if (i<nums.length) stack.push(i);
            if (stack.isEmpty()) break;
        }
        return res;
    }
}
