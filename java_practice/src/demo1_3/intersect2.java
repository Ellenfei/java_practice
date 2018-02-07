package demo1_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by ye on 2017/1/4.
 */
public class intersect2 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,3};
        int[] nums2 = {1,2,2,2,3,3};
        System.out.println(Arrays.toString(inter2(nums1, nums2)));
    }

    public static int[] inter2(int[] nums1,int[] nums2) {
            HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
            ArrayList<Integer> result = new ArrayList<Integer>();
            for (int i= 0; i<nums1.length; i++) {
                if (map.containsKey(nums1[i])) {
                    map.put(nums1[i],map.get(nums1[i])+1);
                }else {
                    map.put(nums1[i],1);
                }
            }

            for (int i = 0; i<nums2.length; i++) {
                if (map.containsKey(nums2[i]) && map.get(nums2[i])>0) {
                    result.add(nums2[i]);
                    map.put(nums2[i],0);
                }
            }

            int[] res = new int[result.size()];
            for (int i = 0; i<result.size(); i++) {
                res[i] = result.get(i);
            }

            return res;
        }

}
