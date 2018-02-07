package demo1_3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ye on 2017/1/18.
 */
public class intersectArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.print(Arrays.toString(intersect(nums1,nums2)));
    }

    public static int[] intersect(int[] num1, int[] num2) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        List<Integer> result = new LinkedList<Integer>();
        for (int i=0; i<num1.length; i++) {
            if (map.containsKey(num1[i])){
                map.put(num1[i],map.get(num1[i])+1);
            } else {
                map.put(num1[i],1);
            }
        }

        for (int i=0; i<num2.length; i++) {
            if (map.containsKey(num2[i]) && map.get(num2[i])>0) {
                result.add(num2[i]);
                map.put(num2[i],map.get(num2[i])-1);
            }
        }

        int[] res = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}
