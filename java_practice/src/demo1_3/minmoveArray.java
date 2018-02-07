package demo1_3;

/**
 * Created by ye on 2017/1/18.
 */
public class minmoveArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.print(minMoves(nums));
    }

    //将n-1个元素加1等价于将剩下的一个元素减1
    public static int minMoves(int[] nums) {
        int min = nums[0];
        int result = 0;
        for(int i=1; i<nums.length; i++) {
            min = Math.min(min,nums[i]);
        }

        for (int n : nums) result+=n - min;
        return result;
    }
}
