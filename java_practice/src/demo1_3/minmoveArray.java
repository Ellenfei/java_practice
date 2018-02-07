package demo1_3;

/**
 * Created by ye on 2017/1/18.
 */
public class minmoveArray {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.print(minMoves(nums));
    }

    //��n-1��Ԫ�ؼ�1�ȼ��ڽ�ʣ�µ�һ��Ԫ�ؼ�1
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
