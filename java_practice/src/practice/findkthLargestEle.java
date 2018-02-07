package practice;

import java.util.PriorityQueue;

/**
 * Created by ye on 2017/3/1.
 */
public class findkthLargestEle {
    public static void main(String[] args) {
        int[] nums = {1,3,2,2,4};
        System.out.println(findKthLargest(nums , 4));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i=0; i<nums.length; i++) {
            pq.add(nums[i]);
            if (pq.size() > k) pq.poll();
        }
        return pq.poll();
    }
}
