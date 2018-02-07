package practice;

import java.util.*;

/**
 * Created by ye on 2017/3/3.
 */
public class findKthSmallestSum {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {1,1,2};
        List<int[]> list = kSmallestPairs(nums1,nums2,3);
        for (int[] a : list) {
            System.out.print(Arrays.toString(a));
        }
        //System.out.print(kSmallestPairs(nums1, nums2, 3));
    }

    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if (nums1.length==0 || nums2.length==0 || k==0) return res;

        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(nums1.length,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]+o1[1]-o2[0]-o2[1];
            }
        });

        for (int i=0; i<nums1.length && i<k; i++) {
            queue.offer(new int[]{nums1[i],nums2[0],0});
        }

        while (k-->0 && !queue.isEmpty()) {
            int[] cur = queue.poll();
            res.add(new int[]{cur[0],cur[1]});

            if (cur[2] == nums2.length-1) continue;
            int curNums1Val = cur[0];
            int nextNums2Index = cur[2]+1;
            int nextNums2Val = nums2[nextNums2Index];

            queue.offer(new int[]{curNums1Val,nextNums2Val,nextNums2Index});
        }
        return res;
    }
}
