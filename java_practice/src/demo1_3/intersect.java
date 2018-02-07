package demo1_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by ye on 2017/1/3.
 */
public class intersect {
    public static void main(String[] args) {
        int[] num1 = {7,1,2,3,4};
        int[] num2 = {1,2,4,6,7};
        System.out.println(Arrays.toString(interSect(num1, num2)));
    }

    public static int[] interSect(int[] num1,int[] num2) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i<num1.length; i++) {
            if (map.containsKey(num1[i])) {
                map.put(num1[i], map.get(num1[i])+1);
            }else {
                map.put(num1[i],1);
            }
        }

        for (int i = 0; i<num2.length; i++) {
            if (map.containsKey(num2[i]) && map.get(num2[i])>0) {
                result.add(num2[i]);
                map.put(num2[i],map.get(num2[i])-1);
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i<result.size(); i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}
