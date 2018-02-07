package jianzhi;

/**
 * Created by Ellen on 2018/1/7.
 */
public class FindGreatestSumOfSubArray31 {
    public static void main(String[] args) {
        int[] nums = {1,2,-4,5,2,-3,4};
        System.out.print(greatestSum(nums));
    }
    public static int greatestSum(int[] nums) {
        if (nums==null || nums.length<1) {
            throw new RuntimeException("invalid input");
        }
        int curSum = nums[0];
        int max = Integer.MIN_VALUE;
        for (int i=1; i<nums.length; i++) {
            if (curSum<0) {
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }
            if (max<curSum) {
                max = curSum;
            }
        }
        return max;
    }
}
