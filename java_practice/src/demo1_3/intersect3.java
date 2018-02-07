package demo1_3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ye on 2017/1/4.
 */
public class intersect3 {
    public static void main (String[] args) {
        int[] nums1 = {5,0,1,2,2,2,3,4,};
        int[] nums2 = {4,3,1,2,2,2,3,4,5};
        System.out.println(Arrays.toString(intersection(nums1,nums2)));
    }


    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> result = new HashSet<Integer>();
        for (int i = 0; i<nums1.length; i++) {
            set.add(nums1[i]);
        }

        for (int i = 0; i<nums2.length; i++) {
            if (set.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }

        int[] res = new int[result.size()];
        int i = 0;
        for (Integer num : result) {
            res[i++] = num;
        }

        return  res;
    }
}

